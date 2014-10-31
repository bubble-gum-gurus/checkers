package org.soen387.domain.tx;

import java.sql.SQLException;
import org.soen387.domain.tx.TxException;

import org.soen387.domain.tx.gateway.TxGateway;


public class Tx {
	
	public void start() throws TxException
	{
		try {
			TxGateway.startTransaction();
		} catch (SQLException e) {
			new TxException(e);
		}
	}
	
	public void commit() throws TxException
	{
		try {
			TxGateway.commit();
		} catch (SQLException e) {
			new TxException(e);
		}
	}
	
	public void rollback() throws TxException
	{
		try {
			TxGateway.rollback();
		} catch (SQLException e) {
			new TxException(e);
		}
	}

}
