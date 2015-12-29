package parser;



import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;


public class SaxPerson extends DefaultHandler {
	
	
	
	Person pr = new  Person();
	
	Database db = new Database();
	
	String thisElement = ""; 
	
	public Database getResult(){ 
		  return db; 
		}

	public Person getPerson(){
		return pr;
	}
	
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		 if (thisElement.equals("name")) { 
			 pr.setName(new String(ch, start, length));
		 }
		 
		 if (thisElement.equals("occupation")) { 
			 pr.setOccupation(new String(ch, start, length));
		 }
		 if (thisElement.equals("ageCat")) { 
			 pr.setAgeCat(AgeCategory.valueOf(new String(ch, start, length)));
		 }
		 
		 if (thisElement.equals("empCat")) { 
			 pr.setEmpVal(EmploymentCategory.valueOf(new String(ch, start, length)));
		 }
		 if (thisElement.equals("taxId")) { 
			 pr.setId(new Integer(new String(ch, start, length)));
		 }
		 if (thisElement.equals("usCitizen")) { 
			 pr.setUsCitizen(new Boolean(new String(ch, start, length)));
		 }
		 if (thisElement.equals("gender")) { 
			 pr.setGenderValue(Gender.valueOf(new String(ch, start, length)));
		 }
		
	}

	@Override
	public void endDocument() throws SAXException {
		 System.out.println("Stop parse XML..."); 
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		thisElement = ""; 
	}

	@Override
	public void startDocument() throws SAXException {
		 System.out.println("Start parse XML..."); 
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		  thisElement = qName; 
	} 
	
	
	
	
}
