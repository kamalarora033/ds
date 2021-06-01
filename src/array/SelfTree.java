package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SelfTree {

	class TreeNode {
		int value;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "TreeNode [value=" + value + ", left=" + left + ", right=" + right + "]";
		}

	}

	TreeNode root;

	SelfTree() {
		root = null;
	}

	@Override
	public String toString() {
		return "SelfTree [root=" + root + "]";
	}

	public void insert(int value) {
		TreeNode newNode = new TreeNode(value);

		if (root == null) {
			root = newNode;
		} else {
			TreeNode currentNode = root;
			while (true) {
				if (value < currentNode.value) {
					if (currentNode.left == null) {
						currentNode.left = newNode;
						return;
					}
					currentNode = currentNode.left;
				} else {
					if (currentNode.right == null) {
						currentNode.right = newNode;
						return;
					}
					currentNode = currentNode.right;
				}
			}
		}
	}

	public TreeNode lookup(int value) {

		if (root == null) {
			return null;
		}
		TreeNode currentNode = root;
		while (currentNode != null) {
			if (value < currentNode.value) {
				currentNode = currentNode.left;
			} else if (value > currentNode.value) {
				currentNode = currentNode.right;
			} else if (value == currentNode.value) {
				return currentNode;
			}
		}
		return null;
	}

	public TreeNode traverse(TreeNode node) {
		node.left = node.left == null ? null : traverse(node.left);
		node.right = node.right == null ? null : traverse(node.right);
		return node;
	}

	public List<Integer> bfs() {
		Queue<TreeNode> trackNodes = new LinkedList<>();
		List<Integer> bfsValues = new ArrayList<>();
		TreeNode currentNode = this.root;
		if (root == null) {
			return null;
		}
		trackNodes.add(currentNode);
		while (!trackNodes.isEmpty()) {
			currentNode = trackNodes.remove();
			bfsValues.add(currentNode.value);
			if (currentNode.left != null) {
				trackNodes.add(currentNode.left);
			}
			if (currentNode.right != null) {
				trackNodes.add(currentNode.right);
			}
		}
		return bfsValues;
	}

	public List<Integer> dfsPreOrder(TreeNode root, List<Integer> data) {
		if (root != null) {
			data.add(root.value);
			dfsPreOrder(root.left, data);
			dfsPreOrder(root.right, data);
		}
		return data;
	}
	
	public List<Integer> dfsInOrder(TreeNode root, List<Integer> data){
		if(root != null) {
			dfsInOrder(root.left, data);
			data.add(root.value);
			dfsInOrder(root.right, data);
		}
		return data;
	}
	
	public List<Integer> dfsPostOrder(TreeNode root, List<Integer> data){
		if(root != null) {
			dfsPostOrder(root.left, data);
			dfsPostOrder(root.right, data);
			data.add(root.value);
		}
		return data;
	}

	public List<Integer> bfsR(Queue<TreeNode> queue, List<Integer> list) {
		if (queue.size() == 0) {
			return list;
		}
		TreeNode currentNode = queue.poll();
		list.add(currentNode.value);
		if (currentNode.left != null) {
			queue.add(currentNode.left);
		}
		if (currentNode.right != null) {
			queue.add(currentNode.right);
		}
		return bfsR(queue, list);
	}

	//    9
	// 4     20
	//1 6  15 170

	public static void main(String[] args) {
		SelfTree tree = new SelfTree();
		tree.insert(9);
		tree.insert(4);
		tree.insert(6);
		tree.insert(20);
		tree.insert(170);
		tree.insert(15);
		tree.insert(1);
		// System.out.println(tree.traverse(tree.root));
		System.out.println(tree.bfs());
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(tree.root);
		List<Integer> bfsR = tree.bfsR(queue, new ArrayList<>());
		System.out.println("bsfR is " + bfsR);
		
		System.out.println("dfs preorder is "+ tree.dfsPreOrder(tree.root, new ArrayList<>()));
		System.out.println("dfs inorder is "+tree.dfsInOrder(tree.root, new ArrayList<>()));
		System.out.println("dfs postorder is "+tree.dfsPostOrder(tree.root, new ArrayList<>()));
		// System.out.println(tree);
	}
}
