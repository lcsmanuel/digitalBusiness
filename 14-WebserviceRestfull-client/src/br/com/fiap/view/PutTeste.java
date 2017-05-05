package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class PutTeste {

	public static void main(String[] args) {
		//Atualizar
		ProdutoRepository rep = new ProdutoRepository();
		
		ProdutoTO produto = 
				new ProdutoTO(1, "Fanta" , 4, 1000);
		
		try {
			rep.atualizar(produto);
			System.out.println("Sucesso!");
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
		
	}
	
}
