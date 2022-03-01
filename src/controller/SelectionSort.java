package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.App;

public class SelectionSort {

	/*
	 
	 */
	
	SimpleDateFormat dateFormat = new 
            SimpleDateFormat ("dd/MM/yyyy");

	public App[] SelectionSortAppName(App[] arr) {

		  int tamanho = arr.length;
		  
	        for (int i = 1; i < tamanho-1; i++)
	        {
	        
	            int min_idx = i;
	            for (int j = i+1; j < tamanho; j++)
	            	if(arr[j] != null) {
	                if ( arr[j].getName().compareToIgnoreCase( arr[min_idx].getName() ) < 0 )
	                    min_idx = j;
	            	}else {
	            		break;
	            	}
	 
	            App temp = arr[min_idx];
	            arr[min_idx] = arr[i];
	            arr[i] = temp;
	        }

	        return arr;
	}
	
	
	public App[] SelectionSortRating(App[] arr) {

		  int tamanho = arr.length;
		  
	        
	        for (int i = 1; i < tamanho-1; i++)
	        {
	            
	            int min_idx = i;
	            for (int j = i+1; j < tamanho; j++)
	            	if(arr[j] != null) {
	            	 			
	                if ( Double.parseDouble(arr[j].getRating()) < Double.parseDouble(arr[min_idx].getRating()) )
	                    min_idx = j;
	            	}else {
	            		break;
	            	}
	 
	            App temp = arr[min_idx];
	            arr[min_idx] = arr[i];
	            arr[i] = temp;
	        }

	        return arr;
	}
	
	
	public App[] SelectionSortLastUpdate(App[] arr) throws ParseException {

		  int tamanho = arr.length;
		  
	        for (int i = 1; i < tamanho-1; i++)
	        {

	            int min_idx = i;
	            for (int j = i+1; j < tamanho; j++)
	            	if(arr[j] != null) {
	                if ( dateFormat.parse(arr[j].getLast_update()).before( dateFormat.parse(arr[min_idx].getLast_update()) ) )
	                    min_idx = j;
	            	}else {
	            		break;
	            	}
	 
	            App temp = arr[min_idx];
	            arr[min_idx] = arr[i];
	            arr[i] = temp;
	        }

	        return arr;
	}
	

	public App[] SelectionSortInstalls(App[] arr) throws ParseException {

		  int tamanho = arr.length;
		  
	        for (int i = 1; i < tamanho-1; i++)
	        {

	            int min_idx = i;
	            for (int j = i+1; j < tamanho; j++)
	            	if(arr[j] != null) {
	                if ( Double.parseDouble(arr[j].getInstalls().replace("+", "").replace(",", "").replace("\"", "")) >  Double.parseDouble(arr[min_idx].getInstalls().replace("+", "").replace(",", "").replace("\"", "")))
	                    min_idx = j;
	            	}else {
	            		break;
	            	}
	 
	            App temp = arr[min_idx];
	            arr[min_idx] = arr[i];
	            arr[i] = temp;
	        }

	        return arr;
	}
	
	
	
}
