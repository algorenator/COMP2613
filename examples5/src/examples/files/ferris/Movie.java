package examples.files.ferris;

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

	public Movie() {
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void writeObject(ObjectOutputStream out) throws IOException {
		out.writeObject(category);
		out.writeObject(title);
	}

	public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		category = (String) in.readObject();
		title = (String) in.readObject();
	}

	@Override
	public String toString() {
		return category + ", " + title;
	}
}
