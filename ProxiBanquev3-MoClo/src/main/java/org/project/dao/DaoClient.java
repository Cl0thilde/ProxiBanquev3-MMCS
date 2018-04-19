package org.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.project.domaine.Client;

public class DaoClient implements IDao<Client> {

	@Override
	public void create(Client element) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			em.persist(element);

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}

	}

	@Override
	public void update(Client element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Client element) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
