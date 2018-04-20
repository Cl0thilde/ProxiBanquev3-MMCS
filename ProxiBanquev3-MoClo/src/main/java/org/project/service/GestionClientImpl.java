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

public class GestionClientImpl implements GestionClient {
	IDao<Client> daoClient = new DaoClient();
	IDao<CompteCourant> daoCompteCourant = new DaoCompteCourant();
	IDao<CompteEpargne> daoCompteEpargne = new DaoCompteEpargne();

	private static Logger LOGGER = LoggerFactory.getLogger(GestionClientImpl.class);

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
			daoClient.update(updatedClient);
			response = Response.ok("Client modifié").build();
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
			response = Response.ok("Client supprimé").build();
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
	public Response createCompteCourant(CompteCourant compteC, String idClient) {
		int id = Integer.parseInt(idClient);
		Client client = daoClient.readById(id);
		compteC.setClient(client);
		daoCompteCourant.create(compteC);
		LOGGER.debug(compteC.toString());
		LOGGER.debug(client.toString());
		return Response.ok(compteC).build();
	}

	@Override
	public Response updateCompteCourant(CompteCourant updatedCompteC, String idClient) {
		Response response = null;
		int id = Integer.parseInt(idClient);
		Client client = daoClient.readById(id);
		CompteCourant compteCourant = daoCompteCourant.readById(updatedCompteC.getNumCompte());
		if (compteCourant != null) {
			updatedCompteC.setClient(client);
			daoCompteCourant.update(updatedCompteC);
			response = Response.ok("Compte courant modifié").build();
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
			response = Response.ok("Compte courant supprimé").build();
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
	public Response createCompteEpargne(CompteEpargne compteE, String idClient) {
		int id = Integer.parseInt(idClient);
		Client client = daoClient.readById(id);
		compteE.setClient(client);
		daoCompteEpargne.create(compteE);
		return Response.ok(compteE).build();
	}

	@Override
	public Response updateCompteEpargne(CompteEpargne updatedCompteE, String idClient) {
		Response response = null;
		int id = Integer.parseInt(idClient);
		Client client = daoClient.readById(id);
		CompteEpargne compteEpargne = daoCompteEpargne.readById(updatedCompteE.getNumCompte());
		if (compteEpargne != null) {
			updatedCompteE.setClient(client);
			daoCompteEpargne.update(updatedCompteE);
			response = Response.ok("Compte épargne modifié").build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deleteCompteEpargne(String numCompte) {
		Response response = null;
		int id = Integer.parseInt(numCompte);
		CompteEpargne compteEpargne = daoCompteEpargne.readById(id);
		if (compteEpargne != null) {
			daoCompteEpargne.delete(compteEpargne);
			response = Response.ok("Compte épargne supprimé").build();
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

	@Override
	public List<Compte> readAllCompte(String idClient) {
		int id = Integer.parseInt(idClient);
		Client client = daoClient.readById(id);
		
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
