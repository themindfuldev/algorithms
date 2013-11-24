package algorithms.sorting;

public class SelectionSort<T extends Comparable<T>> {
	public void selectSort(T[] array) {
		int length = array.length;
		for (int i = 0; i < length; i++) {
			T item = array[i];
			int k = i;
			for (int j = i + 1; j < length; j++) {
				if (array[j].compareTo(item) < 0) {
					k = j;
					item = array[k];
				}
			}
			array[k] = array[i];
			array[i] = item;
		}
	}

	public void heapSort(T[] array) {
		int length = array.length - 1;
		int left = length / 2 + 1;
		int right = length;

		while (left > 0) {
			left--;
			buildHeap(array, left, right);
		}
		while (right > 0) {
			T temp = array[0];
			array[0] = array[right];
			array[right] = temp;
			right--;
			buildHeap(array, left, right);
		}
	}

	private void buildHeap(T[] array, int left, int right) {
		int i = left;
		int j = 2 * left;
		T item = array[left];

		if (j < right && array[j].compareTo(array[j + 1]) < 0) {
			j++;
		}
		while (j <= right && item.compareTo(array[j]) < 0) {
			array[i] = array[j];
			i = j;
			j *= 2;
			if (j < right && array[j].compareTo(array[j + 1]) < 0) {
				j++;
			}
		}
		array[i] = item;
	}

}
