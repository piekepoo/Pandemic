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
import nl.sogyo.pandemic.domain.Ranklist;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


/**
 * @author rvvugt
 *
 */
@Path("setScore")
public class PandemicSetScore {

	/**
	 * @param request
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response initialize(
			@Context HttpServletRequest request, 
			PlayerScore player) {
		
		HttpSession session= request.getSession(true);
		Game pandemic = (Game) session.getAttribute("pandemic");
		
		String namePlayer = player.name;
		int scorePlayer =  player.score;
		
		Ranklist ranklist = pandemic.enterScore(namePlayer, scorePlayer);
 		
 		JSONObject json;

 		json = new JSONObject();

  		json.put("name1", pandemic.getRanks().getName1());
  		json.put("score1", pandemic.getRanks().getScore1());
  		json.put("name2", pandemic.getRanks().getName2());
  		json.put("score2", pandemic.getRanks().getScore2());
  		json.put("name3", pandemic.getRanks().getName3());
  		json.put("score3", pandemic.getRanks().getScore3());
  		json.put("name4", pandemic.getRanks().getName4());
  		json.put("score4", pandemic.getRanks().getScore4());
  		json.put("name5", pandemic.getRanks().getName5());
  		json.put("score5", pandemic.getRanks().getScore5());
  		json.put("name6", pandemic.getRanks().getName6());
  		json.put("score6", pandemic.getRanks().getScore6());
  		json.put("name7", pandemic.getRanks().getName7());
  		json.put("score7", pandemic.getRanks().getScore7());
  		json.put("name8", pandemic.getRanks().getName8());
  		json.put("score8", pandemic.getRanks().getScore8());
  		json.put("name9", pandemic.getRanks().getName9());
  		json.put("score9", pandemic.getRanks().getScore9());
  		json.put("name10", pandemic.getRanks().getName10());
  		json.put("score10", pandemic.getRanks().getScore10());
		
		String output = json.toString();
		
		return Response.status(200).entity(output).build();
	}
	
}
