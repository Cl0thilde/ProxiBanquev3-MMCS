package org.project.domaine;

import org.project.dao.DaoClient;
import org.project.dao.IDao;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IDao<Client> dao = new DaoClient();
//		Conseiller co=new Conseiller();
//		co.setIdConseiller(1);
		Adresse adresse = new Adresse("rue", 233, "ville");
		Client c = new Client("nom", "prenom", adresse, "telephone", "email");
	
////		c.setConseiller(co);
//		dao.create(c);
	
//		c.setNom("tutu");
//		c.setIdClient(1);
//		dao.update(c);
//		dao.delete(c);
		System.out.println(dao.readAll());
		
	}

}
