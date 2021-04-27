package br.com.java.dao;

import java.util.List;

import javax.persistence.*;

import br.com.java.model.Pessoa;


public class PessoaDao {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public PessoaDao() {
		emf = Persistence.createEntityManagerFactory("conexao");
		em = emf.createEntityManager();
	
	}
	public void salvar(Pessoa pessoa) {
		em.getTransaction().begin();
		em.merge(pessoa);
		em.getTransaction().commit();
		emf.close();
	}
	public void excluir(Pessoa pessoa) {
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
		emf.close();
	}
	@SuppressWarnings("unchecked")
	public List<Pessoa> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("SELECT pessoa FROM Pessoa pessoa");
		List<Pessoa> pessoas = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		
		return pessoas;
	}
}
