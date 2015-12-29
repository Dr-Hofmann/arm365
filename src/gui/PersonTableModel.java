package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Person;

public class PersonTableModel extends AbstractTableModel {
	
	private	List<Person> db;
	
	private String[] colNames = {"ID", "NAME", "OCCUPATION", "AGE Category", "EmpCategory", "Us Citizen", "Tax ID"};
	

	public PersonTableModel() {

	}


	public void setData(List<Person> db) {
		this.db = db;
	}

	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return db.size();
		//return 23;
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
		
	}
	
	
	

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}


	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Person person = db.get(row);
		
		switch(col){
		
		case 0:
			return person.getId();
			
		case 1:
			return person.getName();
			
		case 2:
			return person.getOccupation();
			
		case 3:
			return person.getAgeCat();
		case 4:
			return person.getEmpVal();
			
		case 5:
			return person.isUsCitizen();
			
		case 6:
			return person.getTaxId();
			
			
			
			
		}
		
		return null;
	}

}
