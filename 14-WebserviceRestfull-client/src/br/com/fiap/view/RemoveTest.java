package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ProdutoRepository;

public class RemoveTest {

	public static void main(String[] args) {
		ProdutoRepository rep = new ProdutoRepository();
		
		try {
			rep.deletar(1);
			System.out.println("Sucesso!");
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
