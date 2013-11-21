package datastructures.queue;


public class LinkedSortedQueue<T extends Comparable<T>> {
	class Node<U> {
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

	public void enqueue(T value) {
		if (headNode != null) {
			Node<T> currentNode = headNode, previousNode = null;

			while (currentNode != null) {
				if (value.compareTo(currentNode.getValue()) <= 0
						&& (previousNode == null || (previousNode != null && value
								.compareTo(previousNode.getValue()) >= 0))) {
					break;
				}
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}
			
			Node<T> newNode = new Node<T>(value, currentNode);
			if (previousNode != null) {
				previousNode.setNext(newNode);
			}
			else {
				headNode = newNode;
			}
		} else {
			headNode = new Node<T>(value, null);;
		}
	}

	public T dequeue() {
		T result = null;
		if (headNode != null) {
			Node<T> node = headNode;
			headNode = headNode.getNext();
			node.setNext(null);
			result = node.getValue();
		}
		return result;
	}

	public T peek() {
		T result = null;
		if (headNode != null) {
			result = headNode.getValue();
		}
		return result;
	}

	public String print() {
		StringBuilder result = new StringBuilder();
		Node<T> currentNode = headNode;

		while (currentNode != null) {
			result.append(currentNode.getValue());
			
			currentNode = currentNode.getNext();
			if (currentNode != null) {
				result.append("->");
			}
		}
		return result.toString();
	}

}
