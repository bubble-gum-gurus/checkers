package org.soen387.domain.user.identitymap;

import java.util.Hashtable;
import org.soen387.domain.model.user.IUser;

public class UserIdentityMap {
	private static Hashtable users = new Hashtable<Long, IUser>();
	
	public static boolean has(long id) {
		return users.contains(id);
	}
	
	public static IUser get(long id) {
		return (IUser) users.get(id);
	}
	
	public static void add(long id, IUser user) {
		users.put(id, user);
	}
}
