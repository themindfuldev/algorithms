package datastructures.queue;


public class PriorityQueue<T extends Comparable<T>> {

	static int MAX_CAPACITY = 99999999;
	@SuppressWarnings("unchecked")
	LinkedSortedQueue<T>[] priorityQueues = new LinkedSortedQueue[MAX_CAPACITY];

	public void insert(T value, int priority) {
		if (priorityQueues[priority] == null) {
			priorityQueues[priority] = new LinkedSortedQueue<T>();
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
