package datastructures.stack;



public class LinkedStack<T> {
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
	private Node<T> tailNode = null;

	public void push(T value) {
		if (tailNode != null) {
			Node<T> newNode = new Node<T>(value, null);
			tailNode.setNext(newNode);
			tailNode = newNode;
		} else {
			headNode = tailNode = new Node<T>(value, null);
		}
	}

	public T pop() {
		T result = null;
		if (tailNode != null) {
			result = tailNode.getValue();
			
			if (headNode == tailNode) {
				headNode = tailNode = null;
			}
			else {
				Node<T> currentNode = headNode;
				while (currentNode != null) {
					if (currentNode.getNext() == tailNode) {
						tailNode = currentNode;
						currentNode.setNext(null);
						break;
					}
					currentNode = currentNode.getNext();
				}
			}
		}
		return result;
	}

	public T peek() {
		T result = null;
		if (tailNode != null) {
			result = tailNode.getValue();
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
	
	public int size() {
		Node<T> currentNode = headNode;
		int size = 0;

		while (currentNode != null) {
			currentNode = currentNode.getNext();
			size++;
		}

		return size;
	}

}
