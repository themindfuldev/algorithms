package datastructures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {

	enum Direction {
		LEFT, RIGHT;
	}

	class Node<U extends Comparable<U>> {
		U value;
		Node<U> leftNode;
		Node<U> rightNode;
		Node<U> parentNode;

		public Node(U value, Node<U> parentNode) {
			this.value = value;
			this.parentNode = parentNode;
		}

		public U getValue() {
			return value;
		}

		public void setValue(U value) {
			this.value = value;
		}

		public Node<U> getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(Node<U> leftNode) {
			this.leftNode = leftNode;
		}

		public Node<U> getRightNode() {
			return rightNode;
		}

		public void setRightNode(Node<U> rightNode) {
			this.rightNode = rightNode;
		}
		
		public Node<U> getParentNode() {
			return parentNode;
		}

		public void setParentNode(Node<U> parentNode) {
			this.parentNode = parentNode;
		}

		@Override
		public String toString() {
			return String.format("(%s<-%s->%s)", leftNode, value, rightNode);
		}
	}

	Node<T> rootNode = null;

	public void insert(T value) {
		if (rootNode != null) {
			insert(rootNode, value);
		} else {
			rootNode = new Node<T>(value, null);
		}
	}

	private void insert(Node<T> currentNode, T value) {
		if (value.compareTo(currentNode.getValue()) < 0) {
			if (currentNode.getLeftNode() == null) {
				currentNode.setLeftNode(new Node<T>(value, currentNode));
			} else {
				insert(currentNode.getLeftNode(), value);
			}
		} else if (value.compareTo(currentNode.getValue()) > 0) {
			if (currentNode.getRightNode() == null) {
				currentNode.setRightNode(new Node<T>(value, currentNode));
			} else {
				insert(currentNode.getRightNode(), value);
			}
		}
	}

	public Node<T> find(T value) {
		return find(rootNode, value);
	}

	private Node<T> find(Node<T> currentNode, T value) {
		if (currentNode.getValue().equals(value)) {
			return currentNode;
		}
		if (value.compareTo(currentNode.getValue()) < 0) {
			return find(currentNode.getLeftNode(), value);
		} else {
			return find(currentNode.getRightNode(), value);
		}
	}
	
	public boolean delete(T value) {
		if (rootNode == null) {
			return false;
		}
		if (rootNode.getValue().equals(value)) {
			return deleteNode(rootNode, null);
		} 
		if (value.compareTo(rootNode.getValue()) < 0) {
			return delete(rootNode.getLeftNode(), Direction.LEFT, value);
		} else {
			return delete(rootNode.getRightNode(), Direction.RIGHT, value);
		}
	}

	private boolean delete(Node<T> currentNode, Direction direction, T value) {
		if (currentNode == null) {
			return false;
		}
		if (currentNode.getValue().equals(value)) {
			return deleteNode(currentNode, direction);
		}
		if (value.compareTo(currentNode.getValue()) < 0) {
			return delete(currentNode.getLeftNode(), Direction.LEFT, value);
		} else {
			return delete(currentNode.getRightNode(), Direction.RIGHT, value);
		}
	}

	private boolean deleteNode(Node<T> currentNode, Direction direction) {
		Node<T> parentNode = currentNode.getParentNode();
		Node<T> childLeftNode = currentNode.getLeftNode();
		Node<T> childRightNode = currentNode.getRightNode();
		
		if (childLeftNode == null && childRightNode == null) {
			if (parentNode == null) {
				rootNode = null;
			}
			else {
				setChildrenNode(parentNode, direction, null);
				currentNode.setParentNode(null);
			}
		}
		else if (childRightNode != null) {
			if (childRightNode.getLeftNode() == null) {
				if (parentNode == null) {
					rootNode = childRightNode;
					rootNode.setParentNode(null);
				} 
				else {
					setChildrenNode(parentNode, direction, childRightNode);
				}
			}
			else {
				Node<T> newCurrentNode = childRightNode.getLeftNode();
				if (parentNode == null) {
					rootNode = newCurrentNode;
					rootNode.setParentNode(null);
				}
				else {
					setChildrenNode(parentNode, direction, newCurrentNode);
				}
				newCurrentNode.setRightNode(childRightNode);
				childRightNode.setLeftNode(newCurrentNode.getLeftNode());
				childRightNode.setParentNode(newCurrentNode);
				newCurrentNode.setLeftNode(currentNode.getLeftNode());
				currentNode.getLeftNode().setParentNode(newCurrentNode);
				currentNode.setLeftNode(null);
			}
		}
		else if (childLeftNode != null) {
			if (childLeftNode.getRightNode() == null) {
				if (parentNode == null) {
					rootNode = childLeftNode;
					rootNode.setParentNode(null);
				} 
				else {
					setChildrenNode(parentNode, direction, childLeftNode);
				}
			}
			else {
				Node<T> newCurrentNode = childLeftNode.getRightNode();
				if (parentNode == null) {
					rootNode = newCurrentNode;
					rootNode.setParentNode(null);
				}
				else {
					setChildrenNode(parentNode, direction, newCurrentNode);
				}
				newCurrentNode.setLeftNode(childLeftNode);
				childLeftNode.setRightNode(newCurrentNode.getRightNode());
				childLeftNode.setParentNode(newCurrentNode);
				newCurrentNode.setRightNode(currentNode.getRightNode());
				currentNode.getRightNode().setParentNode(newCurrentNode);
				currentNode.setRightNode(null);
			}
		}
		else {
			return false;
		}
		return true;
	}

	private void setChildrenNode(Node<T> parentNode, Direction direction, Node<T> childrenNode) {
		if (direction.equals(Direction.LEFT)) {
			parentNode.setLeftNode(childrenNode);
		} else if (direction.equals(Direction.RIGHT)) {
			parentNode.setRightNode(childrenNode);
		}
		if (childrenNode != null) {
			childrenNode.setParentNode(parentNode);
		}
	}
	
	public T findMinimum() {
		Node<T> minimumNode = rootNode;
		
		if (minimumNode == null) {
			return null;
		}

		T minimumValue = minimumNode.getValue();
		while (minimumNode.getLeftNode() != null) {
			minimumNode = minimumNode.getLeftNode();
			minimumValue = minimumNode.getValue();
		}
		
		return minimumValue;
	}
	
	public T findMaximum() {
		Node<T> maximumNode = rootNode;
		
		if (maximumNode == null) {
			return null;
		}

		T maximumValue = maximumNode.getValue();
		while (maximumNode.getRightNode() != null) {
			maximumNode = maximumNode.getRightNode();
			maximumValue = maximumNode.getValue();
		}
		
		return maximumValue;
	}
	
	public T predecessor(T value) {
		Node<T> currentNode = find(value);
		if (currentNode.getLeftNode() != null) {
			Node<T> predecessorNode = currentNode.getLeftNode();
			while (predecessorNode.getRightNode() != null) {
				predecessorNode = predecessorNode.getRightNode();
			}
			return predecessorNode.getValue();
		}
		else {
			Node<T> predecessorNode = currentNode.getParentNode();
			if (predecessorNode == null) {
				return null;
			}
			if (predecessorNode.getRightNode() == currentNode) {
				return predecessorNode.getValue();
			}
			else {
				do {
					currentNode = predecessorNode;
					predecessorNode = predecessorNode.getParentNode();
				} while (predecessorNode != null && predecessorNode.getRightNode() == currentNode);
					
				return predecessorNode != null? predecessorNode.getValue(): null;
			}			
		}
	}
	
	public T successor(T value) {
		Node<T> currentNode = find(value);
		if (currentNode.getRightNode() != null) {
			Node<T> predecessorNode = currentNode.getRightNode();
			while (predecessorNode.getLeftNode() != null) {
				predecessorNode = predecessorNode.getLeftNode();
			}
			return predecessorNode.getValue();
		}
		else {
			Node<T> predecessorNode = currentNode.getParentNode();
			if (predecessorNode == null) {
				return null;
			}
			if (predecessorNode.getLeftNode() == currentNode) {
				return predecessorNode.getValue();
			}
			else {
				do {
					currentNode = predecessorNode;
					predecessorNode = predecessorNode.getParentNode();
				} while (predecessorNode != null && predecessorNode.getLeftNode() == currentNode);
					
				return predecessorNode != null? predecessorNode.getValue(): null;
			}			
		}
	}

	public String printInOrder() {
		String result = printInOrder(rootNode);
		return result.substring(0, result.length()-2);
	}

	private String printInOrder(Node<T> currentNode) {
		StringBuilder result = new StringBuilder();

		if (currentNode != null) {
			String leftPrint = printInOrder(currentNode.getLeftNode());
			if (leftPrint.isEmpty() == false) {
				result.append(leftPrint);
			}
			
			result.append(currentNode.getValue()).append(", ");
			
			String rightPrint = printInOrder(currentNode.getRightNode());
			if (rightPrint.isEmpty() == false) {
				result.append(rightPrint);
			}
		}

		return result.toString();
	}
	
	public String printBreadth() {
		StringBuilder result = new StringBuilder();
		Queue<Node<T>> breadthQueue = new LinkedList<>();
		
		breadthQueue.add(rootNode);
		while (breadthQueue.size() > 0) {
			Node<T> currentNode = breadthQueue.remove();
			if (currentNode != null) {
				result.append(currentNode.getValue()).append(", ");
				breadthQueue.add(currentNode.getLeftNode());
				breadthQueue.add(currentNode.getRightNode());
			}
		}
		
		return result.substring(0, result.lastIndexOf(",")).toString();
	}
	
	public void balanceTree() {
		List<T> list = getElementsInOrder(rootNode);
		
		for (T value: list) {
			delete(value);
		}

		balanceNode(list, 0, list.size()-1);
	}
	
	private void balanceNode(List<T> list, int startPos, int endPos) {
		if (startPos <= endPos) {
			int position = (startPos + endPos)/2;
			T value = list.get(position);
			if (value != null) {
				insert(value);
				balanceNode(list, startPos, position-1);
				balanceNode(list, position+1, endPos);
			}
		}
	}

	private List<T> getElementsInOrder(Node<T> currentNode) {
		List<T> list = new ArrayList<>();

		if (currentNode != null) {
			list.addAll(getElementsInOrder(currentNode.getLeftNode()));
			list.add(currentNode.getValue());
			list.addAll(getElementsInOrder(currentNode.getRightNode()));
		}

		return list;
	}

}
