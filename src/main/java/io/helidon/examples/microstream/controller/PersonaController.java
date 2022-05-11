/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.helidon.examples.microstream.controller;

import io.helidon.examples.microstream.model.Persona;
import io.helidon.examples.microstream.repository.PersonaRepository;
import java.util.Collection;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 *
 * @author avbravo
 */
@RequestScoped
@Path("personas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonaController {
    @Inject
	private PersonaRepository repository;
	
	// TODO don't worried about pagination
	@GET
	@Operation(summary = "Get all personas", description = "Returns all available items at the restaurant")
	@APIResponse(responseCode = "500", description = "Server unavailable")
	@APIResponse(responseCode = "200", description = "The personas")
	@Tag(name = "BETA", description = "This API is currently in beta state")
	@APIResponse(description = "The personas", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "the personas", required = true, name = "personas")))
	public Collection<Persona> getAll()
	{
		return this.repository.getAll();
	}
	
	@GET
	@Path("{id}")
	@Operation(summary = "Find a persona by id", description = "Find a persona by id")
	@APIResponse(responseCode = "200", description = "The persona")
	@APIResponse(responseCode = "404", description = "When the id does not exist")
	@APIResponse(responseCode = "500", description = "Server unavailable")
	@Tag(name = "BETA", description = "This API is currently in beta state")
	@APIResponse(description = "The persona", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Persona.class)))
	public Persona findById(
		@Parameter(description = "The item ID", required = true, example = "1", schema = @Schema(type = SchemaType.INTEGER)) @PathParam("id") final long id)
	{
		return this.repository.findById(id).orElseThrow(
			() -> new WebApplicationException("There is no persona with the id " + id, Response.Status.NOT_FOUND));
	}
	
	@POST
	@Operation(summary = "Insert a persona", description = "Insert a persona")
	@APIResponse(responseCode = "201", description = "When creates an persona")
	@APIResponse(responseCode = "500", description = "Server unavailable")
	@Tag(name = "BETA", description = "This API is currently in beta state")
	public Response insert(
		@RequestBody(description = "Create a new persona.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Persona.class))) final Persona persona)
	{
		return Response.status(Response.Status.CREATED).entity(this.repository.save(persona)).build();
	}
	@PUT
	@Operation(summary = "Update a persona", description = "Update a persona")
	@APIResponse(responseCode = "201", description = "When update an persona")
	@APIResponse(responseCode = "500", description = "Server unavailable")
	@Tag(name = "BETA", description = "This API is currently in beta state")
	public Response update(
		@RequestBody(description = "Update a  persona.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Persona.class))) final Persona persona)
	{
		return Response.status(Response.Status.CREATED).entity(this.repository.update(persona)).build();
	}
	
	@DELETE
	@Path("{id}")
	@Operation(summary = "Delete a persona by ID", description = "Delete a persona by ID")
	@APIResponse(responseCode = "200", description = "When deletes the persona")
	@APIResponse(responseCode = "500", description = "Server unavailable")
	@Tag(name = "BETA", description = "This API is currently in beta state")
	public Response delete(
		@Parameter(description = "The item ID", required = true, example = "1", schema = @Schema(type = SchemaType.INTEGER)) @PathParam("id") final long id)
	{
		this.repository.deleteById(id);
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
}
