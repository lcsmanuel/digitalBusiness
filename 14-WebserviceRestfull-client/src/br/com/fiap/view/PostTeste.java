package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class PostTeste {

	public static void main(String[] args) {
		//Cadastrar um produto
		
		ProdutoRepository rep = new ProdutoRepository();
		
		ProdutoTO produto = new ProdutoTO(0,"Coca Cola",5,100);
		
		try {
			rep.cadastrar(produto);
			System.out.println("Sucesso!");
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
		
	}
	
}
