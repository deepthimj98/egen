package io.mmrestaurant.controller;

import java.util.List;

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
import javax.ws.rs.core.Response.Status;


import io.mmrestaurant.dao.GuestReservationDAO;
import io.mmrestaurant.exception.AppException;

import io.mmrestaurant.model.Guest_reservation;




@Path("/guestreservation")
public class GuestReservationController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Guest_reservation> viewAllReservation() {
		List<Guest_reservation> guest = null;
		try {
			System.out.println("enters controller class");
			GuestReservationDAO dao = new GuestReservationDAO();
			guest = dao.viewAllReservation();
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return guest;
	}
	@GET
	@Path("/{ccode}")
	@Produces(MediaType.APPLICATION_JSON)
	public Guest_reservation viewReservationByCcode(@PathParam ("ccode") String ccode) {
		Guest_reservation guest2 = null;
		try {
			GuestReservationDAO dao = new GuestReservationDAO();
			guest2 = dao.viewReservationByCcode(ccode);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return guest2;
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Guest_reservation createNewReservation (Guest_reservation guest3) {
		
		try {
			GuestReservationDAO dao = new GuestReservationDAO();
			guest3 = dao.createNewReservation(guest3);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return guest3;
	}
	@PUT
	@Path("/{ccode}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Guest_reservation updateReservation (@PathParam("ccode") String ccode, Guest_reservation guest4) {
		
		try {
			GuestReservationDAO dao = new GuestReservationDAO();
			guest4 = dao.updateReservation(ccode, guest4);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return guest4;
	}
	
	@DELETE
	@Path("/{ccode}")
	public Response deleteByCode (@PathParam("ccode") String ccode){

		try {
			GuestReservationDAO dao = new GuestReservationDAO();
			dao.deleteByCode(ccode);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		
		return Response.ok().build();
	}
}