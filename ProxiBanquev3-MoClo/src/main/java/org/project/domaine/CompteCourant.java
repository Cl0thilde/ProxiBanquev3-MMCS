package org.project.domaine;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Clothilde et Morane
 *
 */

/**
 * Class CompteCourant qui hérite de la Classe Compte
 *
 */
@XmlRootElement
@Entity
public class CompteCourant extends Compte {

	private double decouvertAutorise;
	private String carteVisa;

	public CompteCourant() {
	}

	public CompteCourant(double solde, double decouvertAutorise, String carteVisa) {
		super(solde);
		this.decouvertAutorise = decouvertAutorise;
		this.carteVisa = carteVisa;
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

	@Override
	public String toString() {
		return "CompteCourant [decouvertAutorise=" + decouvertAutorise + ", carteVisa=" + carteVisa + "]";
	}

}
