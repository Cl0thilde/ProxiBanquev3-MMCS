package org.project.dao;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.project.domaine.CompteCourant;
import org.project.util.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoCompteCourant implements IDao<CompteCourant> {

	private static Logger LOGGER = LoggerFactory.getLogger(DaoCompteCourant.class);

	@Override
	public int create(CompteCourant element) {
		EntityManager em = JPAUtil.EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			Date dateOuverture = new Date();
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			shortDateFormat.format(dateOuverture);
			element.setDateOuverture(dateOuverture);
			LOGGER.debug("Compte courant à créer : ", element);
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

	@Override
	public int update(CompteCourant element) {
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

	@Override
	public int delete(CompteCourant element) {
		EntityManager em = JPAUtil.EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			element = em.find(CompteCourant.class, element.getNumCompte());
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

	@Override
	public CompteCourant readById(int id) {
		EntityManager em = JPAUtil.EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		CompteCourant compteCourant = null;
		try {
			txn.begin();

			compteCourant = em.find(CompteCourant.class, id);

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}

		return compteCourant;
	}

	@Override
	public List<CompteCourant> readAll() {
		EntityManager em = JPAUtil.EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		List<CompteCourant> compteCourants = new ArrayList<>();
		try {
			txn.begin();
			TypedQuery<CompteCourant> queryCompteCourant = em.createQuery("from CompteCourant", CompteCourant.class);
			compteCourants = queryCompteCourant.getResultList();

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}

		return compteCourants;

	}

}
