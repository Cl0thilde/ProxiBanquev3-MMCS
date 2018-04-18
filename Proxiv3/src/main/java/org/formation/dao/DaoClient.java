package org.formation.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.projet.domaine.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoClient implements IDao<Client> {

	private static Logger LOGGER = LoggerFactory.getLogger(DaoClient.class);

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
			if (em != null) {
				txn.rollback();
			}
			LOGGER.error("Exception");
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void update(Client element) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			Client client = em.find(Client.class, element.getIdClient());
			client.setTelephone(element.getTelephone());
			em.merge(client);
			txn.commit();
		} catch (Exception e) {
			if (em != null) {
				txn.rollback();
			}
			LOGGER.error("Exception");
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void delete(Client element) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			Client client = em.find(Client.class, element.getIdClient());
			em.remove(client);
			txn.commit();
		} catch (Exception e) {
			if (em != null) {
				txn.rollback();
			}
			LOGGER.error("Exception");
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Client readById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Client client = null;
		try {
			txn.begin();
			client = em.find(Client.class, id);
			txn.commit();
		} catch (Exception e) {
			if (em != null) {
				txn.rollback();
			}
			LOGGER.error("Exception");
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return client;
	}

	@Override
	public List<Client> readAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		List<Client> clients = new ArrayList<>();

		try {
			txn.begin();
			TypedQuery<Client> queryClients = em.createQuery("from Client", Client.class);
			clients = queryClients.getResultList();
			txn.commit();
		} catch (Exception e) {
			if (em != null) {
				txn.rollback();
			}
			LOGGER.error("Exception");
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return clients;
	}

}
