package org.soen387.domain.tx.gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.dsrg.soenea.service.threadLocal.DbRegistry;

public class TxGateway {
	
	public static final String START_TRANSACTION = "START TRANSACTION;";
	public static void startTransaction() throws SQLException {
		Connection con = DbRegistry.getDbConnection();
		Statement s = con.createStatement();
		s.execute(START_TRANSACTION);
		System.out.println(s.toString());
	}
	
	public static final String COMMIT = "COMMIT;";
	public static void commit() throws SQLException {
		Connection con = DbRegistry.getDbConnection();
		Statement s = con.createStatement();
		s.execute(COMMIT);
		System.out.println(s.toString());
	}
	
	public static final String ROLLBACK = "ROLLBACK;";
	public static void rollback() throws SQLException {
		Connection con = DbRegistry.getDbConnection();
		Statement s = con.createStatement();
		s.execute(ROLLBACK);
		System.out.println(s.toString());
	}

}
