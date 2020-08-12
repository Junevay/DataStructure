package data.structure.queue;

import data.structure.array.Array;

public class ArrayQueue<E> implements Queue<E> {

	private Array<E> data;

	public ArrayQueue() {
		this(10);
	}
	
	public ArrayQueue(int capacity) {
		data=new Array<E>(capacity);
	}

	@Override
	public void enqueue(E e) {
		data.addLeast(e);
	}

	@Override
	public E dequeue() {
		return data.removeFirst();
	}

	@Override
	public E front() {
		return data.getFirst();
	}

	@Override
	public int getSize() {
		return data.getSize();
	}

	public int getCapacity() {
		return data.getCapacity();
	}
	
	@Override
	public String toString() {
		StringBuilder res=new StringBuilder();
		res.append(String.format("Queue : size=%d capacity=%d \n", data.getSize(),data.getCapacity()));
		res.append("data : top [");
		for (int i = 0; i < data.getSize(); i++) {
			res.append(data.get(i));
			if(i!=data.getSize()-1) {
				res.append(",");
			}
		}
		res.append("] tail");
		return res.toString();
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
}
