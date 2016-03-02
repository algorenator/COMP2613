package a00904362.data.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a00904362.data.db.Database;

public abstract class Dao {
	private static final Logger LOG = LogManager.getLogger(PlayerDao.class);
	protected final Database _database;
	protected final String _tableName;

	protected Dao(Database database, String tableName) {
		LOG.info("Starting " + getClass().toString());
		_database = database;
		_tableName = tableName;
	}

	public abstract void create() throws SQLException;

	protected void create(String createStatement) throws SQLException {
		Statement statement = null;
		try {
			Connection connection = _database.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(createStatement);
		} finally {
			close(statement);
		}
	}

	protected void add(String updateStatement) throws SQLException {
		Statement statement = null;
		try {
			Connection connection = _database.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(updateStatement);
		} finally {
			close(statement);
		}
	}

	public void drop() throws SQLException {
		Statement statement = null;
		try {
			Connection connection = _database.getConnection();
			statement = connection.createStatement();
			if (_database.tableExists(_tableName)) {
				statement.executeUpdate("drop table " + _tableName);
			}
		} finally {
			close(statement);
		}
	}

	protected void close(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
