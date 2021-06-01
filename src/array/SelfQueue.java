package array;

public class SelfQueue {

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}

	}

	Node first, last = null;
	int length = 0;

	public Node peek() {
		return first;
	}

	public void enqueue(int data) {
		Node newNode = new Node(data);
		if (first == null) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		length++;
	}

	public Node dequeue() {
		Node holdingNode = first;
		first = first.next;
		length--;
		return holdingNode;
	}

	@Override
	public String toString() {
		return "SelfQueue [first=" + first + ", last=" + last + ", length=" + length + "]";
	}

	public static void main(String[] args) {

		SelfQueue sq = new SelfQueue();

		sq.enqueue(10);
		sq.enqueue(20);
		sq.enqueue(30);

		System.out.println(sq);
		System.out.println(sq.dequeue() + " dequeue from queue");

		System.out.println("Top element is " + sq.peek());
	}
}
