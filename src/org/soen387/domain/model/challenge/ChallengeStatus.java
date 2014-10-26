package org.soen387.domain.model.challenge;

public enum ChallengeStatus {
	Open,
	Accepted,
	Refused;
	
	public int getId() { return this.ordinal(); }
}
