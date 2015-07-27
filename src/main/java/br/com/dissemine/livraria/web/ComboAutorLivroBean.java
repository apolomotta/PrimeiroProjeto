package br.com.dissemine.livraria.web;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.dominio.produtos.LivroImpresso;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
public class ComboAutorLivroBean {
	

	private Autor autor;
	private Livro livro;
	private List<LivroImpresso> livros;
	

	   
	   

    
	    public void carregarcombo(){
	    	if(autor!= null){
		Query query = JPAUtil.getEntityManager().createNamedQuery(Livro.LIVROS_POR_AUTOR,Livro.class);
		query.setParameter("idAutor",autor.getId());
		livros = query.getResultList();
	        }
		}



		public Autor getAutor() {
			return autor;
		}



		public void setAutor(Autor autor) {
			this.autor = autor;
		}



		public Livro getLivro() {
			return livro;
		}



		public void setLivro(Livro livro) {
			this.livro = livro;
		}



		public List<LivroImpresso> getLivros() {
		
				carregarcombo();
			
			return livros;
		}



		public void setLivros(List<LivroImpresso> livros) {
			this.livros = livros;
		}

	

}
