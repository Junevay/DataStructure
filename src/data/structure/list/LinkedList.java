package data.structure.list;


public class LinkedList<E> implements List<E>{
	
	private class Node{
		private E data;
		private Node next;
		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
		public Node() {
			this(null,null);
		}
		@Override
		public String toString() {
			return data.toString();
		}
		
	}
	
	private int size;
	private Node dummyHead;
	
	public LinkedList() {
		this.dummyHead = new Node(null, null);
		size=0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int getSize() {
		return size;
	}

	public void add(int index,E e) {
		if(index<0||index>size)
			throw new IllegalArgumentException("下标错误");
		Node prev=dummyHead;
		for(int i=0;i<index;i++)
			prev=prev.next;
		prev.next=new Node(e,prev.next);
		size++;
	}
	
	public void addFirst(E e) {
		add(0, e);
	}
	public void addLeast(E e) {
		add(size, e);
	}
	
	public boolean contains(E e) {
		Node cur=dummyHead.next;
		while(cur!=null)
		{
			if(cur.data.equals(e))
				return true;
			cur=cur.next;
		}
		return false;
	}

	public E get(int index) {
		if(index<0||index>size)
			throw new IllegalArgumentException("下标错误");
	    Node cur=dummyHead.next;
	    for (int i = 0; i < index; i++) 
			cur=cur.next;
	    return cur.data;
		
	}
	
	public int getIndex(E e) {
		 Node cur=dummyHead.next;
		 int index=0;
		 while(cur!=null) {
			 if(cur.data.equals(e)) {
				 return index;
			 }
			 cur=cur.next;
		 }
		 return -1;
	}
	
	public void removeElement(E e) {
		 
		 Node pre=dummyHead;
		 Node cur=pre.next;
		 while(cur!=null) {
			 if(cur.data.equals(e)) {
				 pre.next=cur.next;
				 cur=null;
				 return ;
			 }
			 pre=cur;
			 cur=cur.next;
			 
		 }
	}
	
	public E getFirst() {
		return get(0);
	}
	
	public E getLeast() {
		return get(size);
	}
	
	public void set(int index,E e) {
		if(index<0||index>size)
			throw new IllegalArgumentException("下标错误");
	    Node cur=dummyHead.next;
	    for (int i = 0; i < index; i++) 
			cur=cur.next;
	    cur.data=e;
	}
	
	public E remove(int index) {
		if(index<0||index>size)
			throw new IllegalArgumentException("下标错误");
	    Node prev=dummyHead;
	    for (int i = 0; i < index; i++) 
	    	prev=prev.next;
	     Node removNode=prev.next;
	     prev.next=removNode.next;
	     removNode.next=null;
	     size--;
	     return removNode.data;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLeast() {
		return remove(size);
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		Node cur=dummyHead.next;
		while(cur!=null) {
			sb.append(cur.data);
			sb.append("->");
			cur=cur.next;
		}
		sb.append("NULL");
		return sb.toString();
	}
	
	
}
