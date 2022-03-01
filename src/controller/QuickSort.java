package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.App;

public class QuickSort {

	SimpleDateFormat dateFormat = new 
            SimpleDateFormat ("dd/MM/yyyy");


	public App[] quickSortAppName(App arr[], int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partitionAppName(arr, begin, end);

	        quickSortAppName(arr, begin, partitionIndex-1);
	        quickSortAppName(arr, partitionIndex+1, end);
	    }
	    
	    return arr;
	}
	
	public App[] quickSortRating(App arr[], int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partitionRating(arr, begin, end);

	        quickSortRating(arr, begin, partitionIndex-1);
	        quickSortRating(arr, partitionIndex+1, end);
	    }
	    
	    return arr;
	}
	
	public App[] quickSortInstalls(App arr[], int begin, int end) throws ParseException {
	    if (begin < end) {
	        int partitionIndex = partitionInstalls(arr, begin, end);

	        quickSortInstalls(arr, begin, partitionIndex-1);
	        quickSortInstalls(arr, partitionIndex+1, end);
	    }
	    
	    return arr;
	}
	
	public App[] quickSortLastUpdate(App arr[], int begin, int end) throws ParseException {
	    if (begin < end) {
	        int partitionIndex = partitionLastUpdate(arr, begin, end);

	        quickSortLastUpdate(arr, begin, partitionIndex-1);
	        quickSortLastUpdate(arr, partitionIndex+1, end);
	    }
	    
	    return arr;
	}


	private int partitionAppName(App arr[], int begin, int end) {
	    App pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (arr[j].getName().compareToIgnoreCase(pivot.getName()) <= 0) {
	            i++;

	            App swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    App swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}
	
	private int partitionRating(App arr[], int begin, int end) {
	    App pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	    	
	        if (Double.parseDouble(arr[j].getRating()) > Double.parseDouble(pivot.getRating()) ) {
	            i++;

	            App swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    App swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}

	
	private int partitionLastUpdate(App arr[], int begin, int end) throws ParseException {
	    App pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	    	
	        if (dateFormat.parse(arr[j].getLast_update()).before(dateFormat.parse(pivot.getLast_update()))) {
	            i++;

	            App swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    App swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}

	private int partitionInstalls(App arr[], int begin, int end) throws ParseException {
	    App pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (Double.parseDouble(arr[j].getInstalls().replace("+", "").replace(",", "").replace("\"", "")) <  Double.parseDouble(pivot.getInstalls().replace("+", "").replace(",", "").replace("\"", "")) ) {
	            i++;

	            App swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    App swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}


}
