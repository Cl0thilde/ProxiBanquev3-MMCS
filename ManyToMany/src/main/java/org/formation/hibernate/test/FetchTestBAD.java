package org.formation.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.formation.hibernate.model.Movie;

public class FetchTestBAD {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = null;
		EntityTransaction txn = null;
		Movie m = null;
		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();

			m = em.find(Movie.class, 1);

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
		System.out.println(m.getActors()); // Utilisation de Fetch = EAGER

	}

}
