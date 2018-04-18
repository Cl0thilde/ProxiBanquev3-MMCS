package org.projet.domaine;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idClient;
	@Embedded
	private Personne personne;
	@Embedded
	private Adresse adresse;
	private String telephone;

	public Client() {

	}

	// public Client(int idPersonne, String nom, String prenom, Adresse adresse,
	// String telephone) {
	// super(idPersonne, nom, prenom);
	// this.adresse = adresse;
	// this.telephone = telephone;
	// }

	public Client(Personne personne, Adresse adresse, String telephone) {
		this.personne = personne;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	@XmlElement
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	@XmlElement
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getIdClient() {
		return idClient;
	}

	@XmlElement
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	
	public Personne getPersonne() {
		return personne;
	}

	@XmlElement
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", personne=" + personne + ", adresse=" + adresse + ", telephone="
				+ telephone + "]";
	}



}
