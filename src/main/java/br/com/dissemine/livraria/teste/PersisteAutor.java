package br.com.dissemine.livraria.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.dissemine.livraria.dominio.Autor;



public class PersisteAutor {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = emf.createEntityManager();
		
		
		Autor autor = new Autor();
		autor.setNome("Leonardo");
		autor.setEmail("llvrariano@gmail.com");
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(autor);
		tx.commit();
		em.close();
		emf.close();
	}
}
