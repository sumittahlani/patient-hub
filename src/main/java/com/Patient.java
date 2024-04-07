package com;

import java.util.Objects;

public class Patient {
	
	private Long id;
	
    private String name;
    
    private int age;
    
    private String gender;
    
    private String number;
    
    
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}

	

	public Patient(Long id, String name, int age, String gender, String number) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.number = number;
	}


	public Patient() {
		
	}



	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", number=" + number
				+ "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(age, gender, id, name, number);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return age == other.age && Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(number, other.number);
	}
	
	

}
