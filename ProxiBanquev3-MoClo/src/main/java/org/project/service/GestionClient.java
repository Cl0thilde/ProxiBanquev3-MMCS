package org.project.service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.project.domaine.Client;
import org.project.domaine.CompteCourant;
import org.project.domaine.CompteEpargne;

public interface GestionClient {

	// Méthodes de gestion des clients
	public Response createClient(Client client);

	public Response updateClient(Client client);

	public Response deleteClient(String idClient);

	public Client readClientById(String idClient);

	public List<Client> readAllClient();

	// Méthodes de gestion des comptes courants
	public Response createCompteCourant(CompteCourant compteC);

	public Response updateCompteCourant(CompteCourant compteC);

	public Response deleteCompteCourant(String numCompte);

	public CompteCourant readCompteCourantByNum(String numCompte);

	public List<CompteCourant> readAllCompteCourant();

	// Méthodes de gestion des comptes epargnes
	public Response createCompteEpargne(CompteEpargne compteE);

	public Response updateCompteEpargne(CompteEpargne compteE);

	public Response deleteCompteEpargne(String numCompte);

	public CompteEpargne readCompteEpargneByNum(String numCompte);

	public List<CompteEpargne> readAllCompteEpargne();

}
