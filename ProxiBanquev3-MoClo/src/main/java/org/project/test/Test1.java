package org.project.test;

import org.project.dao.DaoClient;
import org.project.dao.DaoCompteCourant;
import org.project.dao.DaoCompteEpargne;
import org.project.dao.IDao;
import org.project.domaine.Adresse;
import org.project.domaine.Client;
import org.project.domaine.CompteCourant;
import org.project.domaine.CompteEpargne;

public class Test1 {

	public static void main(String[] args) {

		IDao<Client> daoClient = new DaoClient();
		IDao<CompteCourant> daoCompteCourant = new DaoCompteCourant();
		IDao<CompteEpargne> daoCompteEpargne = new DaoCompteEpargne();

//		Adresse adresse1 = new Adresse("A", 75000, "A");
//		Client client1 = new Client("A", "A", adresse1, "A", "A");
//
//		Adresse adresse2 = new Adresse("B", 75000, "B");
//		Client client2 = new Client("B", "B", adresse2, "B", "B");
//
//		Adresse adresse3 = new Adresse("C", 75000, "C");
//		Client client3 = new Client("C", "C", adresse3, "C", "C");

		// daoClient.create(client1);
		// daoClient.create(client2);
		// daoClient.create(client3);

		Client client1 = daoClient.readById(1);
		Client client2 = daoClient.readById(2);
		Client client3 = daoClient.readById(3);

//		CompteCourant compteC1 = new CompteCourant(100, 1000, "CartePremier");
//		CompteCourant compteC2 = new CompteCourant(200, 1000, "CartePremier");
//		CompteCourant compteC3 = new CompteCourant(300, 1000, "CartePremier");
//
//		compteC2.setClient(client2);
//		compteC3.setClient(client3);
//
//		daoCompteCourant.create(compteC1);
//		daoCompteCourant.create(compteC2);
//		daoCompteCourant.create(compteC3);
//		CompteCourant compteC1 = daoCompteCourant.readById(16);
//		compteC1.setClient(client1);
//		daoCompteCourant.create(compteC1);
//		daoCompteCourant.update(compteC1);
//
		CompteEpargne compteE1 = new CompteEpargne(500, 6.5);
		compteE1.setClient(client1);
		daoCompteEpargne.create(compteE1);

	}

}
