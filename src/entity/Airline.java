package entity;

import utils.EntityLoadRelations;

public class Airline {
	private String name;
	private long id;
	
	public Airline() {
		super();
	}
	
	public Airline(String name, long id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
		
		this.setName(EntityLoadRelations.getAttributeById("airlines", this.id, "name"));
	}
	
}
