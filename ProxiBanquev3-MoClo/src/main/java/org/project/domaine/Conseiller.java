package org.project.domaine;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//@Entity
public class Conseiller {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idConseiller;

	private String nom;

	private String prenom;
	private String password;
	private String login;

//	@OneToMany(mappedBy = "idClient")
	private List<Client> clients;

//	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
//	@JoinColumn(name = "idAgence", unique = true)
//	private Agence agence;

	public Conseiller(int idConseiller, List<Client> clients) {
		this.idConseiller = idConseiller;
		this.clients = clients;
	}

	public Conseiller() {
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
//
//	public Agence getAgence() {
//		return agence;
//	}
//
//	public void setAgence(Agence agence) {
//		this.agence = agence;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
