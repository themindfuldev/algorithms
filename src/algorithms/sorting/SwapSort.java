package algorithms.sorting;

public class SwapSort<T extends Comparable<T>> {
	public void bubbleSort(T[] array) {
		int length = array.length;
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < length - 1; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					T item = array[j];
					array[j] = array[j + 1];
					array[j + 1] = item;
				}
			}
		}
	}

	public void shakeSort(T[] array) {
		int left = 0;
		int right = array.length-1;

		do {
			int lastSwap = left;
			for (int i = left; i < right; i++) {
				if (array[i].compareTo(array[i + 1]) > 0) {
					T item = array[i];
					array[i] = array[i + 1];
					array[i + 1] = item;
					lastSwap = i;
				}
			}
			right = lastSwap;
			for (int i = right; i > left; i--) {
				if (array[i - 1].compareTo(array[i]) > 0) {
					T item = array[i - 1];
					array[i - 1] = array[i];
					array[i] = item;
					lastSwap = i;
				}
			}
			left = lastSwap;
		} while (left < right);
	}

}
