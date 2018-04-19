package org.project.service;

import org.project.domaine.Conseiller;

public interface GestionConseiller {
	
	public Conseiller checkConseillerLogin(String login);
	
	public Conseiller checkConseillerPassword(String password);
	

}
