package sbnz.integracija.example.model;

import java.util.List;


public class Pet {



    private String name;


    private String type;


    private float hoursPerWeek;

    private float prise;
    private int adoptableOnKids; //stepen prilagodljivosti na decu

    private List<Pet> notAllowdToLiveWith;

    private int levelOfActivity;

    private int degreeOfMolting; //stepen linjanja

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(float hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public float getPrise() {
        return prise;
    }

    public void setPrise(float prise) {
        this.prise = prise;
    }

    public int getAdoptableOnKids() {
        return adoptableOnKids;
    }

    public void setAdoptableOnKids(int adoptableOnKids) {
        this.adoptableOnKids = adoptableOnKids;
    }

    public List<Pet> getNotAllowdToLiveWith() {
        return notAllowdToLiveWith;
    }

    public void setNotAllowdToLiveWith(List<Pet> notAllowdToLiveWith) {
        this.notAllowdToLiveWith = notAllowdToLiveWith;
    }

    public int getLevelOfActivity() {
        return levelOfActivity;
    }

    public void setLevelOfActivity(int levelOfActivity) {
        this.levelOfActivity = levelOfActivity;
    }

    public int getDegreeOfMolting() {
        return degreeOfMolting;
    }

    public void setDegreeOfMolting(int degreeOfMolting) {
        this.degreeOfMolting = degreeOfMolting;
    }

    public Pet(String name, String type, float hoursPerWeek, float prise, int adoptableOnKids, List<Pet> notAllowdToLiveWith, int levelOfActivity, int degreeOfMolting) {
        this.name = name;
        this.type = type;
        this.hoursPerWeek = hoursPerWeek;
        this.prise = prise;
        this.adoptableOnKids = adoptableOnKids;
        this.notAllowdToLiveWith = notAllowdToLiveWith;
        this.levelOfActivity = levelOfActivity;
        this.degreeOfMolting = degreeOfMolting;
    }

    public Pet() {
    }

	public Pet(String name2) {
		 this.name = name2;
	}
}
