package com.example.vin_s.cargo.model;
//This is the person model
public class Person
{
	int id; //assign everyone a personal int id?
	String name;
	String cInfo;
	String text;
	
	//constructors
	public Person(){}
	
	public Person(int i,String n, String c, String t)
	{
		id = i;
		name = n;
		cInfo = c;
		text = t;
	}
	
	//setters	
	public void setName(String name){
		this.name = name;
	}
	
	public void setcInfo(String cInfo){
		this.cInfo = cInfo;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	//getters 
	public String getName(){
		return name;
	}
	
	public String getcInfo(){
		return cInfo;
	}
	
	public String getText(){
		return text;
	}
}