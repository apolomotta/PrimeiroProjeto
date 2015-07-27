package br.com.dissemine.livraria.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;





import javax.servlet.http.Part;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.dominio.produtos.LivroDigital;
import br.com.dissemine.livraria.dominio.produtos.LivroImpresso;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;


@ManagedBean

public class LivroImpressoBean {

	private LivroImpresso livro = new LivroImpresso();
	private List<LivroImpresso> livros;
	private EntityManager em = JPAUtil.getEntityManager();
	private Autor autor;
	private static final String DIRETORIO_UPLOAD = "C:/JavaBasis/tools/apache-tomcat-7.0.62/webapps/uploads";
	private Part imagemCapa;
	
	
	
	
	
	
	public void salvar(){
		String urlImagemCapa = salvarImagemUpload();
		livro.setUrlImagemCapa(urlImagemCapa);
		livro.adicionarAutor(autor);
		if(livro.getId()==null){
		em.persist(livro);
		}else{
			em.merge(livro);
		}
			
		LivroImpresso livro = new LivroImpresso();
	}
	
	
	
	private String salvarImagemUpload(){
		InputStream is;
		try {
			is = imagemCapa.getInputStream();
			Path temporario = Files.createTempFile(Paths.get(DIRETORIO_UPLOAD),"livroimpresso-",".jpg");
		    Files.copy(is,temporario, StandardCopyOption.REPLACE_EXISTING);
		    is.close();
		    return "/uploads/" + temporario.getFileName().toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	

  public void excluir(LivroImpresso livro){
	  LivroImpresso livroGerenciado = em.merge(livro);
	  em.remove(livroGerenciado);
	  livros = null;
	  
    }

public LivroImpresso getLivro() {
	return livro;
}

public void setLivro(LivroImpresso livro) {
	this.livro = livro;
}

public List<LivroImpresso> getLivros() {
	return livros;
}

public void setLivros(List<LivroImpresso> livros) {
	this.livros = livros;
}



public Part getImagemCapa() {
	return imagemCapa;
}



public void setImagemCapa(Part imagemCapa) {
	this.imagemCapa = imagemCapa;
}


	





}
