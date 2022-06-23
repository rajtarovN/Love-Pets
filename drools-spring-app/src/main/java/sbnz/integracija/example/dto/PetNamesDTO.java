package sbnz.integracija.example.dto;

import sbnz.integracija.example.model.Pet;

public class PetNamesDTO {
	private String name;
	private Long value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;

	}
	
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	
	public PetNamesDTO() {
		super();
	}
	public PetNamesDTO(String name, Long value) {
		super();
		this.name = name;
		this.value = value;
	}
	public PetNamesDTO(Pet p) {
		this.name = p.getName() +" type: " + p.getType();
		this.value = p.getId();
	}
	
	

}
