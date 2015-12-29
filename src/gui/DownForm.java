package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.Person;

public class DownForm extends JPanel{
	
	

	private JTable table;
	private PersonTableModel tableModel;
	

	
	
	public DownForm() {
		
		this.setPreferredSize(new Dimension(1200, 300));
		
		tableModel = new PersonTableModel();
		
		table = new JTable(tableModel);
		
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem menuItemAdd = new JMenuItem("Add New Row");
		JMenuItem menuItemRemove = new JMenuItem("Remove Current Row");
		JMenuItem menuItemRemoveAll = new JMenuItem("Remove All Rows");
		 
		popupMenu.add(menuItemAdd);
		popupMenu.add(menuItemRemove);
		popupMenu.add(menuItemRemoveAll);
 
		
		
		  	table.setPreferredScrollableViewportSize(new Dimension(800, 450));
	        table.setFillsViewportHeight(true);

	        JScrollPane js=new JScrollPane(table);
	        js.setVisible(true);
	        add(js);
	        table.setPreferredSize(new Dimension(800, 450));
	 
		
	        table.setComponentPopupMenu(popupMenu);
		
	        setLayout(new BorderLayout());
		
		add(BorderLayout.CENTER, new JScrollPane(table));
		
		
		
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        int row = table.rowAtPoint(p);
		       
		     //   PupolsInputform pup = new PupolsInputform();
		        
		        if (me.getClickCount() == 2) {
		            
		            String[] result = new String[table.getColumnCount()];
		            
		            for(int i=0;i<table.getColumnCount(); i++)
		            {
		            	
		            	System.out.println(table.getModel().getValueAt(row, i).toString());
		      
		 //              pup.getTextField(i).setText(table.getModel().getValueAt(row, i).toString());
		               
		            }
		        
		//           pup.setVisible(true);
		            
		        }
		    }
		});

		
		
		
	//	table.getModel().addTableModelListener(this);
		
	}

	/*
	public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);

      System.out.println("\n"+data.toString());
    }
	*/
	public void setData(List<Person> db){

		tableModel.setData(db);
	}
	
	
	
	public void refresh(){
	
		tableModel.fireTableDataChanged();
	}
	
	

	
	}
