package org.soen387.domain.user.proxy;

import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.model.user.User;
import org.soen387.domain.user.mapper.UserDataMapper;
import org.soen387.domain.model.user.IUser;
import org.dsrg.soenea.domain.MapperException;


public class UserProxy implements IUser {
	
	private long id;
	private User user;
	
	public UserProxy (long id) {
		this.id = id;
	}
	
	private User getInnerObject() {
		if (user == null) {
			try {
				user = UserDataMapper.find(id);
			} catch (MapperException e) {
				// ?
			}
		}
		return user;
	}
	
	public long getId() {
		return this.getInnerObject().getId();
	}
	
	public void setId(long id) {
		this.getInnerObject().setId(id);
	}
	
	public int getVersion() {
		return this.getInnerObject().getVersion();
	}
	
	public void setVersion(int version) {
		this.getInnerObject().setVersion(version);
	}
	
	public String getUsername() {
		return this.getInnerObject().getUsername();
	}
	
	public void setUsername(String username) {
		this.getInnerObject().setUsername(username);
	}
	
	public String getPassword() {
		return this.getInnerObject().getPassword();
	}
	
	public void setPassword(String password) {
		this.getInnerObject().setPassword(password);
	}
	
	public IPlayer getPlayer() {
		return getInnerObject().getPlayer();
	}
	
	public void setPlayer(IPlayer player) {
		getInnerObject().setPlayer(player);
	}
}
