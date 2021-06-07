package crashLinkedList;

import crashLinkedList.SelfLinkedList.Node;

public class ReOrdering {

	static SelfLinkedList linkedList = new SelfLinkedList(1);
	public static void main(String[] args) {
		linkedList.append(2);
		linkedList.append(3);
		linkedList.append(4);
		linkedList.append(6);
		linkedList.insert(4, 5);
		Node reOrderedNode = reOrdering(linkedList.head);
		printList(reOrderedNode);
	}
	
	public static void printList(Node printNode) {
		Node node = null;
		node = printNode;
		while (node != null) {
			System.out.print(node.data);
			node = node.next;
			if (node != null)
				System.out.print(", ");
		}
	}

	public static Node reOrdering(Node node) {

		if (node == null || node.next == null || node.next.next == null) {
			return node;
		}
		Node middleNode = middelNode(node);
		Node nextList = middleNode.next;
		middleNode.next = null;
		Node reverseList = reverse(nextList);

		Node firstList = node;

		Node finalList = linkedList.new Node();
		Node dummyNode = finalList;

		while (firstList != null || reverseList != null) {
			if (firstList != null) {
				dummyNode.next = firstList;
				dummyNode = dummyNode.next;
				firstList = firstList.next;
			}
			if (reverseList != null) {
				dummyNode.next = reverseList;
				dummyNode = dummyNode.next;
				reverseList = reverseList.next;
			}
		}
		return finalList.next;
	}

	public static Node middelNode(Node node) {
		Node slow = node;
		Node fast = node;
		while (slow.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static Node reverse(Node node) {

		Node prev = null;
		Node next = null;
		Node current = node;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

}
