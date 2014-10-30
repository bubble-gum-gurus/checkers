package org.soen387.domain.checkerboard.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.soen387.domain.checkerboard.tdg.CheckerBoardTDG;
import org.soen387.domain.model.checkerboard.CheckerBoard;
import org.soen387.domain.model.checkerboard.ICheckerBoard;
import org.soen387.domain.model.checkerboard.GameStatus;
import org.soen387.domain.model.player.Player;
import org.soen387.domain.checkerboard.identitymap.CheckerBoardIdentityMap;

public class CheckerBoardDataMapper {
	
	public static List<ICheckerBoard> buildCollection(ResultSet rs)
		    throws SQLException {
		    ArrayList<ICheckerBoard> l = new ArrayList<ICheckerBoard>();
		    while(rs.next()) {
		    	long id = rs.getLong("id");
		    	if (CheckerBoardIdentityMap.has(id)) {
		    		l.add(CheckerBoardIdentityMap.get(id));
		    	} else {
			    	String piecesString = rs.getString("pieces");
			    	char[][] pieces = new char[8][8];
			    	for(int i=0; i < 8; i++) {
			    		for(int j=0; j < 8; j++) {
			    			pieces[j][i] = piecesString.charAt(i*8+j);
			    		}
			    	}
			    	
			        l.add(new CheckerBoard(rs.getLong("id"),
			        		rs.getInt("version"),
			        		GameStatus.values()[rs.getInt("status")],
			        		pieces,
			        		new Player(rs.getLong("first_player")),
			        		new Player(rs.getLong("second_player")),
			        		new Player(rs.getLong("current_player"))
			        		));
		    	}
		    }
		    return l;
		}
	
	// finds a checkerboard by checkerboard id
	public static ICheckerBoard find(long id) throws MapperException {
		try {
			ResultSet rs = CheckerBoardTDG.find(id);
			return buildCollection(rs).get(0);
		} catch (SQLException e) {
			throw new MapperException(e);
		}
	}
	
	// finds a checkerboard id by the ids of the two players
	public static ICheckerBoard find(long player1_id, long player2_id) throws MapperException {
		try {
			ResultSet rs = CheckerBoardTDG.find(player1_id, player2_id);
			List<ICheckerBoard> collection = buildCollection(rs);
			if(collection.isEmpty()) {
				return null;
			} else {
				return collection.get(0);
			}
		} catch (SQLException e) {
			throw new MapperException(e);
		}
	}

	public static List<ICheckerBoard> findAll() throws MapperException {
        try {
            ResultSet rs = CheckerBoardTDG.findAll();
            return buildCollection(rs);
        } catch (SQLException e) {
            throw new MapperException(e);
        }
	}
}
