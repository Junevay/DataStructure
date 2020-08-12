package data.structure.tree;

public interface Tree<E> {
	
	boolean isEmpty();
	
	int getSize();
	
	void add(E e);
	
	boolean contains(E e);

	
	void remove(E e);
}
