package org.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.project.domaine.Conseiller;
import org.project.util.JPAUtil;

public class DAOConnectionImpl implements DAOConnection {

	@Override
	public Conseiller getByLoginConseiller(String loginConseiller) {
		EntityManager em = JPAUtil.EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Conseiller conseiller = null;
		try {
			txn.begin();

			conseiller = em.find(Conseiller.class, loginConseiller);

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
	public Conseiller getByPasswordConseiller(String passwordConseiller) {
		EntityManager em = JPAUtil.EMF.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Conseiller conseiller = null;
		try {
			txn.begin();

			conseiller = em.find(Conseiller.class, passwordConseiller);

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
}
