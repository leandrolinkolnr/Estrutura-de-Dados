package view;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;

import controller.InsertionSort;
import controller.ManipularTxt;
import controller.ManipularVetor;
import model.App;

public class Main {

	private static Scanner sc;

	
	private static HashSet<App> iniciarOperacoes(String url) {

		ManipularTxt manipulador = new ManipularTxt();

		File arquivo_base = new File(url);
		ArrayList<String> conteudo_linha_a_linha = manipulador.lerArquivo(arquivo_base);
		SimpleDateFormat formato_transformado = new SimpleDateFormat("dd/MM/yyyy");

		HashSet<App> base_dados = new HashSet<App>();
		
		for (int i = 1; i < conteudo_linha_a_linha.size(); i++) {
			if (conteudo_linha_a_linha.get(i) == null) {
				break;
			} else {
				try {
					
					String[] atributos = conteudo_linha_a_linha.get(i).split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
					App app = new App();
					app.setName(atributos[0]);
					app.setCategory(atributos[1]);
					app.setRating(atributos[2]);
					app.setReviews(atributos[3]);
					app.setSize(atributos[4]);
					app.setInstalls(atributos[5]);
					app.setType(atributos[6]);
					app.setPrice(atributos[7]);
					app.setContent_rating(atributos[8]);
					app.setGenres(atributos[9]);

					String data = atributos[10].replaceAll("\"", "");

					try {
						DateFormat format = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
						Date date = format.parse(data);

						String nova_data = formato_transformado.format(date);

						app.setLast_update(nova_data);

					} catch (Exception e) {
						try {
							DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
							Date date = format.parse(data);
							String nova_data = formato_transformado.format(date);

							app.setLast_update(nova_data);
						} catch (Exception f) {
							app.setLast_update(data);

						}

					}

					app.setCurrent_ver(atributos[11]);
					app.setAndroid_ver(atributos[12]);

					base_dados.add(app);

				} catch (Exception e) {
				}
			}
			
		}
		

		return base_dados;
	}

	public static void iniciarGui() throws ParseException {
		sc = new Scanner(System.in);
		int op = 0, op2;
		String op3;

		System.out.println("\t| Transformando Data, aguarde...|");

		HashSet<App> base_dados_inicial = iniciarOperacoes("C:\\Users\\LeandroLincoln\\Desktop\\googleplaystore.csv");	 //ALTERAR CAMINHO

		ManipularVetor gerenteVetor = new ManipularVetor(base_dados_inicial);
		
		boolean salvo_transformacao = gerenteVetor.salvarCsv(gerenteVetor.gerarCsv(base_dados_inicial),
				"googleplaystore_date"); 

		if (salvo_transformacao) {

			HashSet<App> base_dados_transformada = iniciarOperacoes(
					"C:\\Users\\LeandroLincoln\\Desktop\\googleplaystore.csv");
			gerenteVetor.setVetor(base_dados_transformada);

			do {
				System.out.println("\n\t ---  Escolha uma opção:   ---");
				System.out.println("\t+===================================+");
				System.out.println(
						"\t| 1 ---------------- Ordenar pelo nome (Campo 'App')                                |");
				System.out.println(
						"\t| 2 ---------------- Ordernar pelas Notas de Avaliação (Campo 'Ratins' )            |");
				System.out.println(
						"\t| 3 ---------------- Ordernar pelo número de instalações (Campo 'installs')         |");
				System.out.println(
						"\t| 4 ---------------- Ordernar pela data da última atualização (Campo last_update)   |");
				System.out.println(
						"\t| 5 ---------------- Filtrar por genero                             |");
				System.out.println("\t| 0 ---------------- SAIR           |");
				System.out.println("\t+===================================+");
				System.out.println(" Opção: ");
				op = sc.nextInt();

				switch (op) {
				
				case 1: {
					imprimeSubMenu();
					do {
						System.out.println("\t --==[  Ordenar pelo nome (Campo 'App') ]==--");
						op2 = sc.nextInt();
						if (op2 == 7) {
							System.out.println(
									"\tErro! Não é possivel ordernar o Vetor pelo Campo 'App' usando o algoritmo 'Couting Sort'");
							break;
						} else {
							
							processarAlgoritmo(gerenteVetor, op, op2);	
							break;
						}

					} while (op2 != 0);
				}
					break;
				case 2: {
					imprimeSubMenu();
					do {

						System.out.println("\t --==[  Ordernar pelas Notas de Avaliação (Campo 'Ratins' )  ]==--");
						op2 = sc.nextInt();
						if (op2 == 7) {
							System.out.println(
									"\tErro! Não é possivel ordernar o Vetor pelo Campo 'Rating' usando o algoritmo 'Couting Sort'");
							break;
						} else {
							processarAlgoritmo(gerenteVetor, op, op2);
							break;
						}

					} while (op2 != 0);

				}
					break;
				case 3: {
					imprimeSubMenu();
					do {
						System.out.println("\t --==[  Ordernar pelo número de instalações (Campo 'installs')   ]==--");
						op2 = sc.nextInt();
						processarAlgoritmo(gerenteVetor, op, op2);
					} while (op2 == 0);

				}
					break;
				case 4: {
					imprimeSubMenu();
					do {

						System.out.println(
								"\t --==[  Ordernar pela data da última atualização (Campo last_update)  ]==--");
						op2 = sc.nextInt();
						if (op2 == 7) {
							System.out.println(
									"\tErro! Não é possivel ordernar o Vetor pelo Campo 'Last Update' usando o algoritmo 'Couting Sort'");
							break;
						} else {
							processarAlgoritmo(gerenteVetor, op, op2);
							break;
						}
					} while (op2 != 0);
				}
					break;
				case 5: {
					System.out.print("Escreva qual categoria que voce deseja: ");
					op3 = sc.next();
					filtrar(op3, "C:\\Users\\leand\\Desktop\\googleplaystore.csv");
				}
					break;	
				case 0:					
					System.out.println("\n Programa Finalizado!\n");
					break;
				default:
					System.out.println("\n Opção inválida!\n Tente novamente.\n");
				}

			} while (op != 0);
		} else {
			System.out.println("\n Não foi possivel transformar a data!");

		}

	}

	public static void main(String... args) throws ParseException {

		iniciarGui();

	}

	public static void processarAlgoritmo(ManipularVetor gerenteVetor, int atributo, int algoritmo)
			throws ParseException {

		String nome_algoritmo = "";
		if (algoritmo == 1) {
			nome_algoritmo = "SelectionSort";
		} else if (algoritmo == 2) {
			nome_algoritmo = "InsertionSort";
		} else if (algoritmo == 3) {
			nome_algoritmo = "MergeSort";
		} else if (algoritmo == 4) {
			nome_algoritmo = "QuickSort";
		} else if (algoritmo == 5) {
			nome_algoritmo = "QuickSort-MediandaDe3";
		} else if (algoritmo == 6) {
			nome_algoritmo = "HeapSort";
		} else if (algoritmo == 7) {
			nome_algoritmo = "CoutingSort";
		}

		String nome_atributo = "";
		if (atributo == 1) {
			nome_atributo = "AppName";
		} else if (atributo == 2) {
			nome_atributo = "Rating";
		} else if (atributo == 3) {
			nome_atributo = "Installs";
		} else {
			nome_atributo = "Last_Update";

		}

		// ordernar app com algoritmo MergeSort
		System.out.println("\n\n*****Ordenação Usando Algoritmo " + nome_algoritmo + "*****\n\n");
		System.out.println("-->Atributo: " + nome_atributo + "\n\n");
		System.out.println("-->Iniciando Médio Caso...");

		
		
		//------------------------------------------------------
		long tempoInicial = System.currentTimeMillis();
		
		App[] vetor_ordenado_medio_caso = gerenteVetor.ordernarVetor(atributo, algoritmo);
		
		System.out.println("");
		System.out.println("O método medio foi executado em " + (System.currentTimeMillis() - tempoInicial)/1000.0 + " segundos.");
		System.out.println("");
		// ------------------------------------------------------------
		
		
		System.out.println("-->Médio Caso Finalizado, salvando arquivo");
		
		boolean salvo_medio_caso = gerenteVetor.salvarCsv(gerenteVetor.gerarCsv(vetor_ordenado_medio_caso),
				nome_algoritmo + "_ordena_" + nome_atributo + "_medio_caso");

		
		if (salvo_medio_caso) {
			System.out.println("Vetor Médio Caso Salvo!");

			System.out.println("-->Iniciando Melhor Caso...");
		
			gerenteVetor.setVetor(vetor_ordenado_medio_caso);
			
			
			//--------------------------------------------------
			long tempoInicial2 = System.currentTimeMillis();
			

			App[] vetor_ordenado_melhor_caso = gerenteVetor.ordernarVetor(atributo, algoritmo);
			
			System.out.println("");
			System.out.println("O método melhor foi executado em " + (System.currentTimeMillis() - tempoInicial2)/1000.0 + " segundos.");
			System.out.println("");
			
			//------------------------------------------------------------------------------------
			

			System.out.println("-->Melhor Caso Finalizado, salvando arquivo");
			
			boolean salvo_melhor_caso = gerenteVetor.salvarCsv(gerenteVetor.gerarCsv(vetor_ordenado_melhor_caso),
					nome_algoritmo + "_ordena_" + nome_atributo + "_melhor_caso");
			
			
			if (salvo_medio_caso) {
				System.out.println("Vetor Melhor Caso Salvo!");

				System.out.println("-->Iniciando Pior Caso...");
				App[] vetor_pior_caso_base = gerenteVetor.inverterVetor(vetor_ordenado_melhor_caso);
				gerenteVetor.setVetor(vetor_pior_caso_base);
				
				
				
				//-------------------------------------------------------
				long tempoInicial3 = System.currentTimeMillis();
				
				App[] vetor_ordenado_pior_caso = gerenteVetor.ordernarVetor(atributo, algoritmo);

				System.out.println(" ");
				System.out.println("O método pior foi executado em " + (System.currentTimeMillis() - tempoInicial3)/1000.0 + " segundos.");
				System.out.println(" ");
				//-------------------------------------------------------
				
				
				System.out.println("-->Pior Caso Finalizado, salvando arquivo");
				boolean salvo_pior_caso = gerenteVetor.salvarCsv (gerenteVetor.gerarCsv(vetor_ordenado_pior_caso),
						nome_algoritmo + "_ordena_" + nome_atributo + "_pior_caso");

				
				
				if (salvo_pior_caso) {
					System.out.println("Ordenações Concluídas!");

				} else {
					System.out.println("Erro ao gerar o arquivo .csv!");

				}

			} else {
				System.out.println("Erro ao gerar o arquivo .csv!");

			}

		} else {
			System.out.println("Erro ao gerar o arquivo .csv!");

		}

	}

	public static void imprimeSubMenu() {
		System.out.println("\n Escolha uma das seguintes opções disponíveis");
		System.out.println("\t+===================================+");
		System.out.println("\t| 1 ---------------- Algoritmo Selection Sort           |");
		System.out.println("\t| 2 ---------------- Algoritmo Insertion Sort           |");
		System.out.println("\t| 3 ---------------- Algoritmo Merge Sort               |");
		System.out.println("\t| 4 ---------------- Algoritmo Quick Sort               |");
		System.out.println("\t| 5 ---------------- Algoritmo Quick Sort(mediana de 3) |");
		System.out.println("\t| 6 ---------------- Algoritmo Heap Sort                |");
		System.out.println("\t| 7 ---------------- Algoritmo Couting Sort             |");
		System.out.println("\t| 0 ---------------- Sair                               |");
		System.out.println("\t+===================================+");
		System.out.print("\t Opção: ");

	}
	
	
	public static void filtrar(String genero, String url) {
		
		
		long tempoInicial = System.currentTimeMillis();

		System.out.println("voce quer filtrar por: " + genero);
	
		ManipularTxt manipulador = new ManipularTxt();

		File arquivo_base = new File(url);
		ArrayList<String> conteudo_linha_a_linha = manipulador.lerArquivo(arquivo_base);
		
		TreeSet<App> base_dados = new TreeSet<>();

		for (String linha : conteudo_linha_a_linha) {

			if (linha == null) {
				break;
			} else {
				try {
					
					String[] atributos = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
					App app = new App();
					
					if(atributos[9].equalsIgnoreCase(genero) | atributos[9].contains(genero)) {
						app.setName(atributos[0]);
						app.setCategory(atributos[1]);
						app.setRating(atributos[2]);
						app.setReviews(atributos[3]);
						app.setSize(atributos[4]);
						app.setInstalls(atributos[5]);
						app.setType(atributos[6]);
						app.setPrice(atributos[7]);
						app.setContent_rating(atributos[8]);
						app.setGenres(atributos[9]);
						app.setCurrent_ver(atributos[11]);
						app.setAndroid_ver(atributos[12]);

						base_dados.add(app);
						
						
				}} catch (Exception e) {
				}
			}

		}
	
		ManipularVetor gerenteVetor = new ManipularVetor();
		
		gerenteVetor.salvarCsv(gerenteVetor.gerarCsv(base_dados),
				" googleplaystore_" + genero); 

		
		System.out.println("Filtragem executada em " + (System.currentTimeMillis() - tempoInicial)/1000.0 + " segundos.");

	}
}
