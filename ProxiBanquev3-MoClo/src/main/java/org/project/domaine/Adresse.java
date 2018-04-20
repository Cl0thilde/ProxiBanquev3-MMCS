package org.project.domaine;

import javax.persistence.Embeddable;

/**
 * Adresse du client relier aux clients dans la base de données.
 * 
 * @author Clothilde et Morane
 *
 */

@Embeddable
public class Adresse {

	private String rue;
	private int codePostal;
	private String ville;

	public Adresse(String rue, int codePostal, String ville) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

}
