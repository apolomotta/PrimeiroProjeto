package br.com.dissemine.livraria.desafio;

public class fatorial {

	public static void main(String[] args) {
	int fat= calcular(5);
	System.out.println("5! = " + fat);
	
	}
   public static int calcular(int numero) {
	   if(numero == 0) {
		   return 1;
	   }
	   if(numero == 1){
	   return 1;
	   }
	   return numero * calcular(numero -1);
		
}
}