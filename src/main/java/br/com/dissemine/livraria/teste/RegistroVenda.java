package br.com.dissemine.livraria.teste;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.carrinhoCompras;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.dominio.produtos.LivroDigital;
import br.com.dissemine.livraria.dominio.produtos.LivroImpresso;
import br.com.dissemine.livraria.dominio.produtos.MiniLivro;
import br.com.dissemine.livraria.dominio.produtos.Revista;

public class RegistroVenda {
	
	public static void main(String[] args) {
		carrinhoCompras carrinho = new carrinhoCompras();
		
		Autor autor = new Autor();
		autor.setNome("Martin Fowler");
		
		
		Livro livroDigital = new LivroDigital(autor);
		livroDigital.setTitulo("Padroes de Integracao - Digital");
		livroDigital.setValor(20.00);
		
		
		
	
		
		Livro livroImpresso = new LivroImpresso(autor);
		livroImpresso.setTitulo("Padroes de Integracao - impresso");
		livroImpresso.setValor(25.00);
		
		Livro miniLivro = new MiniLivro(autor);
		miniLivro.setTitulo("Padroes de Integracao - minilivro");
		miniLivro.setValor(10.00);
		
		Revista revista = new Revista();
		revista.setTitulo("Java Magezine");
		revista.setValor(9.9);
		
		
		carrinho.adiciona(livroDigital);
		carrinho.adiciona(livroImpresso);
		carrinho.adiciona(miniLivro);
		carrinho.adiciona(revista);
		
		carrinho.mostrarItens();
		System.out.println("Valor total:" + carrinho.getValorTotal());
	}


}
