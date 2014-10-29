package org.soen387.domain.user.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.soen387.domain.user.tdg.UserTDG;
import org.soen387.domain.model.user.User;
import org.soen387.domain.player.proxy.PlayerProxy;

public class UserDataMapper {
	
	public static List<User> buildCollection(ResultSet rs)
		    throws SQLException {
		    ArrayList<User> l = new ArrayList<User>();
		    while(rs.next()) {
		    	long id = rs.getLong("id");
		    	l.add(new User(rs.getLong("id"), 
		    			rs.getInt("version"), 
		    			rs.getString("username"),
		    			rs.getString("password"),
		    			new PlayerProxy(rs.getLong("player"))));
		    }
		    return l;
		}
	
	public static User find(long id) throws MapperException {
		try {
			ResultSet rs = UserTDG.find(id);
			List<User> collection = buildCollection(rs);
			if (collection.isEmpty()) {
				return null;
			} else {
				return collection.get(0);
			}
		} catch (SQLException e) {
			throw new MapperException(e);
		}
	}
	
	public static User find(String username, String password) throws MapperException {
		try {
			ResultSet rs = UserTDG.find(username, password);
			List<User> collection = buildCollection(rs);
			if (collection.isEmpty()) {
				return null;
			} else {
				return collection.get(0);
			}
		} catch (SQLException e) {
			throw new MapperException(e);
		}
	}

	public static List<User> findAll() throws MapperException {
        try {
        	ResultSet rs = UserTDG.findAll();
            return buildCollection(rs);
        } catch (SQLException e) {
            throw new MapperException(e);
        }
	}
	
	public static User create(User user) throws MapperException {
		try {
			UserTDG.insert(user.getUsername(), user.getPassword());
			return find(user.getUsername(), user.getPassword());
		} catch (SQLException e) {
			throw new MapperException(e);
		}
	}
	
	public static void update(User user) throws MapperException {
		try {
			UserTDG.update(user.getId(), user.getVersion(), user.getUsername(), user.getPassword(), user.getPlayer().getId());
		} catch (SQLException e) {
			throw new MapperException(e);
		}
	}
}
