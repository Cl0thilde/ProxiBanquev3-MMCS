package org.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.project.domaine.Client;

public class DaoClient implements IDao<Client> {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	@Override
	public void create(Client element) {
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
		emf.close();
	}

	@Override
	public void update(Client element) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			Client client = em.find(Client.class, element.getIdClient());
			client.setAdresse(element.getAdresse());
			client.setNom(element.getNom());
			client.setPrenom(element.getPrenom());
			client.setEmail(element.getEmail());
			em.merge(client);

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}
		emf.close();
	}

	@Override
	public void delete(Client element) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			element = em.find(Client.class, element.getIdClient());
			em.remove(element);

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}
		emf.close();
	}

	@Override
	public Client readById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Client client = null;
		try {
			txn.begin();

			client = em.find(Client.class, id);

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}
		emf.close();
		return client;
	}

	@Override
	public List<Client> readAll() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		List<Client> clients = new ArrayList<>();
		try {
			txn.begin();
			TypedQuery<Client> queryClients = em.createQuery("from Client", Client.class);
			clients = queryClients.getResultList();

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}
		emf.close();
		return clients;

	}

}
