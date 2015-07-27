package br.com.dissemine.livraria.web;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;





import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.Editora;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;



@ManagedBean
public class EditoraBean {

	private Editora editora= new Editora();
	private List<Editora> editoras;
	private EntityManager em = JPAUtil.getEntityManager();
	
	public EditoraBean(){
		Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		   String parametroId = parametros.get("id");
	        if(parametroId != null){
	        	editora = em.find(Editora.class,Long.valueOf(parametroId));
	        	
	        }
	}
	
	public String salvar(){
		
		if(editora.getId()==null){
			em.persist(editora);	
		}else{
			em.merge(editora);
		}
		
		return "listaEditora.xhtml?faces-redirect=true";
	}
	
	public List<Editora> getEditoras(){
		if(editoras == null){
		Query query = em.createQuery("select e from Editora e", Editora.class);
		editoras = query.getResultList();
		}
		return editoras;
	}
	
	public void excluir(Editora editora){
		Editora editoraGerenciada = em.merge(editora);
		em.remove(editoraGerenciada);
		editoras = null;
	}
	


	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	
}
