package model.database;

import model.Level;

import java.lang.String;
import java.sql.*;
import java.sql.SQLException;


/**
 * The Class DBConnection.
 *
 * @author Marie
 */
public final class DBConnection {
	/** The instance. */
	private static DBConnection	INSTANCE = null;

	/** The connection. */
	private Connection	connection;

	/**
	 * Instantiates a new DB connection.
	 */
	private DBConnection() {
		this.open();
	}

	public ResultSet findLevel(int id) throws SQLException {
		final String sql = "{CALL get_level_by_id(?)}";
		final CallableStatement call = this.getConnection().prepareCall(sql);
		call.setInt(1, id);
		call.execute();
		return call.getResultSet();
	}

	public ResultSet findElements(int levelId) throws SQLException{
		final String sql = "{CALL get_elements_by_level(?)}";
		final CallableStatement call = this.getConnection().prepareCall(sql);
		call.setInt(1, levelId);
		call.execute();
		return call.getResultSet();
	}

	/**
	 * Gets the single instance of DBConnection.
	 *
	 * @return single instance of DBConnection
	 */
	public static synchronized DBConnection getInstance() {
		if (DBConnection.INSTANCE == null) {
			DBConnection.INSTANCE = new DBConnection();
		}
		return DBConnection.INSTANCE;
	}

	/**
	 * Open.
	 *
	 * @return the boolean
	 */
	private Boolean open() {
		final DBProperties dbProperties = new DBProperties();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting database url: "+dbProperties.getUrl()+" user: "+dbProperties.getLogin());
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(), dbProperties.getPassword());
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}


}
