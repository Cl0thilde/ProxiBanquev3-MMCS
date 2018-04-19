package org.project.domaine;

public class CompteEpargne extends Compte{

	private double tauxRemuneration;

	public CompteEpargne(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;

	}

	public CompteEpargne() {

	}

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

}
