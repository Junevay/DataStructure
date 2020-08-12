package data.structure.queue;

import java.util.Date;

public class LoopQueue<E> implements Queue<E>{

	private E [] data;
	private int front,tail;
	private int size;
	
	
	public LoopQueue(int capacity) {
		this.data = (E[]) new Object [capacity+1];
		this.front = 0;
		this.tail = 0;
		this.size = 0;
	}
	
	public LoopQueue() {
		this(10);
	}

	@Override
	public void enqueue(E e) {
		if(isFull()) {
			resize(getCapacity()*2);
		}
		data[tail]=e;
		tail=(tail+1)%data.length;
		size++;
	}

	@Override
	public E dequeue() {
		if(isEmpty()) 
		throw new IllegalArgumentException("队列没有数据");
		E res=data[front];
		data[front]=null;
		front=(front+1)%data.length;
		size--;
		if(size==getCapacity()/4&&getCapacity()/2!=0) {
			resize(getCapacity()/2);
		}
		return res;
	}
	
	public void resize(int capacity) {
		E []newData=(E[])new Object[capacity+1];
		for(int i=0;i<size;i++) {
			newData[i]=data[(front+i)%data.length];
		}
		data=newData;
		front=0;
		tail=size;
	}

	@Override
	public E front() {
		if(isEmpty()) 
			throw new IllegalArgumentException("队列没有数据");
		return data[front];
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front==tail;
	}
	
	public int getCapacity() {
		return data.length-1;
	}
	
	public boolean isFull() {
		return (tail+1)%data.length==front;
	}

	
	@Override
	public String toString() {
		StringBuilder res=new StringBuilder();
		res.append(String.format("LoopQueue : size=%d capacity=%d \n", size,getCapacity()));
		res.append("data : top [");
		for (int i = front; i !=tail; i=(i+1)%data.length) {
			res.append(data[i]);
			if((i+1)%data.length!=tail) {
				res.append(",");
			}
		}
		res.append("] tail");
		return res.toString();
	}
}
