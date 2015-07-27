package br.com.dissemine.livraria.dominio.produtos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.dissemine.livraria.dominio.Autor;

@Entity
@DiscriminatorValue(value="impresso")
public class LivroImpresso extends Livro {
 
	private Double peso;
	private Double altura;
	private Double largura;
	
	public LivroImpresso(){
		
	}
	
	public LivroImpresso(Autor autor){
		super(autor);
	}
	
	@Override
	public void concederDesconto(double percentualDesconto) {
		if(percentualDesconto <= 0.3)
		{
		valor -= valor * percentualDesconto;
		System.out.println("Valor com desconto - impresso: " + valor);
		System.out.println("_________________________");
		}else{
			System.out.println("Valor com desconto - impresso: " + valor);
			System.out.println("_________________________");
			
		}
		
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}
	
	
	




}
