package datastructures.list;


public class LinkedOrderedLinearList<T extends Comparable<T>> extends
		LinkedLinearList<T> {

	@Override
	public void insert(T value) {
		if (headNode != null) {
			Node<T> currentNode = headNode,
					previousNode = null;
			
			while (currentNode != null) {
				if (value.compareTo(currentNode.getValue()) <= 0 &&
						(previousNode == null ||
						(previousNode != null && value.compareTo(previousNode.getValue()) >= 0))) {
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
		}
		else {
			headNode = new Node<T>(value, null);
		}
	}

}
