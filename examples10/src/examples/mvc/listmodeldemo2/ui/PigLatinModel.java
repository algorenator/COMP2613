package examples.mvc.listmodeldemo2.ui;

import javax.swing.DefaultListModel;

@SuppressWarnings("serial")
public class PigLatinModel extends DefaultListModel<String> {

	public PigLatinModel() {
	}

	/**
	 * Add an element to the list. Modify the behaviour of DefaultListModel.addElement to change the text to 'pig-latin'
	 */
	@Override
	public void addElement(String value) {
		char c = value.charAt(0);
		value = String.format("%s-%say", value.substring(1), c);
		super.addElement(value.toUpperCase());
	}

}
