package org.soen387.app.helpers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamChecker {

	public static boolean checkParams(String[] params, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		boolean valid = true;
		String errorString = "Missing params: ";
		for(int i = 0; i < params.length; i++) {
			if(req.getParameter(params[i]) == null) {
				errorString += params[i] + ", ";
				valid = false;
			}
		}
		if (!valid) {
			ErrorHandler.error(errorString.substring(0,errorString.length()-2), req, res);
		}
		return valid;
	}
}
