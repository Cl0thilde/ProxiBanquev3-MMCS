package org.formation.service;

import java.util.List;

import javax.ws.rs.*;

public interface IService<T> {

	@Path("/clients/")
	@POST
	public void create(T element);

	@Path("/clients/")
	@PUT
	public void update(T element);

	@Path("/clients/{id}/")
	@DELETE
	public void delete(@PathParam("id") String id);

	@Path("/clients/{id}/")
	@GET
	public T readById(@PathParam("id") String id);

	@Path("/clients/")
	@GET
	public List<T> readAll();
}
