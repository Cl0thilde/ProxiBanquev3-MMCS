package org.project.domaine;

import org.project.dao.DaoClient;
import org.project.dao.DaoCompteCourant;
//import org.project.dao.DaoCompteEpargne;
import org.project.dao.IDao;

public class Test1 {

	public static void main(String[] args) {

		IDao<Client> daoClient = new DaoClient();
		IDao<CompteCourant> daoCompteCourant = new DaoCompteCourant();
//		IDao<CompteEpargne> daoCompteEpargne = new DaoCompteEpargne();

		// Adresse adresse1 = new Adresse("A", 75000, "A");
		// Client client1 = new Client("A", "A", adresse1, "A", "A");
		//
		// Adresse adresse2 = new Adresse("B", 75000, "B");
		// Client client2 = new Client("B", "B", adresse2, "B", "B");
		//
		// Adresse adresse3 = new Adresse("C", 75000, "C");
		// Client client3 = new Client("C", "C", adresse3, "C", "C");

		// daoClient.create(client1);
		// daoClient.create(client2);
		// daoClient.create(client3);

		Client client1 = daoClient.readById(1);
//		Client client2 = daoClient.readById(2);
//		Client client3 = daoClient.readById(3);

		// client1.setIdClient(1);
		// client2.setIdClient(2);
		// client3.setIdClient(3);

		CompteCourant compteC1 = new CompteCourant(100, 1000, "CartePremier");
//		CompteCourant compteC2 = new CompteCourant(200, 1000, "CartePremier");
//		CompteCourant compteC3 = new CompteCourant(300, 1000, "CartePremier");

		// compteC2.setClient(client2);
		// compteC3.setClient(client3);

		// daoCompteCourant.create(compteC1);
		// daoCompteCourant.create(compteC2);
		// daoCompteCourant.create(compteC3);
//		CompteCourant compteC1 = daoCompteCourant.readById(16);
		compteC1.setClient(client1);
		daoCompteCourant.create(compteC1);
//		daoCompteCourant.update(compteC1);
	}

}
