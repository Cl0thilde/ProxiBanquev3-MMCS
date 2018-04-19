package org.project.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.project.domaine.Client;
import org.project.domaine.Compte;
import org.project.domaine.CompteCourant;
import org.project.domaine.CompteEpargne;

@Produces({ "application/xml", "application/json" })
public interface GestionClient {

	// Méthodes de gestion des clients
	@Path("/clients/")
	@POST
	public Response createClient(Client client);

	@Path("/clients/")
	@PUT
	public Response updateClient(Client client);

	@Path("/clients/{idclient}")
	@DELETE
	public Response deleteClient(@PathParam("idclient") String idClient);

	@Path("/clients/{idclient}")
	@GET
	public Client readClientById(@PathParam("idclient")String idClient);

	@Path("/clients/")
	@GET
	public List<Client> readAllClient();

	// Méthodes de gestion des comptes courants
	@Path("/clients/{idclient}/comptes/comptes_courants/")
	@POST
	public Response createCompteCourant(CompteCourant compteC,@PathParam("idclient") String idClient);

	@Path("/clients/{idclient}/comptes/comptes_courants/")
	@PUT
	public Response updateCompteCourant(CompteCourant compteC);

	@Path("/clients/{idclient}/comptes/comptes_courants/{numcompte}/")
	@DELETE
	public Response deleteCompteCourant(@PathParam("numcompte") String numCompte);

	@Path("/clients/{idclient}/comptes/comptes_courants/{numcompte}/")
	@GET
	public CompteCourant readCompteCourantByNum(@PathParam("numcompte") String numCompte);

	@Path("/clients/{idclient}/comptes/comptes_courants/")
	@GET
	public List<CompteCourant> readAllCompteCourant();

	// Méthodes de gestion des comptes epargnes
	@Path("/clients/{idclient}/comptes/comptes_epargnes/")
	@POST
	public Response createCompteEpargne(CompteEpargne compteE,@PathParam("idclient") String idClient);

	@Path("/clients/{idclient}/comptes/comptes_epargnes/")
	@PUT
	public Response updateCompteEpargne(CompteEpargne compteE);

	@Path("/clients/{idclient}/comptes/comptes_epargnes/{numcompte}/")
	@DELETE
	public Response deleteCompteEpargne(String numCompte);

	@Path("/clients/{idclient}/comptes/comptes_epargnes/{numcompte}/")
	@GET
	public CompteEpargne readCompteEpargneByNum(String numCompte);

	@Path("/clients/{idclient}/comptes/comptes_epargnes/")
	@GET
	public List<CompteEpargne> readAllCompteEpargne();

	// Méthode de lecture de tous les comptes confondus d'un client
	@Path("/clients/{idclient}/comptes/")
	@GET
	public List<Compte> readAllCompte();

}
