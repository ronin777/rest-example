package mx.com.ronin.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.fluttercode.datafactory.impl.DataFactory;

import mx.com.ronin.dto.Persona;

import com.google.gson.Gson;

@Path("/")
public class ServicesWorld {

	@GET
	@Path("/")
	public Response getMsg() {
		Gson gson= new Gson();	
		return Response.status(200).entity(gson.toJson(generarLista())).build();

	}
	
	public List<Persona> generarLista(){
		List<Persona> lista = new ArrayList<Persona>();

		DataFactory df = new DataFactory();
	    for (int i = 1; i <= 100; i++) {     
	    	Persona p;
	        p = new Persona(
	        		i,
	        		df.getFirstName(),
	        		df.getLastName(),
	        		df.getName(),
	        		df.getAddress(), 
	        		df.getBirthDate(),
	        		df.getEmailAddress(), 
	        		df.getNumberText(5)
	        		);
	        lista.add(p);
	    }
	    return lista;
	}
}
