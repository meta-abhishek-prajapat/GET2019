package com.metacube.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.metacube.enums.Status;
import com.metacube.facade.InventoryFacade;
import com.metacube.services.Inventory;
import com.metacube.utils.Response;

@Path("/inventory")
public class InventoryController {
	
	InventoryFacade inventory = new InventoryFacade();
	
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllInventory() throws Exception{
		Gson gson = new Gson();
		return gson.toJson(inventory.getAllInventory());
	}
	
	@Path("/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getInventory(@javax.ws.rs.PathParam("name") String name) throws Exception{
		Gson gson = new Gson();
		return gson.toJson(inventory.getInventoryByName(name));
	}
	
	@Path("/")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAll(String json) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		List<Inventory> inventory_list = Arrays.asList(mapper.readValue(json, Inventory[].class));
		Response response = new Response();
		
		for(Inventory obj : inventory_list){
			if(inventory.updateInventory(obj.getName(), obj.getQuantity()) != Status.UPDATED){
				response.setCode(405);
				response.setMessage("Not Updated");
				response.setStatus(false);
				return response;
			}
		}
		response.setCode(200);
		response.setMessage("UPDATED");
		response.setStatus(true);
		return response;
	}
	
	@Path("/{itemname}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response replace(@PathParam("itemname") String itemname,String json) throws Exception{
		Gson gson = new Gson();
		Inventory inventory_obj = gson.fromJson(json, Inventory.class);
		Response response = new Response();
		if(inventory.replaceInventory(itemname, inventory_obj) == Status.UPDATED){
			response.setCode(200);
			response.setMessage("UPDATED");
			response.setStatus(true);
			return response;
		}
		response.setCode(405);
		response.setMessage("NOT FOUND");
		response.setStatus(false);
		return response;
	}
	
	@Path("/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(String json)throws Exception{
		Gson gson = new Gson();
		Inventory inventory_obj = gson.fromJson(json, Inventory.class);
		Response response = new Response();
		if(inventory.insertInventory(inventory_obj.getName(), inventory_obj.getQuantity()) == Status.INSERTED){
			response.setCode(200);
			response.setMessage("Inserted");
			response.setStatus(true);
			return response;
		}
		response.setCode(405);
		response.setMessage("NOT FOUND");
		response.setStatus(false);
		return response;
	}
	
	@Path("/")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteallInventory() throws Exception{
		Response response = new Response();
		if(inventory.deleteall()==Status.DELETED){
			response.setCode(200);
			response.setMessage("DELETED");
			response.setStatus(true);
			return response;
		}
		response.setCode(405);
		response.setMessage("NOT FOUND");
		response.setStatus(false);
		return response;
	}
	
	@Path("/{name}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteInventory(@javax.ws.rs.PathParam("name") String name) throws Exception{
		Response response = new Response();
		if(inventory.deleteInventory(name)==Status.DELETED){
			response.setCode(200);
			response.setMessage("DELETED");
			response.setStatus(true);
			return response;
		}
		response.setCode(405);
		response.setMessage("NOT FOUND");
		response.setStatus(false);
		return response;
	}
}
