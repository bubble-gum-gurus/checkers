package org.soen387.app.helpers;
import javax.servlet.http.*;
import org.dsrg.soenea.domain.MapperException;
import org.soen387.domain.user.mapper.UserDataMapper;
import org.soen387.domain.model.user.IUser;

public class AuthHelper {

	public static IUser getUser(HttpSession session) throws UserNotFoundException {
		Object o = session.getAttribute("user");
		if (o == null) {
			return null;
		}
		long user_id = (Long) o;
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
	
	public static boolean isLoggedIn(HttpSession session) {
		return session.getAttribute("user") != null;
	}
	
	public static void setUser(HttpSession session, IUser user) {
		session.setAttribute("user", user.getId());
	}
	
	public static void clearUser(HttpSession session) {
		session.removeAttribute("user");
	}
}
