package com.example.vin_s.cargo.model;

//this is the post model
//every form needs a setter and a getter

public class Post
{
	//forms 
	int OwnerID;
	int PostID;
	String origin;
	String dest;
	String date;
	
	//constructor, add any other combinations of input that you might need
	public Post(){}
	
	public Post(int Oid, int Pid, String o, String dt, int d, int m, int y)
	{
		OwnerID = Oid;
		PostID = Pid;
		origin = o;
		dest = dt;
		date = d;
	}
	
	//setters
	public void setOwner (int o){
		OwnerID = o;
	}
	
	public void setOrigin (String origin){
		this.origin = origin;
	}

	public void setDest (String dest){
		this.dest = dest;
	}
	
	public void setDate(String day){
		this.date = date;
	}
	
	
	//getters
	public int getOwner(){
		return OwnerID:
	}
	
	public int getPostid(){
		return Post
	}
	public String getOrigin (){
		return origin;
	}
	
	public String getDest(){
		return dest;
	}
	
	public String getDate(){
		return date;
	}
}