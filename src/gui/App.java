package gui;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		//��������� JFrame � ��������� ������ 
		//����� ������� ��� ������� swing ����������
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
			new login().setVisible(true);;
				//new MainForm();

			}
			
		});
		

	}

}
