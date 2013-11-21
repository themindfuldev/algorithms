package algorithms.search;

import java.util.ArrayList;


public class BinarySearch<T extends Comparable<T>> {
	
	private ArrayList<T> array = new ArrayList<>();
	
	public void add(T value) {
		array.add(value);
	}
	
	public int binarySearch(T value) {
		return binarySearch(value, 0, array.size()-1);
	}
	
	private int binarySearch(T value, int leftIndex, int rightIndex) {
		if (leftIndex > rightIndex) {
			return -1;
		}
		
		int middleIndex = (leftIndex + rightIndex)/2;
		
		if (value.equals(array.get(middleIndex))) {
			return middleIndex;
		}
		else if (value.compareTo(array.get(middleIndex)) < 0) {
			return binarySearch(value, leftIndex, middleIndex-1);
		}
		else {
			return binarySearch(value, middleIndex+1, rightIndex);
		}
	}
}
