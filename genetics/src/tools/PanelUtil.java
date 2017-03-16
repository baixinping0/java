package tools;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelUtil {
//	jScrollPane1.setBounds(0, 0, 1334, 672);
//	jPanel1.setPreferredSize(new java.awt.Dimension(1386, 772));
//	this.setSize(1350,710);
	
	public static int windowLeng = 1350;
	public static int windowWidth = 710;
	
	public static void changePanel(JFrame frame, JPanel panel){
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panel);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	public static void changePanel1(JScrollPane scrollPane, JPanel panel){
		
		scrollPane.removeAll();
		scrollPane.add(panel);
		scrollPane.validate();
		scrollPane.repaint();
	}
	
}
