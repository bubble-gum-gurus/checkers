package org.soen387.domain.model.challenge;

import org.soen387.domain.model.player.IPlayer;

public class Challenge {

	private ChallengeStatus status;
	private IPlayer challenger;
	private IPlayer challengee;
	
	public Challenge(ChallengeStatus status) {
		this.status = status;
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
