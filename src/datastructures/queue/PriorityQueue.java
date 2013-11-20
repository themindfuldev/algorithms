package datastructures.queue;

public class PriorityQueue<T extends Comparable<T>> {

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

	class Queue<V extends Comparable<V>> {
		private Node<V> headNode = null;

		public void enqueue(V value) {
			if (headNode != null) {
				Node<V> currentNode = headNode, previousNode = null;

				while (currentNode != null) {
					if (value.compareTo(currentNode.getValue()) <= 0
							&& (previousNode == null || (previousNode != null && value
									.compareTo(previousNode.getValue()) >= 0))) {
						break;
					}
					previousNode = currentNode;
					currentNode = currentNode.getNext();
				}
				
				Node<V> newNode = new Node<V>(value, currentNode);
				if (previousNode != null) {
					previousNode.setNext(newNode);
				}
				else {
					headNode = newNode;
				}
			} else {
				headNode = new Node<V>(value, null);;
			}
		}

		public V dequeue() {
			V result = null;
			if (headNode != null) {
				Node<V> node = headNode;
				headNode = headNode.getNext();
				node.setNext(null);
				result = node.getValue();
			}
			return result;
		}

		public V peek() {
			V result = null;
			if (headNode != null) {
				result = headNode.getValue();
			}
			return result;
		}

		public String print() {
			StringBuilder result = new StringBuilder();
			Node<V> currentNode = headNode;

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

	static int MAX_CAPACITY = 99999999;
	@SuppressWarnings("unchecked")
	Queue<T>[] priorityQueues = new Queue[MAX_CAPACITY];

	public void insert(T value, int priority) {
		if (priorityQueues[priority] == null) {
			priorityQueues[priority] = new Queue<T>();
		}
		priorityQueues[priority].enqueue(value);
	}

	public T findMinimum(int priority) {
		T result = null;

		if (priorityQueues[priority] != null) {
			result = priorityQueues[priority].peek();
		}

		return result;
	}

	public T deleteMinimum(int priority) {
		T result = null;

		if (priorityQueues[priority] != null) {
			result = priorityQueues[priority].dequeue();
		}

		return result;
	}

	public String print() {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < priorityQueues.length; i++) {
			if (priorityQueues[i] != null) {
				result.append(String.format("[%d]->", i)).append(priorityQueues[i].print()).append("\n");
			}
		}
		
		return result.toString();
	}

}
