package controller;

public class CoutingSort {

	public int [] countingSort(int inputArray[]) {
		
		int max = inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			if (max < inputArray[i]) {
				max = inputArray[i];
			}
		}

		int countArray[] = new int[max + 1];
		for (int i = 0; i < countArray.length; i++) {
			countArray[i] = 0;
		}

		
		for (int i = 0; i < inputArray.length; i++) {
			countArray[inputArray[i]]++;
		}

		for (int i = 1; i <= max; i++) {
			countArray[i] += countArray[i - 1];
		}

		int outputArray[] = new int[inputArray.length];
		for (int j = (inputArray.length - 1); j >= 0; j--) {
			outputArray[countArray[inputArray[j]] - 1] = inputArray[j];
			countArray[inputArray[j]]--;
		}
		
		return outputArray;
	}

	

}
