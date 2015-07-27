package br.com.dissemine.livraria.desafio;

public class Diretor extends Funcionario{

	@Override
	public void calcularBonus() {
		double valor=(getSalario() + ((getSalario() * 0.1 )));
		System.out.println("Salario com Bonus:" + valor);
	}

}
