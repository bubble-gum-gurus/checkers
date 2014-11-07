package org.soen387.domain.model.checkerboard;

import java.awt.Point;

import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.model.player.Player;

public class CheckerBoard implements ICheckerBoard {

	public CheckerBoard(long id, int version, GameStatus status,
			char[][] pieces, IPlayer firstPlayer, IPlayer secondPlayer,
			IPlayer currentPlayer) {
		super();
		this.id = id;
		this.version = version;
		this.status = status;
		this.pieces = pieces;
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.currentPlayer = currentPlayer;
	}
	
	public CheckerBoard(IPlayer firstPlayer, IPlayer secondPlayer) {
		pieces = new char[8][8];
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[i].length; j++) {
			//	"b b b b  b b b bb b b b                  r r r rr r r r  r r r r"
			//	pieces[i][j] = 'e';
				if(j == 0 && (i%2 == 0))
					pieces[i][j] = 'b';
				else if(j == 1 && (i%2 == 1))
					pieces[i][j] = 'b';
				else if(j == 2 && (i%2 == 0))
					pieces[i][j] = 'b';
				else if(j == 5 && (i%2 == 1))
					pieces[i][j] = 'r';
				else if(j == 6 && (i%2 == 0))
					pieces[i][j] = 'r';
				else if(j == 7 && (i%2 == 1))
					pieces[i][j] = 'r';
				else
					pieces[i][j] = '\u0000';
			}
			//pieces[i][j] = ' ';
			
		}
		status = GameStatus.Ongoing;
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.currentPlayer = firstPlayer;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}

	public char[][] getPieces() {
		return pieces;
	}

	public void setPieces(char[][] pieces) {
		this.pieces = pieces;
	}

	public IPlayer getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(IPlayer firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public IPlayer getSecondPlayer() {
		return secondPlayer;
	}

	public void setSecondPlayer(IPlayer secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

	public IPlayer getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(IPlayer currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public long getId() {
		return id;
	}

	long id;
	int version;
	GameStatus status;
	char[][] pieces;
	IPlayer firstPlayer;
	IPlayer secondPlayer;
	IPlayer currentPlayer;
	
	public String toString()
	{
		String value = "";
		for(int i = 0; i<8; ++i)
		{
			for(int j =0; j<8; ++j)
			{
				if(pieces[j][i] == '\0')
					value+=" ";
				else
				value+=pieces[j][i];
				
			}
		}
		
		return value;
	}

	public void move(Point source, Point target) {
		
	}
	
	public void jump(Point source, Point... targets) {
		
	}
}
