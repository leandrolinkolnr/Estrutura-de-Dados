package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.App;

public class HeapSort {

	SimpleDateFormat dateFormat = new 
            SimpleDateFormat ("dd/MM/yyyy");
	
	public App[] heapSortAppName(App[] arrA) {
		
		int size = arrA.length;

		for (int i = size / 2 - 1; i >= 0; i--)
			heapifyAppName(arrA, size, i);

		
		for (int i = size - 1; i >= 0; i--) {

			App x = arrA[0];
			arrA[0] = arrA[i];
			arrA[i] = x;

			heapifyAppName(arrA, i, 0);
		}

		return arrA;
	}
	
	
	public App[] heapSortRating(App[] arrA) {

		int size = arrA.length;

		for (int i = size / 2 - 1; i >= 0; i--)
			heapifyRating(arrA, size, i);

		
		for (int i = size - 1; i >= 0; i--) {

			App x = arrA[0];
			arrA[0] = arrA[i];
			arrA[i] = x;

			heapifyRating(arrA, i, 0);
		}

		return arrA;
	}
	
	public App[] heapSortInstalls(App[] arrA) {

		int size = arrA.length;

		for (int i = size / 2 - 1; i >= 0; i--)
			heapifyInstalls(arrA, size, i);

		
		for (int i = size - 1; i >= 0; i--) {

			App x = arrA[0];
			arrA[0] = arrA[i];
			arrA[i] = x;

			heapifyInstalls(arrA, i, 0);
		}
		
		return arrA;
	}
	
	
	public App[] heapSortLastUpdate(App[] arrA) throws ParseException {

		int size = arrA.length;

		for (int i = size / 2 - 1; i >= 0; i--)
			heapifyLastUpdate(arrA, size, i);

		
		for (int i = size - 1; i >= 0; i--) {

			App x = arrA[0];
			arrA[0] = arrA[i];
			arrA[i] = x;

			heapifyLastUpdate(arrA, i, 0);
		}

		return arrA;
	}
	
	

	void heapifyAppName(App [] arrA, int heapSize, int i) {
		
		
		int largest = i;
		int leftChildIdx = 2 * i + 1;
		int rightChildIdx = 2 * i + 2;


		if (leftChildIdx < heapSize && arrA[leftChildIdx].getName().compareTo(arrA[largest].getName()) >  0 )
			largest = leftChildIdx;

		if (rightChildIdx < heapSize && arrA[rightChildIdx].getName().compareTo(arrA[largest].getName()) >  0)
			largest = rightChildIdx;

		if (largest != i) {
			App swap = arrA[i];
			arrA[i] = arrA[largest];
			arrA[largest] = swap;

			heapifyAppName(arrA, heapSize, largest);
		}
	}
	
	void heapifyRating(App [] arrA, int heapSize, int i) {
		int largest = i;
		int leftChildIdx = 2 * i + 1;
		int rightChildIdx = 2 * i + 2;


		if (leftChildIdx < heapSize && Double.parseDouble(arrA[leftChildIdx].getRating()) > Double.parseDouble(arrA[largest].getRating()) )
			largest = leftChildIdx;
		
		if (rightChildIdx < heapSize && Double.parseDouble(arrA[rightChildIdx].getRating()) > Double.parseDouble(arrA[largest].getRating()) )
			largest = rightChildIdx;

		if (largest != i) {
			App swap = arrA[i];
			arrA[i] = arrA[largest];
			arrA[largest] = swap;

			heapifyAppName(arrA, heapSize, largest);
		}
	}

	
	void heapifyInstalls(App [] arrA, int heapSize, int i) {
		int largest = i;
		int leftChildIdx = 2 * i + 1;
		int rightChildIdx = 2 * i + 2;

		 

		if (leftChildIdx < heapSize && Double.parseDouble(arrA[leftChildIdx].getInstalls().replace("+", "").replace(",", "").replace("\"", "")) > Double.parseDouble(arrA[largest].getInstalls().replace("+", "").replace(",", "").replace("\"", "")) )
			largest = leftChildIdx;
		
		if (rightChildIdx < heapSize && Double.parseDouble(arrA[rightChildIdx].getInstalls().replace("+", "").replace(",", "").replace("\"", "")) > Double.parseDouble(arrA[largest].getInstalls().replace("+", "").replace(",", "").replace("\"", "")))
			largest = rightChildIdx;

		if (largest != i) {
			App swap = arrA[i];
			arrA[i] = arrA[largest];
			arrA[largest] = swap;

			heapifyAppName(arrA, heapSize, largest);
		}
	}
	
	
	void heapifyLastUpdate(App [] arrA, int heapSize, int i) throws ParseException {
		int largest = i;
		int leftChildIdx = 2 * i + 1;
		int rightChildIdx = 2 * i + 2;

		 
		
		if (leftChildIdx < heapSize && dateFormat.parse(arrA[leftChildIdx].getLast_update()).after(dateFormat.parse(arrA[largest].getLast_update())) )
			largest = leftChildIdx;
		
		if (rightChildIdx < heapSize && dateFormat.parse(arrA[rightChildIdx].getLast_update()).after(dateFormat.parse(arrA[largest].getLast_update())))
			largest = rightChildIdx;

		if (largest != i) {
			App swap = arrA[i];
			arrA[i] = arrA[largest];
			arrA[largest] = swap;

			heapifyAppName(arrA, heapSize, largest);
		}
	}

}
