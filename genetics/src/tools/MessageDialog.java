package tools;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MessageDialog {
	public static void showMessage(String str, JFrame frame){
		JOptionPane.showMessageDialog(frame.getContentPane(), str, "消息提示!", JOptionPane.INFORMATION_MESSAGE);
		return;
	}
}
