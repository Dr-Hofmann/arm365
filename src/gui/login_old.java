package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Dec 16 23:54:25 MSK 2015
 */



/**
 * @author Anton Sotnikov
 */
public class login_old extends JFrame {
	public login_old() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Anton Sotnikov
		Titlelabel = new JLabel();
		LoginField = new JTextField();
		Passwordlabel = new JLabel();
		Loginlabel = new JLabel();
		PasswordField = new JTextField();
		separator1 = new JSeparator();
		LoginButton = new JButton();

		LoginButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				LoginField.getText();
				
				System.out.println(LoginField.getText()+" "+PasswordField.getText());
				
			}
			
			
			
		});
		
		//======== this ========
		Container contentPane = getContentPane();

		//---- Titlelabel ----
		Titlelabel.setText("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0418\u043c\u044f \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f/\u043f\u0430\u0440\u043e\u043b\u044c");

		//---- Passwordlabel ----
		Passwordlabel.setText("PASSWORD");

		//---- Loginlabel ----
		Loginlabel.setText("LOGIN");
		Loginlabel.setFont(Loginlabel.getFont().deriveFont(Loginlabel.getFont().getStyle() | Font.ITALIC));

		//---- LoginButton ----
		LoginButton.setText("Login");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator1, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(53, 53, 53)
							.addComponent(Titlelabel, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(62, 62, 62)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(Loginlabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addComponent(Passwordlabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
							.addGap(31, 31, 31)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
									.addComponent(LoginField, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
									.addComponent(PasswordField, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(18, 18, 18)
					.addComponent(Titlelabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(separator1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(Loginlabel)
						.addComponent(LoginField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(Passwordlabel)
						.addComponent(PasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addComponent(LoginButton)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Anton Sotnikov
	private JLabel Titlelabel;
	private JTextField LoginField;
	private JLabel Passwordlabel;
	private JLabel Loginlabel;
	private JTextField PasswordField;
	private JSeparator separator1;
	private JButton LoginButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
