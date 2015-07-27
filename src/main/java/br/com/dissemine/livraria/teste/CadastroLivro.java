package br.com.dissemine.livraria.teste;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.Editora;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.dominio.produtos.LivroImpresso;

public class CadastroLivro {
	public static void main(String[] args){
		Autor autor = new Autor();
		autor.setNome ("Nietzsche");
		autor.setEmail ("nietzsche@666.com");
		
		Editora editora = new Editora();
		editora.setNome ("Sextante");
		editora.setUrl ("www.sextante.com");
		editora.setEmail ("sextante@local.com");
		
		Livro livro = new LivroImpresso(autor);
		livro.setTitulo ("Ecce homo");
		livro.setNumeroPaginas (200);
		livro.setValor (59.90);
		livro.setIsbn ("000-000-000");
		
		livro.setEditora (editora);
		
		livro.mostrarDetalhes();
		livro.concederDesconto(0.1);
		
		
		Autor outroAutor = new Autor();
		outroAutor.setNome ("Dan Brown");
		outroAutor.setEmail ("dan@brown.com");
		
		Editora outroEditora = new Editora();
		outroEditora.setNome ("Pearson");
		outroEditora.setUrl ("www.pearson.com");
		outroEditora.setEmail ("pearson@local.com");
		
		Livro outroLivro = new LivroImpresso(autor);
		outroLivro.setTitulo ("Fortaleza Digital");
		outroLivro.setNumeroPaginas (300);
		outroLivro.setValor (49.70);
		outroLivro.setIsbn ("000-111-000");
		
		outroLivro.setEditora (outroEditora);
		
		
		outroLivro.mostrarDetalhes();
		livro.concederDesconto(0.2);
		
	}

}
