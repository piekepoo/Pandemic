// /**
//  * 
//  */
// package nl.sogyo.pandemic.api;

// import org.json.simple.JSONArray;
// import org.json.simple.JSONObject;

// import nl.sogyo.mancala.domain.Game;

// /**
//  * @author 
//  *
//  */
// public class JSONResultProcessor {

// 	/**
// 	 * @param pandemic
// 	 * @return
// 	 */
// 	public String createJSONResponse(Game pandemic) {
		
// 		JSONObject result = new JSONObject();
		
// 		JSONObject playerName = this.createJSONPlayer(1, mancala, 1);
// 		JSONObject playerAge = this.createJSONPlayer(8, mancala, 2);
        
// 		JSONArray players = new JSONArray();
//         player.add(playerName);
//         player.add(playerAge);
        
//         result.put("player", player);
        
// 		return result.toJSONString();
// 	}
	
// 	/**
// 	 * @param startIndex
// 	 * @param player
// 	 * @param domainPlayer
// 	 * @param mancala
// 	 * @return
// 	 */
// 	private JSONObject createJSONPlayer(int startIndex, Mancala mancala, int playerIndex) {
		
// 		JSONObject jsonPlayer = new JSONObject();
		
// 		if (startIndex < 8) {
// 			jsonPlayer.put("type", "player1");
// 		} else {
// 			jsonPlayer.put("type", "player2");
// 		}
		
// 		jsonPlayer.put("name", mancala.getPlayerName(playerIndex));
		
// 		if (mancala.isToMovePlayer(playerIndex)) {
// 			jsonPlayer.put("hasTurn", true);
// 		} else {
// 			jsonPlayer.put("hasTurn", false);
// 		}
		
// 		JSONArray pits = new JSONArray();
// 		for (int i = startIndex; i <= startIndex + 6; i++) {
// 			pits.add(this.createJSONPit(i, mancala));
// 		}
// 		jsonPlayer.put("pits", pits);
		
// 		return jsonPlayer;
// 	}
	
 
// }
