package data.structure.array;


public class Array <E> {

	private E [] data;
	private int size;
	
	
	
	public Array() {
	  this(10);
	}
     
	public Array(int capacity) {
		 data=(E[])new Object [capacity];
		size=0;
		}
	public Array(E[] es) {
		 data = (E []) new Object[es.length];
		 for (int i = 0; i < es.length; i++) {
			data[i]=es[i];
		}
		 size=es.length; 
	}

	public void set(int index,E e) {
		if(index<0||index>size)
			throw new IllegalArgumentException("数组下标越界");
		data[index]=e;
	}

	public E get(int index) {
		if(index<0||index>=size)
			throw new IllegalArgumentException("数组下标越界");
		return data[index];
	}
	
	public E getFirst() {
		
		return get(0);
	}
	
	public E getLeast() {
		return get(size-1);
	}
	
	public void add(int index,E e)  {
		if(size==data.length)
			resize(2*data.length);
		if(index<0||index>size)
			throw new IllegalArgumentException("数组下标越界");
		for(int i=size-1;i>=index;i--) {
			data[i+1]=data[i];
		}
		data[index]=e;
		size++;
	}
	
	public void addFirst(E e) {
		add(0, e);
	}
	
	public void addLeast(E e) {
		add(size, e);
	}

	public int getCapacity() {
		return data.length;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public boolean contians(E e) {
		for (int i = 0; i < size; i++) {
			if(data[i].equals(e))
				return true;
		}
		return false;
	}
	
	public int find(E e) {
		for (int i = 0; i < size; i++) {
			if(data[i].equals(e))
				return i;
		}
        return -1;
	}
	
	public E remove(int index) {
		if(index<0||index>=size)
			throw new IllegalArgumentException("数组下标越界");
		E res=data[index];
		for (int i =index; i < size-1; i++) {
			data[i]=data[i+1];
		}
		size--;
		data[size]=null;
		if(data.length/4==size&&data.length/2!=0)
			resize(data.length/2);
		return res;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLeast() {
		return remove(size-1);
	}
	
	public int removeElement(E e) {
		int find = find(e);
		remove(find);
		return find;
	}
	
	public void resize(int capacity) {
	E []newData= (E[])new Object [capacity];
	for (int i = 0; i < size; i++) {
		newData[i]=data[i];
	}
	 data=newData;
	}

	@Override
	public String toString() {
		StringBuilder res=new StringBuilder();
		res.append(String.format("Array : size=%d capacity=%d \n", size,data.length));
		res.append("data :[");
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if(i!=size-1) {
				res.append(",");
			}
		}
		res.append("]");
		return res.toString();
	}

	public void swap(int i, int j) {
		if((i<0||i>size)||(j<0||j>size))
			throw new IllegalArgumentException("数组下标越界");
		
		E temp=data[i];
		data[i] = data[j];
		data[j]=temp;
		
	}
	

}
