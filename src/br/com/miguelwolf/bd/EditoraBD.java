package br.com.miguelwolf.bd;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.miguelwolf.entidades.Editora;
import br.com.miguelwolf.utils.Constants;

@Named
@RequestScoped
public class EditoraBD {

	private EntityManager manager;
	private EntityManagerFactory factory;

	private List<Editora> lista;

	public EditoraBD() {
		factory = Persistence.createEntityManagerFactory(Constants.BANCO);
		manager = factory.createEntityManager();
	}

	public boolean salvar(Editora e) {
		try {			
			manager.persist(e);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			factory.close();
			return true;
		} catch (Exception err) {
			return false;
		}
	}
	
	public boolean atualizar(Editora e) {
		try {
			manager.merge(e);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			factory.close();
			return true;
		} catch (Exception err) {
			return false;
		}
	}

	public List<Editora> consultarEditoras() {
		factory = Persistence.createEntityManagerFactory(Constants.BANCO);
		manager = factory.createEntityManager();
		Query query = (Query) manager.createQuery("SELECT l FROM Editora l");
		return query.getResultList();
	}
	
	public Editora consultarEditoraId(String id) {
		factory = Persistence.createEntityManagerFactory(Constants.BANCO);
		manager = factory.createEntityManager();
		Query query = (Query) manager.createQuery("SELECT e FROM Editora e where e.codEditora = "+id);
		return (Editora) query.getSingleResult();
	}

}
