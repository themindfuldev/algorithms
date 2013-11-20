package datastructures.list;


public class SequentialOrderedLinearList<T extends Comparable<T>> extends
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

	private static int MAX_CAPACITY = 99999999;
	@SuppressWarnings("unchecked")
	private Node<T>[] list = new Node[MAX_CAPACITY];
	private int headIndex = -1;
	private int lastIndex = 0;

	@Override
	public void insert(T value) {
		if (lastIndex < list.length) {
			int nextIndex = -1, 
				currentIndex = headIndex,
				previousIndex = -1;
			
			while (currentIndex != -1) {
				if (value.compareTo(list[currentIndex].getValue()) <= 0 
						&& (previousIndex == -1 
							|| (previousIndex != -1 && value.compareTo(list[previousIndex].getValue()) >= 0))) {
					nextIndex = currentIndex; 
					break;
				}
				
				previousIndex = currentIndex;
				currentIndex = list[currentIndex].getNext();
			} 
			
			if (nextIndex == headIndex) {
				headIndex = lastIndex;
			}
			else if (previousIndex != -1) {
				list[previousIndex].setNext(lastIndex);
			}
			
			list[lastIndex] = new Node<T>(value, nextIndex);
			lastIndex++;
		}
		else {
			throw new IllegalStateException("The list is full.");
		}
	}
	
	@Override
	public T get(int iterations) {
		Node<T> item = null;
		T value = null;
		int index = headIndex;
		
		for (int i=0; i<=iterations; i++) {
			if (index != -1) {
				item = list[index];
				index = item.getNext();
			}
			else {
				item = null;
			}			
		}
		
		if (item != null) {
			value = item.getValue();
		}
		
		return value;
	}

	@Override
	public T remove(int iterations) {
		Node<T> item = null;
		T value = null;
		int currentIndex = headIndex,
			previousIndex = -1;
		
		if (headIndex != -1) {
			item = list[headIndex];
			for (int i=1; i<=iterations; i++) {
				previousIndex = currentIndex;
				currentIndex = item.getNext();
				if (currentIndex != -1) {
					item = list[currentIndex];
				}
				else {
					item = null;
					break;
				}
			}
			
			if (item != null) {
				value = item.getValue();
				
				if (currentIndex != headIndex) {
					list[previousIndex].setNext(item.getNext());
				}
				else {
					headIndex = item.getNext();
				}
				
				item.setNext(-1);
			}
		}
		
		return value;
	}

	@Override
	public boolean remove(T value) {
		int currentIndex = headIndex,
			previousIndex = -1;
		
		while (currentIndex != -1) {
			Node<T> item = list[currentIndex];
			if (value.compareTo(item.getValue()) == 0) {
				if (previousIndex != -1) {
					list[previousIndex].setNext(item.getNext());
				}
				else {
					headIndex = item.getNext();
				}
				item.setNext(-1);
				return true;
			}
			previousIndex = currentIndex;
			currentIndex = item.getNext();
		}
		
		return false;
	}

	@Override
	public int size() {
		int index = headIndex, size = 0;

		while (index != -1) {
			index = list[index].getNext();
			size++;
		}

		return size;
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
