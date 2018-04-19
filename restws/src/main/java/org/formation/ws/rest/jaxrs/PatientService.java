package org.formation.ws.rest.jaxrs;

import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Produces({ "application/xml", "application/json" })
public interface PatientService {

	@Path("/patients/{id}/")
	@GET
	Patient getPatient(@PathParam("id") String id);

	@Path("/patients/")
	@PUT
	Response updatePatient(Patient patient);

	@Path("/patients/")
	@POST
	Response addPatient(Patient patient);

	@Path("/patients/{id}/")
	@DELETE
	Response deletePatients(@PathParam("id") String id);

	@Path("/patients/prescriptions/{id}/")
	@GET
	Prescription getPrescription(@PathParam("prescriptionId") String prescriptionId);

	@Path("/patients/")
	@GET
	Collection<Patient> getAllPatient();
}