package org.soen387.domain.checkerboard.identitymap;

import java.util.Hashtable;
import org.soen387.domain.model.checkerboard.ICheckerBoard;

public class CheckerBoardIdentityMap {
	
	private static Hashtable checkerboards = new Hashtable<Long, ICheckerBoard>();
	
	public static boolean has(long id) {
		return checkerboards.contains(id);
	}
	
	public static ICheckerBoard get(long id) {
		return (ICheckerBoard) checkerboards.get(id);
	}
	
	public static void put(long id, ICheckerBoard checkerboard) {
		checkerboards.put(id, checkerboard);
	}
}
