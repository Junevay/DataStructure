package data.structure.tree;

import data.structure.stack.ArrayStack;

/**
 * 
 * @Description:右斜红黑树
 * @author MK517775
 * @date 2019年11月26日 上午11:23:34
 */
public class RBTree<E extends Comparable<E>> implements Tree<E>{

	private final boolean RED=true;
	private final boolean BLACK=false;
	
	
	private class Node{
		private E data;
		private Node left;
		private Node right;
		private boolean color=RED;
		public Node(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		public Node() {
			this(null);
		}
		@Override
		public String toString() {
			return data.toString();
		}
		
	}
	
	private int size;
	private Node root;

	public RBTree() {
		size=0;
		root=null;	}
	
	public RBTree(E e) {
		size=1;
		root=new Node(e);	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void add(E e) {
		root=add(root,e);
	}

	/**
	 * node           node                  y                   
	 *    \   右旋转     \      左旋转     / \      颜色翻转   
	 *     x   ----->     y    ------>  node  x    --------->         
	 *    /                \                                     
	 *   y                  x                                       
	 */
	private Node add(Node node,E e) {
		if(node==null) {
			size++;
			return root=new Node(e);
		} 
		
		if(node.data.compareTo(e)>0) {
			node.left=add(node.left,e);
		}else if(node.data.compareTo(e)<0){
			node.right=add(node.right,e);
		}
		
		if(isRed(node.left)&&!isRed(node.right)) {
			node=rightRotate(node);
		}
		
		if(isRed(node.right)&&isRed(node.right.right)) {
			node=leftRotate(node);
		}
		
		if(isRed(node.left)&&isRed(node.right)) {
			flipColors(node);
		}
		
		return node;
	}
	
	@Override
	public boolean contains(E e) {
		return contains(root,e);
	}
	
	private boolean contains(Node node,E e) {
		if(node==null) {
			return false;
		}
		if(node.data.compareTo(e)>0) {
			return contains(node.left,e);
		}else if(node.data.compareTo(e)<0){
			return contains(node.right,e);
		}else {
			return true;
		}
		
	}

	@Override
	public void remove(E e) {
		root=remove(root,e);
	}
	
	private Node remove(Node node,E e) {
		if(node==null) {
			return node ;
		}
		if(node.data.compareTo(e)>0) {
			node.left=remove(node.left,e);
		}else if(node.data.compareTo(e)<0){
			node.right=remove(node.right,e);
		}else {
			if(node.left==null) {
				node =removeMin(node);
			} else if(node.right==null) {
				node= removeMax(node);
			}else {
				Node nextNode=maximun(node.left);				
				nextNode.left=removeMax(node.left);
				nextNode.right=node.right;
				return nextNode;
			} 
			
		}
		return node;
	}
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node node) {
		
		if(node ==null) {
			return ;
		}
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right); 
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root,0,res);
		return res.toString();
	}

	private void generateBSTString(Node node, int depth, StringBuilder res) {
		if(node==null) {
			res.append(generateDepthString(depth)+"null\n");
			return ;
		}
		res.append(generateDepthString(depth)+node.data+"\n");
		generateBSTString(node.left,depth+1,res);
		generateBSTString(node.right,depth+1,res);

	}

	private String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			res.append("--");
		}
		return res.toString();
	}
	
	public void preOrderNR() {
		ArrayStack<RBTree<E>.Node> stack = new ArrayStack<Node>();
		stack.push(root);
		while(!stack.isEmpty()) {
		
		  Node curNode=stack.pop();
		  System.out.println(curNode);
		  if(curNode.right!=null)
			  stack.push(curNode.right);
		  if(curNode.left!=null)
			  stack.push(curNode.left);
		}
	}

	public E minimun() {
		if(size==0) {
			throw new IllegalArgumentException("BST is empty!");
		}
		return minimun(root).data;
	}
	
	private Node minimun(Node node) {
		if(node.left==null) {
			return node;
		}
		return minimun(node.left);
	}
	
	public E maximun() {
		if(size==0) {
			throw new IllegalArgumentException("BST is empty!");
		}
		return maximun(root).data;
	}
	
	private Node maximun(Node node) {
		if(node.right==null) {
			return node;
		}
		return maximun(node.right);
	}
	
	private Node removeMin(Node node) {
		if(node.left==null) {
			Node rightNode = node.right;
			node.right=null;
			size--;
			return rightNode;
		}
		 node.left=removeMin(node.left);
		 return node;
	}
	
	public E removeMax() {
	   E maximun = maximun();
	   root=removeMax(root);
	   return maximun;
	}
	public E removeMin() {
		E minimun = minimun();
		root=removeMin(root);
		return minimun;
	}
	private Node removeMax(Node node) {
		if(node.right==null) {
			Node leftNode = node.left;
			node.left=null;
			size--;
			return leftNode;
		}
		 node.right=removeMin(node.right);
		 return node;
	}
	
	/** 对节点node进行右旋转 返回旋转后的新根节点x
	 *      node                        x
	 *  	/ \                        / \
	 * 	   x  T1                      T3 node 
	 * 	  / \      向右旋转node          / \
	 *  T3  T2     ----------->         T2 T1
	 */
	private Node rightRotate(Node node) {
		Node x=node.left;
		
		node.left=x.right;
		x.right=node;
		
		x.color=node.color;
		node.color=RED;
		return x;
	}
	
	/** 对节点x进行左旋转 返回旋转后的新根节点y
	 *   	node                        x
	 *  	/ \                        / \
	 * 	   T1  x                     node T3
	 * 	      / \      向左旋转x     / \   
	 *       T2 T3    ----------->  T1 T2 
	 */
	private Node leftRotate(Node node) {
	
		Node x=node.right;
		
		node.right=x.left;
		x.left=node;

		x.color=node.color;
		node.color=RED;
		return x;
	
	}
	
	private void flipColors(Node node) {
		
		node.color=RED;
		node.left.color=BLACK;
		node.right.color=BLACK;
	}
	
	private boolean isRed(Node node) {
		if(node==null) {
			return BLACK;
		}
		return node.color;
	}
	
}
