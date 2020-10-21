/**
 * 
 */
package nl.sogyo.pandemic.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.sogyo.pandemic.domain.Game;
import nl.sogyo.pandemic.domain.MainChar;
import nl.sogyo.pandemic.domain.TextArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


/**
 * @author rvvugt
 *
 */
@Path("setPlayer")
public class PandemicInitialize {

	/**
	 * @param request
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response initialize(
			@Context HttpServletRequest request, 
			PlayerData player) {
		
		HttpSession session= request.getSession(true);
		Game pandemic = new Game();
		
		String namePlayer = player.name;
		int agePlayer =  player.age;
		
		pandemic.setPlayerInfo(namePlayer, agePlayer);
		
		session.setAttribute("pandemic", pandemic);	

		TextArray textArray = pandemic.startCycle();
 		
 		JSONObject json;

 		json = new JSONObject();

  		json.put("name", namePlayer);
  		json.put("age", agePlayer);
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
  		json.put("ifButton", textArray.getIfButton());
  		json.put("afterWork", textArray.getAfterWork());
  		json.put("buttonAw1", textArray.getButtonAw1());
  		json.put("buttonAw2", textArray.getButtonAw2());
  	
 		json.put("money", pandemic.getMainChar().getMoney());
  		json.put("social", pandemic.getMainChar().getSocialNeed());
  		json.put("virusc", pandemic.getMainChar().getVirusChance());
  		json.put("cycle", pandemic.getCycle());
		
		String output = json.toString();
		
		return Response.status(200).entity(output).build();
	}
	
}
