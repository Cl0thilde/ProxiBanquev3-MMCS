package org.project.domaine;

import java.util.List;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
//@Entity

public class Agence {

//	@Id
	private String idAgence;

	
//	@OneToMany(mappedBy="idConseiller")
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
