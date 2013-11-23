package datastructures.tree;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HuffmanTree {

	class Node implements Comparable<Node> {
		Character character;
		int frequency;
		Node parentNode;
		Node leftNode;
		Node rightNode;

		public Node(Character character, int frequency) {
			this.character = character;
			this.frequency = frequency;
		}

		public Node(int frequency, Node leftNode, Node rightNode) {
			this.frequency = frequency;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
			
			if (rightNode != null) {
				rightNode.setParentNode(this);
			}
			if (leftNode != null) {
				leftNode.setParentNode(this);
			}
		}

		public Character getCharacter() {
			return character;
		}

		public void setCharacter(Character character) {
			this.character = character;
		}

		public int getFrequency() {
			return frequency;
		}

		public void setFrequency(int frequency) {
			this.frequency = frequency;
		}

		public Node getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}

		public Node getRightNode() {
			return rightNode;
		}

		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}
		
		public Node getParentNode() {
			return parentNode;
		}

		public void setParentNode(Node parentNode) {
			this.parentNode = parentNode;
		}

		@Override
		public String toString() {
			return String.format("(%s<-%s(%d)->%s)", leftNode, character,
					frequency, rightNode);
		}

		@Override
		public int compareTo(Node o) {
			return this.frequency - o.frequency;
		}
		
		public String toEncodedString() {
			if (parentNode != null) {
				if (parentNode.getLeftNode() == this) {
					return parentNode.toEncodedString()+"0";
				}
				else if (parentNode.getRightNode() == this) {
					return parentNode.toEncodedString()+"1";
				}
			}
			
			return "";
		}

	}
	
	private Map<Character, String> compressionTable = new HashMap<>();
	private String originalText;
	private byte[] compressedText;
	
	public HuffmanTree(String text) {
		this.originalText = text;
		Map<Character, Integer> frequencyTable = createFrequencyTable();
		
		LinkedList<Node> nodeList = createNodeList(frequencyTable);
		processNodeList(nodeList);
		
		createEncodingTable(nodeList.poll());
		compressString();
	}

	private void createEncodingTable(Node node) {
		if (node != null) {
			if (node.getLeftNode() != null) {
				createEncodingTable(node.getLeftNode());
			}
			if (node.getCharacter() != null) {
				compressionTable.put(node.getCharacter(), node.toEncodedString());
			}
			if (node.getRightNode() != null) {
				createEncodingTable(node.getRightNode());
			}
		}
	}

	private void processNodeList(LinkedList<Node> nodeList) {
		while (nodeList.size() > 1) {
			Node firstNode = nodeList.poll();
			Node secondNode = nodeList.poll();
			
			nodeList.add(new Node(firstNode.getFrequency()+secondNode.getFrequency(), firstNode, secondNode));
			
			Collections.sort(nodeList);
		}
	}

	private LinkedList<Node> createNodeList(Map<Character, Integer> frequencyTable) {
		LinkedList<Node> nodeList = new LinkedList<Node>();
		
		for (Map.Entry<Character, Integer> entry : frequencyTable.entrySet()) {
			nodeList.add(new Node(entry.getKey(), entry.getValue()));
		}
		
		Collections.sort(nodeList);
		
		return nodeList;
	}

	private Map<Character, Integer> createFrequencyTable() {
		Map<Character, Integer> frequencyTable = new HashMap<>();
		for (char ch : this.originalText.toCharArray()) {
			if (frequencyTable.containsKey(ch)) {
				Integer frequency = frequencyTable.get(ch);
				frequencyTable.put(ch, ++frequency);
			} else {
				frequencyTable.put(ch, 1);
			}
		}

		return frequencyTable;
	}
	
	private void compressString() {
		StringBuilder compressedString = new StringBuilder();
		
		for (char ch : this.originalText.toCharArray()) {
			compressedString.append(compressionTable.get(ch));
		}
		
		int start = 0;
		int end = 8;
		int total = compressedString.length();
		compressedText = new byte[total/8];
		int i = 0;
		do {
			String byteString = compressedString.subSequence(start, end).toString();
			compressedText[i++] = Long.valueOf(byteString, 2).byteValue(); 
			
			start += 8;
			end = (end+8 > total) ? total: end+8; 
		} while (end < total);
	}

	public String getOriginalText() {
		return originalText;
	}

	public byte[] getCompressedText() {
		return compressedText;
	}
	
}
