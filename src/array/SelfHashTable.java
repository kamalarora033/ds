package array;

import java.util.ArrayList;
import java.util.List;

class HashNode<K, V> {
	K key;
	V value;

	HashNode<K, V> next;

	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

class Map<K, V> {

	private List<HashNode<K, V>> bucketArray;
	private int numBuckets;
	private int size;

	public Map() {
		bucketArray = new ArrayList<>();
		numBuckets = 10;
		size = 0;

		for (int i = 0; i < numBuckets; i++) {
			bucketArray.add(null);
		}
	}

	public int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % numBuckets;

		index = index < 0 ? index * -1 : index;
		return index;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public V get(K key) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(bucketIndex);

		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public V remove(K key) {
		int index = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(index);

		HashNode<K, V> prev = null;

		while (head != null) {
			if (head.key.equals(key)) {
				break;
			}
			prev = head;
			head = head.next;
		}
		if (head == null) {
			return null;
		}
		size--;

		if (prev != null) {
			prev.next = head.next;
		} else {
			bucketArray.set(index, head.next);
		}
		return head.value;
	}

	public void add(K key, V value) {
		int index = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(index);

		HashNode<K, V> newNode = new HashNode<K, V>(key, value);

		while (head != null) {
			if (head.key.equals(key)) {
				return;
			}
			head = head.next;
		}
		size++;
		head = bucketArray.get(index);
		newNode.next = head;
		bucketArray.set(index, newNode);

	}
}

public class SelfHashTable {
	public static void main(String[] args) {
		Map<String, Integer> map = new Map<>();
		map.add("this", 1);
		map.add("coder", 2);
		map.add("this", 4);
		map.add("hi", 5);
		System.out.println(map.size());
		System.out.println(map.remove("this"));
		System.out.println(map.remove("this"));
		System.out.println(map.size());
		System.out.println(map.isEmpty());
	}
}
