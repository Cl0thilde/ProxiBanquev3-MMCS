package org.formation.service;

import java.util.List;

import org.formation.dao.DaoClient;
import org.formation.dao.IDao;
import org.projet.domaine.Client;

public class ServiceClient implements IService<Client> {

	IDao<Client> dao = new DaoClient();

	@Override
	public void create(Client element) {
		dao.create(element);
	}

	@Override
	public void update(Client element) {
		dao.update(element);
	}

	@Override
	public void delete(String id) {
		int idClient = Integer.parseInt(id);
		Client client = dao.readById(idClient);
		dao.delete(client);
	}

	@Override
	public Client readById(String id) {
		int idClient = Integer.parseInt(id);
		return dao.readById(idClient);
	}

	@Override
	public List<Client> readAll() {
		return dao.readAll();
	}

}
