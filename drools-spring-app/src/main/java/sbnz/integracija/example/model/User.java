package sbnz.integracija.example.model;

import java.util.List;

import sbnz.integracija.example.enums.PlaceForLiving;

public class User {

    
    protected Long id;

   
    protected String firstName;

   
    protected String lastName;

   
    protected String email;

    
    protected String password;

   
    protected Boolean active;
    
    protected int levelOfProtection;
    
    protected int hoursPerWeek;
    
    protected float price;
    
    protected PlaceForLiving placeForLiving;
    
    protected List<String> alergicOn; //ovo je tip zivotinje
    
    protected List<String> afraidOf;
    
    protected List<String> liveWith;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<String> getAfraindOf() {
		return afraidOf;
	}

	public void setAfraidOf(List<String> afraidOf) {
		this.afraidOf = afraidOf;
	}

	public int getLevelOfProtection() {
		return levelOfProtection;
	}

	public void setLevelOfProtection(int levelOfProtection) {
		this.levelOfProtection = levelOfProtection;
	}

	public List<String> getAlergicOn() {
		return alergicOn;
	}

	public void setAlergicOn(List<String> alergicOn) {
		this.alergicOn = alergicOn;
	}

	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public PlaceForLiving getPlaceForLiving() {
		return placeForLiving;
	}

	public void setPlaceForLiving(PlaceForLiving placeForLiving) {
		this.placeForLiving = placeForLiving;
	}
	
	public List<String> getLiveWith() {
		return liveWith;
	}

	public void setLiveWith(List<String> liveWith) {
		this.liveWith = liveWith;
	}

	public List<String> getAfraidOf() {
		return afraidOf;
	}

	public User(Long id, String firstName, String lastName, String email, String password, Boolean active,
			int levelOfProtection, List<String> alergicOn,float price, int time, PlaceForLiving place, List<String> afraidof, List<String> liveWith ) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.active = active;
		this.levelOfProtection = levelOfProtection;
		this.alergicOn = alergicOn;
		this.price= price;
		this.placeForLiving = place;
		this.hoursPerWeek = time;
		this.afraidOf = afraidof;
		this.liveWith = liveWith;
		
	}
	public User(Long id, String firstName, String lastName, String email, String password, Boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public User() {
    }
}
