package data.structure.queue;

public interface Queue<E> {

	void enqueue(E e);
	
	E dequeue();
	
	E front();
	
	int getSize();
	
	boolean isEmpty();

}
