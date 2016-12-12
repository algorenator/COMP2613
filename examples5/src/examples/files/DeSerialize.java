package examples.files;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DeSerialize {
	private static final String FILENAME = "movies.jsr";

	@SuppressWarnings("rawtypes")
	public static void main(String args[]) {
		ArrayList movies = new ArrayList();

		// stream movies back in
		try {
			FileInputStream fileIn = new FileInputStream(FILENAME);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);

			Object o = objectIn.readObject();
			assert (o instanceof ArrayList) : "Bad movie file";
			movies = (ArrayList) o;
			objectIn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("Reconstructed object from " + FILENAME + "\n");
		displayMovies(movies);
	}

	public static void displayMovies(Collection<?> collection) {
		Iterator<?> iterator = collection.iterator();
		while (iterator.hasNext()) {
			Object o = iterator.next();
			System.out.println(o);
		}
	}
}
