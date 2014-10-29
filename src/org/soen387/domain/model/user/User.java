package org.soen387.domain.model.user;

import org.soen387.domain.model.player.IPlayer;

public class User implements IUser {
	
	private long id;
	private int version;
	private String username;
	private String password;
	private IPlayer player;
	
	public User (long id, int version, String username, String password, IPlayer player) {
		this.id = id;
		this.version = version;
		this.username = username;
		this.password = password;
		this.player = player;
	}
	
	
	//User constructor w/o (id,version)
	public User (String username, String password) {
			
		this.username = username;
		this.password = password;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getVersion() {
		return this.version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public IPlayer getPlayer () {
		return player;
	}
	
	public void setPlayer(IPlayer player) {
		this.player = player;
	}
}
