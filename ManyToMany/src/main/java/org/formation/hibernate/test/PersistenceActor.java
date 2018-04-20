package org.formation.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.formation.hibernate.model.Actor;

public class PersistenceActor {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = null;
		EntityTransaction txn = null;

		Actor a1 = new Actor("Clint Eastwood");
		Actor a2 = new Actor("Bruce Willis");
		Actor a3 = new Actor("Will Smith");
		Actor a4 = new Actor("Mila Jovovitch");
		Actor a5 = new Actor("Noomi Rapace");

		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			em.persist(a1);
			em.persist(a2);
			em.persist(a3);
			em.persist(a4);
			em.persist(a5);
			txn.commit();

		} catch (Exception e) {
			if (em != null) {
				txn.rollback();
			}
			System.err.println("ERREUR");
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}

	}

}
