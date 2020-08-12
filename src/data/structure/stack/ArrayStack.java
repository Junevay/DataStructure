package data.structure.stack;


import data.structure.array.Array;

public class ArrayStack<E> implements Stack<E>{
	
	private Array<E> data;
	
	

	public ArrayStack(int capacity) {
		
		this.data = new Array<E>(capacity);
	}
	
	public ArrayStack() {
		
		this(10);
	}
	

	@Override
	public void push(E e) {
		data.addLeast(e);
	}

	@Override
	public E pop() {
		return data.removeLeast();
	}

	@Override
	public E peek() {
		return data.getFirst();
	}

	@Override
	public int getSize() {
		return data.getSize();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}
	

	public int getCapacity() {
		return data.getCapacity();
	}

	@Override
	public String toString() {
		StringBuilder res=new StringBuilder();
		res.append(String.format("Stack : size=%d capacity=%d \n", data.getSize(),data.getCapacity()));
		res.append("data :[");
		for (int i = 0; i < data.getSize(); i++) {
			res.append(data.get(i));
			if(i!=data.getSize()-1) {
				res.append(",");
			}
		}
		res.append("] top");
		return res.toString();
	}

	
}
