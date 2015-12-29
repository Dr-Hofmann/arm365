package gui;

import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String occupation;
	private String ageCat;
	private int ageCatId;
	private String empVal;
	private String taxId;
	private boolean usCitizen;
	private String genderValue;
	private String state;
	
	public FormEvent(Object source){
		
		super(source);
	}
	

	public FormEvent(Object source, String name, String occupation, String ageCat, int ageCatId, String empVal, String taxId, boolean usCitizen, String genderValue ) {
		super(source);
		
		this.name = name;
		
		this.occupation = occupation;
		
		this.ageCat = ageCat;
		
		this.ageCatId = ageCatId;
		
		this.empVal = empVal;
		
		this.taxId = taxId;
		
		this.usCitizen = usCitizen;
		
		this.genderValue = genderValue;
		

	}
	
	public FormEvent(Object source, String state){
		super(source);
		this.state = state;
	}


	public String getAgeCat() {
		return ageCat;
	}


	public void setAgeCat(String ageCat) {
		this.ageCat = ageCat;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	public int getAgeCatId() {
		return ageCatId;
	}


	public String getTaxId() {
		return taxId;
	}


	public boolean getUsCitizen() {
		return usCitizen;
	}


	public String getEmpVal() {
		return empVal;
	}


	public String getGenderValue() {
		return genderValue;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	
	
	
	

}
