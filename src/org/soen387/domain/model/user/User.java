package org.soen387.domain.model.user;

public class User {
	
	private long id;
	private int version;
	private String first_name;
	private String last_name;
	private String email;
	private String username;
	
	public User (long id, int version, String first_name, String last_name, String email, String username) {
		this.id = id;
		this.version = version;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email; 
		this.username = username;
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
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
