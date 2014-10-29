package org.soen387.app.helpers;

public class UserNotFoundException extends Exception {
	public UserNotFoundException (String message) {
		super(message);
	}
	public UserNotFoundException (Exception e) {
		super(e);
	}
}
