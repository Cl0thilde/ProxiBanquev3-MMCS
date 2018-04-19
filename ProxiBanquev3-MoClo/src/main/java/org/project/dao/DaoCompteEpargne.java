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

import org.project.domaine.CompteEpargne;

public class DaoCompteEpargne implements IDao<CompteEpargne> {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	@Override
	public void create(CompteEpargne element) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			Date dateOuverture = new Date();
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
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
	public void update(CompteEpargne element) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			CompteEpargne compteEpargne = em.find(CompteEpargne.class, element.getNumCompte());
			compteEpargne.setSolde(element.getSolde());
			em.merge(compteEpargne);

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
	public void delete(CompteEpargne element) {
		EntityManager em = emf.createEntityManager();
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
		emf.close();

	}

	@Override
	public CompteEpargne readById(int id) {
		EntityManager em = emf.createEntityManager();
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
		emf.close();
		return compteEpargne;
	}

	@Override
	public List<CompteEpargne> readAll() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		List<CompteEpargne> compteEpargnes = new ArrayList<>();
		try {
			txn.begin();
			TypedQuery<CompteEpargne> queryCompteEpargne = em.createQuery("from Client", CompteEpargne.class);
			compteEpargnes = queryCompteEpargne.getResultList();

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}
		emf.close();
		return compteEpargnes;

	}
}
