/**
 * Project: A00904362Lab1
 * File: Player.java
 * Date: Jan 19, 2016
 * Time: 4:53:36 PM
 */

package a00904362.data;

/**
 * @author Alexey Gorbenko, A00904362
 *
 */

public class Player {
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String gamertag;

	/**
	 * 
	 */
	public Player() {
		super();
	}

	/**
	 * @param id
	 * @param firstname
	 * @param lasttname
	 * @param email
	 * @param gamertag
	 */
	public Player(int id, String firstname, String lasttname, String email, String gamertag) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lasttname;
		this.email = email;
		this.gamertag = gamertag;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lasttname
	 *            the lastname to set
	 */
	public void setLastname(String lasttname) {
		this.lastname = lasttname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param emal
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the gamertag
	 */
	public String getGamertag() {
		return gamertag;
	}

	/**
	 * @param gamertag
	 *            the gamertag to set
	 */
	public void setGamertag(String gamertag) {
		this.gamertag = gamertag;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [id=" + id + ", firstname=" + firstname + ", lasttname=" + lastname + ", emal=" + email
				+ ", gamertag=" + gamertag + "]";
	}

}
