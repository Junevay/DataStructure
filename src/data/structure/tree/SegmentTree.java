package data.structure.tree;


public class SegmentTree<E> {

	private E data[];
	private E tree[];
	private Merage<E> merage;
	
	public SegmentTree(E arr[],Merage<E> merage) {
		data=(E[]) new Object[arr.length];
		tree=(E[]) new Object[4*arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i]=arr[i];
		}
		this.merage=merage;
		buildSegmentTree(0,0,data.length-1);
		
	}

	private void buildSegmentTree(int treeIndex, int i, int j) {
		
		if(i==j) {
			tree[treeIndex]=data[j];
			return ;
		}		
		
		int leftChild=leftChild(treeIndex);
		int rightChild=rightChild(treeIndex);
		
		int mid = i +(j-i)/2;
		buildSegmentTree(leftChild,i,mid);
		buildSegmentTree(rightChild,mid+1,j);
		
		tree[treeIndex]=merage.Mergae(tree[leftChild], tree[rightChild]);
		
			
	}
	
	public int leftChild(int index) {
		return 2*index+1;
	}
	public int rightChild(int index) {
		return 2*index+2;
	}
	public int getSize() {
		return data.length;
	}
	public boolean isEmpty() {
		return data.length==0;
	}
	
	public String toString() {
		StringBuilder res =new StringBuilder();
		res.append("[");
		for (int i = 0; i < tree.length; i++) {
			if(tree[i]!=null) {
				res.append(tree[i]);
			}else {
				res.append("null");
			}
			
			if(i!=tree.length-1) {
				res.append(",");
			}
		}
		res.append("]");
		return res.toString();
	}
	
	public E query(int queryL,int queryR) {
		if((queryL<0||queryL>=data.length)||(queryR<0||queryR>=data.length)) {
			throw new IllegalArgumentException("数组下标越界");
		}
		return query(0,0,data.length-1,queryL, queryR);
	}

	private E query(int treeIndex, int l, int r, int queryL, int queryR) {
		if(queryL==l&&queryR==r) {
			return tree[treeIndex];
		}
		int leftChild = leftChild(treeIndex);
		int rightChild = rightChild(treeIndex);
		int mid=l+(r-l)/2;
		if(queryL>=mid+1) {
			return query(rightChild, mid+1, r, queryL, queryR);
		}else if(queryR<=mid) {
			return query(leftChild, l, mid, queryL, queryR);

		}
		
			E res= merage.Mergae( query(leftChild, l, mid, queryL, mid),  query(rightChild, mid+1, r, mid+1, queryR))        ;
			return res;
	
		
	}
	
	public void set(E e ,int index) {
		if(index<0||index>=data.length) {
			throw new IllegalArgumentException("数组下标越界");
		}
		data[index]=e;
		 set(0,0,data.length-1,e, index);
	}
	
	private void set(int treeIndex, int l, int r, E e, int index) {
		if(r==l) {
			 tree[treeIndex]=e;
			 return ;
		}
		int leftChild = leftChild(treeIndex);
		int rightChild = rightChild(treeIndex);
		int mid=l+(r-l)/2;
		if(index>=mid+1) {
			 set(rightChild, mid+1, r, e, index);
		}else if(index<=mid) {
			set(leftChild, l, mid, e, index);

		}
		tree[treeIndex]=merage.Mergae(tree[leftChild],tree[rightChild]);

		
	}
}
