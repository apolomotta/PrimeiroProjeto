package br.com.dissemine.livraria.desafio;





public class CalcularBonus {
	public static void main(String[] args) {
		Salario salario = new Salario();
		
		Funcionario professor = new Professor();
		professor.setNome("Marcelo");
		professor.setCpf("555.334.232-45");
		professor.setMatricula(1234);
		professor.setSalario(5000);
		((Professor) professor).setHorasAula(60);
		
		
		Funcionario diretor = new Diretor();
		diretor.setNome("Roger");
		diretor.setCpf("5000");
		diretor.setMatricula(1334);
		diretor.setSalario(10000);
		
		salario.adiciona(professor);
		salario.adiciona(diretor);
	}
}
