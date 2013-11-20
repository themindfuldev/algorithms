package datastructures.list;

public class LinkedCircularLinearList<T extends Comparable<T>> extends
		LinkedLinearList<T> {

	@Override
	public void insert(T value) {
		if (headNode == null) {
			headNode = new Node<T>(value, headNode);
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
				currentNode = currentNode.getNext();
			}

			if (currentNode != null) {
				value = currentNode.getValue();
			}
		}

		return value;
	}

	@Override
	public T remove(int iterations) {
		Node<T> currentNode = headNode, previousNode = headNode;
		T value = null;

		if (currentNode != null) {
			for (int i = 0; i < iterations; i++) {
				currentNode = currentNode.getNext();
			}
	
			while (previousNode.getNext() != currentNode) {
				previousNode = previousNode.getNext();
			}

			if (previousNode == currentNode) {
				headNode = null;
			}
			else {
				previousNode.setNext(currentNode.getNext());
				if (currentNode == headNode) {
					headNode = previousNode;
				}
			}
			currentNode.setNext(null);
			value = currentNode.getValue();
		}

		return value;
	}

	@Override
	public boolean remove(T value) {
		Node<T> currentNode = headNode, previousNode = headNode;

		if (currentNode != null) {
			do {
				if (value.compareTo(currentNode.getValue()) == 0) {
					while (previousNode.getNext() != currentNode) {
						previousNode = previousNode.getNext();
					}
					if (previousNode == currentNode) {
						headNode = null;
					}
					else {
						previousNode.setNext(currentNode.getNext());
						if (currentNode == headNode) {
							headNode = previousNode;
						}
					}
					currentNode.setNext(null);
					return true;
				}
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			} while (currentNode.getNext() != headNode);
		}
		return false;
	}

	@Override
	public int size() {
		Node<T> currentNode = headNode;
		int size = 0;

		if (currentNode != null) {
			do {
				size++;
				currentNode = currentNode.getNext();
			} while (currentNode.getNext() != headNode);
		}

		return size;
	}

	@Override
	public String print() {
		StringBuilder printedList = new StringBuilder();

		Node<T> currentNode = headNode;
		if (currentNode != null) {
			do {
				printedList.append(currentNode.getValue());
				currentNode = currentNode.getNext();
				if (currentNode.getNext() != headNode) {
					printedList.append(",");
				}
			} while (currentNode.getNext() != headNode);
		}

		return printedList.toString();
	}
}
