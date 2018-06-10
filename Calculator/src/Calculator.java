import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Calculator extends JFrame{
	public void run() {
		UI ui = new UI();
		setSize(400,400);
		setTitle("¤pºâ½L");
		setLayout(new BorderLayout());
		add(ui.showlbl,BorderLayout.NORTH);
		add(ui,BorderLayout.CENTER);
		setVisible(true);
	}
	
	static public void main(String[] args) {
		Calculator cal = new Calculator();
		cal.run();
	}
}
