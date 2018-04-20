package org.project.domaine;

import java.util.List;

/**
 * @author Morane & Clothilde
 *
 */

/**
 * Classe du conseiller ; Prête pour les prochaines itérations du projet
 *
 */

public class Conseiller {
	private int idConseiller;
	private String nom;
	private String prenom;
	private String password;
	private String login;
	private List<Client> clients;

	public Conseiller(int idConseiller, List<Client> clients) {
		this.idConseiller = idConseiller;
		this.clients = clients;
	}

	public Conseiller(String nom, String prenom, String password, String login) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.login = login;
	}

	public Conseiller() {
		super();
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
