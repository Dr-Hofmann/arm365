package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.directory.api.ldap.model.cursor.CursorException;
import org.xml.sax.SAXException;

import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;
import parser.SaxProcessor;
import gui.FormEvent;
import jdbc.PersonJdbc;
import ldap.ldapConnection;

public class Controller {
	String dataState = null;
	Database db  = new Database();
	Database works = new Database();
	Database outbox = new Database();
	ArrayList hashes;

	public List<Person> getPeople(){
		
		return db.getPeople();
	}
	
		public List<Person> getOutbox(){
		
		return outbox.getPeople();
	}
	
		
	
	public List<Person> getDatabase(){
		
		if(dataState.equals("Рабочие")){
			return works.getPeople();
		}
		
		if(dataState.equals("Входящие")){
			return db.getPeople();
		}
		
	return null;
	}
	
	public void addPerson(FormEvent ev){
		
		String name = ev.getName();
		
		String occupation = ev.getOccupation();
		
		//String ageCat = ev.getAgeCat();
		
		int ageCatId = ev.getAgeCatId();
		
		String empCat =ev.getEmpVal();
		
		
		String taxId = ev.getTaxId();
		
		String gender = ev.getGenderValue();
		
		boolean usCitizen = ev.getUsCitizen();
		
		
		AgeCategory ageCategory = null;
		switch(ageCatId){
		
		case 0:
		ageCategory = AgeCategory.child;
		break;
		
		case 1:
			ageCategory = AgeCategory.adult;
			break;
			
		case 2:
			ageCategory = AgeCategory.senior;
			break;
		}
		
		EmploymentCategory empCategory = null;
		if(empCat.equals("Employed")){
			empCategory = EmploymentCategory.employed;
		}
		if(empCat.equals("Self-employed")){
			empCategory = EmploymentCategory.self_employed;
		}
		
		if(empCat.equals("unemployed")){
			empCategory = EmploymentCategory.unemployed;
		}
		
		if(empCat.equals("other")){
			empCategory = EmploymentCategory.other;
		}
		

		Gender genderCat=null;
		
		if(gender.equals("male")){
			genderCat = Gender.male;
		}
		if(gender.equals("female")){
			genderCat = Gender.female;
		}
		
		
		
		Person person = new Person(name, occupation, ageCategory, empCategory, taxId,usCitizen, genderCat);
		

		db.addPerson(person);
		

		//db.print();
		//System.out.println();
		
		
	}
	
	public void checkJTreeNode(DefaultMutableTreeNode node) throws FileNotFoundException, SAXException, ParserConfigurationException, IOException, CursorException{
		if(node.toString()=="Рабочие"){
			works.addPerson(new Person("John", "16", AgeCategory.child, EmploymentCategory.self_employed, "20", true, Gender.male));
			System.out.println("Проверка прошла - выбран 'Рабочие'");
			dataState = "Рабочие";
		
			
			new SaxProcessor();
			
			new  PersonJdbc();
			
			hashes = this.hashDataGenerator();
			
			printHashes(hashes);
			
			new ldapConnection();
			
			
		}
		
		if(node.toString()=="Входящие"){
			//works.addPerson(new Person("John", "16", AgeCategory.child, EmploymentCategory.self_employed, "20", true, Gender.male));
			System.out.println("Проверка прошла - выбран 'Входящие'");
			dataState = "Входящие";
		}
	}
	
	
	public void saveData(String str){
		if(str.equals("close")){
			System.out.println("Save data");
			try  
			  {  
			   FileOutputStream fileOut = new FileOutputStream("employee.ser");  
			   ObjectOutputStream outStream = new ObjectOutputStream(fileOut);  
			   outStream.writeObject(db);  
			   outStream.close();  
			   fileOut.close();  
			  }catch(IOException i)  
			  {  
			   i.printStackTrace();  
			  }  

		
		}
	}

	
	public void loadData(String str){
		if(str.equals("imp")){
			System.out.println("load data");
			 try  
			  {  
			   FileInputStream fileIn =new FileInputStream("employee.ser");  
			   ObjectInputStream in = new ObjectInputStream(fileIn);  
			  db = (Database) in.readObject();  
			   in.close();  
			   fileIn.close();  
			  }catch(IOException i)  
			  {  
			   i.printStackTrace();  
			   return;  
			  }catch(ClassNotFoundException c)  
			  {  
			   System.out.println("Employee class not found");  
			   c.printStackTrace();  
			   return;  
			  }  

		
			
		}
	}
	
	public ArrayList hashDataGenerator(){
		 hashes = new ArrayList();
		int hash;
		for(int i = 0; i < db.getPeople().size(); i++){
			Person temp = db.getPeople().get(i);
			hash = temp.hashCode();
			hashes.add(hash);
		//	System.out.println("Hash is" + hashes.get(i).toString());
		}	
		return hashes;	
	}

	
		public void printHashes(ArrayList arr){
			
			for(int i = 0; i < arr.size(); i++){
				System.out.println("Hash is" + arr.get(i).toString()+" "+i);
				
			}
			
			
		}
	
	
}
