package org.soen387.test;

import java.util.HashMap;
import java.util.Map;

import org.dsrg.soenea.service.threadLocal.ThreadLocalTracker;

public class FieldMap extends ThreadLocal<Map<String, String>> {
	public static FieldMap current = new FieldMap();
	
	@Override
	protected Map<String, String> initialValue() {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		// base 
		map.put("XML_PARAM", "mode");
		map.put("XML_VALUE", "xml");
		map.put("BASE_URL",  "http://localhost:8080/CheckersGame");
		
		// login
		map.put("LOGIN_PATH", "/LogIn");
		map.put("USERNAME_PARAM", "username");
		map.put("PASSWORD_PARAM", "password");

		// logout
		map.put("LOGOUT_PATH", "/LogOut");
		
		// register
		map.put("REGISTER_PATH", "/Register");
		map.put("FIRSTNAME_PARAM", "firstname");
		map.put("LASTNAME_PARAM", "lastname");
		map.put("EMAIL_PARAM", "email");
		
		// list players
		map.put("LIST_PLAYERS_PATH", "/ListPlayers");
		
		// view player stats
		map.put("VIEW_PLAYER_STATS_PATH", "/ViewPlayerStats");
		map.put("PLAYER_PARAM", "id");
		
		//UC 6		
		map.put("CHALLENGE_PLAYER_PATH", "/ChallengePlayer");
		map.put("TARGET_PLAYER_PARAM", "id");		
		
		/*
		 * By default I accept a status and either 1 or 2, the ordinal values of the ChallengeStatus.
		 * The testsuite responds either true or false for accepting, passing the acceptValue if
		 * it is true and the refuseValue if it was false. This should provide enough flexibility.
		 */
		
		//UC 7
		map.put("RESPOND_TO_CHALLNGE_PATH", "/RespondToUserChallenge");
		map.put("CHALLENGE_PARAM", "challenge");
		map.put("CHALLENGE_VERSION_PARAM", "version");
		map.put("CHALLENGE_RESPONSE_PARAM", "status");
		map.put("CHALLENGE_ACCEPT_VALUE", "1");
		map.put("CHALLENGE_REFUSE_VALUE", "2");
		
		//UC 8
		map.put("LIST_GAMES_PATH", "/ListGames");
		
		//UC 9
		map.put("VIEW_GAME_PATH", "/ViewGame");
		map.put("GAME_PARAM", "id");
		
		//UC 10
		map.put("LIST_CHALLENGES_PATH", "/ListChallenges");
		
		return map;
	}
	
	static {
		ThreadLocalTracker.registerThreadLocal(current);
	}
}
