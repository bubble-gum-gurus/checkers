package org.soen387.domain.tx;

public class TxException extends Exception {

	private static final long serialVersionUID = -8428026988028489334L;

	public TxException(String s) {
		super(s);
	}
	
	public TxException(Throwable t) {
		super(t);
	}
	
	public TxException(String s, Throwable t) {
		super(s, t);
	}
}
