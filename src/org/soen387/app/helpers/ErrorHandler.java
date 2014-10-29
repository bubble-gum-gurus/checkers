package org.soen387.app.helpers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandler {

	public static void error(String error, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setAttribute("error", error);
		req.getRequestDispatcher("/WEB-INF/jsp/xml/error.jsp").forward(req, res);
	}
}
