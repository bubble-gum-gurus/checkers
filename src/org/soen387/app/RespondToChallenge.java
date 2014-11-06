package org.soen387.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dsrg.soenea.domain.MapperException;
import org.soen387.app.helpers.AuthHelper;
import org.soen387.app.helpers.ErrorHandler;
import org.soen387.app.helpers.ParamChecker;
import org.soen387.app.helpers.UserNotFoundException;
import org.soen387.domain.challenge.mapper.ChallengeDataMapper;
import org.soen387.domain.model.challenge.ChallengeStatus;
import org.soen387.domain.model.challenge.IChallenge;
import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.model.user.IUser;

/**
 * Servlet implementation class ListGames
 */
@WebServlet("/RespondToChallenge")
public class RespondToChallenge extends AbstractPageController implements Servlet {
       
    /**
     * @see AbstractPageController#AbstractPageController()
     */
    public RespondToChallenge() {
        super();
    }

	@Override
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// check that appropriate params were supplied
		String[] params = {"challenge", "version", "status"};
		if (!ParamChecker.checkParams(params, request, response)) {
			return;
		}
		
		// load params
		long challenge_id = Long.valueOf(request.getParameter("challenge"));
		int version = Integer.valueOf(request.getParameter("version"));
		int status = Integer.valueOf(request.getParameter("status"));
		
		// get session
		HttpSession session = request.getSession();
		
		try {
			
			// verify user is logged in
			if(!AuthHelper.isLoggedIn(session)) {
				ErrorHandler.error("not logged in", request, response);
				return;
			}
			
			// retrieve user
			IUser user = AuthHelper.getUser(session);
			IPlayer player = user.getPlayer();
			
			// check for challenge
			IChallenge challenge = ChallengeDataMapper.find(challenge_id);
			if (challenge == null) {
				ErrorHandler.error("challenge doesn't exist", request, response);
				return;
			}
			
			// validate that the challenge is for the curernt user
			if (challenge.getChallengee().getId() != player.getId()) {
				ErrorHandler.error("current user does not have permission to respond to this challenge", request, response);
				return;
			}
			
			// set the status
			challenge.setStatus(ChallengeStatus.values()[status]);
			ChallengeDataMapper.update(challenge);
			
			// forward to jsp
			request.setAttribute("challenge", challenge);
			request.getRequestDispatcher("/WEB-INF/jsp/xml/respondtochallenge.jsp").forward(request, response);
			
		} catch (MapperException e) {

			ErrorHandler.error("errorz", request, response);
		} catch (UserNotFoundException e) {
			
		}
		
	}


}
