package br.com.dissemine.livraria.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import br.com.dissemine.livraria.dominio.produtos.Livro;



@Entity
public class ItemCompra {
    
	
	@Id
	@SequenceGenerator(name = "compraGenerator", sequenceName = "compra_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compraGenerator")
	protected Long Id;
	@OneToOne
	private Livro livro;
	private Integer quantidade;
	

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	} 
	
}
