package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.directory.api.ldap.model.cursor.CursorException;
import org.xml.sax.SAXException;

import controller.Controller;

public class MainForm extends JFrame{

	private UpForm uf;
	private DownForm df;
	private LeftPane lp;
	private JSplitPane sp;
	private JSplitPane spTwo;
	private TopPanel tp;
	private BottomPanel bp;
	private JFileChooser fileChooser;
	private  Controller controller;
	
	
	

	public MainForm(){
		super("Автоматизированное рабочее место специалиста банка");
		
		uf = new UpForm();
		df = new DownForm();
		
		sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, uf, df);
		lp = new LeftPane();
		tp = new TopPanel();
		bp = new BottomPanel();
		spTwo = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lp, sp);
		fileChooser = new JFileChooser();
		
		fileChooser.addChoosableFileFilter(new PersonFileFilter());
		
		controller = new Controller();
		
		
	

			uf.setFormListener(new FormListener(){
			
			public void formEventOccured(FormEvent e){
				/*
				String name = e.getName();
				String occupation = e.getOccupation();
				String ageCat = e.getAgeCat();
				int ageCatId = e.getAgeCatId();
				String emp = e.getEmpVal();
				
				String taxId = e.getTaxId() ;
				
				String gender = e.getGenderValue();
				
			
				
				df.appendText(name+" : "+occupation+ " : " + ageCat +" : "+emp+" : "+ageCatId+" : "+taxId+" : "+ gender+"\n");
				*/
				
				//--------------------------------------------
				
				System.out.println( e.getAgeCat());
				controller.addPerson(e);
				
				df.refresh();
		
			}

		});
		
		
		final JTree tree = lp.getJTree();
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		tree.addTreeSelectionListener(new TreeSelectionListener(){

			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				// TODO Auto-generated method stub
				 DefaultMutableTreeNode node = (DefaultMutableTreeNode)
	                       tree.getLastSelectedPathComponent();
				 System.out.println(node);
				 
				 try {
					controller.checkJTreeNode(node);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CursorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 df.setData(controller.getDatabase());
				 
				 df.refresh();
				 
			}
			
		});
		
		tp.setFormListener(new FormListener(){

			@Override
			public void formEventOccured(FormEvent e) {
				
				if((e.getState()).equals("close")){
					System.out.println("Its close button pushed!!!");
					controller.saveData(e.getState());
					//setVisible(false); 
					//dispose(); 
				}
				
				if((e.getState()).equals("imp")){
					System.out.println("Its imp button pushed!!!");
					controller.loadData(e.getState());
					df.setData(controller.getPeople());
				}
			}
		});
		
		
		
		df.setData(controller.getPeople());
		
		setJMenuBar(createMenu());
		
		setLayout(new BorderLayout());
		
		add(BorderLayout.CENTER,sp);

		add(BorderLayout.WEST,spTwo);
		
		add(BorderLayout.NORTH, tp);		
		
		add(BorderLayout.SOUTH, bp);
		
		this.setSize(1200, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	private JMenuBar createMenu(){
		//Структура реализующая меню на главной форме
		JMenuBar bar = new JMenuBar();
		
		JMenu about = new JMenu("Опрограмме");
		JMenuItem exit = new JMenuItem("Выход");
		JCheckBoxMenuItem info = new JCheckBoxMenuItem("Information");
	
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
		    
		    int action = JOptionPane.showConfirmDialog(MainForm.this, "Do you exit this application?", "ConfirmAction", JOptionPane.OK_CANCEL_OPTION);
	
		if(action == JOptionPane.OK_OPTION){
		//	System.out.println(JOptionPane.OK_OPTION);
		System.exit(0);
		}
			}

		});
		
		//
		//
		about.setMnemonic(KeyEvent.VK_F);
		exit.setMnemonic(KeyEvent.VK_X);
		//
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK ));
		//
		
		info.setSelected(true);
		about.add(info);
		about.add(exit);
		
		
		info.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
		
				JCheckBoxMenuItem item = (JCheckBoxMenuItem)ev.getSource();
				
				tp.setVisible(item.isSelected());
			}	
		});
		
		JMenu docum = new JMenu("Документ");
		JMenuItem import_ = new JMenuItem("Импорт");
		JMenuItem export_ = new JMenuItem("Экспорт");
		docum.add(import_);
		docum.add(export_);
		
		import_.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(fileChooser.showOpenDialog(MainForm.this) == JFileChooser.APPROVE_OPTION){
					System.out.println(fileChooser.getSelectedFile());
					
			
		}
			}
			
			
		});

		export_.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(fileChooser.showSaveDialog(MainForm.this) == JFileChooser.APPROVE_OPTION){
					System.out.println(fileChooser.getSelectedFile());
					
			
		}
			}
			
			
		});
		
		JMenu pravka = new JMenu("Правка");
		JMenu sviaz = new JMenu("Связь");
		JMenu otchet = new JMenu("Отчет");
		JMenu nastroiki = new JMenu("Настройки");
		JMenu service = new JMenu("Сервис");
		JMenu help = new JMenu("Помощь");
	
		bar.add(about);
		bar.add(docum);
		bar.add(pravka);
		bar.add(sviaz);
		bar.add(otchet);
		bar.add(nastroiki);
		bar.add(service);
		bar.add(help);
		
		return bar;
		
		
	}
	

}
