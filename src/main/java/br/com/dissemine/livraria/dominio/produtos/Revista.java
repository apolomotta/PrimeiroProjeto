package br.com.dissemine.livraria.dominio.produtos;

import br.com.dissemine.livraria.dominio.Editora;

public class Revista implements Produto, Promocional {

	 private String titulo;
	 private Editora editora;
	 private Double valor;
	 
	 
	 
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	@Override
	public void concederDesconto(double percentualDesconto) {
		if(percentualDesconto <= 0.2)
		{
		valor -= valor * percentualDesconto;
		System.out.println("Valor com desconto - revista: " + valor);
		System.out.println("_________________________");	
		}else {
			System.out.println("Valor com desconto - revista: " + valor);
			System.out.println("_________________________");	
		}
		
	}
	@Override
	public int compareTo(Produto outro) {
	return this.getTitulo().compareToIgnoreCase(outro.getTitulo());
		
	}
	
}
