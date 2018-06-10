import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class LabelContent {
	static String temp;
	static void setContent(JLabel lab, ActionEvent e) {
		temp = lab.getText();
		String src = e.getActionCommand();
		if(src.equals("DEL")) {
			if(temp.length()!=1)
				lab.setText(temp.substring(0, temp.length()-1));
			else
				lab.setText("0");
		}
		else if(src.equals("C")) {
			lab.setText("0");
		}
		else if(src.equals("=")) {
			
		}
		else {
			if(lab.getText().equals("0") && !src.equals("."))
				lab.setText(src);
			else
				lab.setText(temp.concat(src));
		}
		
		
	}
}
