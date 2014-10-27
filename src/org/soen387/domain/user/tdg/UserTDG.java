package org.soen387.domain.user.tdg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.dsrg.soenea.service.threadLocal.DbRegistry;

public class UserTDG {
	public static final String TABLE_NAME = "User";
	public static final String COLUMNS = "username, password ";
	public static final String TRUNCATE_TABLE = "TRUNCATE TABLE  " + TABLE_NAME + ";";
	public static final String DROP_TABLE = "DROP TABLE  " + TABLE_NAME + ";";
	public static final String CREATE_TABLE ="CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" 
			+ "id BIGINT NOT NULL AUTO_INCREMENT, "
			+ "version int, "
			+ "username CHAR(64), "
			+ "password CHAR(64), "
			+ "UNIQUE (username), "
			+ "PRIMARY KEY (id)"
			+ ");";

	public static final String UPDATE = "UPDATE " + TABLE_NAME + " "
			+ "SET version=version+1, "
			+ "username=?, "
			+ "password=? "
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
			+ "VALUES (?,?);";
	
	public static int insert( String username, String password) throws SQLException {
		Connection con = DbRegistry.getDbConnection();
		PreparedStatement ps = con.prepareStatement(INSERT);
		ps.setString(1,username);
		ps.setString(2,password);
		System.out.println(ps.toString());
		return ps.executeUpdate();
	}
	
	public static int update(long id, int version, String username, String password) throws SQLException {
		Connection con = DbRegistry.getDbConnection();
		PreparedStatement ps = con.prepareStatement(UPDATE);
		ps.setLong(1, id);
		ps.setInt(2, version);
		ps.setString(3, username);
		ps.setString(4, password);
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
	
	public static final String FIND_USER = "SELECT * FROM " + TABLE_NAME + " WHERE username=? AND password=?;";
	public static ResultSet find(String username, String password) throws SQLException{
		Connection con = DbRegistry.getDbConnection();
		PreparedStatement ps = con.prepareStatement(FIND_USER);
		ps.setString(1, username);
		ps.setString(2, password);
		return ps.executeQuery();
	}
	
	public static final String FIND_ALL = "SELECT * FROM " + TABLE_NAME + ";";
	public static ResultSet findAll() throws SQLException {
    	Connection con = DbRegistry.getDbConnection();
		PreparedStatement ps = con.prepareStatement(FIND_ALL);
		return ps.executeQuery();
	}
	
}
