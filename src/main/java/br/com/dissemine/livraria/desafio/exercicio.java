package br.com.dissemine.livraria.desafio;
public class exercicio {

	public static void main(String[] args) {

		int contador = 0;

		while (contador <= 100) {
			if (contador % 3 == 0) {
				System.out.println("numero = " + contador);
			}
			contador = contador + 1;
		}

	}

}
