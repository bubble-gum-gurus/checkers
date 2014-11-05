package org.soen387.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dsrg.soenea.domain.MapperException;
import org.soen387.app.helpers.ErrorHandler;
import org.soen387.app.helpers.ParamChecker;
import org.soen387.domain.user.mapper.UserDataMapper;
import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.model.player.Player;
import org.soen387.domain.model.user.IUser;
import org.soen387.domain.model.user.User;
import org.soen387.domain.player.mapper.PlayerDataMapper;

public class ViewUserStats extends AbstractPageController implements Servlet{

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

