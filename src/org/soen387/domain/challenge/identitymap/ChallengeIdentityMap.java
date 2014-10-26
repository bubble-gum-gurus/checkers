package org.soen387.domain.challenge.identitymap;

import java.util.Hashtable;

import org.soen387.domain.model.challenge.IChallenge;

public class ChallengeIdentityMap {
	private static Hashtable challenges = new Hashtable<Long, IChallenge>();
	
	public static boolean has(long id) {
		return challenges.contains(id);
	}
	
	public static IChallenge get(long id) {
		return (IChallenge) challenges.get(id);
	}
	
	public static void put(long id, IChallenge challenge) {
		challenges.put(id, challenge);
	}
}
