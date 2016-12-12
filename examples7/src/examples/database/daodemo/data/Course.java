package examples.database.daodemo.data;

// courseId VARCHAR(10), subjectId VARCHAR(4), courseNumber VARCHAR(4), title VARCHAR(64), numOfCredits INTEGER, primary key (courseId) )";

public class Course {

	private String _courseId;
	private String _subjectId;
	private String _courseNumber;
	private String _title;
	private Integer _numOfCredits;

	public Course(String courseId, String subjectId, String courseNumber, String title, int numOfCredits) {
		_courseId = courseId;
		_subjectId = subjectId;
		_courseNumber = courseNumber;
		_title = title;
		_numOfCredits = numOfCredits;
	}

	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return _courseId;
	}

	/**
	 * @param courseId
	 *            the courseId to set
	 */
	public void setCourseId(String courseId) {
		_courseId = courseId;
	}

	/**
	 * @return the subjectId
	 */
	public String getSubjectId() {
		return _subjectId;
	}

	/**
	 * @param subjectId
	 *            the subjectId to set
	 */
	public void setSubjectId(String subjectId) {
		_subjectId = subjectId;
	}

	/**
	 * @return the courseNumber
	 */
	public String getCourseNumber() {
		return _courseNumber;
	}

	/**
	 * @param courseNumber
	 *            the courseNumber to set
	 */
	public void setCourseNumber(String courseNumber) {
		_courseNumber = courseNumber;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return _title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		_title = title;
	}

	/**
	 * @return the numOfCredits
	 */
	public Integer getNumOfCredits() {
		return _numOfCredits;
	}

	/**
	 * @param numOfCredits
	 *            the numOfCredits to set
	 */
	public void setNumOfCredits(Integer numOfCredits) {
		_numOfCredits = numOfCredits;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Course [_courseId=" + _courseId + ", _subjectId=" + _subjectId + ", _courseNumber=" + _courseNumber
		        + ", _title=" + _title + ", _numOfCredits=" + _numOfCredits + "]";
	}
}
