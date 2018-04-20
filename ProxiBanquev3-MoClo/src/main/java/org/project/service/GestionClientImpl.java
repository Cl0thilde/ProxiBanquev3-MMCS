package org.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.project.dao.DaoClient;
import org.project.dao.DaoCompteCourant;
import org.project.dao.DaoCompteEpargne;
import org.project.dao.IDao;
import org.project.domaine.Client;
import org.project.domaine.Compte;
import org.project.domaine.CompteCourant;
import org.project.domaine.CompteEpargne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Morane & Clothilde
 *
 */

/**
 * Implementation de l'interface de service ; Cette classe impl�mente les
 * diff�rentes m�thodes utilisables par un conseiller
 *
 */
public class GestionClientImpl implements GestionClient {
	IDao<Client> daoClient = new DaoClient();
	IDao<CompteCourant> daoCompteCourant = new DaoCompteCourant();
	IDao<CompteEpargne> daoCompteEpargne = new DaoCompteEpargne();

	private static Logger LOGGER = LoggerFactory.getLogger(GestionClientImpl.class);

	/**
	 * M�thode de cr�ation d'un client
	 *
	 */
	@Override
	public Response createClient(Client client) {
		daoClient.create(client);
		return Response.ok(client).build();
	}

	/**
	 * M�thode de modification d'un client existant; si le client n'existe pas la
	 * base de donn�es n'est pas modifi�e
	 */
	@Override
	public Response updateClient(Client updatedClient) {
		Response response = null;
		Client client = daoClient.readById(updatedClient.getIdClient());

		if (client != null) {
			daoClient.update(updatedClient);
			response = Response.ok("Client modifi�").build();
		} else {
			LOGGER.error("Le client n'existe pas!");
			response = Response.notModified().build();
		}
		return response;
	}

	/**
	 * M�thode de suppression d'un client existant ; Si le client n'existe pas, la base
	 * de donn�es n'est pas modifi�e
	 */
	@Override
	public Response deleteClient(String idClient) {
		Response response = null;
		int id = Integer.parseInt(idClient);
		Client client = daoClient.readById(id);

		if (client != null) {
			daoClient.delete(client);
			response = Response.ok("Client supprim�").build();
		} else {
			LOGGER.error("Le client n'existe pas!");
			response = Response.notModified().build();
		}
		return response;
	}

	/**
	 * M�thode de lecture des informations personnelles d'un client existant
	 * 
	 */
	@Override
	public Client readClientById(String idClient) {
		int id = Integer.parseInt(idClient);
		Client client = daoClient.readById(id);
		if (client == null) {
			LOGGER.error("Le client n'existe pas!");
		}
		return client;
	}

	/**
	 * M�thode de lecture des informations personnelles de tous les clients
	 * 
	 */
	@Override
	public List<Client> readAllClient() {
		return daoClient.readAll();
	}

	/**
	 * M�thode de cr�ation d'un compte courant pour un client donn�
	 * 
	 */
	@Override
	public Response createCompteCourant(CompteCourant compteC, String idClient) {
		int id = Integer.parseInt(idClient);
		Client client = daoClient.readById(id);
		compteC.setClient(client);
		daoCompteCourant.create(compteC);
		LOGGER.debug(compteC.toString());
		LOGGER.debug(client.toString());
		return Response.ok(compteC).build();
	}

	/**
	 * M�thode de modification des informations d'un compte courant pour un client
	 * donn� (solde + d�couvert autoris� + type de carte)
	 * 
	 */
	@Override
	public Response updateCompteCourant(CompteCourant updatedCompteC, String idClient) {
		Response response = null;
		int id = Integer.parseInt(idClient);
		Client client = daoClient.readById(id);
		CompteCourant compteCourant = daoCompteCourant.readById(updatedCompteC.getNumCompte());
		if (compteCourant != null) {
			updatedCompteC.setClient(client);
			daoCompteCourant.update(updatedCompteC);
			response = Response.ok("Compte courant modifi�").build();
		} else {
			LOGGER.error("Le compte n'existe pas!");
			response = Response.notModified().build();
		}
		return response;
	}

	/**
	 * M�thode de suppression d'un compte courant par son num�ro de compte
	 * 
	 */
	@Override
	public Response deleteCompteCourant(String numCompte) {
		Response response = null;
		int id = Integer.parseInt(numCompte);
		CompteCourant compteCourant = daoCompteCourant.readById(id);
		if (compteCourant != null) {
			daoCompteCourant.delete(compteCourant);
			response = Response.ok("Compte courant supprim�").build();
		} else {
			LOGGER.error("Le compte n'existe pas!");
			response = Response.notModified().build();
		}
		return response;
	}

	/**
	 * M�thode de lecture des informations d'un compte courant par son num�ro de
	 * compte
	 * 
	 */
	@Override
	public CompteCourant readCompteCourantByNum(String numCompte) {
		int id = Integer.parseInt(numCompte);
		CompteCourant compteCourant = daoCompteCourant.readById(id);
		if (compteCourant == null) {
			LOGGER.error("Le client n'existe pas!");
		}
		return compteCourant;
	}

	/**
	 * M�thode de lecture de tous les comptes courants
	 * 
	 */
	@Override
	public List<CompteCourant> readAllCompteCourant() {
		return daoCompteCourant.readAll();
	}

	/**
	 * M�thode de cr�ation d'un compte �pargne pour un client donn�
	 * 
	 */
	@Override
	public Response createCompteEpargne(CompteEpargne compteE, String idClient) {
		int id = Integer.parseInt(idClient);
		Client client = daoClient.readById(id);
		compteE.setClient(client);
		LOGGER.debug(compteE.toString());
		LOGGER.debug(client.toString());
		daoCompteEpargne.create(compteE);
		return Response.ok(compteE).build();
	}

	/**
	 * M�thode de modification des informations d'un compte �pargne pour un client
	 * donn� (solde + taux de r�mun�ration)
	 * 
	 */
	@Override
	public Response updateCompteEpargne(CompteEpargne updatedCompteE, String idClient) {
		Response response = null;
		int id = Integer.parseInt(idClient);
		Client client = daoClient.readById(id);
		CompteEpargne compteEpargne = daoCompteEpargne.readById(updatedCompteE.getNumCompte());
		if (compteEpargne != null) {
			updatedCompteE.setClient(client);
			daoCompteEpargne.update(updatedCompteE);
			response = Response.ok("Compte �pargne modifi�").build();
		} else {
			LOGGER.error("Le compte n'existe pas!");
			response = Response.notModified().build();
		}
		return response;
	}

	/**
	 * M�thode de suppression d'un compte �pargne par son num�ro de compte
	 * 
	 */
	@Override
	public Response deleteCompteEpargne(String numCompte) {
		Response response = null;
		int id = Integer.parseInt(numCompte);
		CompteEpargne compteEpargne = daoCompteEpargne.readById(id);
		if (compteEpargne != null) {
			daoCompteEpargne.delete(compteEpargne);
			response = Response.ok("Compte �pargne supprim�").build();
		} else {
			LOGGER.error("Le compte n'existe pas!");
			response = Response.notModified().build();
		}
		return response;
	}

	/**
	 * M�thode de lecture des informations d'un compte �pargne par son num�ro de
	 * compte
	 * 
	 */
	@Override
	public CompteEpargne readCompteEpargneByNum(String numCompte) {
		int id = Integer.parseInt(numCompte);
		CompteEpargne compteEpargne = daoCompteEpargne.readById(id);
		if (compteEpargne == null) {
			LOGGER.error("Le client n'existe pas!");
		}
		return compteEpargne;
	}

	/**
	 * M�thode de lecture de tous les comptes �pargnes
	 * 
	 */
	@Override
	public List<CompteEpargne> readAllCompteEpargne() {
		return daoCompteEpargne.readAll();
	}

	/**
	 * M�thode de lecture de tous les comptes
	 * 
	 */
	@Override
	public List<Compte> readAllCompte() {
		List<Compte> comptes = new ArrayList<>();
		List<CompteCourant> comptesCourant = daoCompteCourant.readAll();
		List<CompteEpargne> comptesEpargne = daoCompteEpargne.readAll();
		comptes.addAll(comptesCourant);
		comptes.addAll(comptesEpargne);

		return comptes;
	}

	public IDao<Client> getDaoClient() {
		return daoClient;
	}

	public void setDaoClient(IDao<Client> daoClient) {
		this.daoClient = daoClient;
	}

	public IDao<CompteCourant> getDaoCompteCourant() {
		return daoCompteCourant;
	}

	public void setDaoCompteCourant(IDao<CompteCourant> daoCompteCourant) {
		this.daoCompteCourant = daoCompteCourant;
	}

	public IDao<CompteEpargne> getDaoCompteEpargne() {
		return daoCompteEpargne;
	}

	public void setDaoCompteEpargne(IDao<CompteEpargne> daoCompteEpargne) {
		this.daoCompteEpargne = daoCompteEpargne;
	}

}
