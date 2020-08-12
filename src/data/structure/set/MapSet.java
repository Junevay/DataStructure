package data.structure.set;



import data.structure.map.BSTMap;

public class MapSet<E extends Comparable<E>> implements Set<E>{


	private   BSTMap<E,Object> bstMap;
	
	@Override
	public void add(E e) {
		bstMap.add(e, null);
	}

	@Override
	public void remove(E e) {
		bstMap.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return bstMap.contains(e);
	}

	@Override
	public int getSize() {
		return bstMap.getSize();
	}

	@Override
	public boolean isEmpty() {
		return bstMap.isEmpty();
	}

}
