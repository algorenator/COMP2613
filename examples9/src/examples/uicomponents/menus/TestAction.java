package examples.uicomponents.menus;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 * A sample action that prints the action name to System.out
 */
@SuppressWarnings("serial")
class TestAction extends AbstractAction {

	public TestAction(String name) {
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println(getValue(Action.NAME) + " selected.");
	}
}
