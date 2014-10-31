package org.soen387.domain.tx;

import java.sql.SQLException;
import org.soen387.domain.tx.TxException;

import org.soen387.domain.tx.gateway.TxGateway;


public class Tx {
	
	public void start() throws SQLException
	{
		TxGateway.startTransaction();
	}
	
	public void commit() throws SQLException
	{
		TxGateway.commit();
	}
	
	public void rollback() throws SQLException
	{
		TxGateway.rollback();
	}

}
