package data.structure.set;

import data.structure.list.LinkedList;

public class LinkedListSet<E> implements Set<E>{

	private LinkedList<E> linkedList;
	
	
	
	public LinkedListSet() {
		super();
		this.linkedList = new LinkedList<E>();
	}

	@Override
	public void add(E e) {
		if(!linkedList.contains(e))
			linkedList.addFirst(e);
	}

	@Override
	public void remove(E e) {
		linkedList.removeElement(e);
	}

	@Override
	public boolean contains(E e) {
		return linkedList.contains(e);
	}

	@Override
	public int getSize() {
		return linkedList.getSize();
	}

	@Override
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

}
