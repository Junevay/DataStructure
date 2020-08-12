package data.structure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import data.structure.stack.ArrayStack;

public class AVLTree<E extends Comparable<E>> implements Tree<E>{

	private class Node{

		private E data;
		private Node left;
		private Node right;
		private int height;
		
		public Node(E e) {

			this.data = e;
			this.left = null;
			this.right = null;
			this.height=0;
		}
	
		@Override
		public String toString() {
			return data.toString();
		}
		
	}
	
	private int size;
	private Node root;

	public AVLTree() {
		size=0;
		root=null;	}
	
	public AVLTree(E e) {
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
		//计算高度
		node.height=Math.max(getHeight(node.left), getHeight(node.right))+1;
		
		//计算平衡因子
		int blanceFactor = getBlanceFactor(node);
		if(Math.abs(blanceFactor)>1) {
			System.out.println("unBlance :"+blanceFactor);
		}
		//LL
		if(blanceFactor>1&&getBlanceFactor(node.left)>=0)
		return rightRotate(node);
		//RR
		if(blanceFactor<-1&&getBlanceFactor(node.right)<=0)
		return leftRotate(node);
		//LR -->LL 
		/** 对节点y进行左旋转 返回旋转后的新根节点T2
		 *   	 x                           x
		 *  	/ \                         / \ 
		 * 	   y  T4                       z  T4 
		 * 	  / \      向左旋转y          /  \ 
		 *   T1  z     ----------->      y   T3
		 *      / \                     / \
		 *     T2 T3                   T1 T2
		 */
		if(blanceFactor>1&&getBlanceFactor(node.left)<0) {
			node.left=leftRotate(node.left);
			return rightRotate(node);
		}
		//RL -->RR
		/** 对节点y进行右旋转 返回旋转后的新根节点T2
		 *   	 x                            x
		 *  	/ \                          / \
		 * 	   T1  y                        T1  z
		 * 	      / \      向右旋转y           / \
		 *       z  T4   ----------->        T2   y
		 *      / \                              / \
		 *     T2 T3                            T3 T4
		 */
		if(blanceFactor<-1&&getBlanceFactor(node.right)>0) {
			node.right=rightRotate(node.right);
			return leftRotate(node);
		}
		
		
		
		return node;
	}
	
	private int getHeight(Node node) {
		if(node==null) {
			return 0;
		}
		return node.height;
	}
	
	private int getBlanceFactor(Node node) {
		if(node==null) {
			return 0;
		}
		return getHeight(node.left)-getHeight(node.right);
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
		
		Node retNode;
		if(node.data.compareTo(e)>0) {
			node.left=remove(node.left,e);
			retNode=node;
		}else if(node.data.compareTo(e)<0){
			node.right=remove(node.right,e);
			retNode=node;
		}else {
			//删除的节点左子树为空的情况
			if(node.left==null) {
				Node rightNode = node.right;
				node.right=null;
				size--;
				retNode= rightNode;
			} else if(node.right==null) {
				Node leftNode = node.left;
				node.left=null;
				size--;
				retNode= leftNode;
			}else {
				Node nextNode=maximun(node.left);				
				nextNode.left=remove(node.left,nextNode.data);//删除左子树最大的节点，返回左子树节点
				nextNode.right=node.right;
				retNode= nextNode;
			} 
			
		}
		
		if(retNode==null)
			return null;
		//计算高度
		retNode.height = Math.max(getHeight(retNode.left), getHeight(retNode.right)) + 1;
		// 计算平衡因子
		int blanceFactor = getBlanceFactor(retNode);
		if (Math.abs(blanceFactor) > 1) {
			System.out.println("unBlance :" + blanceFactor);
		}
		// LL
		if (blanceFactor > 1 && getBlanceFactor(retNode.left) >= 0)
			return rightRotate(retNode);
		// RR
		if (blanceFactor < -1 && getBlanceFactor(retNode.right) <= 0)
			return leftRotate(retNode);
		// LR -->LL
				/** 对节点y进行左旋转 返回旋转后的新根节点T2
				 *   	 x                           x
				 *  	/ \                         / \ 
				 * 	   y  T4                       z  T4 
				 * 	  / \      向左旋转y          /  \ 
				 *   T1  z     ----------->      y   T3
				 *      / \                     / \
				 *     T2 T3                   T1 T2
				 */
		if (blanceFactor > 1 && getBlanceFactor(retNode.left) < 0) {
			retNode.left = leftRotate(retNode.left);
			return rightRotate(retNode);
		}
				//RL -->RR
				/** 对节点y进行右旋转 返回旋转后的新根节点T2
				 *   	 x                            x
				 *  	/ \                          / \
				 * 	   T1  y                        T1  z
				 * 	      / \      向右旋转y           / \
				 *       z  T4   ----------->        T2   y
				 *      / \                              / \
				 *     T2 T3                            T3 T4
				 */
		if (blanceFactor < -1 && getBlanceFactor(retNode.right) > 0) {
			retNode.right = rightRotate(retNode.right);
			return leftRotate(retNode);
		}
		
		
		return retNode;
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
		ArrayStack<AVLTree<E>.Node> stack = new ArrayStack<Node>();
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
	
	/**
	 *删除节点的最小的节点，返回右子树	
	 */
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
		 node.right=removeMax(node.right);
		 return node;
	}
	
	/** 对节点x进行右旋转 返回旋转后的新根节点y
	 *   	 x                           y
	 *  	/ \                        /   \
	 * 	   y  T1                      z     x
	 * 	  / \      向右旋转x         / \   / \
	 *   z  T2     ----------->     T4 T3 T2 T1
	 *  / \
	 * T4 T3
	 */
	private Node rightRotate(Node x) {
		Node y=x.left;
		Node T2=y.right;
		
		y.right=x;
		x.left=T2;
		
		x.height=Math.max(getHeight(x.left), getHeight(x.right))+1;
		y.height=Math.max(getHeight(y.left), getHeight(y.right))+1;
		return y;
	}
	
	/** 对节点x进行左旋转 返回旋转后的新根节点y
	 *   	 x                           y
	 *  	/ \                        /   \
	 * 	   T1  y                      x     z
	 * 	      / \      向左旋转x     / \   / \
	 *       T2  z    ----------->  T1 T2 T3 T4
	 *          / \
	 *         T3 T4
	 */
	private Node leftRotate(Node x) {
		Node y=x.right;
		Node T2=y.left;
		
		y.left=x;
		x.right=T2;
		
		x.height=Math.max(getHeight(x.left), getHeight(x.right))+1;
		y.height=Math.max(getHeight(y.left), getHeight(y.right))+1;
		return y;
	}
	
	private void inOrder(Node node,List<E> list) {
		
		if(node==null) {
			return ;
		}
		
		inOrder(node.left, list);
		list.add(node.data);
		inOrder(node.right, list);
	}
	
	public boolean isBST() {
		ArrayList<E> list = new ArrayList<E>();
		inOrder(root, list);
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i).compareTo(list.get(i-1))<0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isBlance() {
		return isBlance(root);
	}

	private boolean isBlance(Node node) {
		if(node==null) {
			return true;
		}
		if(Math.abs(getBlanceFactor(node))<=1) {
			return isBlance(node.left)&&isBlance(node.right);
		}else {
			return false;
		}
		
	}
}
