package datastructures.list;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SequentialOrderedLinearList<T extends Comparable<T>> implements
		LinearList<T> {
	
	private class Node<U extends Comparable<U>> {
		private U value;
		private int next;

		public Node(U value, int next) {
			super();
			this.value = value;
			this.next = next;
		}

		public U getValue() {
			return value;
		}

		public int getNext() {
			return next;
		}

		public void setNext(int next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "[" + value.toString() + ", next=" + next + "]";
		}
		
	}

	@SuppressWarnings("unchecked")
	private Node<T>[] list = new Node[256901116];
	private int headIndex = -1;
	private int tailIndex = -1;
	private int lastIndex = 0;

	@Override
	public void addFirst(T value) {
		throw new NotImplementedException();
	}

	@Override
	public void addLast(T value) {
		if (lastIndex < list.length) {
			int nextIndex = -1, 
				index = headIndex,
				previousIndex = -1;
			
			while (index != -1) {
				if (previousIndex != -1) {
					if (value.compareTo(list[previousIndex].getValue()) > 0 && value.compareTo(list[index].getValue()) < 0) {
						nextIndex = index;
					}
				}
				else {
					if (value.compareTo(list[index].getValue()) < 0) {
						nextIndex = index;
					}
				}
				
				previousIndex = index;
				index = list[index].getNext();
			}
			
			if (nextIndex == headIndex) {
				headIndex = lastIndex;
			}
			
			if (nextIndex == -1) {
				if (tailIndex != -1) {
					list[tailIndex].setNext(lastIndex);
				}
				tailIndex = lastIndex;
			}

			list[lastIndex] = new Node<T>(value, nextIndex);
			lastIndex++;
		}

	}

	@Override
	public void insert(T value, int index) {
		throw new NotImplementedException();
	}

	@Override
	public T get(int index) {
		throw new NotImplementedException();
	}

	@Override
	public T remove(int index) {
		throw new NotImplementedException();
	}
	
	@Override
	public boolean remove(T value) {
		int index = headIndex,
			previousIndex = -1;
		
		while (index != -1) {
			Node<T> item = list[index];
			if (value.compareTo(item.getValue()) == 0) {
				int nextIndex = item.getNext();
				if (previousIndex != -1) {
					list[previousIndex].setNext(item.getNext());
				}
				if (nextIndex != -1) {
					item.setNext(list[nextIndex].getNext());
				}
				return true;
			}
			previousIndex = index;
			index = item.getNext();
		}
		
		return false;
	}

	@Override
	public int size() {
		return lastIndex;
	}

	@Override
	public String print() {
		StringBuilder printedList = new StringBuilder();
		int index = headIndex;
		
		while (index != -1) {
			Node<T> item = list[index];
			printedList.append(item.getValue());
			
			index = item.getNext();
			if (index != -1) {
				printedList.append(",");
			}
		}

		return printedList.toString();
	}

}
