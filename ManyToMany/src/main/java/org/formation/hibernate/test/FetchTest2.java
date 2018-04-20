package org.formation.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.formation.hibernate.model.Movie;

public class FetchTest2 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();

		TypedQuery<Movie> tq = em.createQuery("select m from Movie m Join fetch m.actors a where m.idMovie= :id",
				Movie.class);
		tq.setParameter("id", 4);

		Movie m = tq.getSingleResult();

		if (em != null) {
			em.close();
		}
		if (emf != null) {
			emf.close();
		}

		System.out.println(m.getActors());

	}
}
