package br.com.dissemine.livraria.web;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.dominio.produtos.LivroImpresso;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
public class ListarBean {

	private LivroImpresso livro = new LivroImpresso();
	private List<Livro> livros;
   private String titulo = "";
    private String ultimoTituloPesquisado = "";
	
   
    
    public ListarBean() {
    	Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
 	   String parametroId = parametros.get("id");
         if(parametroId != null){
         livro = JPAUtil.getEntityManager().find(LivroImpresso.class,Long.valueOf(parametroId));
         	
         }
    }
   
   
	
		public void carregarlivros(){
		Query query = JPAUtil.getEntityManager().createNamedQuery(Livro.LIVROS_EM_ESTOQUE_POR_TITULO,Livro.class);
		query.setParameter("tituloLivro","%" + titulo.toUpperCase() + "%");
		livros = query.getResultList();
		ultimoTituloPesquisado = titulo;
		
		}



	public List<Livro> getLivros() {
		if(! ultimoTituloPesquisado.equals(titulo)){
			carregarlivros();
		}
			return livros;
		}



	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
