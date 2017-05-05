package br.com.fiap.view;

import javax.swing.JOptionPane;

import br.com.fiap.bo.EstoqueBOStub;
import br.com.fiap.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.bo.EstoqueBOStub.ProdutoTO;

public class TerminalConsulta {

	public static void main(String[] args) {
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			
			ConsultarProduto valores = new ConsultarProduto();
			valores.setCodigo(Integer.parseInt(
				JOptionPane.showInputDialog("Digite o código")));
			
			ConsultarProdutoResponse response = 
							stub.consultarProduto(valores);
			
			ProdutoTO produto = response.get_return();
			
			JOptionPane.showMessageDialog(null,
					"Produto: " + produto.getDescricao()+
					"\nPreço: " + produto.getPreco());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}