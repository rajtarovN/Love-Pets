package sbnz.integracija.example.dto;

import java.util.List;

import sbnz.integracija.example.enums.PlaceForLiving;
import sbnz.integracija.example.model.Pet;

public class PetDTO {
	private Long id;
    private String name;
    private String type;
    private float hoursPerWeek;
    private float price;
    private int adoptableOnKids; //stepen prilagodljivosti na decu
    private int minYears; //minimum godina koliko deca trebaju imate da bi ga prihvatili
    private List<String> notAllowdToLiveWith;
    private int levelOfActivity; //ovako ovo neka ide do 3, 3 je voli trc i setnju, 2 setnja, 1 nista 
    private int degreeOfMolting; //stepen linjanja
    private String placeForLiving;
    private int levelOfProtection;
	private boolean extroversion;
	private boolean introversion;
	private int levelOfStressOnJob;
	private boolean loveMystery;
	private int loveMeditation;
	private int levelOfPatience;
	private int levelOfPersistance;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAdoptableOnKids() {
		return adoptableOnKids;
	}
	public void setAdoptableOnKids(int adoptableOnKids) {
		this.adoptableOnKids = adoptableOnKids;
	}
	public int getMinYears() {
		return minYears;
	}
	public void setMinYears(int minYears) {
		this.minYears = minYears;
	}
	public List<String> getNotAllowdToLiveWith() {
		return notAllowdToLiveWith;
	}
	public void setNotAllowdToLiveWith(List<String> notAllowdToLiveWith) {
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
	
	public int getLevelOfProtection() {
		return levelOfProtection;
	}
	public void setLevelOfProtection(int levelOfProtection) {
		this.levelOfProtection = levelOfProtection;
	}
	public boolean isExtroversion() {
		return extroversion;
	}
	public void setExtroversion(boolean extroversion) {
		this.extroversion = extroversion;
	}
	public boolean isIntroversion() {
		return introversion;
	}
	public void setIntroversion(boolean introversion) {
		this.introversion = introversion;
	}
	public int getLevelOfStressOnJob() {
		return levelOfStressOnJob;
	}
	public void setLevelOfStressOnJob(int levelOfStressOnJob) {
		this.levelOfStressOnJob = levelOfStressOnJob;
	}
	public boolean isLoveMystery() {
		return loveMystery;
	}
	public void setLoveMystery(boolean loveMystery) {
		this.loveMystery = loveMystery;
	}
	public int getLoveMeditation() {
		return loveMeditation;
	}
	public void setLoveMeditation(int loveMeditation) {
		this.loveMeditation = loveMeditation;
	}
	public int getLevelOfPatience() {
		return levelOfPatience;
	}
	public void setLevelOfPatience(int levelOfPatience) {
		this.levelOfPatience = levelOfPatience;
	}
	public int getLevelOfPersistance() {
		return levelOfPersistance;
	}
	public void setLevelOfPersistance(int levelOfPersistance) {
		this.levelOfPersistance = levelOfPersistance;
	}
	public String getPlaceForLiving() {
		return placeForLiving;
	}
	public void setPlaceForLiving(String placeForLiving) {
		this.placeForLiving = placeForLiving;
	}
	public PetDTO(Long id, String name, String type, float hoursPerWeek, float price, int adoptableOnKids, int minYears,
			List<String> notAllowdToLiveWith, int levelOfActivity, int degreeOfMolting, String placeForLiving,
			int levelOfProtection, boolean extroversion, boolean introversion, int levelOfStressOnJob,
			boolean loveMystery, int loveMeditation, int levelOfPatience, int levelOfPersistance) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.hoursPerWeek = hoursPerWeek;
		this.price = price;
		this.adoptableOnKids = adoptableOnKids;
		this.minYears = minYears;
		this.notAllowdToLiveWith = notAllowdToLiveWith;
		this.levelOfActivity = levelOfActivity;
		this.degreeOfMolting = degreeOfMolting;
		this.placeForLiving = placeForLiving;
		this.levelOfProtection = levelOfProtection;
		this.extroversion = extroversion;
		this.introversion = introversion;
		this.levelOfStressOnJob = levelOfStressOnJob;
		this.loveMystery = loveMystery;
		this.loveMeditation = loveMeditation;
		this.levelOfPatience = levelOfPatience;
		this.levelOfPersistance = levelOfPersistance;
	}
	public PetDTO() {
		super();
	}
	public PetDTO(Pet pet) {
		super();
		this.id = pet.getId();
		this.name = pet.getName();
		this.type = pet.getType();
		this.hoursPerWeek = pet.getHoursPerWeek();
		this.price = pet.getPrice();
		this.adoptableOnKids = pet.getAdoptableOnKids();
		this.minYears = pet.getMinYears();
		this.notAllowdToLiveWith = pet.getNotAllowdToLiveWith();
		this.levelOfActivity = pet.getLevelOfActivity();
		this.degreeOfMolting = pet.getDegreeOfMolting();
		this.placeForLiving = pet.getPlaceForLiving().toString().toLowerCase();
		this.levelOfProtection = pet.getLevelOfProtection();
		this.extroversion = pet.isExtroversion();
		this.introversion = pet.isIntroversion();
		this.levelOfStressOnJob = pet.getLevelOfStressOnJob();
		this.loveMystery = pet.isLoveMystery();
		this.loveMeditation = pet.getLoveMeditation();
		this.levelOfPatience = pet.getLevelOfPatience();
		this.levelOfPersistance = pet.getLevelOfPersistance();
	}
	

}
