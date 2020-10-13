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
import org.json.simple.JSONArray;

import java.util.List;
import nl.sogyo.pandemic.domain.Game;
import nl.sogyo.pandemic.domain.MainChar;
import nl.sogyo.pandemic.domain.TextArray;


/**
 * @author piekeheijmans
 *
 */

@Path("/getPaper")
public class PandemicGame {

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
		Game pandemic = (Game) session.getAttribute("pandemic");
		TextArray textArray = pandemic.startCycle();
		System.out.println("Fetch call received");
	
	 	JSONObject json;

 		json = new JSONObject();

  		json.put("name", pandemic.getMainChar().getName());
  		json.put("age", pandemic.getMainChar().getAgegroup());
  		json.put("id", textArray.getId());
  		json.put("day", textArray.getDay());
  		json.put("paperTitle", textArray.getPaperTitle());
  		json.put("paperContent", textArray.getPaperContent());
  		json.put("buttonsPaper", textArray.getButtonsPaper());
  		json.put("goToWork", textArray.getGoToWork());
  		json.put("buttonsWork1", textArray.getButtonsWork1());
  		json.put("buttonsWork2", textArray.getButtonsWork2());
  		json.put("ifOv", textArray.getIfOv());
  		json.put("ifBike", textArray.getIfBike());
  		json.put("afterWork", textArray.getAfterWork());
  		json.put("buttonAw1", textArray.getButtonAw1());
  		json.put("buttonAw2", textArray.getButtonAw2());
		
		String output = json.toString();
		
		return Response.status(200).entity(output).build();
	}
	
}
