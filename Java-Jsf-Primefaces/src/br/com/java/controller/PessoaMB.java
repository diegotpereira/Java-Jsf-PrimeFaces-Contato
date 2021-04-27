package br.com.java.controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.java.dao.PessoaDao;
import br.com.java.model.Pessoa;

@ManagedBean
public class PessoaMB {
	
	private Pessoa pessoa;
	private PessoaDao pessoaDao;
	private List<Pessoa> Lista;
	
	public PessoaMB() {
		pessoaDao = new PessoaDao();
		pessoa = new Pessoa();
		Lista = pessoaDao.listarTodos();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getLista() {
		return Lista;
	}
	public void salvar() {
		pessoaDao.salvar(pessoa);
		addMessage("Pessoa salva com sucesso!!");
		Lista = pessoaDao.listarTodos();
	}

	private void addMessage(String summary) {
		// TODO Auto-generated method stub
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		
	}
}
