package org.soen387.domain.challenge.proxy;

import org.soen387.domain.model.challenge.*;
import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.challenge.mapper.ChallengeDataMapper;
import org.dsrg.soenea.domain.MapperException;

public class ChallengeProxy implements IChallenge {
	
	private long id;
	private IChallenge challenge = null;
	
	public ChallengeProxy(long id) {
		this.id = id;
	}
	
	private IChallenge getInnerObject() {
		if (challenge == null) {
			try {
				challenge = ChallengeDataMapper.find(id);
			} catch(MapperException e) {
				// ?
			}
		}
		return challenge;
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
	
	public ChallengeStatus getStatus() {
		return getInnerObject().getStatus();
	}
	
	public void setStatus(ChallengeStatus status) {
		getInnerObject().setStatus(status);
	}
	
	public IPlayer getChallenger() {
		return getInnerObject().getChallenger();
	}
	
	public void setChallenger(IPlayer player) {
		getInnerObject().setChallenger(player);
	}
	
	public IPlayer getChallengee() {
		return getInnerObject().getChallengee();
	}
	
	public void setChallengee(IPlayer player) {
		getInnerObject().setChallengee(player);
	}
}
