/**
 * 
 */
package nl.sogyo.pandemic.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.util.List;
import nl.sogyo.pandemic.domain.Game;
import nl.sogyo.pandemic.domain.MainChar;
import nl.sogyo.pandemic.domain.TextArray;


/**
 * @author piekeheijmans
 *
 */

@Path("/saveAnswer")
public class PandemicAnswers {

	/**
	 * @param request
	 * @return
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{event}/{choice}")
	public Response saveAnswer(
			@PathParam("event") String event, 
			@PathParam("choice") String choice, 
			@Context HttpServletRequest request) {
		
		HttpSession session= request.getSession(true);
		Game pandemic = (Game) session.getAttribute("pandemic");
		pandemic.evaluateAnswer(event, Integer.parseInt(choice));
		System.out.println("Fetch call received");

		JSONObject json;

 		json = new JSONObject();

		json.put("money", pandemic.getMainChar().getMoney());
  		json.put("social", pandemic.getMainChar().getSocialNeed());
  		json.put("virusc", pandemic.getMainChar().getVirusChance());
  		json.put("toilet", pandemic.getMainChar().getAmountToiletPaper());

		String output = json.toString();
		
		return Response.status(200).entity(output).build();
	}
	
}
