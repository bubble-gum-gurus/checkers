package org.soen387.domain.model.user;

import org.soen387.domain.model.player.IPlayer;

public interface IUser {
	
	public abstract long getId();
	public abstract void setId(long id);
	public abstract int getVersion();
	public abstract void setVersion(int version);
	public abstract String getUsername();
	public abstract void setUsername(String username);
	public abstract String getPassword();
	public abstract void setPassword(String password);
	public abstract IPlayer getPlayer();
	public abstract void setPlayer(IPlayer player);
	
}
