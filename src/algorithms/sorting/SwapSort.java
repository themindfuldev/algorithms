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
		int right = array.length - 1;

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

	public void combSort(T[] array) {
		int length = array.length;
		int h = length;
		boolean swap;
		do {
			h = (int) (h / 1.3);
			if (h == 9 || h == 10) {
				h = 11;
			}
			swap = false;
			for (int i = 0; i < (length-h); i++) {
				if (array[i].compareTo(array[i + h]) > 0) {
					T item = array[i];
					array[i] = array[i + h];
					array[i + h] = item;
					swap = true;
				}
			}
		} while (swap == true || h > 1);
	}
	
	public void quickSort(T[] array) {
		quickSort(array, 0, array.length-1);
	}
	
	private void quickSort(T[] array, int left, int right) {
		int i = left;
		int j = right;
		T item = array[(left+right)/2];
		do {
			while (array[i].compareTo(item) < 0) {
				i++;
			}
			while (array[j].compareTo(item) > 0) {
				j--;
			}
			if (i < j) {
				T temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		} while (i < j);
		if (left < j && j < right) {
			quickSort(array, left, j);
		}
		if (left < i && i < right) {
			quickSort(array, i, right);
		}
	}

}
