package model;

import java.io.Serializable;

public class Person implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private static int count = 0;
	
	private int id;
	private String name;
	private String occupation;
	private AgeCategory ageCat;
	
	private EmploymentCategory empVal;
	private String taxId;
	private boolean usCitizen;
	private Gender genderValue;
	
	public Person(){
		
	}

	public Person(String name, String occupation, AgeCategory ageCat,
			 EmploymentCategory empVal, String taxId,
			boolean usCitizen, Gender genderValue) {
		super();
		this.name = name;
		this.occupation = occupation;
		this.ageCat = ageCat;
		
		this.empVal = empVal;
		this.taxId = taxId;
		this.usCitizen = usCitizen;
		this.genderValue = genderValue;
		
		this.id = count;
		
		count++;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public AgeCategory getAgeCat() {
		return ageCat;
	}
	public void setAgeCat(AgeCategory ageCat) {
		this.ageCat = ageCat;
	}
	
	public EmploymentCategory getEmpVal() {
		return empVal;
	}
	public void setEmpVal(EmploymentCategory empVal) {
		this.empVal = empVal;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public boolean isUsCitizen() {
		return usCitizen;
	}
	public void setUsCitizen(boolean usCitizen) {
		this.usCitizen = usCitizen;
	}
	public Gender getGenderValue() {
		return genderValue;
	}
	public void setGenderValue(Gender genderValue) {
		this.genderValue = genderValue;
	}

	@Override
	public int hashCode() {
		
		return super.hashCode();
	}
	
	
	

}
