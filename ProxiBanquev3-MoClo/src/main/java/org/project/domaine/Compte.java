package org.project.domaine;

public abstract class Compte {

	private int numCompte;
	private double solde;
	private String dateOuverture;

	public Compte(int numCompte, double solde, String dateOuverture) {
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}

	public Compte() {
	}

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

}
