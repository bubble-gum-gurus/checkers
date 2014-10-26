package org.soen387.domain.model.player;

public interface IPlayer {
	
	public long getId();
	public void setId(long id);
	public int getVersion();
	public void setVersion(int version);
	public String getFirstName();
	public void setFirstName(String first_name);
	public String getLastName();
	public void setLastName(String last_name);
	public String getEmail();
	public void setEmail(String email);
	
}
