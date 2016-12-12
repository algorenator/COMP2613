package examples.uicomponents.dialogs.filechooser;

import java.io.File;

import javax.swing.Icon;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

/**
 * A file view that displays an icon for all files that match a file filter.
 */
class FileIconView extends FileView {

	private final FileFilter filter;
	private final Icon icon;

	/**
	 * Constructs a FileIconView.
	 * 
	 * @param aFilter
	 *            a file filter--all files that this filter accepts will be shown with the icon.
	 * @param anIcon
	 *            --the icon shown with all accepted files.
	 */
	public FileIconView(FileFilter filter, Icon anIcon) {
		this.filter = filter;
		icon = anIcon;
	}

	@Override
	public Icon getIcon(File f) {
		if (!f.isDirectory() && filter.accept(f)) {
			return icon;
		} else {
			return null;
		}
	}
}
