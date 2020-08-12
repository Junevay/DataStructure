package data.structure.union;

public class UnionFindBySize implements UF{

	private int [] parent;
	private int [] size;
	
	public UnionFindBySize(int size) {
		
		parent=new int [size];
		this.size=new int [size];
		for (int i = 0; i < size; i++) {
			parent[i]=i;
		}	
	}
	
	
	@Override
	public int getSize() {
		return parent.length;
	}

	@Override
	public void unionElements(int p, int q) {
		
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot==qRoot)
			return ;
		
		if(size[pRoot]>size[qRoot]) {
			parent[qRoot]=pRoot;
			size[pRoot]+=size[qRoot];
		}else {
			parent[pRoot]=qRoot;
			size[qRoot]+=size[pRoot];
		}
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find(p)==find(q);
	}
	
	private int find(int p) {
		if(p<0||p>=parent.length) {
			throw new IllegalArgumentException("p is out of bound");
		}
		while(parent[p]!=p)
			p=parent[p];
		return p;
	}

	
}
