package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {

	JLabel label;
	
	public BottomPanel() {
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.setPreferredSize(new Dimension(1200, 50));
		
		label = new JLabel("This is a BottomPanel!!");
		
		this.setLayout(new BorderLayout());
		
		add(BorderLayout.CENTER, label);

	}

}
