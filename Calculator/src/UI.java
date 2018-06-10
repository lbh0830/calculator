import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI extends JPanel{
	JLabel showlbl= new JLabel("0",JLabel.RIGHT);
	JButton btn[];
	static String[] btn_str = 
		{"(",")","C","DEL",
		 "7","8","9","÷",
		 "4","5","6","×",
		 "1","2","3","-",
		 "0",".","=","+"
		};
	
	public UI() {
		setLayout(new GridLayout(5,4,10,10));
		showlbl.setFont(new Font("Monospaced",Font.BOLD,40));
		showlbl.setSize(600, 200);
		showlbl.setOpaque(true);		//設定不透明
		showlbl.setBackground(new Color(220,220,220));
		btn = new JButton[btn_str.length];	
		for(int i=0;i<btn_str.length;i++) {
			btn[i] = new JButton(btn_str[i]);
			btn[i].setFont(new Font("Monospaced",Font.BOLD,25));
			btn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LabelContent.setContent(showlbl, e);
				}
			});
			add(btn[i]);
		}
	}
	
}
