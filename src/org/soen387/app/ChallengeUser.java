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
			
			// check that user exists
			IUser challengee = UserDataMapper.find(challengee_id);
			if (challengee == null) {
				ErrorHandler.error("user not found", request, response);
				return;
			}
			
			// check that the two users do not currently have an
			// open challenge
			
			
		} catch (MapperException e) {

			e.printStackTrace();
		}
		
	}


}
