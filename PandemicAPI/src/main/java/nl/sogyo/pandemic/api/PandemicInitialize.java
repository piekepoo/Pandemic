/**
 * 
 */
package nl.sogyo.pandemic.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;

import nl.sogyo.pandemic.domain.Greeter;


/**
 * @author piekeheijmans
 *
 */

@Path("/getPaper")
public class PandemicInitialize {

	/**
	 * @param request
	 * @return
	 */
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response initialize(
			@Context HttpServletRequest request) {
		
		HttpSession session= request.getSession(true);
		System.out.println("Fetch call received");
		// Cycle cycleTest = new Cycle();
		// cycleTest.setPaper();
		// String paperArticle = cycleTest.getPaper(); //cycleTest.getPaper();

		Greeter greeter = new Greeter();	
		String greetingMessage = greeter.sayHello();
		String output = greetingMessage.toString();
		
		return Response.status(200).entity(output).build();
	}
	
}
