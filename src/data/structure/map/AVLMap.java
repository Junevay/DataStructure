package data.structure.map;

import data.structure.tree.AVLKVTree;

public class AVLMap<K extends Comparable<K>,V> implements Map<K, V> {

	private AVLKVTree<K, V> avlTree;
	
	public AVLMap() {
		avlTree=new AVLKVTree<>();
	}
	
	@Override
	public void add(K key, V value) {
		avlTree.add(key, value);
	}

	@Override
	public V remove(K key) {
		return avlTree.remove(key);
	}

	@Override
	public boolean contains(K key) {
		return avlTree.contains(key);
	}

	@Override
	public V get(K key) {
		return avlTree.get(key);
	}

	@Override
	public void set(K key, V value) {
		avlTree.set(key,value);
	}

	@Override
	public int getSize() {
		return avlTree.getSize();
	}

	@Override
	public boolean isEmpty() {
		return avlTree.isEmpty();
	}

}
