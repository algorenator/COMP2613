package examples.files.ferris;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;

public class DeSerializeXML {

	private static final String FILENAME = "movies.xml";

	@SuppressWarnings("unchecked")
	public static void main(String args[]) {

		ArrayList<Movie> movies = null;

		// stream movies back in
		try {
			XMLDecoder in = new XMLDecoder(new BufferedInputStream(new FileInputStream(FILENAME)));
			movies = (ArrayList<Movie>) in.readObject();
			in.close();
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
