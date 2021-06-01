package array;

public class Trie {
	static final int ALPHABET_SIZE = 26;

	static class TrieNode {
		boolean isLeaf;
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];

		TrieNode() {
			isLeaf = false;
			for (int i = 0; i < ALPHABET_SIZE; i++) {
				children[i] = null;
			}
		}
	}

	static TrieNode root = null;

	public static void insert(String key) {
		int length = key.length();

		TrieNode pCrawl = root;

		for (int i = 0; i < length; i++) {
			int index = key.charAt(i) - 'a';
			if (pCrawl.children[index] == null) {
				pCrawl.children[index] = new TrieNode();
			}
			pCrawl = pCrawl.children[index];
		}
		pCrawl.isLeaf = true;
	}

	public static boolean search(String key) {
		TrieNode pCrawl = root;
		int length = key.length();

		for (int i = 0; i < length; i++) {
			int index = key.charAt(i) - 'a';
			if (pCrawl.children[index] == null) {
				return false;
			}
			pCrawl = pCrawl.children[index];
		}
		return (pCrawl != null && pCrawl.isLeaf);

	}

	public static void main(String args[]) {
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

		String output[] = { "Not present in trie", "Present in trie" };

		root = new TrieNode();

		int i;
		for (i = 0; i < keys.length; i++)
			insert(keys[i]);

		if (search("the") == true)
			System.out.println("the --- " + output[1]);
		else
			System.out.println("the --- " + output[0]);

		if (search("these") == true)
			System.out.println("these --- " + output[1]);
		else
			System.out.println("these --- " + output[0]);

		if (search("their") == true)
			System.out.println("their --- " + output[1]);
		else
			System.out.println("their --- " + output[0]);

		if (search("thaw") == true)
			System.out.println("thaw --- " + output[1]);
		else
			System.out.println("thaw --- " + output[0]);

	}
}
