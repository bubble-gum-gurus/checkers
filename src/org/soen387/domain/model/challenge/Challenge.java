package org.soen387.domain.model.challenge;

import org.soen387.domain.model.player.IPlayer;

public class Challenge implements IChallenge {

	private long id;
	private int version;
	private ChallengeStatus status;
	private IPlayer challenger;
	private IPlayer challengee;
	
	public Challenge(long id, int version, ChallengeStatus status, IPlayer challengee, IPlayer challenger) {
		this.id = id;
		this.version = version;
		this.status = status;
		this.challengee = challengee;
		this.challenger = challenger;
	}
	
	public long getId() {
		return id;
	}
	
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	public ChallengeStatus getStatus() {
		return status;
	}
	
	public void setStatus(ChallengeStatus status) {
		this.status = status;
	}
	
	public IPlayer getChallenger() {
		return challenger;
	}
	
	public void setChallenger(IPlayer challenger) {
		this.challenger = challenger;
	}
	
	public IPlayer getChallengee() {
		return challengee;
	}
	
	public void setChallengee(IPlayer challengee) {
		this.challengee = challengee;
	}
}
