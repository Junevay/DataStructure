package data.structure.map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

	class Node {
		public K key;
		public V value;
		public Node left, right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public Node() {
			this(null, null);
		}

	}

	private Node root;
	private int size;

	@Override
	public void add(K key, V value) {
		root = add(root, key, value);
	}

	private Node add(Node node, K key, V value) {

		if (node == null) {
			size++;
			return new Node(key, value);
		}

		if (node.key.compareTo(key) > 0) {
			node.left = add(node.left, key, value);
		} else if (node.key.compareTo(key) < 0) {
			node.right = add(node.right, key, value);
		} else {
			node.value = value;
		}
		return node;
	}

	@Override
	public V remove(K key) {
		Node node = getNode(root, key);
		if (node != null) {
			root = remove(root, key);
			return node.value;
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		return getNode(root, key) != null;
	}

	@Override
	public V get(K key) {
		Node node = getNode(root, key);
		return node == null ? null : node.value;
	}

	@Override
	public void set(K key, V value) {
		Node node = getNode(root, key);
		if (node == null) {
			throw new IllegalArgumentException(key + "不存在");
		}
		node.value = value;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	private Node getNode(Node node, K key) {
		if (node == null) {
			return null;
		}

		if (key.compareTo(node.key) > 0) {
			return getNode(node.right, key);
		} else if (key.compareTo(node.key) < 0) {
			return getNode(node.left, key);
		} else {
			return node;
		}

	}

	private Node getMaxNode(Node node) {
		if (node.right != null) {
			return getMaxNode(node);
		}
		return node;
	}

	private Node removeMax(Node node) {
		if (node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}

		node.right = removeMax(node.right);
		return node;
	}

	private Node remove(Node node, K key) {
		if (node == null) {
			return null;
		}

		if (key.compareTo(node.key) > 0) {
			return node.right = remove(node.right, key);
		} else if (key.compareTo(node.key) < 0) {
			return node.left = remove(node.left, key);
		} else {

			// 删除的节点 左节点为null
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}

			// 删除的节点 右节点为null
			if (node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}

			// 左右子树都不为空的情况下
			// 1。找到删除节点的右子树的最小节点，代替删除节点

			// 2. 找到删除节点的左子树的最大节点，代替删除节点
			Node replaceNode = getMaxNode(node.left);
			replaceNode.left = removeMax(node.left);
			replaceNode.right = node.right;
			node.left = node.right = null;
			return replaceNode;
		}

	}
}
