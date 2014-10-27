package org.soen387.domain.model.player;

import org.soen387.domain.model.user.*;

/**
 * 
 *This is an incomplete stub. Fix it.
 */
public class Player implements IPlayer {
	long id;
	private int version;
	private String first_name;
	private String last_name;
	private String email;
	private IUser user;
	
	public Player(long id) {
		super();
		this.id = id;
	}

	public Player(long id, int version, String first_name, String last_name, String email, IUser user) {
		super();
		this.id = id;
		this.version = version;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.user = user;
	}
	
	//Player Constructor w/o (id,version)
	public Player (String first_name, String last_name, String email, IUser user){
		
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.user = user;
				
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
	
	public String getFirstName() {
		return this.first_name;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return this.last_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public IUser getUser() {
		return user;
	}
	
	public void setUser(IUser user) {
		this.user = user;
	}
}
