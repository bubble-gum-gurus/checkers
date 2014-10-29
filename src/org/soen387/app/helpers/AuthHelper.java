package org.soen387.app.helpers;

import javax.servlet.http.HttpSession;

import org.dsrg.soenea.domain.MapperException;
import org.soen387.domain.user.mapper.UserDataMapper;
import org.soen387.domain.model.user.IUser;

public class AuthHelper {

	public static IUser getUser(HttpSession session) throws UserNotFoundException {
		long user_id = (Long) session.getAttribute("user");
		IUser user = null;
		try {
			user = UserDataMapper.find(user_id);
		} catch (MapperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserNotFoundException(e);
		}
		return user;
	}
	
	public static void setUser(HttpSession session, IUser user) {
		session.setAttribute("user", user.getId());
	}
	
	public static void clearUser(HttpSession session) {
		session.removeAttribute("user");
	}
}
