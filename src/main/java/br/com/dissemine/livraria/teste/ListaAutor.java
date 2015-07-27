package br.com.dissemine.livraria.teste;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

public class ListaAutor {
	
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		Query query = em.createQuery("select a from Autor a", Autor.class);
		
		List<Autor> autores = query.getResultList();
		for(Autor autor:autores){
			System.out.println(autor.getNome()+" "+autor.getEmail());
		}
		em.close();
			
	}
	
}
