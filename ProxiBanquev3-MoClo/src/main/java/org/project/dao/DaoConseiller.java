package org.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.project.domaine.Conseiller;
import org.project.util.JPAUtil;

public class DaoConseiller implements IDao<Conseiller> {

	@Override
	public int create(Conseiller element) {
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

		return element.getIdConseiller();

	}

	@Override
	public int update(Conseiller element) {
		// TODO Auto-generated method stub

		return element.getIdConseiller();

	}

	@Override
	public int delete(Conseiller element) {
		EntityManager em = JPAUtil.EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			element = em.find(Conseiller.class, element.getIdConseiller());
			em.remove(element);

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}
		return element.getIdConseiller();
	}

	@Override
	public Conseiller readById(int id) {
		EntityManager em = JPAUtil.EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Conseiller conseiller = null;
		try {
			txn.begin();

			conseiller = em.find(Conseiller.class, id);

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}

		return conseiller;
	}

	@Override
	public List<Conseiller> readAll() {
		EntityManager em = JPAUtil.EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		List<Conseiller> conseillers = new ArrayList<>();
		try {
			txn.begin();
			TypedQuery<Conseiller> queryConseiller = em.createQuery("from Conseiller", Conseiller.class);
			conseillers = queryConseiller.getResultList();

			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();

		} finally {
			if (em != null)
				em.close();

		}

		return conseillers;

	}
}
