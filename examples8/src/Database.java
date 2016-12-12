
public class Database {
	
	private static Database theInstance;
	
	private String theData;
	
	private Database() {
		theData = "This is a Singleton design pattern test";
	}
	
	public static Database getTheInstance() {
		if (theInstance == null) {
			theInstance = new Database();
		}
		
		return theInstance;
	}
	
	public Object getTheData() {
		return theData;
	}

}
