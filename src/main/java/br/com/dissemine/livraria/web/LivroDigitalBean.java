package br.com.dissemine.livraria.web;



import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.produtos.LivroDigital;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;



@ManagedBean
public class LivroDigitalBean {
	
	
	private LivroDigital livro = new LivroDigital();
	private List<LivroDigital> livros;
	private EntityManager em = JPAUtil.getEntityManager();
	private Autor autor;
	
	public LivroDigitalBean(){
		Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	   String parametroId = parametros.get("id");
        if(parametroId != null){
        livro = em.find(LivroDigital.class,Long.valueOf(parametroId));
        	
        }
	}
	
	public void salvar(){
		livro.adicionarAutor(autor);
		if(livro.getId()==null){
		em.persist(livro);
		}else{
			em.merge(livro);
		}
			
		LivroDigital livro = new LivroDigital();
	}
	
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	

  public void excluir(LivroDigital livro){
	  LivroDigital livroGerenciado = em.merge(livro);
	  em.remove(livroGerenciado);
	  livros = null;
	  
    }

public LivroDigital getLivro() {
	return livro;
}

public void setLivro(LivroDigital livro) {
	this.livro = livro;
}

public List<LivroDigital> getLivros() {
	return livros;
}

public void setLivros(List<LivroDigital> livros) {
	this.livros = livros;
}


	





}
