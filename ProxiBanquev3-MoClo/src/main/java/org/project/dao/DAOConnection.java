package org.project.dao;

import org.project.domaine.Conseiller;

public interface DAOConnection {

	public  Conseiller getByLoginConseiller(String loginConseiller);
	
	public Conseiller getByPasswordConseiller(String passwordConseiller);
	
}
