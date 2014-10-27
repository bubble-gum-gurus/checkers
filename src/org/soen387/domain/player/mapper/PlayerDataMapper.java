package org.soen387.domain.player.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.soen387.domain.player.tdg.PlayerTDG;
import org.soen387.domain.player.identitymap.PlayerIdentityMap;
import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.model.player.Player;
import org.soen387.domain.user.proxy.UserProxy;

public class PlayerDataMapper {
	
	public static List<IPlayer> buildCollection(ResultSet rs)
		    throws SQLException {
		    ArrayList<IPlayer> l = new ArrayList<IPlayer>();
		    while(rs.next()) {
		    	long id = rs.getLong("id");
		    	if (PlayerIdentityMap.has(id)) {
		    		l.add(PlayerIdentityMap.get(id));
		    	} else {
			    	l.add(new Player(id, 
			    			rs.getInt("version"), 
			    			rs.getString("first_name"),
			    			rs.getString("last_name"),
			    			rs.getString("email"),
			    			new UserProxy(rs.getLong("user"))
			    			));
		    	}
		    }
		    return l;
		}
	
	public static IPlayer create(IPlayer player) throws MapperException {
		
		try {
			PlayerTDG.insert(player.getFirstName(), player.getLastName(), player.getEmail(), player.getUser().getId());
			return find(player.getEmail());
		} catch (SQLException e) {
			throw new MapperException(e);
		}
	}
	
	public static IPlayer find(String email) throws MapperException {
		try {
			ResultSet rs = PlayerTDG.find(email);
			List<IPlayer> collection = buildCollection(rs);
			if (collection.isEmpty()) {
				return null;
			} else {
				return collection.get(0);
			}
		} catch (SQLException e) {
			throw new MapperException(e);
		}
	}
	
	public static IPlayer find(long id) throws MapperException {
		if(PlayerIdentityMap.has(id)) {
			return PlayerIdentityMap.get(id);
		}
		try {
			ResultSet rs = PlayerTDG.find(id);
			IPlayer p = buildCollection(rs).get(0);
			PlayerIdentityMap.add(id, p);
			return p;
		} catch (SQLException e) {
			throw new MapperException(e);
		}
	}

	public static List<IPlayer> findAll() throws MapperException {
        try {
            ResultSet rs = PlayerTDG.findAll();
            return buildCollection(rs);
        } catch (SQLException e) {
            throw new MapperException(e);
        }
	}
}
