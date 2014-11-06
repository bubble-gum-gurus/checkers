package org.soen387.domain.checkerboard.proxy;

import java.awt.Point;

import org.soen387.domain.model.checkerboard.GameStatus;
import org.soen387.domain.model.checkerboard.ICheckerBoard;
import org.soen387.domain.model.checkerboard.CheckerBoard;
import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.model.player.Player;
import org.soen387.domain.checkerboard.mapper.CheckerBoardDataMapper;
import org.dsrg.soenea.domain.MapperException;

import java.awt.Point;

public class CheckerBoardProxy implements ICheckerBoard {
	
	private long id;
	private ICheckerBoard checkerboard = null;
	
	public CheckerBoardProxy(long id) {
		this.id = id;
	}
	
	private ICheckerBoard getInnerObject() {
		if (checkerboard == null) {
			try {
				checkerboard = CheckerBoardDataMapper.find(id);
			} catch(MapperException e) {
				// ?
			}
		}
		return checkerboard;
	}
	
	public long getId() {
		return getInnerObject().getId();
	}
	
	public int getVersion() {
		return getInnerObject().getVersion();
	}
	
	public void setVersion(int version) {
		getInnerObject().setVersion(version);
	}
	
	public GameStatus getStatus() {
		return getInnerObject().getStatus();
	}
	
	public void setStatus(GameStatus status) {
		getInnerObject().setStatus(status);
	}
	
	public char[][] getPieces() {
		return getInnerObject().getPieces();
	}
	
	public void setPieces(char[][] pieces) {
		getInnerObject().setPieces(pieces);
	}
	
	public IPlayer getFirstPlayer() {
		return getInnerObject().getFirstPlayer();
	}
	
	public void setFirstPlayer(IPlayer firstPlayer) {
		getInnerObject().setFirstPlayer(firstPlayer);
	}
	
	public IPlayer getSecondPlayer() {
		return getInnerObject().getSecondPlayer();
	}
	
	public void setSecondPlayer(IPlayer secondPlayer) {
		getInnerObject().setSecondPlayer(secondPlayer);
	}

	public IPlayer getCurrentPlayer() {
		return getInnerObject().getCurrentPlayer();
	}
	
	public void setCurrentPlayer(IPlayer currentPlayer) {
		getInnerObject().setCurrentPlayer(currentPlayer);
	}
	
	public void move(Point source, Point target) {
		getInnerObject().move(source, target);
	}

	public void jump(Point source, Point... targets) {
		getInnerObject().jump(source, targets);
	}
}
