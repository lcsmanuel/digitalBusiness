package br.com.fiap.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.bo.CarroBOStub;
import br.com.fiap.bo.CarroBOStub.Buscar;
import br.com.fiap.bo.CarroBOStub.BuscarResponse;
import br.com.fiap.bo.CarroBOStub.Cadastrar;
import br.com.fiap.bo.CarroBOStub.Carro;

public class Tela {

	protected Shell shell;
	private Text txtCor;
	private Text txtPlaca;
	private Text txtPreco;
	private Text txtCodigo;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		txtCor = new Text(shell, SWT.BORDER);
		txtCor.setBounds(38, 36, 115, 21);
		
		Label lblCor = new Label(shell, SWT.NONE);
		lblCor.setBounds(38, 15, 55, 15);
		lblCor.setText("Cor");
		
		Label lblPlaca = new Label(shell, SWT.NONE);
		lblPlaca.setBounds(38, 69, 55, 15);
		lblPlaca.setText("Placa");
		
		txtPlaca = new Text(shell, SWT.BORDER);
		txtPlaca.setBounds(38, 90, 115, 21);
		
		Label lblPreo = new Label(shell, SWT.NONE);
		lblPreo.setBounds(38, 127, 55, 15);
		lblPreo.setText("Pre\u00E7o");
		
		txtPreco = new Text(shell, SWT.BORDER);
		txtPreco.setBounds(38, 148, 115, 21);
		
		Button btnCadastrar = new Button(shell, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Recuperar os valores do text
				String cor = txtCor.getText();
				String placa = txtPlaca.getText();
				float preco = Float.parseFloat(txtPreco.getText());		
				//Criar um carro
				try {
					//Chamar o webservice
					CarroBOStub stub = new CarroBOStub();
					Carro carro = new Carro();
					carro.setCor(cor);
					carro.setPlaca(placa);
					carro.setPreco(preco);
					
					Cadastrar params = new Cadastrar();
					params.setCarro(carro);
					
					stub.cadastrar(params);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(38, 186, 115, 25);
		btnCadastrar.setText("Cadastrar");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(212, 36, 76, 21);
		
		Label lblCdigo = new Label(shell, SWT.NONE);
		lblCdigo.setBounds(212, 15, 55, 15);
		lblCdigo.setText("C\u00F3digo");
		
		Button btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					//Instanciar o Stub
					CarroBOStub stub = new CarroBOStub();
					//Recuperar o id que o cara digitou
					int codigo = Integer.parseInt(txtCodigo.getText());
					//Instanciar a classe (nome do método)
					Buscar params = new Buscar();
					params.setCodigo(codigo);
					//chamar o webservice através do stub
					BuscarResponse resp = stub.buscar(params);
					//Recuperar o valor retornado pelo webservice
					Carro carro = resp.get_return();
					//Exibir o resultado
					txtCor.setText(carro.getCor());
					txtPlaca.setText(carro.getPlaca());
					txtPreco.setText(String.valueOf(carro.getPreco()));
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(297, 34, 75, 25);
		btnBuscar.setText("Buscar");

	}
}
