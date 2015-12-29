package gui;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		//Запускает JFrame в отдельном потоке 
		//Некое правило для запуска swing приложений
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
			new login().setVisible(true);;
				//new MainForm();

			}
			
		});
		

	}

}
