package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.App;

public class MergeSort {

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public App[] mergeSortAppName(int inicio, int fim, App[] apps) {
		if (inicio < fim - 1) {
			int meio = (inicio + fim) / 2;

			mergeSortAppName(inicio, meio, apps);

			mergeSortAppName(meio, fim, apps);

			intercalaNameApp(apps, inicio, meio, fim);
		}

		return apps;
	}
	
	public App[] mergeSortRating(int inicio, int fim, App[] apps) {

		if (inicio < fim - 1) {
			int meio = (inicio + fim) / 2;

			mergeSortRating(inicio, meio, apps);

			mergeSortRating(meio, fim, apps);

			intercalaRating(apps, inicio, meio, fim);
		}

		return apps;
	}
	
	
	
	public App[] mergeSortLastUpdate(int inicio, int fim, App[] apps) throws ParseException {
		
		if (inicio < fim - 1) {
			int meio = (inicio + fim) / 2;

			mergeSortLastUpdate(inicio, meio, apps);

			mergeSortLastUpdate(meio, fim, apps);

			intercalaLastUpdates(apps, inicio, meio, fim);
		}

		return apps;
	}
	
	public App[] mergeSortInstalls(int inicio, int fim, App[] apps) {
		
		long tempoInicial = System.currentTimeMillis();

		if (inicio < fim - 1) {
			int meio = (inicio + fim) / 2;

			mergeSortInstalls(inicio, meio, apps);

			mergeSortInstalls(meio, fim, apps);

			intercalaInstalls(apps, inicio, meio, fim);
		}
		
		return apps;
	}

	private void intercalaNameApp(App[] apps, int inicio, int meio, int fim) {
		App novoVetor[] = new App[fim - inicio];
		int i = inicio;
		int m = meio;
		int pos = 0;

		while (i < meio && m < fim) {

			if (apps[i].getName().compareToIgnoreCase(apps[m].getName()) <= 0) {
				novoVetor[pos] = apps[i];
				pos = pos + 1;
				i = i + 1;

			} else {
				novoVetor[pos] = apps[m];
				pos = pos + 1;
				m = m + 1;
			}
		}

		while (i < meio) {
			novoVetor[pos] = apps[i];
			pos = pos + 1;
			i = i + 1;
		}

		while (m < fim) {
			novoVetor[pos] = apps[m];
			pos = pos + 1;
			m = m + 1;
		}

		for (pos = 0, i = inicio; i < fim; i++, pos++) {
			apps[i] = novoVetor[pos];
		}
	}

	private void intercalaRating(App[] apps, int inicio, int meio, int fim) {
		App novoVetor[] = new App[fim - inicio];
		int i = inicio;
		int m = meio;
		int pos = 0;

		while (i < meio && m < fim) {

			if (Double.parseDouble(apps[i].getRating()) <= Double.parseDouble(apps[m].getRating())) {
				novoVetor[pos] = apps[i];
				pos = pos + 1;
				i = i + 1;

			} else {
				novoVetor[pos] = apps[m];
				pos = pos + 1;
				m = m + 1;
			}
		}

		while (i < meio) {
			novoVetor[pos] = apps[i];
			pos = pos + 1;
			i = i + 1;
		}

		while (m < fim) {
			novoVetor[pos] = apps[m];
			pos = pos + 1;
			m = m + 1;
		}

		for (pos = 0, i = inicio; i < fim; i++, pos++) {
			apps[i] = novoVetor[pos];
		}
	}

	private void intercalaInstalls(App[] apps, int inicio, int meio, int fim) {
		App novoVetor[] = new App[fim - inicio];
		int i = inicio;
		int m = meio;
		int pos = 0;

		while (i < meio && m < fim) {

			if (Double.parseDouble(apps[i].getInstalls().replace("+", "").replace(",", "").replace("\"", "")) >= Double
					.parseDouble(apps[m].getInstalls().replace("+", "").replace(",", "").replace("\"", ""))) {
				novoVetor[pos] = apps[i];
				pos = pos + 1;
				i = i + 1;

			} else {
				novoVetor[pos] = apps[m];
				pos = pos + 1;
				m = m + 1;
			}
		}

		while (i < meio) {
			novoVetor[pos] = apps[i];
			pos = pos + 1;
			i = i + 1;
		}

		while (m < fim) {
			novoVetor[pos] = apps[m];
			pos = pos + 1;
			m = m + 1;
		}

		for (pos = 0, i = inicio; i < fim; i++, pos++) {
			apps[i] = novoVetor[pos];
		}
	}

	private void intercalaLastUpdates(App[] apps, int inicio, int meio, int fim) throws ParseException {
		App novoVetor[] = new App[fim - inicio];
		int i = inicio;
		int m = meio;
		int pos = 0;

		while (i < meio && m < fim) {

			if (dateFormat.parse(apps[i].getLast_update()).before(dateFormat.parse(apps[m].getLast_update()))) {
				novoVetor[pos] = apps[i];
				pos = pos + 1;
				i = i + 1;

			} else {
				novoVetor[pos] = apps[m];
				pos = pos + 1;
				m = m + 1;
			}
		}

		while (i < meio) {
			novoVetor[pos] = apps[i];
			pos = pos + 1;
			i = i + 1;
		}

		while (m < fim) {
			novoVetor[pos] = apps[m];
			pos = pos + 1;
			m = m + 1;
		}

		for (pos = 0, i = inicio; i < fim; i++, pos++) {
			apps[i] = novoVetor[pos];
		}
	}

}
