package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;  
  
/** 
 * Created by dolphin on 15-03-05. 
 */  
public class JIMHistoryTextPane extends JIMSendTextPane {  
  
    private ConcurrentLinkedQueue<Message> messageConcurrentLinkedQueue;  
    private ConcurrentHashMap<Integer, Image> senderHeadImageConcurrentHashMap;  
    private Color otherMessageColor = new Color(188, 237, 245);  
    private Color otherMessageBorderColor = new Color(156, 205, 213);  
    private Color selfMessageColor = new Color(230, 230, 230);  
    private Color selfMessageBorderColor = new Color(198, 198, 198);  
  
    public JIMHistoryTextPane() {  
        setEditable(false); // ������ʾ��ʷ��Ϣ����˱���Ϊֻ��ģʽ���������û��޸�����  
        setOpaque(false); // ���óɱ���͸������ȫ�Ի�Żῴ��Ч��  
    }  
  
    @Override  
    public void paintComponent(Graphics g) {  
        Graphics2D g2D = (Graphics2D) g;  
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // �����ƽ������  
  
        // ͨ���Բ�����Ϣ�����������ȫ����Ϣ���ݡ���Ϣ������ͷ��  
        if (messageConcurrentLinkedQueue != null) {  
            Iterator<Message> iterator = messageConcurrentLinkedQueue.iterator();  
            while (iterator.hasNext()) {  
                Message message = iterator.next();  
  
                Point point = message.getMessagePaintLeftTop();  
  
                if (point != null) {  
                    // ������Ϣ������ͷ��  
                    if (senderHeadImageConcurrentHashMap != null) {  
                        Image image = senderHeadImageConcurrentHashMap.get(message.getSenderHeadImageID());  
                        if (image != null) {  
                            if (message.isSelfSender()) {  
                                g2D.drawImage(image, this.getWidth() - image.getWidth(null) - 9, point.y - 25, null);  
                            } else {  
                                // ��Ϣ�������Ǳ��ˣ���ͷ������ʾ  
                                g2D.drawImage(image, 9, point.y - 25, null);  
                            }  
                        }  
                    }  
  
                    // ���ƶ���Ϣ�������С��ͷ  
                    int xPoints[] = new int[3];  
                    int yPoints[] = new int[3];  
  
                    if (message.isSelfSender()) {  
                        // �����Լ���ϢԲ����Ϣ���ݾ���  
                        g2D.setColor(selfMessageColor);  
                        g2D.fillRoundRect(point.x - 7, point.y - 7, message.getMessagePaintWidth() + 14, message.getMessagePaintHeight() + 14, 10, 10);  
                        // ����Բ����Ϣ���ݱ߿�  
                        g2D.setColor(selfMessageBorderColor);  
                        g2D.drawRoundRect(point.x - 7, point.y - 7, message.getMessagePaintWidth() + 14, message.getMessagePaintHeight() + 14, 10, 10);  
  
                        // ��Ϣ���������Լ�����ͷ������ʾ  
                        xPoints[0] = (point.x - 7) + (message.getMessagePaintWidth() + 14);  
                        yPoints[0] = point.y;  
                        xPoints[1] = xPoints[0] + 7;  
                        yPoints[1] = point.y;  
                        xPoints[2] = xPoints[0];  
                        yPoints[2] = point.y + 7;  
  
                        g2D.setColor(selfMessageColor);  
                        g2D.fillPolygon(xPoints, yPoints, 3);  
                        g2D.setColor(selfMessageBorderColor);  
                        g2D.drawPolyline(xPoints, yPoints, 3);  
                        g2D.setColor(selfMessageColor);  
                        g2D.drawLine(xPoints[0], yPoints[0] + 1, xPoints[2], yPoints[2] - 1);  
                    } else {  
                        // ���Ʊ�����ϢԲ����Ϣ���ݾ���  
                        // ����Բ����Ϣ���ݾ���  
                        g2D.setColor(otherMessageColor);  
                        g2D.fillRoundRect(point.x - 7, point.y - 7, message.getMessagePaintWidth() + 14, message.getMessagePaintHeight() + 14, 10, 10);  
                        // ����Բ����Ϣ���ݱ߿�  
                        g2D.setColor(otherMessageBorderColor);  
                        g2D.drawRoundRect(point.x - 7, point.y - 7, message.getMessagePaintWidth() + 14, message.getMessagePaintHeight() + 14, 10, 10);  
  
                        // ��Ϣ�������Ǳ��ˣ���ͷ������ʾ  
                        xPoints[0] = point.x - 7;  
                        yPoints[0] = point.y;  
                        xPoints[1] = xPoints[0] - 7;  
                        yPoints[1] = point.y;  
                        xPoints[2] = xPoints[0];  
                        yPoints[2] = point.y + 7;  
  
                        g2D.setColor(otherMessageColor);  
                        g2D.fillPolygon(xPoints, yPoints, 3);  
                        g2D.setColor(otherMessageBorderColor);  
                        g2D.drawPolyline(xPoints, yPoints, 3);  
                        g2D.setColor(otherMessageColor);  
                        g2D.drawLine(xPoints[0], yPoints[0] + 1, xPoints[2], yPoints[2] - 1);  
                    }  
                }  
            } // while  
        }  
  
        super.paintComponent(g); // ִ��Ĭ��������ƣ���Ϣ�ı���ͼƬ�Լ�������ʾ�����ݣ�  
    }  
  
    public void setMessageConcurrentLinkedQueue(ConcurrentLinkedQueue<Message> messageConcurrentLinkedQueue) {  
        this.messageConcurrentLinkedQueue = messageConcurrentLinkedQueue;  
    }  
  
    public void setSenderHeadImageConcurrentHashMap(ConcurrentHashMap<Integer, Image> senderHeadImageConcurrentHashMap) {  
        this.senderHeadImageConcurrentHashMap = senderHeadImageConcurrentHashMap;  
    }  
}  
