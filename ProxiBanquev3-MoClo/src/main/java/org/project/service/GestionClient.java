package org.project.service;

import java.util.List;

import org.project.domaine.Client;
import org.project.domaine.CompteCourant;
import org.project.domaine.CompteEpargne;

public interface GestionClient {

	// Méthodes de gestion des clients
	public void createClient(Client client);

	public void updateClient(Client client);

	public void deleteClient(String idClient);

	public Client readClientByNum(String idClient);

	public List<Client> readAllClient();

	// Méthodes de gestion des comptes courants
	public void createCompteCourant(CompteCourant compteC);

	public void updateCompteCourant(CompteCourant compteC);

	public void deleteCompteCourant(String numCompte);

	public CompteCourant readCompteCourantByNum(String numCompte);

	public List<CompteCourant> readAllCompteCourant();

	// Méthodes de gestion des comptes epargnes
	public void createCompteEpargne(CompteEpargne compteE);

	public void updateCompteEpargne(CompteEpargne compteE);

	public void deleteCompteEpargne(String numCompte);

	public CompteEpargne readCompteEpargneById(String numCompte);

	public List<CompteEpargne> readAllCompteEpargne();

}
