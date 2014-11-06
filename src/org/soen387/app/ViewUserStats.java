package org.soen387.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.soen387.app.helpers.AuthHelper;
import org.soen387.app.helpers.ErrorHandler;
import org.soen387.domain.checkerboard.mapper.CheckerBoardDataMapper;
import org.soen387.domain.model.checkerboard.ICheckerBoard;
import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.model.user.IUser;
import org.soen387.domain.player.mapper.PlayerDataMapper;
import org.soen387.domain.user.mapper.UserDataMapper;
@WebServlet("/ViewUserStats")
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
			long user_id = Long.valueOf(request.getParameter("id"));
			
			HttpSession session = request.getSession();
			IUser user = UserDataMapper.find(user_id);
			IPlayer player = user.getPlayer();
			
			List<ICheckerBoard> checkerBoardList = CheckerBoardDataMapper.findAllForPlayer(player);
			request.setAttribute("user", user);
			request.setAttribute("checkerBoardList", checkerBoardList);
			
//			request.setAttribute("user",username);
//			request.setAttribute("stats",stats);		
			request.getRequestDispatcher("/WEB-INF/jsp/xml/ViewStats.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHandler.error(e.toString(), request, response);
		}
	}
}

