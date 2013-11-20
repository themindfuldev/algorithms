package datastructures.list;

public interface LinearList<T> {
	public void addFirst(T value);
	public void addLast(T value);
	public void insert(T value, int index);
	public T get(int index);
	public T remove(int index);
	public boolean remove(T value);
	public int size();
	public String print();
}
