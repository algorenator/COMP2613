/**
 * Project: A00904362Lab7
 * File: PlayerDao.java
 * Date: Feb 29, 2016
 * Time: 2:52:55 PM
 */

package a00904362.data.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import a00904362.NotFoundException;
import a00904362.data.Player;
import a00904362.data.db.Database;

/**
 * @author Alexey Gorbenko, A00904362
 *
 */

public class PlayerDao extends Dao {

	private final static String table_name = "A00904362_Player";

	public PlayerDao(Database database) {
		super(database, table_name);
	}

	public Player createValueObject() {
		return new Player();
	}

	public Player getObject(int id) throws NotFoundException, SQLException {
		Player valueObject = createValueObject();
		valueObject.setId(id);
		load(valueObject);
		return valueObject;
	}

	public void load(Player valueObject) throws NotFoundException, SQLException {

		String sql = "SELECT * FROM " + table_name + " WHERE (id = ? ) ";
		PreparedStatement stmt = null;

		try {
			Connection conn = _database.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getId());

			singleQuery(stmt, valueObject);

		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	public List<Player> loadAll() throws SQLException {
		Connection conn = _database.getConnection();
		String sql = "SELECT * FROM " + table_name + " ORDER BY id ASC ";
		List<Player> searchResults = listQuery(conn.prepareStatement(sql));

		return searchResults;
	}

	public synchronized void create(Player valueObject) throws SQLException {

		String sql = "";
		PreparedStatement stmt = null;

		try {
			Connection conn = _database.getConnection();
			sql = "INSERT INTO " + table_name + " ( id, firstname, lastname, "
					+ "email, gamertag, dob) VALUES (?, ?, ?, ?, ?, ?) ";
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, valueObject.getId());
			stmt.setString(2, valueObject.getFirstname());
			stmt.setString(3, valueObject.getLastname());
			stmt.setString(4, valueObject.getEmail());
			stmt.setString(5, valueObject.getGamertag());
			// stmt.setDate(6, valueObject.getDob());
			stmt.setDate(6, new Date(valueObject.getDob().getTime().getTime()));

			int rowcount = databaseUpdate(stmt);
			if (rowcount != 1) {
				// System.out.println("PrimaryKey Error when updating DB!");
				throw new SQLException("PrimaryKey Error when updating DB!");
			}

		} finally {
			if (stmt != null)
				stmt.close();
		}

	}

	public void fillPlayers(List<Player> players) throws SQLException {
		for (Player pl : players) {
			create(pl);
		}
	}

	public void save(Player valueObject) throws NotFoundException, SQLException {

		String sql = "UPDATE " + table_name + " SET firstname = ?, lastname = ?, email = ?, "
				+ "gamertag = ?, dob = ? WHERE (id = ? ) ";
		PreparedStatement stmt = null;

		try {
			Connection conn = _database.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, valueObject.getFirstname());
			stmt.setString(2, valueObject.getLastname());
			stmt.setString(3, valueObject.getEmail());
			stmt.setString(4, valueObject.getGamertag());
			stmt.setDate(6, new Date(valueObject.getDob().getTime().getTime()));

			stmt.setInt(6, valueObject.getId());

			int rowcount = databaseUpdate(stmt);
			if (rowcount == 0) {
				// System.out.println("Object could not be saved! (PrimaryKey not found)");
				throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
			}
			if (rowcount > 1) {
				// System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
				throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
			}
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	public void delete(Player valueObject) throws NotFoundException, SQLException {

		String sql = "DELETE FROM " + table_name + " WHERE (id = ? ) ";
		PreparedStatement stmt = null;

		try {
			Connection conn = _database.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getId());

			int rowcount = databaseUpdate(stmt);
			if (rowcount == 0) {
				// System.out.println("Object could not be deleted (PrimaryKey not found)");
				throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
			}
			if (rowcount > 1) {
				// System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
				throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
			}
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	public void deleteAll() throws SQLException {

		String sql = "DELETE FROM " + table_name;
		PreparedStatement stmt = null;

		try {
			Connection conn = _database.getConnection();
			stmt = conn.prepareStatement(sql);
			@SuppressWarnings("unused")
			int rowcount = databaseUpdate(stmt);
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	public int countAll() throws SQLException {

		String sql = "SELECT count(*) FROM " + table_name;
		PreparedStatement stmt = null;
		ResultSet result = null;
		int allRows = 0;

		try {
			Connection conn = _database.getConnection();
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();

			if (result.next())
				allRows = result.getInt(1);
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}
		return allRows;
	}

	public List<String> getGamerTags() throws SQLException {
		List<Player> searchResults = loadAll();

		List<String> tags = new ArrayList<String>();
		for (Player pl : searchResults) {
			tags.add(pl.getGamertag());
		}

		return tags;
	}

	@SuppressWarnings("unchecked")
	public Player getPlayerByTag(String tag) throws SQLException, NotFoundException {
		Player player = new Player();
		// List <Player> player_result =new ArrayList<Player>() ;
		player.setGamertag(tag);
		List<Player> player_result = (List<Player>) searchMatching(player);

		if (player_result.size() == 0) {
			// System.out.println("Player Object Not Found!");
			throw new NotFoundException("Player Object by tag Not Found!");
		}
		return player_result.get(0);

	}

	public List<?> searchMatching(Player valueObject) throws SQLException {
		Connection conn = _database.getConnection();
		List<?> searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM " + table_name + " WHERE 1=1 ");

		if (valueObject.getId() != 0) {
			if (first) {
				first = false;
			}
			sql.append("AND id = ").append(valueObject.getId()).append(" ");
		}

		if (valueObject.getFirstname() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND firstname LIKE '").append(valueObject.getFirstname()).append("%' ");
		}

		if (valueObject.getLastname() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND lastname LIKE '").append(valueObject.getLastname()).append("%' ");
		}

		if (valueObject.getEmail() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND email LIKE '").append(valueObject.getEmail()).append("%' ");
		}

		if (valueObject.getGamertag() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND gamertag LIKE '").append(valueObject.getGamertag()).append("%' ");
		}

		if (valueObject.getDob() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND dob = '").append(valueObject.getDob()).append("' ");
		}

		sql.append("ORDER BY id ASC ");

		if (first)
			searchResults = new ArrayList<Player>();
		else
			searchResults = listQuery(conn.prepareStatement(sql.toString()));

		return searchResults;
	}

	protected int databaseUpdate(PreparedStatement stmt) throws SQLException {

		int result = stmt.executeUpdate();

		return result;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return table_name;
	}

	protected void singleQuery(PreparedStatement stmt, Player valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;

		try {

			result = stmt.executeQuery();

			if (result.next()) {

				valueObject.setId(result.getInt("id"));
				valueObject.setFirstname(result.getString("firstname"));
				valueObject.setLastname(result.getString("lastname"));
				valueObject.setEmail(result.getString("email"));
				valueObject.setGamertag(result.getString("gamertag"));
				valueObject.setDob(result.getDate("dob"));

			} else {
				// System.out.println("Player Object Not Found!");
				throw new NotFoundException("Player Object Not Found!");
			}
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}
	}

	protected List<Player> listQuery(PreparedStatement stmt) throws SQLException {

		ArrayList<Player> searchResults = new ArrayList<Player>();
		ResultSet result = null;

		try {
			result = stmt.executeQuery();

			while (result.next()) {
				Player temp = createValueObject();

				temp.setId(result.getInt("id"));
				temp.setFirstname(result.getString("firstname"));
				temp.setLastname(result.getString("lastname"));
				temp.setEmail(result.getString("email"));
				temp.setGamertag(result.getString("gamertag"));
				temp.setDob(result.getDate("dob"));

				searchResults.add(temp);
			}

		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}

		return (List<Player>) searchResults;
	}

	/*
	 * (non-Javadoc)
	 * @see a00904362.data.dao.Dao#create()
	 */
	@Override
	public void create() throws SQLException {

		String createStatement = "CREATE TABLE  " + table_name
				+ " (id bigint NOT NULL,firstname varchar(255),lastname varchar(255),email varchar(255),gamertag varchar(255),dob date)";
		super.create(createStatement);

	}

}
