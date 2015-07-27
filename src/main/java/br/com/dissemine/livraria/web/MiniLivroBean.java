package br.com.dissemine.livraria.web;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;




import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.produtos.LivroDigital;
import br.com.dissemine.livraria.dominio.produtos.MiniLivro;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
public class MiniLivroBean {

	private MiniLivro livro = new MiniLivro();
	private List<MiniLivro> livros;
	private Autor autor;
	private EntityManager em = JPAUtil.getEntityManager();
	
	
	public MiniLivroBean(){
		Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	   String parametroId = parametros.get("id");
        if(parametroId != null){
        livro = em.find(MiniLivro.class,Long.valueOf(parametroId));
        	
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

	

  public void excluir(MiniLivro livro){
	  MiniLivro livroGerenciado = em.merge(livro);
	  em.remove(livroGerenciado);
	  livros = null;
	  
    }

public MiniLivro getLivro() {
	return livro;
}

public void setLivro(MiniLivro livro) {
	this.livro = livro;
}

public List<MiniLivro> getLivros() {
	return livros;
}

public void setLivros(List<MiniLivro> livros) {
	this.livros = livros;
}

}
