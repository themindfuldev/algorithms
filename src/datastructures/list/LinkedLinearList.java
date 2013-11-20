package datastructures.list;

public class LinkedLinearList<T extends Comparable<T>> extends LinearList<T> {
	private class Node<U extends Comparable<U>> {
		private U value;
		private Node<U> next;

		public Node(U value, Node<U> next) {
			this.value = value;
			this.next = next;
		}

		public U getValue() {
			return value;
		}

		public Node<U> getNext() {
			return next;
		}

		public void setNext(Node<U> next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "[" + value.toString() + "], " + next;
		}

	}

	private Node<T> headNode = null;

	@Override
	public void insert(T value) {
		if (headNode == null) {
			headNode = new Node<T>(value, null);
		} else {
			Node<T> newNode = new Node<T>(value, headNode);
			headNode = newNode;
		}
	}

	@Override
	public T get(int iterations) {
		T value = null;

		if (iterations > 0) {
			Node<T> currentNode = headNode;
			for (int i = 0; i < iterations; i++) {
				if (currentNode != null) {
					currentNode = currentNode.getNext();
				}
			}
			
			if (currentNode != null) {
				value = currentNode.getValue();
			}
		}

		return value;
	}

	@Override
	public T remove(int iterations) {
		Node<T> currentNode = headNode, previousNode = null;
		T value = null;

		for (int i = 0; i < iterations; i++) {
			if (currentNode != null) {
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}
		}

		if (currentNode != null) {
			if (previousNode != null) {
				previousNode.setNext(currentNode.getNext());
			}
			else {
				headNode = currentNode.getNext();
			}
			currentNode.setNext(null);
			value = currentNode.getValue();
		}

		return value;
	}

	@Override
	public boolean remove(T value) {
		Node<T> currentNode = headNode, previousNode = null;

		while (currentNode != null) {
			if (value.compareTo(currentNode.getValue()) == 0) {
				if (previousNode != null) {
					previousNode.setNext(currentNode.getNext());
				} else {
					headNode = currentNode.getNext();
				}
				currentNode.setNext(null);
				return true;
			}
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		return false;
	}

	@Override
	public int size() {
		Node<T> currentNode = headNode;
		int size = 0;

		while (currentNode != null) {
			currentNode = currentNode.getNext();
			size++;
		}

		return size;
	}

	@Override
	public String print() {
		StringBuilder printedList = new StringBuilder();

		Node<T> currentNode = headNode;
		while (currentNode != null) {
			printedList.append(currentNode.getValue());
			currentNode = currentNode.getNext();
			if (currentNode != null) {
				printedList.append(",");
			}
		}

		return printedList.toString();
	}

}
