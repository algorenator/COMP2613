package examples.mvc.listmodeldemo2;

import javax.swing.DefaultListModel;
import javax.swing.UIManager;

import examples.mvc.listmodeldemo2.ui.ListModelFrame;
import examples.mvc.listmodeldemo2.ui.UppercaseModel;

public class ListModelDemo2 {

	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception ex) {
			// ignore it
		}

		//DefaultListModel listModel = new PigLatinModel();
		DefaultListModel listModel = new UppercaseModel();
		ListModelFrame frame = new ListModelFrame(listModel);
		frame.setVisible(true);
	}

}
