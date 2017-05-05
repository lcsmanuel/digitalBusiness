package br.com.fiap.view;

import java.util.List;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class GetTeste {

	public static void main(String[] args) {
		
		ProdutoRepository rep = new ProdutoRepository();
		
		//TESTE DO LISTAR
		try {
			 List<ProdutoTO> listar = rep.listar();
			 for (ProdutoTO produtoTO : listar) {
				System.out.println(produtoTO.getNome());
				System.out.println(produtoTO.getPreco());
				System.out.println(produtoTO.getQuantidade());
			}
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
		
		//TESTE DO BUSCAR
		System.out.println("BUSCAR:");
		try {
			ProdutoTO produto = rep.buscar(1);
			System.out.println(produto.getNome());
			System.out.println(produto.getPreco());
			System.out.println(produto.getQuantidade());
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
