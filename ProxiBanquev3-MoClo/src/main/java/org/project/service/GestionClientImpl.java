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
		Client client = daoClient.readById(updatedClient.getIdClient());
		Response response = null;
		if(client!=null) {
			response = Response.ok().build();
}else {
	response = Response.notModified().build();
}
		return null;
	}

	@Override
	public Response deleteClient(String idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client readClientById(String idClient) {
		int id = Integer.parseInt(idClient);
		return daoClient.readById(id);
	}

	@Override
	public List<Client> readAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response createCompteCourant(CompteCourant compteC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateCompteCourant(CompteCourant compteC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteCompteCourant(String numCompte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompteCourant readCompteCourantByNum(String numCompte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompteCourant> readAllCompteCourant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response createCompteEpargne(CompteEpargne compteE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateCompteEpargne(CompteEpargne compteE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteCompteEpargne(String numCompte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompteEpargne readCompteEpargneByNum(String numCompte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompteEpargne> readAllCompteEpargne() {
		// TODO Auto-generated method stub
		return null;
	}

}
