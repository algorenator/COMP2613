package examples.files.ferris;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;

public class DeSerialize {
	private static final String FILENAME = "movies.out";

	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		ArrayList<Movie> movies = new ArrayList<Movie>();

		// stream movies back in
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(FILENAME));
			Object o = objectIn.readObject();
			assert (o instanceof ArrayList<?>) : "Bad movie file";
			movies = (ArrayList<Movie>) o;
			objectIn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("Reconstructed object from " + FILENAME + "\n");
		showMovies(movies);
	}

	@SuppressWarnings("rawtypes")
	public static void showMovies(Collection collection) {
		for (Object o : collection) {
			System.out.println(o);
		}
	}
}
