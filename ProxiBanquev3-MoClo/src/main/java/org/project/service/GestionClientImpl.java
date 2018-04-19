package org.project.service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.project.dao.DaoClient;
import org.project.dao.DaoCompteCourant;
import org.project.dao.DaoCompteEpargne;
import org.project.dao.IDao;
import org.project.domaine.Client;
import org.project.domaine.CompteCourant;
import org.project.domaine.CompteEpargne;

public class GestionClientImpl implements GestionClient {
	IDao<Client> daoClient = new DaoClient();
	IDao<CompteCourant> daoCompteCourant = new DaoCompteCourant();
	IDao<CompteEpargne> daoCompteEpargne = new DaoCompteEpargne();

	@Override
	public Response createClient(Client client) {
		daoClient.create(client);
		return Response.ok(client).build();
	}

	@Override
	public Response updateClient(Client updatedClient) {
		Response response = null;
		Client client = daoClient.readById(updatedClient.getIdClient());
		if (client != null) {
			daoClient.update(client);
			response = Response.ok("Client modifi�").build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deleteClient(String idClient) {
		Response response = null;
		int id = Integer.parseInt(idClient);
		Client client = daoClient.readById(id);
		if (client != null) {
			daoClient.delete(client);
			response = Response.ok("Client supprim�").build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Client readClientById(String idClient) {
		int id = Integer.parseInt(idClient);
		return daoClient.readById(id);
	}

	@Override
	public List<Client> readAllClient() {
		return daoClient.readAll();
	}

	@Override
	public Response createCompteCourant(CompteCourant compteC) {
		daoCompteCourant.create(compteC);
		return Response.ok(compteC).build();
	}

	@Override
	public Response updateCompteCourant(CompteCourant updatedCompteC) {
		Response response = null;
		CompteCourant compteCourant = daoCompteCourant.readById(updatedCompteC.getNumCompte());
		if (compteCourant != null) {
			daoCompteCourant.update(compteCourant);
			response = Response.ok("Compte courant modifi�").build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deleteCompteCourant(String numCompte) {
		Response response = null;
		int id = Integer.parseInt(numCompte);
		CompteCourant compteCourant = daoCompteCourant.readById(id);
		if (compteCourant != null) {
			daoCompteCourant.delete(compteCourant);
			response = Response.ok("Compte courant supprim�").build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public CompteCourant readCompteCourantByNum(String numCompte) {
		int id = Integer.parseInt(numCompte);
		return daoCompteCourant.readById(id);
	}

	@Override
	public List<CompteCourant> readAllCompteCourant() {
		return daoCompteCourant.readAll();
	}

	@Override
	public Response createCompteEpargne(CompteEpargne compteE) {
		daoCompteEpargne.create(compteE);
		return Response.ok(compteE).build();
	}

	@Override
	public Response updateCompteEpargne(CompteEpargne updatedCompteE) {
		Response response = null;
		CompteEpargne compteEpargne = daoCompteEpargne.readById(updatedCompteE.getNumCompte());
		if (compteEpargne != null) {
			daoCompteEpargne.update(compteEpargne);
			response = Response.ok("Compte �pargne modifi�").build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deleteCompteEpargne(String numCompte) {
		Response response = null;
		int id = Integer.parseInt(numCompte);
		CompteEpargne compteCourant = daoCompteEpargne.readById(id);
		if (compteCourant != null) {
			daoCompteEpargne.delete(compteCourant);
			response = Response.ok("Compte �pargne supprim�").build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public CompteEpargne readCompteEpargneByNum(String numCompte) {
		int id = Integer.parseInt(numCompte);
		return daoCompteEpargne.readById(id);
	}

	@Override
	public List<CompteEpargne> readAllCompteEpargne() {
		return daoCompteEpargne.readAll();
	}

}