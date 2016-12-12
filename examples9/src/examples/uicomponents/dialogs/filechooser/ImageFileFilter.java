package examples.uicomponents.dialogs.filechooser;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ImageFileFilter extends FileFilter {

	@Override
	public boolean accept(File file) {
		String filename = file.getName();
		return filename.endsWith("jpg") || filename.endsWith("jpeg") || filename.endsWith("gif");
	}

	@Override
	public String getDescription() {
		return "Image files";
	}
}
