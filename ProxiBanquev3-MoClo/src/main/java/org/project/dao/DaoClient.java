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
 * Dao du client impl�ment�e
 */
public class DaoClient implements IDao<Client> {

	/**
	 * m�thode Create() pour persister un client dans la base de donn�es
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
	 * M�thode update() permet de mettre � jour le client dans la base de donn�es
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
	 * M�thode delete() permet de supprimer un client dans la base de donn�es
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
	 * M�thode readById() permet d'afficher un client de la base de donn�es
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
	 * M�thode readAll() permet d'afficher tous les clients de la base de donn�es
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
