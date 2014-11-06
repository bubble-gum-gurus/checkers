package org.soen387.app;

public class LostUpdateException extends Exception {
	private static final long serialVersionUID = 1L;

	public LostUpdateException (String message) {
		super(message);
	}
}
