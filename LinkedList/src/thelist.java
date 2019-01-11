
public class thelist {
	Node start;

	
	public thelist(int firstValue) {
		this.start = new Node(firstValue);

	}
	
	public void addValue(int newValue) {
		Node current =start;
		while(current.next!=null) {
			current = current.next;
		}
		current.next = new Node(newValue);
		
	}
	
	public void dump() {
		Node current =start;
		while (current!=null) {
			System.out.println(current.value);
			current = current.next;
		}
	}

}
