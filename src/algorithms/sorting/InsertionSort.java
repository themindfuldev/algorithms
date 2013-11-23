package algorithms.sorting;

public class InsertionSort<T extends Comparable<T>> {
	public void directInsertSort(T[] array) {
		int length = array.length;
		for (int i = 1; i < length; i++) {
			T item = array[i];
			int j = i - 1;
			while (j >= 0 && item.compareTo(array[j]) < 0) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = item;
		}
	}

	public void shellSort(T[] array, int powerLimit) {
		for (int power = powerLimit; power >= 0; power--) {
			int increment = (int) Math.pow(2, power);
			for (int segment = 0; segment < increment; segment++) {
				segmentShellSort(array, increment, segment);
			}
		}
	}

	public void segmentShellSort(T[] array, int increment, int segment) {
		int length = array.length;
		for (int i = segment + increment; i < length; i += increment) {
			T item = array[i];
			int j = i - increment;
			int k = segment;
			while ((j >= segment) && (k == segment)) {
				if (item.compareTo(array[j]) < 0) {
					array[j + increment] = array[j];
					j -= increment;
				}
				else {
					k = j + increment;
				}
			}
			array[k] = item;
		}
	}

}
