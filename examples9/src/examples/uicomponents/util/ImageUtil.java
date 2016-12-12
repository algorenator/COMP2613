package examples.uicomponents.util;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * @author sam
 * 
 */
public class ImageUtil {

	public static Image loadImage(Class<?> clazz, final String name) throws IOException {
		InputStream stream = clazz.getResourceAsStream(name);
		if (stream == null) {
			throw new IOException("Cannot load " + name);
		}

		return ImageIO.read(stream);
	}

	/**
	 * Load a image resource. Same as loadImage, but does not throw an exception
	 * 
	 * @param clazz
	 * @param name
	 * @return
	 */
	public static Image loadImage2(Class<?> clazz, final String name) {
		InputStream stream = clazz.getResourceAsStream(name);
		if (stream == null) {
			return null;
		}

		try {
			return ImageIO.read(stream);
		} catch (IOException e) {
			return null;
		}
	}
}
