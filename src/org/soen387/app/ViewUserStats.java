package org.soen387.app;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soen387.app.helpers.ErrorHandler;

public class ViewUserStats extends AbstractPageController implements Servlet{
	private static final long serialVersionUID = 1L;

	public ViewUserStats()
	{
		super();
	}
	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	

	// check that the appropriate params were supplied
//		String[] params = {""};
//		if(!ParamChecker.checkParams(params, request, response)) {
//			return;
//		}
//		
//		// retrieve params
//		String username = request.getParameter("user");
//		String stats = request.getParameter("stats");
		
		
		// create user
		try {
//			request.setAttribute("user",username);
//			request.setAttribute("stats",stats);		
			request.getRequestDispatcher("/WEB-INF/jsp/xml/ViewStats.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHandler.error(e.toString(), request, response);
		}
	}
}

