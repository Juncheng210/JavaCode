package day0517;

public class Link {
	private Node root;//根节点
	private int size;
	private int index = 0;//模拟数组下标
	private String[] returnArray;
	
	/**
	 * 移除元素
	 * @param data 要移除的元素
	 */
	public void remove(String data) {
		if(this.contains(data)) {
			if(data.equals(this.root.data)) {
				this.root = this.root.next;
			} else {
				this.root.next.removeNode(this.root, data);
			}
			this.size--;
		}
	}
	/**
	 * 转换为数组
	 * @return String[]
	 */
	public String[] toArray() {
		if(this.root == null) {
			return null;
		}
		this.index = 0;
		this.returnArray = new String[this.size];
		this.root.toArrayNode();
		return this.returnArray;
	}
	/**
	 * 修改指定位置的元素
	 * @param index 指定的位置
	 * @param data 目标值
	 */
	public void set(int index, String data) {
		if(index > (this.size - 1) || index < 0) {
			return;
		}
		this.index = 0;
		this.root.setNode(index, data);
	}
	/**
	 * 过去元素
	 * @param index 
	 * @return String
	 */
	public String get(int index) {
		if(index > (this.size - 1) || index < 0) {
			return null;
		}
		this.index = 0;
		return this.root.getNode(index);
	}
	/**
	 * 添加元素
	 * @param data
	 */
	public void add(String data) {
		if(data == null) {
			return;
		}
		Node node = new Node(data);
		this.size++;
		if(this.root == null) {
			this.root = node;
		} else {
			this.root.addNode(node);
		}
	}
	/**
	 * 是否包含某个元素
	 * @param data
	 * @return boolean
	 */
	public boolean contains(String data) {
		if(data == null || this.root == null) {
			return false;
		}
		return this.root.containsNode(data);
	}
	/**
	 * 判断是否为空
	 * @return boolean
	 */
	public boolean isEmpty() {
		return this.size == 0;
//		return this.root == null;
	}
	/**
	 * 获取元素个数
	 * @return int
	 */
	public int size() {
		return this.size;
	}
	
	private class Node{
		private String data;
		private Node next;
		
		public Node(String data) {
			this.data = data;
		}
		public Node() {}
		
		public void toArrayNode() {
			Link.this.returnArray[Link.this.index++] = this.data;
			if(this.next != null) {
				this.next.toArrayNode();
			}
		}
		public void removeNode(Node prev, String data) {
			if(this.data.equals(data)) {
				prev.next = this.next;
			} else {
				this.next.removeNode(prev, data);
			}
		}
		public void setNode(int index, String data) {
			if(Link.this.index++ == index) {
				this.data = data;
			} else {
				this.next.setNode(index,data);
			}
		}
		public String getNode(int index) {
			if(Link.this.index++ == index) {
				return this.data;
			} else {
				return this.next.getNode(index);
			}
		}
		public String getData() {
			return this.data;
		}
		/**
		 * 是否包含节点
		 * @param data
		 * @return boolean
		 */
		public boolean containsNode(String data) {
			if(data.equals(this.data)) {
				return true;
			} else {
				if(this.next != null) {
					return this.next.containsNode(data);
				} else {
					return false;
				}
			}
		}
		/**
		 * 添加节点
		 * @param node
		 */
		public void addNode(Node node) {
			if(this.next == null) {
				this.next = node;
			} else {
				this.next.addNode(node);
			}
		}
	}
}
