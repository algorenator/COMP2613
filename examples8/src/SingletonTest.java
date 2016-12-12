
public class SingletonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Database db = Database.getTheInstance();
		
		System.out.println(db.getTheData());
	}

}
