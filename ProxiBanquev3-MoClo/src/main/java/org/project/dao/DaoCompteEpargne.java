package org.project.dao;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.project.domaine.CompteEpargne;
import org.project.util.JPAUtil;

/**
 * 
@author Clothide et Morane
 *
 */

public class DaoCompteEpargne implements IDao<CompteEpargne> {
	/**
	 * Méthode create() permet de persister un compte épargne dans la base de
	 * données
	 */
	@Override
	public int create(CompteEpargne element) {
		EntityManager em = JPAUtil.EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			Date dateOuverture = new Date();
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			shortDateFormat.format(dateOuverture);
			element.setDateOuverture(dateOuverture);
			em.merge(element);

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}
		return element.getNumCompte();
	}

	/**
	 * Méthode update() permet de mettre à jour un compte épargne dans la base de
	 * données
	 */
	@Override
	public int update(CompteEpargne element) {
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
		return element.getNumCompte();
	}

	/**
	 * Méthode delete() permet de supprimer un compte épargne dans la base de
	 * données
	 */
	@Override
	public int delete(CompteEpargne element) {
		EntityManager em = JPAUtil.EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			element = em.find(CompteEpargne.class, element.getNumCompte());
			em.remove(element);

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}
		return element.getNumCompte();
	}

	/**
	 * Méthode readById() permet d'afficher un compte épargne de la base de données
	 */
	@Override
	public CompteEpargne readById(int id) {
		EntityManager em = JPAUtil.EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		CompteEpargne compteEpargne = null;
		try {
			txn.begin();

			compteEpargne = em.find(CompteEpargne.class, id);

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}

		return compteEpargne;
	}

	/**
	 * Méthode readAll() permet d'afficher plusieurs comptes épargnes de la base de
	 * données
	 */
	@Override
	public List<CompteEpargne> readAll() {
		EntityManager em = JPAUtil.EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		List<CompteEpargne> compteEpargnes = new ArrayList<>();
		try {
			txn.begin();
			TypedQuery<CompteEpargne> queryCompteEpargne = em.createQuery("from CompteEpargne", CompteEpargne.class);
			compteEpargnes = queryCompteEpargne.getResultList();

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}

		return compteEpargnes;

	}
}
