package examples.files.ferris;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SerializeXML {

	private static final String FILENAME = "movies.xml";
	private static final String[][] DATA = { { "Drama", "Elizabeth I" }, //
	        { "Action", "The Bourne Supremacy" },//
	        { "Comedy", "Ferris Bueller's Day Off" }, //
	        { "Cartoon", "Cars" } };

	public static void main(String args[]) {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		for (String[] data : DATA) {
			movies.add(new Movie(data[0], data[1]));
		}

		// stream the movies out to a file
		XMLEncoder out = null;
		try {
			out = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILENAME)));
			out.writeObject(movies);
			System.out.println("Finished writing movies to " + FILENAME);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			out.close();
		}
	}
}
