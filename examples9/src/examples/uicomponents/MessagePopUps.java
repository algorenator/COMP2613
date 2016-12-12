package examples.uicomponents;

/**
 *
 * @author Fred Fish, A00123456
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MessagePopUps {

	public static void main(String[] a) {
		JFrame parent = new JFrame();

		String answer = JOptionPane.showInputDialog(parent, "Enter something", "This is an Input Dialog",
				JOptionPane.INFORMATION_MESSAGE);
		int buttonPressed = JOptionPane.showConfirmDialog(parent, "You entered " + answer);
		String message = null;
		if (buttonPressed == JOptionPane.YES_OPTION) {
			message = "YES";
		} else if (buttonPressed == JOptionPane.NO_OPTION) {
			message = "NO";
		} else if (buttonPressed == JOptionPane.CANCEL_OPTION) {
			message = "CANCEL";
		} else {
			message = "I'm confused...";
		}
		JOptionPane.showConfirmDialog(parent, "You pressed " + message, "More options confirmation dialog",
				JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(parent, "Bye!");
	}
}
