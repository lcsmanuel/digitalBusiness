package br.com.fiap.view;

import br.com.fiap.bo.EstoqueBOStub;
import br.com.fiap.bo.EstoqueBOStub.Listar;
import br.com.fiap.bo.EstoqueBOStub.ListarResponse;
import br.com.fiap.bo.EstoqueBOStub.ProdutoTO;

public class TerminalConsultaTudo {

	public static void main(String[] args) {
		
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			
			//Chama o webservice
			ListarResponse response = 
							stub.listar(new Listar());
			
			//Recupera os valores do webservice
			ProdutoTO[] array = response.get_return();
			
			for (ProdutoTO produtoTO : array) {
				System.out.println("Produto: " + produtoTO.getDescricao());
				System.out.println("Preço: " + produtoTO.getPreco());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
