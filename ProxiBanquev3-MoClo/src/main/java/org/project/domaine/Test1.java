package org.project.domaine;

import org.project.dao.DaoClient;

import org.project.dao.DaoCompteCourant;

import org.project.dao.DaoCompteEpargne;

import org.project.dao.IDao;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IDao<CompteCourant> dao = new DaoCompteCourant();
//		Conseiller co=new Conseiller();
//		co.setIdConseiller(1);
		Adresse adresse = new Adresse("rue", 233, "ville");
		Client c = new Client("nom", "prenom", adresse, "telephone", "email");
		CompteCourant cc= new CompteCourant(0.1, "carteVisa");
		
	
////	c.setConseiller(co);
//		dao.create(c);
	
//		c.setNom("tutu");
//		c.setIdClient(1);
//		dao.update(c);
//		dao.delete(c);
//		System.out.println(dao.readAll());
//		cc.setSolde(200);
//		cc.setNumCompte(1);
		System.out.println(dao.readAll());
//		dao.update(cc);
//		
		

		IDao<Client> daoClient = new DaoClient();
		IDao<CompteEpargne> daoCompteEpargne = new DaoCompteEpargne();
		// Conseiller co=new Conseiller();
		// co.setIdConseiller(1);
		
		CompteEpargne cE = new CompteEpargne();

		daoCompteEpargne.create(cE);

//		cE.setTauxRemuneration(0.45);
//		cE.setNumCompte(1);
//		cE.setSolde(457.56);

//		daoCompteEpargne.update(cE);

		//// c.setConseiller(co);
		// dao.create(c);

		// c.setNom("tutu");
		// c.setIdClient(1);
		// dao.update(c);
		// dao.delete(c);
		// System.out.println(dao.readAll());

	}

}
