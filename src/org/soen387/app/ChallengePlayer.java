package org.soen387.app;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dsrg.soenea.domain.MapperException;
import org.soen387.domain.challenge.mapper.ChallengeDataMapper;
import org.soen387.domain.checkerboard.mapper.CheckerBoardDataMapper;
import org.soen387.domain.model.checkerboard.ICheckerBoard;
import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.model.user.IUser;
import org.soen387.domain.model.challenge.*;
import org.soen387.domain.player.mapper.PlayerDataMapper;
import org.soen387.app.helpers.AuthHelper;
import org.soen387.app.helpers.ErrorHandler;
import org.soen387.app.helpers.ParamChecker;
import org.soen387.app.helpers.UserNotFoundException;

/**
 * Servlet implementation class ListGames
 */
@WebServlet("/ChallengePlayer")
public class ChallengePlayer extends AbstractPageController implements Servlet {
       
	private static final long serialVersionUID = 1L;

	/**
     * @see AbstractPageController#AbstractPageController()
     */
    public ChallengePlayer() {
        super();
    }

	@Override
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// check that appropriate params were supplied
		String[] params = {"id"};
		if (!ParamChecker.checkParams(params, request, response)) {
			return;
		}
		
		// load params
		long challengee_id = Long.valueOf(request.getParameter("id"));
		
		// get session
		HttpSession session = request.getSession();
		
		try {
			
			// check that the user is logged in
			if (!AuthHelper.isLoggedIn(session)) {
				ErrorHandler.error("not logged in", request, response);
				return;
			}
			
			// load challenger
			IUser challenger = AuthHelper.getUser(session);
			
			
			// check that user exists
			IPlayer challengeePlayer = PlayerDataMapper.find(challengee_id);
			if (challengeePlayer == null) {
				ErrorHandler.error("player not found", request, response);
				return;
			}
			
			// get the players
			IPlayer challengerPlayer = challenger.getPlayer();
			
			// check that the two users do not have an
			// open challenge
			IChallenge open_challenge = ChallengeDataMapper.find(challengeePlayer, challengerPlayer);
			if (open_challenge != null) {
				ErrorHandler.error("challenge exists between users", request, response);
				return;
			}
			
			// check that the two players do not have an open game..
			ICheckerBoard open_game = CheckerBoardDataMapper.find(challengeePlayer.getId(), challengerPlayer.getId());
			if (open_game != null) {
				ErrorHandler.error("game exists between users", request, response);
				return;
			}
			
			// make a challenge between the two users
			IChallenge challenge = new Challenge(challengeePlayer, challengerPlayer);
			challenge = ChallengeDataMapper.create(challenge);
			
			// forward to jsp
			request.setAttribute("challenge", challenge);
			request.getRequestDispatcher("/WEB-INF/jsp/xml/challengeuser.jsp").forward(request, response);
			
		} catch (MapperException e) {

			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			
		}
		
	}


}
