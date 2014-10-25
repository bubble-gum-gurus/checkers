package org.soen387.domain.user.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.soen387.domain.user.tdg.UserTDG;
import org.soen387.domain.model.user.User;

public class UserDataMapper {
	
	public static List<User> buildCollection(ResultSet rs)
		    throws SQLException {
		    ArrayList<User> l = new ArrayList<User>();
		    while(rs.next()) {
		    	l.add(new User(rs.getLong("id"), 
		    			rs.getInt("version"), 
		    			rs.getString("first_name"),
		    			rs.getString("last_name"),
		    			rs.getString("email"),
		    			rs.getString("username")));
		    }
		    return l;
		}

	public static List<User> findAll() throws MapperException {
        try {
            ResultSet rs = UserTDG.findAll();
            return buildCollection(rs);
        } catch (SQLException e) {
            throw new MapperException(e);
        }
	}
}
