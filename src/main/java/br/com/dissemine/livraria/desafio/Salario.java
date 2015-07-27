package br.com.dissemine.livraria.desafio;


public class Salario {
	
		public void adiciona(Funcionario funcionario){
			System.out.println("adicionando funcionario");
			System.out.println("Nome:"+ funcionario.nome);
			System.out.println("Salario:"+funcionario.salario);
			
		   funcionario.calcularBonus();	
		}

}
