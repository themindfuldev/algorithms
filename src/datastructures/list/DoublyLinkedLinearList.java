package datastructures.list;

public class DoublyLinkedLinearList<T extends Comparable<T>> extends LinearList<T> {
	class Node<U extends Comparable<U>> {
		private U value;
		private Node<U> next;
		private Node<U> prev;

		public Node(U value, Node<U> next, Node<U> prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
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
		
		public Node<U> getPrev() {
			return prev;
		}

		public void setPrev(Node<U> prev) {
			this.prev = prev;
		}

		@Override
		public String toString() {
			return "[" + value.toString() + "], " + next;
		}

	}

	Node<T> headNode = null;

	@Override
	public void insert(T value) {
		if (headNode == null) {
			headNode = new Node<T>(value, null, null);
		} else {
			Node<T> newNode = new Node<T>(value, headNode, null);
			headNode.setPrev(newNode);
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
		Node<T> currentNode = headNode;
		T value = null;

		for (int i = 0; i < iterations; i++) {
			if (currentNode != null) {
				currentNode = currentNode.getNext();
			}
		}

		if (currentNode != null) {
			if (currentNode != headNode) {
				if (currentNode.getPrev() != null) {
					currentNode.getPrev().setNext(currentNode.getNext());
				}
				if (currentNode.getNext() != null) {
					currentNode.getNext().setPrev(currentNode.getPrev());
				}
			}
			else {
				headNode = currentNode.getNext();
				if (headNode != null) {
					headNode.setPrev(null);
				}
			}
			currentNode.setNext(null);
			currentNode.setPrev(null);
			value = currentNode.getValue();
		}

		return value;
	}

	@Override
	public boolean remove(T value) {
		Node<T> currentNode = headNode;

		while (currentNode != null) {
			if (value.compareTo(currentNode.getValue()) == 0) {
				if (currentNode != headNode) {
					if (currentNode.getPrev() != null) {
						currentNode.getPrev().setNext(currentNode.getNext());
					}
					if (currentNode.getNext() != null) {
						currentNode.getNext().setPrev(currentNode.getPrev());
					}
				}
				else {
					headNode = currentNode.getNext();
					if (headNode != null) {
						headNode.setPrev(null);
					}
				}
				currentNode.setNext(null);
				currentNode.setPrev(null);
				return true;
			}
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
