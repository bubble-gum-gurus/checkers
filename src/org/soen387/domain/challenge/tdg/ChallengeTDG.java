package org.soen387.domain.challenge.tdg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.dsrg.soenea.service.threadLocal.DbRegistry;

public class ChallengeTDG {
	public static final String TABLE_NAME = "Challenge";
	public static final String COLUMNS = "version, status, challengee, challenger ";
	public static final String TRUNCATE_TABLE = "TRUNCATE TABLE  " + TABLE_NAME + ";";
	public static final String DROP_TABLE = "DROP TABLE  " + TABLE_NAME + ";";
	public static final String CREATE_TABLE ="CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" 
			+ "id BIGINT NOT NULL AUTO_INCREMENT, "
			+ "version int, "
			+ "status int, "
			+ "challengee BIGINT, "
			+ "challenger BIGINT, "
			+ "PRIMARY KEY (id)"
			+ ");";

	public static final String UPDATE = "UPDATE " + TABLE_NAME + " "
			+ "SET version=version+1, "
			+ "status=?, "
			+ "challengee=? "
			+ "challenger=? "
			+ "WHERE id=? AND version=?;";
	public static final String DELETE = "DELETE FROM " + TABLE_NAME + " "
			+ "WHERE id=? AND version=?;";

	public static void createTable() throws SQLException {
		Connection con = DbRegistry.getDbConnection();
		Statement update = con.createStatement();
		update.execute(CREATE_TABLE);
	}

	public static void dropTable() throws SQLException {
		Connection con = DbRegistry.getDbConnection();
		Statement update = con.createStatement();
		update.execute(TRUNCATE_TABLE);
		update = con.createStatement(); 
		update.execute(DROP_TABLE);
	}
	
	
	public static final String INSERT = "INSERT INTO " + TABLE_NAME + " (" + COLUMNS + ") "
			+ "VALUES (?,?,?,?);";
	public static int insert(int status, long challengee, long challenger) throws SQLException {
		Connection con = DbRegistry.getDbConnection();
		PreparedStatement ps = con.prepareStatement(INSERT);
		ps.setInt(1,1);
		ps.setInt(2,status);
		ps.setLong(3,challengee);
		ps.setLong(4,challenger);
		System.out.println(ps.toString());
		return ps.executeUpdate();
	}
	
	public static int update(long id, int version, int status, long challengee, long challenger) throws SQLException {
		Connection con = DbRegistry.getDbConnection();
		PreparedStatement ps = con.prepareStatement(UPDATE);
		ps.setInt(1, status);
		ps.setLong(2, challengee);
		ps.setLong(3, challenger);
		ps.setLong(4, id);
		ps.setInt(5, version);
		System.out.println(ps.toString());
		return ps.executeUpdate();
	}
	
	public static int delete(long id, int version) throws SQLException {
		Connection con = DbRegistry.getDbConnection();
		PreparedStatement ps = con.prepareStatement(DELETE);
		ps.setLong(1, id);
		ps.setInt(2, version);
		System.out.println(ps.toString());
		return ps.executeUpdate();
	}
	
	public static final String FIND_ID = "SELECT * FROM " + TABLE_NAME + " WHERE id=?;";
	public static ResultSet find(long id) throws SQLException {
		Connection con = DbRegistry.getDbConnection();
		PreparedStatement ps = con.prepareStatement(FIND_ID);
		ps.setLong(1, id);
		return ps.executeQuery();
	}
	
	public static final String FIND_USERS = "SELECT * FROM " + TABLE_NAME + " WHERE (challengee=? AND challenger=?) OR (challengee=? AND challenger=?);";
	public static ResultSet find(long user1, long user2) throws SQLException {
		Connection con = DbRegistry.getDbConnection();
		PreparedStatement ps = con.prepareStatement(FIND_USERS);
		ps.setLong(1, user1);
		ps.setLong(2, user2);
		ps.setLong(3, user2);
		ps.setLong(4, user1);
		return ps.executeQuery();
	}

	public static final String FIND_BY_CHALLENGEE = "SELECT * FROM " + TABLE_NAME + " WHERE challengee=?;";
	public static ResultSet findByChallengee(long id) throws SQLException {
		Connection con = DbRegistry.getDbConnection();
		PreparedStatement ps = con.prepareStatement(FIND_BY_CHALLENGEE);
		ps.setLong(1, id);
		return ps.executeQuery();
	}
}
