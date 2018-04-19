package org.project.dao;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.project.domaine.CompteCourant;

public class DaoCompteCourant implements IDao<CompteCourant> {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	@Override
	public void create(CompteCourant element) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			Date dateOuverture = new Date();
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			shortDateFormat.format(dateOuverture);
			element.setDateOuverture(dateOuverture);
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
	public void update(CompteCourant element) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			CompteCourant compteCourant = em.find(CompteCourant.class, element.getNumCompte());
			compteCourant.setSolde(element.getSolde());
			em.merge(compteCourant);

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
	public void delete(CompteCourant element) {
		EntityManager em = emf.createEntityManager();
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
		emf.close();
	}

	@Override
	public CompteCourant readById(int id) {
		EntityManager em = emf.createEntityManager();
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
		emf.close();
		return compteCourant;
	}

	@Override
	public List<CompteCourant> readAll() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		List<CompteCourant> compteCourants = new ArrayList<>();
		try {
			txn.begin();
			TypedQuery<CompteCourant> queryCompteCourant = em.createQuery("from Client", CompteCourant.class);
			compteCourants = queryCompteCourant.getResultList();

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}
		emf.close();
		return compteCourants;

	}
}
