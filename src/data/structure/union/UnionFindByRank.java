package data.structure.union;

public class UnionFindByRank implements UF{

	
	private int [] parent;
	private int [] rank;
	
	public UnionFindByRank(int size) {
		
		parent=new int [size];
		this.rank=new int [size];
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
		
		if(rank[qRoot]>rank[pRoot]) {
			parent[pRoot]=qRoot;
		}else if(rank[qRoot]<rank[pRoot]) {
			parent[qRoot]=pRoot;
		}else if(rank[qRoot]==rank[pRoot]){
			parent[qRoot]=pRoot;
			rank[pRoot]+=1;
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
