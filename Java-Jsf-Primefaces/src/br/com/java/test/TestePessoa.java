package br.com.java.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.java.dao.PessoaDao;
import br.com.java.model.Pessoa;

public class TestePessoa {
	
	private PessoaDao pessoaDao;
	private Pessoa pessoa;

	@Test
	public void testSalvar() {
		pessoa = new Pessoa();
		
		pessoa.setId(1);
		pessoa.setNome("Teste Inserção de Pessoa");
		pessoa.setEmail("pessoa@teste.com");
		pessoa.setTelefone("51998656231");
		
		pessoaDao = new PessoaDao();
		pessoaDao.salvar(pessoa);
		
		assertTrue(pessoaDao.listarTodos().size()>0);
	}

}
