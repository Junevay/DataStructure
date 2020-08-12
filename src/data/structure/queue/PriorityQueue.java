package data.structure.queue;

import data.structure.heap.MaxHeap;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {


	private MaxHeap<E> heap;
	
	public PriorityQueue() {
		heap=new MaxHeap<E>();
	}
	
	@Override
	public void enqueue(E e) {
		heap.add(e);
	}

	@Override
	public E dequeue() {
		return heap.extractMax();
	}

	@Override
	public E front() {
		return heap.findMax();
	}

	@Override
	public int getSize() {
		return heap.getSize();
	}

	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}

}
