package array;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

	public void push(int data) {
		stack1.push(data);
		System.out.println(data + " inserted");
	}

	public Integer pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		Integer poppedItem = stack2.pop();

		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return poppedItem;

	}

	public Integer peek() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		Integer peekItem = stack2.peek();

		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return peekItem;
	}

	@Override
	public String toString() {
		return "QueueUsingStack [stack1=" + stack1 + ", stack2=" + stack2 + "]";
	}

	public static void main(String[] args) {
		QueueUsingStack queueStack = new QueueUsingStack();
		queueStack.push(10);
		queueStack.push(11);
		queueStack.push(12);
		queueStack.push(13);
		System.out.println("queue is " + queueStack);
		System.out.println(queueStack.pop());
		System.out.println(queueStack.peek());

	}
}
