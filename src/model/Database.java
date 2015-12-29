package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Person> people;
	
	public Database(){
		people = new ArrayList<Person>();
	}
	
	public void addPerson(Person person){
		people.add(person);
	}
	
	public List<Person> getPeople(){
		return people;
	}
	
	
	public void print(){
		

		System.out.println(people.size());
		
	}
	

}
