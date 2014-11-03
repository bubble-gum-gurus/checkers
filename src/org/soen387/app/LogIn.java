package org.soen387.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dsrg.soenea.domain.MapperException;
import org.soen387.domain.user.mapper.UserDataMapper;
import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.model.user.IUser;
import org.soen387.domain.model.user.User;
import org.soen387.domain.player.mapper.PlayerDataMapper;
import org.soen387.app.helpers.*;

/**
 * Servlet implementation class ListUsers
 */
@WebServlet("/LogIn")


public class LogIn extends AbstractPageController implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//We're inheriting from SoenEA's Servlet, so we get the DB getting taken care of mostly for us
		//We just need to make sure MyResources.properties has all our stuff, then it opens
		//and closes db connections for us and we can get at them by asking for
		//DbRegistry.getConnection()
		//
		//But I don't start a transaction or deal with commit/rollback automatically... You gotta do that as
		//appropriate!"
		
		HttpSession session = request.getSession();
		
		try {
			if (AuthHelper.isLoggedIn(session)) {
				ErrorHandler.error("already logged in", request, response);
			}
			String username =  request.getParameter("username");
			String password =  request.getParameter("password");
			IUser user =  UserDataMapper.find(username, password);
			if(user == null){
				ErrorHandler.error("user not found", request, response);
			}
			else{
				AuthHelper.setUser(session, user);
				request.setAttribute("user", user);
				request.getRequestDispatcher("/WEB-INF/jsp/xml/LogIn.jsp").forward(request, response);
			}

		} catch (MapperException e) {
			e.printStackTrace();
		}
	}

}
