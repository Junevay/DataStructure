package data.structure.list;

public interface List<E> {

	boolean isEmpty();
	
	int getSize();
	
	void add(int index,E e);
	
	boolean contains(E e);
	
	E get(int index);
	
	void set(int index,E e);
	
	E remove(int index);
}
