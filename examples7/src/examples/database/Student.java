package examples.database;

import java.sql.Date;
import java.util.Calendar;

public class Student {
	private String _ssn;
	private String _firstName;
	private String _mi;
	private String _lastName;
	private String _phone;
	private Date _birthDate;
	private String _street;
	private String _zipCode;
	private String _deptID;

	public Student(String ssn, String firstName, String mi, String lastName, String phone, Date birthDate,
	        String street, String zipCode, String deptID) {
		_ssn = ssn;
		_firstName = firstName;
		_mi = mi;
		_lastName = lastName;
		_phone = phone;
		_birthDate = birthDate;
		_street = street;
		_zipCode = zipCode;
		_deptID = deptID;
	}

	public Student(String ssn, String firstName, String mi, String lastName, String phone, String birthDate,
	        String street, String zipCode, String deptID) {
		_ssn = ssn;
		_firstName = firstName;
		_mi = mi;
		_lastName = lastName;
		_phone = phone;
		setBirthDate(birthDate);
		_street = street;
		_zipCode = zipCode;
		_deptID = deptID;
	}

	public Student() {
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return _ssn;
	}

	/**
	 * @param ssn
	 *            the ssn to set
	 */
	public void setSsn(String ssn) {
		_ssn = ssn;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return _firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	/**
	 * @return the mi
	 */
	public String getMi() {
		return _mi;
	}

	/**
	 * @param mi
	 *            the mi to set
	 */
	public void setMi(String mi) {
		_mi = mi;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return _lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return _phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		_phone = phone;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return _birthDate;
	}

	public String getBirthDateString() {
		if (_birthDate == null) {
			return null;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(_birthDate);

		return String.format("%d-%d-%d", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
		        calendar.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		_birthDate = birthDate;
	}

	public void setBirthDate(String birthDate) {
		if (birthDate == null || birthDate.trim().length() == 0 || birthDate.equalsIgnoreCase("null")) {
			// don't set the birthdate
		} else {
			_birthDate = Date.valueOf(birthDate);
		}
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return _street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		_street = street;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return _zipCode;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	/**
	 * @return the deptID
	 */
	public String getDeptID() {
		return _deptID;
	}

	/**
	 * @param deptID
	 *            the deptID to set
	 */
	public void setDeptID(String deptID) {
		_deptID = deptID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [_ssn=" + _ssn + ", _firstName=" + _firstName + ", _mi=" + _mi + ", _lastName=" + _lastName
		        + ", _phone=" + _phone + ", _birthDate=" + _birthDate + ", _street=" + _street + ", _zipCode="
		        + _zipCode + ", _deptID=" + _deptID + "]";
	}

}
