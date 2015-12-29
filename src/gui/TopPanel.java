package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel {

	JButton create;
	JButton open;
	JButton select;
	JButton find;
	JButton exchange;
	JButton imp = new JButton("������");
	JButton exp;
	JButton report;
	JButton exit = new JButton("�������");
	FormListener formListener;

	public TopPanel() {

		setPreferredSize(new Dimension(1200, 60));

		setBorder(BorderFactory.createLineBorder(Color.black));

		this.setLayout(new GridLayout(0, 9));

		create = new JButton("�������");
		Dimension dim = create.getPreferredSize();
		dim.height = 80;
		create.setPreferredSize(dim);

		add(create);

		add(new JButton("�������"));
		add(new JButton("�����"));
		add(imp);
		add(new JButton("�������"));
		add(new JButton("������"));
		add(exit);

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String closeMessage = "close";
				FormEvent ev = new FormEvent(this, closeMessage);

				if (formListener != null) {
					formListener.formEventOccured(ev);

				}
			}

		});
		
		
		imp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String Message = "imp";
				FormEvent ev = new FormEvent(this, Message);

				if (formListener != null) {
					formListener.formEventOccured(ev);

				}
			}

		});
		
		
	}

	public void setFormListener(FormListener listener) {
		this.formListener = listener;

	}

}
