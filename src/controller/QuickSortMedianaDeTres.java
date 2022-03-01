package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.App;

public class QuickSortMedianaDeTres {
    static // só array como argumento
   
	SimpleDateFormat dateFormat = new 
            SimpleDateFormat ("dd/MM/yyyy");
	
    public App[] quicksortMedianaDeTresAppName(App[] apps, int inicio, int fim){        
        if(inicio < fim){
            int q = partitionAppname(apps, inicio, fim);
            quicksortMedianaDeTresAppName(apps, inicio, q - 1);
            quicksortMedianaDeTresAppName(apps, q + 1, fim);            
        }
        
        return apps;
    }
    
    public App[] quicksortMedianaDeTresRating(App[] apps, int inicio, int fim){        
        if(inicio < fim){
            int q = partitionRatins(apps, inicio, fim);
            quicksortMedianaDeTresRating(apps, inicio, q - 1);
            quicksortMedianaDeTresRating(apps, q + 1, fim);            
        }
        
        return apps;
    }
    
    public App[] quicksortMedianaDeTresInstalls(App[] apps, int inicio, int fim) throws NumberFormatException, ParseException{        
        if(inicio < fim){
            int q = partitionInstalls(apps, inicio, fim);
            quicksortMedianaDeTresInstalls(apps, inicio, q - 1);
            quicksortMedianaDeTresInstalls(apps, q + 1, fim);            
        }
        
        return apps;
    }
    
    public App[] quicksortMedianaDeTresLastUpdate(App[] apps, int inicio, int fim) throws NumberFormatException, ParseException{        
        if(inicio < fim){
            int q = partitionLastUpdate(apps, inicio, fim);
            quicksortMedianaDeTresLastUpdate(apps, inicio, q - 1);
            quicksortMedianaDeTresLastUpdate(apps, q + 1, fim);            
        }
        
        return apps;
    }
    
    
    private static int partitionAppname(App[] apps, int inicio, int fim){
        int meio = (inicio + fim)/2;
        App a = apps[inicio];
        App b = apps[meio];
        App c = apps[fim];
        int medianaIndice; 
        if(a.getName().compareToIgnoreCase(b.getName()) > 0){
            if(b.getName().compareToIgnoreCase(c.getName()) < 0){
                medianaIndice = meio;
            }else{                
                if(a.getName().compareToIgnoreCase(c.getName()) < 0){
                    medianaIndice = fim;
                }else{
                    medianaIndice = inicio;
                }
            }
        }else{
            if(c.getName().compareToIgnoreCase(b.getName()) < 0){
                medianaIndice = meio;
            }else{
                if(c.getName().compareToIgnoreCase(a.getName()) < 0){
                    medianaIndice = fim;
                }else{
                    medianaIndice = inicio;
                }
            }
        }
        swap(apps, medianaIndice, fim);
        
      
        App pivo = apps[fim];
        int i = inicio - 1;
       
        for(int j = inicio; j <= fim - 1; j++){
            if(apps[j].getName().compareToIgnoreCase(pivo.getName()) <= 0){
                i = i + 1;
                swap(apps, i, j);
            }
        }
        swap(apps, i + 1, fim);
        return i + 1; 
    }
    
    private static int partitionRatins(App[] apps, int inicio, int fim){
        int meio = (inicio + fim)/2;
        App a = apps[inicio];
        App b = apps[meio];
        App c = apps[fim];
        int medianaIndice; 
        
        if(Double.parseDouble(a.getRating()) > Double.parseDouble(b.getRating()) ){
            if(Double.parseDouble(b.getRating()) < Double.parseDouble(c.getRating()) ){
                medianaIndice = meio;
            }else{                
                if(Double.parseDouble(a.getRating()) < Double.parseDouble(c.getRating()) ){
                    medianaIndice = fim;
                }else{
                    medianaIndice = inicio;
                }
            }
        }else{
            if(Double.parseDouble(c.getRating()) < Double.parseDouble(b.getRating()) ){
                medianaIndice = meio;
            }else{
                if(Double.parseDouble(c.getRating()) < Double.parseDouble(a.getRating()) ){
                    medianaIndice = fim;
                }else{
                    medianaIndice = inicio;
                }
            }
        }
        swap(apps, medianaIndice, fim);
        
      
        App pivo = apps[fim];
        int i = inicio - 1;
       
        for(int j = inicio; j <= fim - 1; j++){
            if(Double.parseDouble(apps[j].getRating()) >= Double.parseDouble(pivo.getRating()) ){
                i = i + 1;
                swap(apps, i, j);
            }
        }
        swap(apps, i + 1, fim);
        return i + 1; 
    }
    
    
    private static int partitionLastUpdate(App[] apps, int inicio, int fim) throws NumberFormatException, ParseException{
        int meio = (inicio + fim)/2;
        App a = apps[inicio];
        App b = apps[meio];
        App c = apps[fim];
        int medianaIndice; 
        
       
        if( dateFormat.parse(a.getLast_update()).after(dateFormat.parse(b.getLast_update()))){
            if(dateFormat.parse(b.getLast_update()).before(dateFormat.parse(c.getLast_update()))){
                medianaIndice = meio;
            }else{                
                if(dateFormat.parse(a.getLast_update()).before(dateFormat.parse(c.getLast_update()))){
                    medianaIndice = fim;
                }else{
                    medianaIndice = inicio;
                }
            }
        }else{
            if(dateFormat.parse(c.getLast_update()).before(dateFormat.parse(b.getLast_update()))){
                medianaIndice = meio;
            }else{
                if(dateFormat.parse(c.getLast_update()).before(dateFormat.parse(a.getLast_update()))){
                    medianaIndice = fim;
                }else{
                    medianaIndice = inicio;
                }
            }
        }
        swap(apps, medianaIndice, fim);
        
      
        App pivo = apps[fim];
        int i = inicio - 1;
       
        for(int j = inicio; j <= fim - 1; j++){
            if(dateFormat.parse(apps[j].getLast_update()).before(dateFormat.parse(pivo.getLast_update()))){
                i = i + 1;
                swap(apps, i, j);
            }
        }
        swap(apps, i + 1, fim);
        return i + 1; 
    }
    
    
    private static int partitionInstalls(App[] apps, int inicio, int fim) throws NumberFormatException, ParseException{
        int meio = (inicio + fim)/2;
        App a = apps[inicio];
        App b = apps[meio];
        App c = apps[fim];
        int medianaIndice; 
        
        if( Double.parseDouble(a.getInstalls().replace("+", "").replace(",", "").replace("\"", "")) > Double.parseDouble(b.getInstalls().replace("+", "").replace(",", "").replace("\"", "")) ){
            if(Double.parseDouble(b.getInstalls().replace("+", "").replace(",", "").replace("\"", "")) < Double.parseDouble(c.getInstalls().replace("+", "").replace(",", "").replace("\"", ""))){
                medianaIndice = meio;
            }else{                
                if(Double.parseDouble(a.getInstalls().replace("+", "").replace(",", "").replace("\"", "")) > Double.parseDouble(c.getInstalls().replace("+", "").replace(",", "").replace("\"", ""))){
                    medianaIndice = fim;
                }else{
                    medianaIndice = inicio;
                }
            }
        }else{
            if(Double.parseDouble(c.getInstalls().replace("+", "").replace(",", "").replace("\"", "")) > Double.parseDouble(b.getInstalls().replace("+", "").replace(",", "").replace("\"", ""))){
                medianaIndice = meio;
            }else{
                if(Double.parseDouble(c.getInstalls().replace("+", "").replace(",", "").replace("\"", "")) > Double.parseDouble(a.getInstalls().replace("+", "").replace(",", "").replace("\"", ""))){
                    medianaIndice = fim;
                }else{
                    medianaIndice = inicio;
                }
            }
        }
        swap(apps, medianaIndice, fim);
        
      
        App pivo = apps[fim];
        int i = inicio - 1;
       
        for(int j = inicio; j <= fim - 1; j++){
            if(Double.parseDouble(apps[j].getInstalls().replace("+", "").replace(",", "").replace("\"", "")) >= Double.parseDouble(pivo.getInstalls().replace("+", "").replace(",", "").replace("\"", ""))){
                i = i + 1;
                swap(apps, i, j);
            }
        }
        swap(apps, i + 1, fim);
        return i + 1; 
    }
    
    
    private static void swap(App[] A, int i, int j){
        App temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }    
}