package org.project.domaine;

import java.util.List;

public class Conseiller extends Personne{

	private int idConseiller;
	private List<Client> clients;

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

}
