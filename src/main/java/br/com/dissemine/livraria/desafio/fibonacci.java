package br.com.dissemine.livraria.desafio;

public class fibonacci {

	public static void main(String[] args) {
		int a=0,b=1,c=1;
		int cont=1;
		System.out.println("numero=" + a);
		while(cont<=6)
    {
    	System.out.println("numero=" + c);
    	c=a+b;
    	a=b;
    	b=c;
    	cont++;
    }
	}

}
