package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.entity.Consultor;
import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ConsultorRepository;

public class Teste {

	public static void main(String[] args) {
		
		ConsultorRepository rep = new ConsultorRepository();
		
		Consultor consultor = new Consultor();
		consultor.setNome("Teste");
		consultor.setTelefone("1321313");
		consultor.setCpf("132131313131");
		
		try {
			//Cadastra
			rep.cadastrar(consultor);
			System.out.println("Cadastrado!");
			
			//Lista
			List<Consultor> listar = rep.listar();
			for (Consultor c : listar) {
				System.out.println(c.getNome() + " " + c.getCpf() + " " + c.getTelefone());
			}
			
			Consultor consultor2 = listar.get(1);
			consultor2.setNome("Teste Update");
			//Atualizar
			rep.atualizar(consultor2);
			
			//Buscar
			Consultor consultor3 = rep.buscar(1);
			System.out.println(consultor3.getNome());
			
			//Remover
			rep.remover(1);
			
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
		
	}
	
}
