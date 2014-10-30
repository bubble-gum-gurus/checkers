package org.soen387.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dsrg.soenea.domain.MapperException;
import org.soen387.domain.challenge.mapper.ChallengeDataMapper;
import org.soen387.domain.user.mapper.UserDataMapper;
import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.model.user.IUser;
import org.soen387.domain.model.challenge.*;
import org.soen387.app.helpers.ErrorHandler;
import org.soen387.app.helpers.ParamChecker;

/**
 * Servlet implementation class ListGames
 */
@WebServlet("/ChallengeUser")
public class ChallengeUser extends AbstractPageController implements Servlet {
       
    /**
     * @see AbstractPageController#AbstractPageController()
     */
    public ChallengeUser() {
        super();
    }

	@Override
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// check that appropriate params were supplied
		String[] params = {"user"};
		if (!ParamChecker.checkParams(params, request, response)) {
			return;
		}
		
		// load params
		long challengee_id = Long.valueOf(request.getParameter("user"));
		
		try {
			
			// temporary load challenger until we have auth working
			IUser challenger = UserDataMapper.find(9);
			
			// check that user exists
			IUser challengee = UserDataMapper.find(challengee_id);
			if (challengee == null) {
				ErrorHandler.error("user not found", request, response);
				return;
			}
			
			// get the players
			IPlayer challengeePlayer = challengee.getPlayer();
			IPlayer challengerPlayer = challenger.getPlayer();
			
			// check that the two users do not have an
			// open challenge
			IChallenge open_challenge = ChallengeDataMapper.find(challengeePlayer.getId(), challengerPlayer.getId());
			if (open_challenge != null) {
				ErrorHandler.error("challenge exists between users", request, response);
				return;
			}
			
			// check that the two players do not have an open game..
			
			// make a challenge between the two users
			IChallenge challenge = new Challenge(challengeePlayer, challengerPlayer);
			challenge = ChallengeDataMapper.create(challenge);
			
			// forward to jsp
			request.setAttribute("challenge", challenge);
			request.getRequestDispatcher("/WEB-INF/jsp/xml/challengeuser.jsp").forward(request, response);
			
		} catch (MapperException e) {

			e.printStackTrace();
		}
		
	}


}
