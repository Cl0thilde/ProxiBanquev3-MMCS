package org.formation.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.formation.hibernate.model.Actor;
import org.formation.hibernate.model.Movie;

public class PersistenceMovie {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = null;
		EntityTransaction txn = null;

		Actor a1 = new Actor("Clint Eastwood");
		Actor a2 = new Actor("Bruce Willis");
		Actor a3 = new Actor("Will Smith");
		Actor a4 = new Actor("Mila Jovovitch");
		Actor a5 = new Actor("Noomi Rapace");

		Movie m1 = new Movie("Le Cinquième Element");
		Movie m2 = new Movie("Million Dolar Baby");
		Movie m3 = new Movie("Resident Evil");
		Movie m4 = new Movie("Piège de Cristal");
		Movie m5 = new Movie("Je suis une Légende");
		Movie m6 = new Movie("Seven Sisters");
		Movie m7 = new Movie("Bright");

		m1.getActors().add(a2);
		m1.getActors().add(a4);
		m2.getActors().add(a1);
		m3.getActors().add(a4);
		m4.getActors().add(a2);
		m5.getActors().add(a3);
		m6.getActors().add(a5);
		m7.getActors().add(a3);
		m7.getActors().add(a5);

		a1.getMovies().add(m2);
		a2.getMovies().add(m1);
		a2.getMovies().add(m4);
		a3.getMovies().add(m5);
		a3.getMovies().add(m7);
		a4.getMovies().add(m1);
		a4.getMovies().add(m3);
		a5.getMovies().add(m6);
		a5.getMovies().add(m7);

		try {
			em = emf.createEntityManager();
			txn = em.getTransaction();
			txn.begin();

			em.persist(m1);
			em.persist(m2);
			em.persist(m3);
			em.persist(m4);
			em.persist(m5);
			em.persist(m6);
			em.persist(m7);

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
