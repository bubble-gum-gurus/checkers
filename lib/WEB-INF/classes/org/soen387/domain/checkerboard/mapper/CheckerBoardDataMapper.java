package org.soen387.domain.checkerboard.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.soen387.domain.checkerboard.tdg.CheckerBoardTDG;
import org.soen387.domain.model.checkerboard.CheckerBoard;
import org.soen387.domain.model.checkerboard.GameStatus;
import org.soen387.domain.model.player.Player;

public class CheckerBoardDataMapper {
	
	public static List<CheckerBoard> buildCollection(ResultSet rs)
		    throws SQLException {
		    ArrayList<CheckerBoard> l = new ArrayList<CheckerBoard>();
		    while(rs.next()) {
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
		    return l;
		}

	public static List<CheckerBoard> findAll() throws MapperException {
        try {
            ResultSet rs = CheckerBoardTDG.findAll();
            return buildCollection(rs);
        } catch (SQLException e) {
            throw new MapperException(e);
        }
	}
}
