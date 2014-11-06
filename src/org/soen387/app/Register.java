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
import org.soen387.app.helpers.AuthHelper;
import org.soen387.app.helpers.ErrorHandler;
import org.soen387.app.helpers.ParamChecker;
import org.soen387.domain.user.mapper.UserDataMapper;
import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.model.player.Player;
import org.soen387.domain.model.user.IUser;
import org.soen387.domain.model.user.User;
import org.soen387.domain.tx.*;
import org.soen387.domain.player.mapper.PlayerDataMapper;

/**
 * Servlet implementation class ListUsers
 */
@WebServlet("/Register")


public class Register extends AbstractPageController implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// check if user is logged in
		HttpSession session = request.getSession();
//		if (AuthHelper.isLoggedIn(session)) {
//			ErrorHandler.error("already logged in", request, response);
//			return;
//		}
		
		
		// check that the appropriate params were supplied
		String[] params = {"username", "password", "firstname", "lastname", "email"};
		if(!ParamChecker.checkParams(params, request, response)) {
			return;
		}
		
		// retrieve params
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname= request.getParameter("firstname"); 
		String lastname = request.getParameter("lastname");
		String email 	= request.getParameter("email");
		
		// create user
		try {
			Tx.start();
			IUser user = new User(username,password);
			user = UserDataMapper.create(user);
			IPlayer player = new Player(firstname,lastname, email, user);	
			player = PlayerDataMapper.create(player);
			user.setPlayer(player);
			UserDataMapper.update(user);
			request.setAttribute("player", player);
			AuthHelper.setUser(session, user);
			request.getRequestDispatcher("/WEB-INF/jsp/xml/Register.jsp").forward(request, response);
		} catch (MapperException e) {
			try {
				Tx.rollback();
			} catch (TxException e1) {
				e1.printStackTrace();
				ErrorHandler.error(e.toString(), request, response);
			}
			e.printStackTrace();
			ErrorHandler.error(e.toString(), request, response);
		} catch (TxException e) {
			e.printStackTrace();
			ErrorHandler.error(e.toString(), request, response);
		} finally {
			try {
				Tx.commit();
			} catch (TxException e) {
				e.printStackTrace();
				ErrorHandler.error(e.toString(), request, response);
			}
		}
	}

}
