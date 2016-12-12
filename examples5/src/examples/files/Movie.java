package examples.files;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Movie implements Serializable {

	private String category;
	private String title;

	public Movie(String category, String title) {
		this.category = category;
		this.title = title;
	}

	@Override
	public String toString() {
		return "CATEGORY=" + category + "\t" + "TITLE=" + title;
	}

	public void writeObject(ObjectOutputStream out) throws IOException {
		out.writeObject(category);
		out.writeObject(title);
	}

	public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		category = (String) in.readObject();
		title = (String) in.readObject();
	}
}
