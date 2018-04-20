package org.formation.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.formation.hibernate.model.Actor;
import org.formation.hibernate.model.Movie;

public class RemoveActorFromMovie {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = null;
		EntityTransaction txn = null;

		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();

			Actor a = em.find(Actor.class, 1);
			Movie m = em.find(Movie.class, 7);
			m.getActors().remove(a);

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
