package org.formation.ws.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.formation.ws.rest.jaxrs.Patient;

public class SimpleRestClient {

	private static final String ID = "id";
	private static final String ID_PLACEHOLDER = "/{id}";
	private static final String PATIENTS = "/patients";
	private static final String SERVICE_PATIENTS = "http://localhost:8080/restws/services/patientservice";

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		WebTarget getTarget = client.target(SERVICE_PATIENTS).path(PATIENTS).path(ID_PLACEHOLDER).resolveTemplate(ID,
				"123");

		Response getResponse = getTarget.request().get();
		Patient p = getResponse.readEntity(Patient.class);
		System.out.println(p.getName() + " status " + getResponse.getStatus());

		WebTarget putTarget = client.target(SERVICE_PATIENTS).path(PATIENTS);
		Patient patient = new Patient();
		patient.setName("Bobby");
		patient.setId(123);
		Response putResponse = putTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));

		System.out.println("put = " + putResponse.getStatus());

		Patient bob = new Patient();
		bob.setName("BOOOOOBBY");
		WebTarget postTarget = client.target(SERVICE_PATIENTS).path(PATIENTS);
		Patient newBob = postTarget.request().post(Entity.entity(bob, MediaType.APPLICATION_XML), Patient.class);

		System.out.println("create" + newBob.getId());

		client.close();
		getResponse.close();
		putResponse.close();
	}

}
