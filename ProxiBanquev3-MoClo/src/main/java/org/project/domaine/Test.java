package org.project.domaine;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			//
			//// Conseiller con1 = new Conseiller();
			Client cl1 = new Client();
			// Client cl2 = new Client();
			//
			//// cl1.setConseiller(con1);
			// cl2.setConseiller(con1);
			// em.persist(cl1);
			// em.persist(cl2);

			CompteCourant c = new CompteCourant(0, "carteVisa");
			CompteEpargne c1 = new CompteEpargne(0.2);
			List<Compte> comptes = new ArrayList<>();
			comptes.add(c);
			comptes.add(c1);

			// c.setClient(cl1);
			// em.persist(c);

			cl1.setComptes(comptes);
			em.persist(cl1);
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

}
