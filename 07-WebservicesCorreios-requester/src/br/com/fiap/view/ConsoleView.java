package br.com.fiap.view;

import javax.swing.JOptionPane;

import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class ConsoleView {

	public static void main(String[] args) {
		//Chamar o serviço de calcular prazo dos correios
		try {
			CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
			//40010 SEDEX
			//Valores que serão enviados para o webservice
			CalcPrazo valores = new CalcPrazo();
			valores.setNCdServico("40010"); //SEDEX
			valores.setSCepDestino(
				JOptionPane.showInputDialog("CEP Destino"));
			valores.setSCepOrigem(
				JOptionPane.showInputDialog("CEP Origem"));
			
			//Chama o webservice
			CalcPrazoResponse response = stub.calcPrazo(valores);
			
			//Recuperar os valores retornados pelo webservice
			String prazo = response.getCalcPrazoResult()
				.getServicos().getCServico()[0].getPrazoEntrega();
			
			JOptionPane.showMessageDialog(null, "Prazo: " + prazo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
