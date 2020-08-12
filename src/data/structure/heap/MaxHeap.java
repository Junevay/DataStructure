package data.structure.heap;

import data.structure.array.Array;

public class MaxHeap<E extends Comparable<E>>{
	
	private Array<E> data;
	
	public MaxHeap() {
		data=new Array<E>();
	}
	
	public  MaxHeap(int capacity) {
		data=new Array<E>(capacity);
	}
	
	public  MaxHeap(E [] es) {
		data=new Array<E>(es);
		int n = parent(data.getSize()-1);
		for (int i = n; i >= 0; i--) {
			siftDown(i);
		}
	}
	
	public int getSize() {
		return data.getSize();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	private int parent(int index) {
		if(index==0) {
			throw new IllegalArgumentException("0 不存在父节点");
		}
		return (index-1)/2;
	}
	
	private int leftChild(int index) {
		return index*2+1;
	}
	
	private int rightChild(int index) {
		return index*2+2;
	}
	
	public void add(E e) {
		data.addLeast(e);
		siftUp(data.getSize()-1);
	}

	//添加元素到最后面，然后进行上浮操作，与父节点比较大小
	private void siftUp(int i) {	
		while (i!=0&&data.get(i).compareTo(data.get(parent(i)))>0) {
			data.swap(i,parent(i));
			i=parent(i);
		}
	}
	
	public E findMax() {
		if(data.getSize()==0) {
			throw new IllegalArgumentException("MaxHeep 不存在元素");
		}
		return data.get(0);
	}
	
	//取出最大值，最后一个和第一个交换，然后删除最后一个元素，进行下沉的操作
	public E extractMax() {
		E ret=findMax();
		data.swap(0, data.getSize()-1);
		data.removeLeast();
		siftDown(0);
		return ret;
	}

	//从上往下比较，大的放前面
	private void siftDown(int i) {
		
		while(leftChild(i)<data.getSize()) {
			int j=leftChild(i);
			if(j+1<data.getSize()&&data.get(j+1).compareTo(data.get(j))>0)
				j=rightChild(i);
			if(data.get(i).compareTo(data.get(j))>0)
				break;
			data.swap(i, j);
			i=j;
		}
	}
	
	public E replace(E e) {
		E ret=data.get(0);
		data.set(0, e);
		siftDown(0);
		return ret;		
	}
	

		
	
}
