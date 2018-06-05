package day0525.task;

public class TicketTest {
	public static void main(String[] args) {
		new Thread(new Ticket()).start();
		new Thread(new Ticket()).start();
		new Thread(new Ticket()).start();
		new Thread(new Ticket()).start();
	}
}
