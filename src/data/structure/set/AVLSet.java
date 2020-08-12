package data.structure.set;

import data.structure.tree.AVLKVTree;

public class AVLSet<E extends Comparable<E>> implements Set<E> {

	private AVLKVTree<E, Object> avlkvTree;
	
	public AVLSet() {
		avlkvTree=new AVLKVTree();
	}
	

	@Override
	public void add(E e) {
		avlkvTree.add(e, null);
	}

	@Override
	public void remove(E e) {
		avlkvTree.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return avlkvTree.contains(e);
	}

	@Override
	public int getSize() {
		return avlkvTree.getSize();
	}

	@Override
	public boolean isEmpty() {
		return avlkvTree.isEmpty();
	}
	
	
}
