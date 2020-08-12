package data.structure.queue;



public class LinkedListQueue<E> implements Queue<E> {
	

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
		
		public Node(E e) {
			this(e,null);
		}

		public String toString() {
			return data.toString();
		}
		
	}
	
	private Node front;
	private Node tail;
	private int size;
	
	
	
	public LinkedListQueue() {
	
		this.front = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public void enqueue(E e) {
		if(tail!=null) {
			tail.next=new Node(e);
			tail=tail.next;
		}else {
			tail=new Node(e);
			front=tail;
		}
		size++;
	}

	@Override
	public E dequeue() {
		if(isEmpty())
			throw new IllegalArgumentException("队列为空");
		Node res=front;
		front=front.next;
		res.next=null;
		if(front==null)
			tail=null;
		size--;
		return res.data;
	}

	@Override
	public E front() {
		if(isEmpty())
			throw new IllegalArgumentException("队列为空");
		return front.data;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Queue top :[");
		Node cur=front;
		while(cur!=null) {
			sb.append(cur);
			sb.append("->");
			cur=cur.next;
		}
		sb.append("NULL]tail");
		return sb.toString();
	}



}
