package day0517;

public class Node {
	private String data;
	private Node next;
	
	public Node(String data) {
		this.data = data;
	}
	public Node() {
		
	}
	
	public void addNode(Node node) {
		if(this.next == null) {
			this.next = node;
		} else {
			this.next.addNode(node);
		}
	}
	public void printNode() {
		System.out.println(this.data);
		if(this.next != null) {
			this.next.printNode();
		}
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getNext() {
		return this.next;
	}
	public String getData() {
		return this.data;
	}
	
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj instanceof Node){
			Node node =(Node)obj;
			if(node.data.equals(this.data)){
				return true;
			}
		}
		return false;
	}
	
	
}
