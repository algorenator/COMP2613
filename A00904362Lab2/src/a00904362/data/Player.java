/**
 * Project: A00904362Lab2
 * File: Player.java
 * Date: Jan 26, 2016
 * Time: 4:53:36 PM
 */

package a00904362.data;

import a00904362.utils.Validator;

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
	 * @param lastname
	 * @param email
	 * @param gamertag
	 */
	public Player(int id, String firstname, String lastname, String email, String gamertag) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
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

	public void setId(String id) {
		this.id = Validator.validate_id(id);
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
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param emal
	 *            the emal to set
	 */
	public void setEmail(String email) {
		this.email = (Validator.validate_email(email)) ? email : "N/A";
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
		return "Player [id=" + id + ", firstname=" + firstname + ", lasttname=" + lastname + ", email=" + email
				+ ", gamertag=" + gamertag + "]";
	}

}
