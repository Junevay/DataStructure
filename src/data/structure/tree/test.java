package data.structure.tree;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import data.structure.set.BSTSet;
import utils.FileOperation;

public class test {
	public static void main(String[] args) {
		Integer[] nums= {1,2,3,4,5,6,7,8,9};
		SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(nums,(a,b)->a+b);
		System.out.println(segmentTree);
		Integer query = segmentTree.query(2, 4);
		System.out.println(query);
		
		
		List<String> words = new ArrayList();
		FileOperation.readFile("english.txt", words);
		
		AVLTree<String> avlTree = new AVLTree<String>();
		BSTSet<String> bstSet = new BSTSet<String>();
		Trie trie = new Trie();
		for (String string : words) {
			bstSet.add(string);
			avlTree.add(string);
			trie.add(string);
		}
		System.out.println(trie.getSize()+"   "+bstSet.getSize() +"isBst:"+ avlTree.isBST()+"isBlance:"+avlTree.isBlance());
		for (String string : words) {
			
			avlTree.remove(string);
			if(!avlTree.isBlance()||!avlTree.isBST()) {
				throw new IllegalArgumentException("error");
			}
		}
		
		
		int n=10000000;
		Random random = new Random();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			arrayList.add(random.nextInt(Integer.MAX_VALUE));
		}
		
		
		LocalDateTime startTime = LocalDateTime.now();
		AVLTree<Integer> avlTree2 = new AVLTree<Integer>();
		for (Integer integer : arrayList) {
			avlTree2.add(integer);
		}
		
		LocalDateTime endTime = LocalDateTime.now();
		 Duration between = Duration.between(startTime, endTime);
		System.out.println("avltree use Time"+between.getSeconds());
		
		 startTime = LocalDateTime.now();
		
		
		RBTree<Integer> rbTree = new RBTree<Integer>();
		for (Integer integer : arrayList) {
			rbTree.add(integer);
		}
		
		 endTime = LocalDateTime.now();
		  between = Duration.between(startTime, endTime);
		System.out.println("rbTree use Time"+between.getSeconds());
	
	}
}
