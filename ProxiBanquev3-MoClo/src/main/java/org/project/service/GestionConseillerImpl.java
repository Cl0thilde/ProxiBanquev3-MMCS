package org.project.service;

import org.project.dao.DAOConnection;
import org.project.dao.DAOConnectionImpl;
import org.project.dao.DaoConseiller;
import org.project.dao.IDao;
import org.project.domaine.Conseiller;

public class GestionConseillerImpl implements GestionConseiller{
DAOConnection dao = new DAOConnectionImpl();
	@Override
	public Conseiller checkConseillerLogin(String login) {
			// DONE Methode de vérification conseiller
			
			Conseiller conseiller = dao.getByLoginConseiller(login);
			if (conseiller.getLogin().equals(login)) {
				return conseiller;
			} else {
				conseiller.setIdConseiller(0);
				
				return conseiller;
			}
		}

	@Override
	public Conseiller checkConseillerPassword(String password) {
		// DONE Methode de vérification conseiller			
		Conseiller conseiller = dao.getByPasswordConseiller(password);
					if (conseiller.getPassword().equals(password)) {
						return conseiller;
					} else {
						conseiller.setIdConseiller(0);
						
						return conseiller;
					}
	}
}

	



