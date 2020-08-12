package data.structure.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import data.structure.array.Array;
import data.structure.heap.MaxHeap;
import data.structure.list.LinkedList;
import data.structure.map.AVLMap;
import data.structure.map.BSTMap;
import data.structure.map.LinkedMap;
import data.structure.queue.ArrayQueue;
import data.structure.queue.LinkedListQueue;
import data.structure.queue.LoopQueue;
import data.structure.set.AVLSet;
import data.structure.set.BSTSet;
import data.structure.set.LinkedListSet;
import data.structure.stack.ArrayStack;
import data.structure.stack.LinkedListStack;
import data.structure.tree.BST;
import utils.FileOperation;

public class Test {

	public static void main(String[] args) {
		
		
		
		int n=10000000;
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		Array<Integer> arrays = new Array<Integer>(10000000);
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			maxHeap.add(random.nextInt(Integer.MAX_VALUE));
		}
		
		for (int i = 0; i < n; i++) {
			arrays.add(i, maxHeap.extractMax());
		}
		
		for (int i = 0; i < n-1; i++) {
			if(arrays.get(i)<arrays.get(i+1)) {
				throw new IllegalArgumentException("Error");
			}
		}
		
		List<String> words = new ArrayList();
		FileOperation.readFile("english.txt", words);
		
		BSTSet<String> bstSet = new BSTSet<String>();
		LinkedListSet<String> linkedListSet=new LinkedListSet<String>();
		BSTMap<String, Integer> bstMap = new BSTMap<String, Integer>();
		LinkedMap<String, Integer> linkedMap = new LinkedMap<String,Integer>();
		AVLMap<String, Integer> avlMap=new AVLMap<String, Integer>();
		AVLSet<String> avLSet=new AVLSet<String>();
		
		for (String string : words) {
			bstSet.add(string);
			
			if(bstMap.contains(string)) {
				bstMap.add(string, bstMap.get(string)+1);
			}else {
				bstMap.add(string, 1);
			}
			
			if(linkedMap.contains(string)) {
				linkedMap.add(string, linkedMap.get(string)+1);
			}else {
				linkedMap.add(string, 1);
			}
			linkedListSet.add(string);
			
			
			avLSet.add(string);
			
				if(avlMap.contains(string)) {
					avlMap.add(string, avlMap.get(string)+1);
				}else {
					avlMap.add(string, 1);
				}
			}
	
	
		System.out.println("单词的数量："+bstSet.getSize());
		System.out.println("单词的数量to："+bstMap.get("to"));
		System.out.println("单词的数量："+linkedListSet.getSize());
		System.out.println("单词的数量to："+linkedMap.get("to"));
		System.out.println("单词的数量："+avLSet.getSize());
		System.out.println("单词的数量to："+avlMap.get("to"));
		
		
		
		
		
		
		BST<Integer> bst = new BST<Integer>();

		for (int i = 0; i < 1000; i++) {
			bst.add(random.nextInt(1000));
		}
		Array<Integer> s = new Array<Integer>();
		while(!bst.isEmpty())
			s.addLeast(bst.removeMin());
			System.out.print(s);
		int nums[]={53,6,45,48,78,1,23,16,13};
		for (int i = 0; i < nums.length; i++) {
			bst.add(nums[i]);
		}
		bst.preOrder();
		System.out.println();
		bst.preOrderNR();
		System.out.println();
		System.out.println(bst);
		
	  Array<Integer> array=new Array<Integer>(1);
	  
	  for (int i = 0; i <10; i++) {
		array.addLeast(i);
	}
	  array.add(10, 12);
	  array.addFirst(100);
	  array.removeElement(0);
	 
		ArrayStack<Integer> arrayStack = new ArrayStack<Integer>(1);
		for (int i = 0; i < 10; i++) {
			 arrayStack.push(i);
			 if(i%3==0) {
				arrayStack.pop(); 
			 }
			 System.out.println(arrayStack);
		}
		
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			arrayQueue.enqueue(i);
			if(i%3==0) {
				arrayQueue.dequeue();
			}
			System.out.println(arrayQueue);
		}
		
		LoopQueue<Integer> loopQueue = new LoopQueue<Integer>(1);
		for (int i = 0; i <15; i++) {
			loopQueue.enqueue(i);
			if(i%2==0) {
				loopQueue.dequeue();
			}
			System.out.println(loopQueue);
		}
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < 11; i++) {
		   linkedList.addLeast( i);
		}
		System.out.println(linkedList);
		linkedList.add(2, 999);
		System.out.println(linkedList);
		linkedList.remove(5);
		System.out.println(linkedList);
		
		System.out.println(linkedList.contains(10));
		
		LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();
		for (int i = 0; i < 10; i++) {
			linkedListStack.push(i);
			System.out.println(linkedListStack);
			if(i%3==2) {
				linkedListStack.pop();
			}
		
		}
		
		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
		for (int i = 0; i <15; i++) {
			
			linkedListQueue.enqueue(i);
			System.out.println(linkedListQueue);
			if(i%3==2) {
				linkedListQueue.dequeue();
			}
		}
	}
}
