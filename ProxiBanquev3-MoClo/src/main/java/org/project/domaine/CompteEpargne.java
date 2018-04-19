package org.project.domaine;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}


}
