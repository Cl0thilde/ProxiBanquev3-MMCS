package org.project.domaine;

public class Adresse {

	private String rue;
	private int codePostal;
	private String dateOuverture;

	public Adresse(String rue, int codePostal, String dateOuverture) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.dateOuverture = dateOuverture;
	}

	public Adresse() {
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

}
