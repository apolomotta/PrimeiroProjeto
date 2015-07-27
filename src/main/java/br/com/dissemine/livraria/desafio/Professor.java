package br.com.dissemine.livraria.desafio;



public class Professor extends Funcionario {
	
	private double horasAula;
	@Override
	public void calcularBonus() {
		double valor = (getSalario() + ((getSalario() * 0.1 )+(10 * horasAula))); 
		System.out.println("Salario com Bonus:" + valor);
	}
	public double getHorasAula() {
		return horasAula;
	}
	public void setHorasAula(double horasAula) {
		this.horasAula = horasAula;
	}

}
