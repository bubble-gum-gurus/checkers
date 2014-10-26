package org.soen387.domain.model.checkerboard;

import org.soen387.domain.model.player.Player;
import java.awt.Point;

public interface ICheckerBoard {
	
	public abstract long getId();
	public abstract int getVersion();
	public abstract void setVersion(int version);
	public abstract GameStatus getStatus();
	public abstract void setStatus(GameStatus status);
	public abstract char[][] getPieces();
	public abstract void setPieces(char[][] pieces);
	public abstract Player getFirstPlayer();
	public abstract void setFirstPlayer(Player firstPlayer);
	public abstract Player getSecondPlayer();
	public abstract void setSecondPlayer(Player secondPlayer);
	public abstract Player getCurrentPlayer();
	public abstract void setCurrentPlayer(Player currentPlayer);
	public abstract void move(Point source, Point target);
	public abstract void jump(Point source, Point... targets);
}
