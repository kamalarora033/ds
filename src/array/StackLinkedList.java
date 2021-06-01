package array;

public class StackLinkedList {

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

	int length;
	Node top, bottom = null;

	public void push(int data) {
		Node newNode = new Node(data);
		if (bottom == null) {
			bottom = newNode;
			top = newNode;
		} else {
			Node holdingNode = top;
			top = newNode;
			top.next = holdingNode;
		}
		length++;
	}

	public int pop() {
		if (top == null) {
			return 0;
		}
		Node holdingNode = top;
		top = holdingNode.next;
		length--;
		return holdingNode.data;
	}

	public Node peek() {
		return top;
	}

	@Override
	public String toString() {
		return "StackLinkedList [length=" + length + ", top=" + top + ", bottom=" + bottom + "]";
	}

	public static void main(String[] args) {

		StackLinkedList sll = new StackLinkedList();

		sll.push(10);
		sll.push(20);
		sll.push(30);

		System.out.println(sll);
		System.out.println(sll.pop() + " popped from stack");

		System.out.println("Top element is " + sll.peek());
	}

}
