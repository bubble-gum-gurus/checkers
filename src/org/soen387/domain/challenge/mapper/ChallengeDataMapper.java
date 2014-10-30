package org.soen387.domain.challenge.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.soen387.domain.challenge.tdg.ChallengeTDG;
import org.soen387.domain.challenge.identitymap.ChallengeIdentityMap;
import org.soen387.domain.model.challenge.Challenge;
import org.soen387.domain.model.challenge.IChallenge;
import org.soen387.domain.model.challenge.ChallengeStatus;
import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.player.proxy.PlayerProxy;

public class ChallengeDataMapper {
	
	public static List<IChallenge> buildCollection(ResultSet rs)
		    throws SQLException {
		    ArrayList<IChallenge> l = new ArrayList<IChallenge>();
		    while(rs.next()) {
		    	long id = rs.getLong("id");
		    	if (ChallengeIdentityMap.has(id)) {
		    		l.add(ChallengeIdentityMap.get(id));
		    	} else {
			    	
			        l.add(new Challenge(id,
			        		rs.getInt("version"),
			        		ChallengeStatus.values()[rs.getInt("status")],
			        		new PlayerProxy(rs.getLong("challengee")),
			        		new PlayerProxy(rs.getLong("challenger"))
			        		));
		    	}
		    }
		    return l;
		}
	
	public static IChallenge find(long id) throws MapperException {
		try {
			ResultSet rs = ChallengeTDG.find(id);
			return buildCollection(rs).get(0);
		} catch (SQLException e) {
			throw new MapperException(e);
		}
	}
	
	public static IChallenge find(long user1_id, long user2_id) throws MapperException {
		try {
			ResultSet rs = ChallengeTDG.find(user1_id, user2_id);
			List<IChallenge> collection = buildCollection(rs);
			if (collection.isEmpty()) {
				return null;
			} else {
				return collection.get(0);
			}
		} catch (SQLException e) {
			throw new MapperException(e);
		}
	}
	
	public static IChallenge create(IChallenge challenge) throws MapperException {
		try {
			long challenger_id = challenge.getChallenger().getId();
			long challengee_id = challenge.getChallengee().getId();
			ChallengeTDG.insert(challenge.getStatus().getId(), challengee_id, challenger_id);
			return find(challengee_id, challenger_id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MapperException(e);
		}
	}
}
