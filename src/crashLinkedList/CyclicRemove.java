package crashLinkedList;

import crashLinkedList.SelfLinkedList.Node;

public class CyclicRemove {

	public static void main(String[] args) {
		SelfLinkedList linkedList = new SelfLinkedList(1);
		linkedList.head.next = linkedList.new Node(2);
		linkedList.head.next.next = linkedList.new Node(3);
		linkedList.head.next.next.next = linkedList.new Node(4);
		linkedList.head.next.next.next.next = linkedList.new Node(5);
		linkedList.head.next.next.next.next.next = linkedList.head.next;
		removeCyclic(linkedList.head);
		linkedList.printList();
	}

	static boolean removeCyclic(Node head) {
		if (head == null || head.next == null) {
			return false;
		}
		Node slow = head;
		Node fast = head;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("Yes! it is cyclic");
				fast.next = null;
				System.out.println("Removed Cyclic");
				return true;
			}
		}

		return false;
	}
}
