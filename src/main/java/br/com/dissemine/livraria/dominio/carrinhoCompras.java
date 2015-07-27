package br.com.dissemine.livraria.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.dissemine.livraria.dominio.produtos.Produto;

public class carrinhoCompras {
	
	private double valorTotal = 0;
	
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public void adiciona(Produto produto){
		
		
		
		produtos.add(produto);
	    valorTotal = valorTotal + produto.getValor();
	 
		 
	    
	}
	
	public void mostrarItens(){
		
		Collections.sort(produtos);
		for(Produto produto:produtos){
			System.out.println("nome:"+produto.getTitulo()+"   valor:"+produto.getValor());
		}
		
	}
	public double getValorTotal() {
		return valorTotal;
	}
	
}
