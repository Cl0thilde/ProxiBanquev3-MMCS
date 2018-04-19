package org.project.domaine;

import java.util.List;

public class Agence {

	private String idAgence;
	private List<Conseiller> conseillers;

	public Agence(String idAgence, List<Conseiller> conseillers) {
		this.idAgence = idAgence;
		this.conseillers = conseillers;
	}

	public Agence() {
	}

	public String getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(String idAgence) {
		this.idAgence = idAgence;
	}

	public List<Conseiller> getConseillers() {
		return conseillers;
	}

	public void setConseillers(List<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}

}
