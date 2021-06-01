package array;

public class SelfArrayList {

	int arr[];
	int capacity;
	int current;

	public SelfArrayList() {
		arr = new int[1];
		capacity = 1;
		current = 0;
	}

	public void push(int data) {

		if (current == capacity) {
			int temp[] = new int[2 * capacity];

			for (int i = 0; i < capacity; i++) {
				temp[i] = arr[i];
			}
			capacity = 2 * capacity;
			arr = temp;
		}

		arr[current] = data;
		current++;
	}

	public void pop() {
		current--;
	}

	public int get(int index) {

		if (index < current) {
			return arr[index];
		}
		return -1;
	}

	public int size() {
		return current;
	}

	public int getCapacity() {
		return capacity;
	}

	public void print() {
		for (int i = 0; i < current; i++) {
			System.out.println(arr[i]);
		}
	}

	public void push(int index, int data) {
		if (index == capacity) {
			push(data);
		} else {
			arr[index] = data;
		}
	}

}
