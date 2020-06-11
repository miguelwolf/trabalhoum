package br.com.miguelwolf.bd;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.miguelwolf.entidades.Editora;
import br.com.miguelwolf.entidades.Livro;
import br.com.miguelwolf.utils.Constants;

@Named
@RequestScoped
public class LivroBD {

	private EntityManager manager;
	private EntityManagerFactory factory;

	private List<Livro> lista;

	public LivroBD() {		
		factory = Persistence.createEntityManagerFactory(Constants.BANCO);
		manager = factory.createEntityManager();
	}

	public boolean salvar(Livro livro) {
		try {
			
//			Editora e = new Editora();
//			e.setCodEditora(Long.parseLong(editora));
			
			manager.persist(livro);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			factory.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean atualizar(Livro livro) {
		try {
			
//			Editora e = new Editora();
//			e.setCodEditora(Long.parseLong(editora));
			
			manager.merge(livro);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			factory.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<Livro> consultarLivros() {
		factory = Persistence.createEntityManagerFactory(Constants.BANCO);
		manager = factory.createEntityManager();
		Query query = (Query) manager.createQuery("SELECT l FROM Livro l");
		return query.getResultList();
	}

}
