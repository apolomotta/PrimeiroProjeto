package br.com.dissemine.livraria.desafio;

public class Repeticao {

	public static void main(String[] args) {
		
		int contador = 0;
		while (contador < 10){
			System.out.println("Contador = " + contador);
			contador = contador + 1;
		}
		for(int i=0; i<10; i++){
			if (i==5){
				continue;
			}
			System.out.println("contador = " + i);
		}

	}

}
