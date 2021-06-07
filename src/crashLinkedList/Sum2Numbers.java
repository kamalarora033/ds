package crashLinkedList;

import crashLinkedList.SelfLinkedList.Node;

public class Sum2Numbers {

	static SelfLinkedList list = new SelfLinkedList(7);

	public static void main(String[] args) {

		list.head.next = list.new Node(5);
		list.head.next.next = list.new Node(9);
		list.head.next.next.next = list.new Node(4);
		list.head.next.next.next.next = list.new Node(6);
		System.out.print("First List is ");
		list.printList();

		SelfLinkedList list2 = new SelfLinkedList(8);
		list2.head = list2.new Node(8);
		list2.head.next = list2.new Node(4);
		System.out.print("Second List is ");
		list2.printList();

		// add the two lists and see the result
		Node rs = addTwoLists(list.head, list2.head);
		System.out.print("Resultant List is ");
		printList(rs);
	}

	static Node addTwoLists(Node first, Node second) {
		Node temp = null;
		Node result = null;
		Node prev = null;
		int carry = 0;
		int sum = 0;
		while (first != null || second != null) {

			sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
			carry = sum > 10 ? 1 : 0;
			sum = sum % 10;
			temp = list.new Node(sum);

			if (first.next != null) {
				first = first.next;
			}
			if (second.next != null) {
				second = second.next;
			}
			if (result == null) {
				result = temp;
			} else {
				prev.next = temp;
			}
			prev = temp;

		}

		if (carry > 0) {
			temp.next = list.new Node(carry);
		}
		return result;
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
}
