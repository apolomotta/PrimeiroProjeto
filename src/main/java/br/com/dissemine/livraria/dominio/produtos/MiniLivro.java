package br.com.dissemine.livraria.dominio.produtos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.dissemine.livraria.dominio.Autor;
@Entity
@DiscriminatorValue(value="mini")
public class MiniLivro extends Livro {
	
	public MiniLivro(){
		
	}
	
	public MiniLivro(Autor autor){
		super(autor);
	}
		
		public void concederDesconto(double percentualDesconto) {
			
			System.out.println("Valor sem desconto - minilivro: " + valor);
			System.out.println("_________________________");
			}
}
