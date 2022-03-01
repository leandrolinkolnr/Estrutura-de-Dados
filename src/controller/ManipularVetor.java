package controller;

import java.io.File;
import java.text.ParseException;

import model.App;

public class ManipularVetor {

	private App[] vetor;
	private static InsertionSort ordenadorInsertionSort;
	private static SelectionSort ordenadorSelectionSort;

	private ManipularTxt manipularTxt ;
	private String caminho_padrao = ("C:\\Users\\leand\\Desktop");
	
	public ManipularVetor( App[] vetor) {
		this.vetor = vetor;
		
		 ordenadorInsertionSort = new InsertionSort();
		 ordenadorSelectionSort = new SelectionSort();
		 manipularTxt = new ManipularTxt();
	}


	public App[] getVetor() {
		return vetor;
	}


	public void setVetor(App[] vetor) {
		this.vetor = vetor;
	}
	
	
	public void imprimirVetor(App [] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == null) {
				break;
			} else {

				System.out.println(vetor[i].getName());
			}
		}
	}
	
	public void imprimirVetorData(App [] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == null) {
				break;
			} else {

				System.out.println(vetor[i].getName() + " - " + vetor[i].getLast_update());
			}
		}
	}
	
	
	public App[] ordernarVetor(int atributo, int algoritmo) throws ParseException {
		
		if(atributo == 1) {
			
			if(algoritmo == 1) {

				return ordenadorSelectionSort.SelectionSortAppName(this.vetor);

			}
			else if(algoritmo == 2) {
				
				return ordenadorInsertionSort.insertionSortAppName(this.vetor);
			}
			else if(algoritmo == 3) {
				
				  int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new MergeSort().mergeSortAppName(0,vetorLimpo.length,vetorLimpo);
			}else if(algoritmo == 4) {
				//quick sort
				 int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new QuickSort().quickSortAppName(vetorLimpo,0,vetorLimpo.length-1);
			}else if(algoritmo == 5) {
				//quick sort - medianda de 3
				 int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new QuickSortMedianaDeTres().quicksortMedianaDeTresAppName(vetorLimpo,0,vetorLimpo.length-1);
			}else if(algoritmo == 6) {
				//heapSort
				 int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new HeapSort().heapSortAppName(vetorLimpo);
			}
			else {
				return null;
			}
		}else if(atributo == 2) {
		//atributo rating
		    if(algoritmo == 1) {
		    	//selection sort
				return ordenadorSelectionSort.SelectionSortRating(this.vetor);
		    }
			else if(algoritmo == 2) {
				//insertion sort
				return ordenadorInsertionSort.insertionSortRating(this.vetor);
			}
			else if(algoritmo == 3) {
				//merge sort
				  int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new MergeSort().mergeSortRating(0,vetorLimpo.length,vetorLimpo);
			}else if(algoritmo == 4) {
				//quick sort
				 int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new QuickSort().quickSortRating(vetorLimpo,0,vetorLimpo.length-1);
			}
			else if(algoritmo == 5) {
				//quick sort com medianda de 3
				 int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new QuickSortMedianaDeTres().quicksortMedianaDeTresRating(vetorLimpo,0,vetorLimpo.length-1);
			}else if(algoritmo == 6) {
				//heapSort
				 int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new HeapSort().heapSortRating(vetorLimpo);
			}
			else {
				return null;
			}
		}else if(atributo == 3) {
			//atributo install
			if(algoritmo == 1) {
				return ordenadorSelectionSort.SelectionSortInstalls(this.vetor);	
			}
			else if(algoritmo == 2) {
				//insertion sort
				return ordenadorInsertionSort.insertionSortInstalls(this.vetor);
			}
			else if(algoritmo == 3) {
				//merge sort
				  int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new MergeSort().mergeSortInstalls(0,vetorLimpo.length,vetorLimpo);
			}
			else if(algoritmo == 4) {
				//quick sort
				 int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new QuickSort().quickSortInstalls(vetorLimpo,0,vetorLimpo.length-1);
			}else if(algoritmo == 5) {
				//quick sort com mediana de 3
				 int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new QuickSortMedianaDeTres().quicksortMedianaDeTresInstalls(vetorLimpo,0,vetorLimpo.length-1);
			}else if(algoritmo == 6) {
				//heapSort
				 int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new HeapSort().heapSortInstalls(vetorLimpo);
			}else if(algoritmo == 7) {
				//CoutingSort
				 int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }
				    
				    int [] vetorInstalacoes = new int[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorInstalacoes[i] = Integer.parseInt(vetorLimpo[i].getInstalls().replace("+", "").replace(",", "").replace("\"", ""));
				    }

				int [] ordenado =  new CoutingSort().countingSort(vetorInstalacoes);
				
				App[] vetorOrdenado = new App[firtPosicaoNula];
				for(int i = 0; i < ordenado.length; i++) {
					for(int j = 0; j < vetorLimpo.length; j++) {
						
						if(vetorLimpo[j] != null) {
						if(ordenado[i] == Integer.parseInt(vetorLimpo[j].getInstalls().replace("+", "").replace(",", "").replace("\"", ""))) {
							vetorOrdenado[i] = vetorLimpo[j];
							vetorLimpo[j] = null;
						    break;
						}
						}
					}
				}
				
				return vetorOrdenado;
			}
			
			else {
				return  null;
			}
		}
		else {
			//atributo last update
			if(algoritmo == 1) {
					return ordenadorSelectionSort.SelectionSortLastUpdate(this.vetor);
			}
			else if(algoritmo == 2) {
				//insertion sort
				return ordenadorInsertionSort.insertionSortLastUpdate(this.vetor);
			}
			else if(algoritmo == 3) {
				//merge sort
				  int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new MergeSort().mergeSortLastUpdate(0,vetorLimpo.length,vetorLimpo);
			}
			else if(algoritmo == 4) {
				//quick sort
				 int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new QuickSort().quickSortLastUpdate(vetorLimpo,0,vetorLimpo.length-1);
			}else if(algoritmo == 5) {
				//quick sort com mediana de 3
				 int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new QuickSortMedianaDeTres().quicksortMedianaDeTresLastUpdate(vetorLimpo,0,vetorLimpo.length-1);
			}else if(algoritmo == 6) {
				//heapSort
				 int firtPosicaoNula = 0;
				    for (int i = 0; i < vetor.length; i++) {
				        if(vetor[i] == null) {

				        	firtPosicaoNula = i;
				        	break;
				        }else {
				        	firtPosicaoNula = vetor.length;
				        }
				    }
				    
				    App[] vetorLimpo = new App[firtPosicaoNula];
				    for(int i = 0; i  < firtPosicaoNula; i++) {
				    	vetorLimpo[i] = this.vetor[i];
				    }

				
				return new HeapSort().heapSortLastUpdate(vetorLimpo);
			}
			else {
				return  null;
			}
		}
		
	}
	
	
public App[] inverterVetor(App[] vetor) {
		
	    int firtPosicaoNula = -1;
	    for (int i = 0; i < vetor.length; i++) {
	        if(vetor[i] == null) {
	        	firtPosicaoNula = i;
	        	break;
	        }else {
	        	firtPosicaoNula = vetor.length;

	        }
	    }
	    
	    App[] vetInvert = new App[vetor.length];

	    int tamanho = firtPosicaoNula;

	    for (int i = 0; i < tamanho; i++) {
	        vetInvert[tamanho - 1 - i] = vetor[i];
	    }
	    return vetInvert;
	}
		
	
	
	public String gerarCsv (App [] vetor) {
		String texto = "";
		for(App app : vetor) {
			if(app != null) {
				
				String linha = "";
				linha = app.getName() + "," +
				        app.getCategory() + "," +
				        app.getRating() + "," +
						app.getReviews() + "," + 
				        app.getSize() + "," +
						app.getInstalls() + "," +
						app.getType() + "," +
				        app.getPrice() + "," +
						app.getContent_rating() + ","+
				        app.getGenres() + "," +
						app.getLast_update() + "," +
				        app.getCurrent_ver() + "," +
						app.getAndroid_ver() + "\n";
				
				texto += linha;
				
			}else {
				break;
			}
		}
		
		return texto;
	}
	
public boolean salvarCsv(String texto, String nome_arquivo) {
		
		File file = manipularTxt.criarArquivoRetorno(caminho_padrao, nome_arquivo, "csv");
		
		if(file != null) {
			boolean texto_salvo = manipularTxt.escreverArquivo(file, texto);

			return true;
		}else {
			return false;
		}
		
	}
	
	
	
}
