package algorithms.sorting;

public class FusionSort<T extends Comparable<T>> {
	
	public void mergeSort(T[] array) {
		mergeSort(array, 0, array.length-1);
	}
	private void mergeSort(T[] array, int left, int right) {
		if (left < right) {
			int middle = (left+right)/2;
			mergeSort(array, left, middle);
			mergeSort(array, middle+1, right);
			merge(array, left, middle, right);
		}
	}	

	private void merge(T[] originalArray, int left, int middle, int right) {
		int i = left;
		int j = left;
		int k = middle + 1;
		T[] mergeArray = originalArray.clone();
		
		while (j <= middle && k <= right) {
			if (originalArray[j].compareTo(originalArray[k]) < 0) {
				mergeArray[i] = originalArray[j];
				i++;
				j++;
			}
			else {
				mergeArray[i] = originalArray[k];
				i++;
				k++;
			}
		}
		
		while (j <= middle) {
			mergeArray[i] = originalArray[j];
			i++;
			j++;
		}
		
		for (i=left; i<k; i++) {
			originalArray[i] = mergeArray[i];
		}
	}

}
