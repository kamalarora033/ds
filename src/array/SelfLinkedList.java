package array;

public class SelfLinkedList {

	Node head, tail = null;
	int length;

	public SelfLinkedList(int data) {
		Node head = new Node(data);
		this.head = this.tail = head;
		length++;
	}

	class Node {
		int data;
		Node prev;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public void append(int data) {
		Node newNode = new Node(data);
		tail.next = newNode;
		newNode.prev = tail;
		newNode.next = null;
		this.tail = newNode;
		length++;
	}

	public void prepend(int data) {
		Node newNode = new Node(data);
		this.head.prev = newNode;
		newNode.prev = null;
		newNode.next = this.head;
		this.head = newNode;
		length++;
	}

	public void printList() {
		Node node = null;
		node = this.head;
		while (node != null) {
			System.out.print(node.data);
			node = node.next;
			if (node != null)
				System.out.print(", ");
		}
	}

	public void insert(int index, int data) {

		if (index >= length) {
			this.append(data);
		}

		Node newNode = new Node(data);
		Node leader = this.traverseTo(index - 1);
		Node nextNextNode = leader.next;
		leader.next = newNode;
		newNode.prev = leader;
		newNode.next = nextNextNode;
		length++;
	}

	public Node traverseTo(int index) {
		int counter = 0;
		Node currentNode = this.head;
		while (counter != index) {
			currentNode = currentNode.next;
			counter++;
		}
		return currentNode;
	}

	public static void main(String[] args) {
		SelfLinkedList linkedList = new SelfLinkedList(1);
		linkedList.append(2);
		linkedList.append(3);
		linkedList.append(4);
		linkedList.append(6);
		linkedList.insert(4, 5);
		linkedList.printList();
	}
}
