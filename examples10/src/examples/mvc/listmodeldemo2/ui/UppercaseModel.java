package examples.mvc.listmodeldemo2.ui;

import javax.swing.DefaultListModel;

@SuppressWarnings("serial")
public class UppercaseModel extends DefaultListModel<String> {

	public UppercaseModel() {
	}

	/**
	 * Add an element to the list. Modify the behaviour of DefaultListModel.addElement to change the text to 'pig-latin'
	 */
	@Override
	public void addElement(String value) {
		super.addElement(value.toUpperCase());
	}

}
