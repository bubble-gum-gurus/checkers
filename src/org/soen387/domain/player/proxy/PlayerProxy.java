package org.soen387.domain.player.proxy;

import org.dsrg.soenea.domain.MapperException;
import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.model.player.Player;
import org.soen387.domain.player.mapper.PlayerDataMapper;
import org.dsrg.soenea.domain.MapperException;

public class PlayerProxy implements IPlayer {
	
	private long id;
	private IPlayer player;

	public PlayerProxy(long id) {
		this.id = id;
	}
	
	private IPlayer getInnerObject() {
		if(player == null) {
			try {
				player = PlayerDataMapper.find(id);
			} catch (MapperException e) {
				// ?
			}
		}
		return player;
	}
	
	public long getId() {
		return getInnerObject().getId();
	}
	
	public void setId(long id) {
		getInnerObject().setId(id);
	}
	
	public int getVersion() {
		return getInnerObject().getVersion();
	}
	
	public void setVersion(int version) {
		getInnerObject().setVersion(version);
	}
	
	public String getFirstName() {
		return getInnerObject().getFirstName();
	}
	
	public void setFirstName(String firstName) {
		getInnerObject().setFirstName(firstName);
	}
	
	public String getLastName() {
		return getInnerObject().getLastName();
	}
	
	public void setLastName(String lastName) {
		getInnerObject().setLastName(lastName);
	}
	
	public String getEmail() {
		return getInnerObject().getEmail();
	}
	
	public void setEmail(String email) {
		getInnerObject().setEmail(email);
	}
}
