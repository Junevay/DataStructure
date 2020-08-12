package data.structure.tree;

import data.structure.map.BSTMap;

/**
 * 
 * @Description:字典树
 */
public class Trie {

	class Node{
		private boolean isWord;
		private BSTMap<Character, Node> next;
		
		public Node(boolean isWord) {
			this.isWord=isWord;
			next=new BSTMap<Character, Node>();
		}
		
		public Node() {
			this(false);
		}
	}
	private Node root;
	private int size;
	
	
	public Trie() {
		root=new Node();
		size=0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(String word) {
		add(root,word,0);
	}
	
	public void add(Node node,String word,int index) {
		if(!node.isWord&&index==word.length()) {
				node.isWord=true;
				size++;
				return ;
			}
		if(index<word.length()) {
			char c = word.charAt(index);
			Node nextNode=node.next.get(c);
			if(nextNode==null) {
				nextNode=new Node();
				node.next.add(c,nextNode);
			}
			
			 add(nextNode, word,index+1);
		}

	}
	
	public boolean contains(String word) {
		return contains(root,word,0);
	}

	private boolean contains(Node node, String word,int index) {
		if(index==word.length()) {
			return node.isWord;
		}
		
		char c = word.charAt(index);
		Node nextNode=node.next.get(c);
		if(nextNode!=null) {
			return contains(nextNode,word,index+1);
		}else {
			return false;
		}
	}
	
	public boolean isPrefix(String word) {
		return isPrefix(root,word,0);
	}

	private boolean isPrefix(Node node, String word, int index) {
		if(index==word.length()) {
			return true;
		}
		
		char c = word.charAt(index);
		Node nextNode=node.next.get(c);
		if(nextNode!=null) {
			return contains(nextNode,word,index+1);
		}else {
			return false;
		}
	}
}
