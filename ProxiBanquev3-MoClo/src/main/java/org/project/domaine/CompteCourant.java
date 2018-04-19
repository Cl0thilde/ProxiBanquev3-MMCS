package org.project.domaine;

import javax.persistence.Entity;

@Entity
public class CompteCourant extends Compte {

	private double decouvertAutorise;
	private String carteVisa;

	public CompteCourant() {
	}

	public CompteCourant(double decouvertAutorise, String carteVisa) {
		this.decouvertAutorise = decouvertAutorise;
		this.carteVisa = carteVisa;
	}

	public double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	public String getCarteVisa() {
		return carteVisa;
	}

	public void setCarteVisa(String carteVisa) {
		this.carteVisa = carteVisa;
	}

}
