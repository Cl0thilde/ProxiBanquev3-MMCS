package org.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.project.domaine.Client;
import org.project.util.JPAUtil;

/**
 * @author Morane et Clothilde
 *
 */
/**
 * Dao du client implémentée
 */
public class DaoClient implements IDao<Client> {

	/**
	 * méthode Create() pour persister un client dans la base de données
	 */

	@Override
	public int create(Client element) {
		EntityManager em = JPAUtil.EMF.createEntityManager();
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
		return element.getIdClient();
	}

	/**
	 * Méthode update() permet de mettre à jour le client dans la base de données
	 */
	@Override
	public int update(Client element) {
		// TODO Auto-generated method stub
		EntityManager em = JPAUtil.EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			em.merge(element);

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}
		return element.getIdClient();
	}

	/**
	 * Méthode delete() permet de supprimer un client dans la base de données
	 */
	@Override
	public int delete(Client element) {
		EntityManager em = JPAUtil.EMF.createEntityManager();
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
		return element.getIdClient();
	}

	/**
	 * Méthode readById() permet d'afficher un client de la base de données
	 */
	@Override
	public Client readById(int id) {
		EntityManager em = JPAUtil.EMF.createEntityManager();
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

		return client;
	}

	/**
	 * Méthode readAll() permet d'afficher tous les clients de la base de données
	 */
	@Override
	public List<Client> readAll() {
		EntityManager em = JPAUtil.EMF.createEntityManager();
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

		return clients;

	}

}
