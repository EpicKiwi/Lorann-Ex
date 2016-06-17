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

	public Level find(final int id) {
		Level level = new Level(id);

		try {
			final String sql = "{call lvl(?)ID}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				level = new Level(id, resultSet.getString("id"));

			}
			return level;
		} catch (final SQLException e){
			e.printStackTrace();
		}
		return null;
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
