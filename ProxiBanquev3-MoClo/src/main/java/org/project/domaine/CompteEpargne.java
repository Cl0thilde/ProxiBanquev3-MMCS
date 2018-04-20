package org.project.domaine;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class CompteEpargne extends Compte {

	private double tauxRemuneration;

	public CompteEpargne(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;

	}

	public CompteEpargne() {

	}

	public CompteEpargne(double solde, double tauxRemuneration) {
		super(solde);
		this.tauxRemuneration = tauxRemuneration;
	}

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

}
