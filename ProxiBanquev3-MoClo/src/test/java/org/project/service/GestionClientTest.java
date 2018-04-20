package org.project.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.project.dao.IDao;
import org.project.domaine.Client;

public class GestionClientTest {

	@Mock
	IDao<Client> dao;
	private GestionClientImpl Gcl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		Gcl = new GestionClientImpl();
		Gcl.setDaoClient(dao);
	}

	@Test
	public void createClient_Should_Create_A_Client() {
		Client client = new Client();
		client.setIdClient(1);
		when(dao.create(client)).thenReturn(client.getIdClient());
		assertTrue(Gcl.createClient(client).getStatus() == 200);
		verify(dao).create(client);

	}

	@Test
	public void readClient_Should_Read_A_Client() {
		Client client = new Client();
		when(dao.readById(anyInt())).thenReturn(client);
		assertEquals(Gcl.readClientById("111"), client);
		verify(dao).readById(111);
	}

}
