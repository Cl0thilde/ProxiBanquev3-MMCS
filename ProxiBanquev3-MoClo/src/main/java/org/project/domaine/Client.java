package org.project.domaine;

import java.util.List;

public class Client extends Personne {

	private int idClient;
	private Adresse adresse;
	private String telephone;
	private String email;
	private List<Compte> comptes;

	public Client(int idClient, Adresse adresse, String telephone, String email, List<Compte> comptes) {

		this.idClient = idClient;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.comptes = comptes;
	}

	public Client() {

	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

}
