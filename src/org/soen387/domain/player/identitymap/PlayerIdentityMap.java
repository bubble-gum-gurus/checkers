package org.soen387.domain.player.identitymap;

import java.util.Hashtable;
import org.soen387.domain.model.player.IPlayer;

public class PlayerIdentityMap {
	
	private static Hashtable players = new Hashtable<Long, IPlayer>();
	
	public static boolean has(long id) {
		return players.contains(id);
	}
	
	public static IPlayer get(long id) {
		return (IPlayer) players.get(id);
	}
	
	public static void add(long id, IPlayer player) {
		players.put(id, player);
	}
}
