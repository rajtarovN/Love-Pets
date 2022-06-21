package sbnz.integracija.example.model;

import java.util.List;

import sbnz.integracija.example.dto.FormSinglePersonDTO;
import sbnz.integracija.example.enums.PlaceForLiving;

public class SinglPerson extends User{
	private boolean loveRunning;
	private boolean loveWalking;
	private boolean extroversion;
	private boolean introversion;
	private int levelOfStressOnJob;
	private boolean loveMystery;
	private int loveMeditation;
	private int levelOfPatience;
	private int levelOfPersistance; //stepen upornosti
    private int friendly;
	public boolean isLoveRunning() {
		return loveRunning;
	}
	public void setLoveRunning(boolean loveRunning) {
		this.loveRunning = loveRunning;
	}
	public boolean isLoveWalking() {
		return loveWalking;
	}
	public void setLoveWalking(boolean loveWalking) {
		this.loveWalking = loveWalking;
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
	public int getFriendly() {
		return friendly;
	}
	public void setFriendly(int friendly) {
		this.friendly = friendly;
	}
	public SinglPerson(Long id, String firstName, String lastName, String email, String password, Boolean active,
			boolean loveRunning, boolean loveWalking, boolean levelOfExtroversion, int levelOfStressOnJob,
			boolean loveMystery, int loveMeditation, int levelOfPatience, int levelOfPersistance, int friendly, int levelOfProtection,
			List<String> alergicOn, float price, int time, PlaceForLiving place, List<String> afraidOf, List<String>liveWith) {
		super(id, firstName, lastName, email, password, active, levelOfProtection, alergicOn, price, time, place, afraidOf, liveWith);
		this.loveRunning = loveRunning;
		this.loveWalking = loveWalking;
		this.extroversion = levelOfExtroversion;
		this.introversion = !levelOfExtroversion;
		this.levelOfStressOnJob = levelOfStressOnJob;
		this.loveMystery = loveMystery;
		this.loveMeditation = loveMeditation;
		this.levelOfPatience = levelOfPatience;
		this.levelOfPersistance = levelOfPersistance;
		this.friendly = friendly;
		//this.levelOfProtection=3;
		System.out.println(this.levelOfProtection+"d");
	}
	public SinglPerson(Long id, String firstName, String lastName, String email, String password, Boolean active) {
		super(id, firstName, lastName, email, password, active);
	}
	public SinglPerson(FormSinglePersonDTO dto) {
		super(dto.getLevelOfProtection(), dto.getPlaceForLiving(), dto.getHoursPerWeek(), dto.getPrice());
		this.loveRunning = dto.isLoveRunning();
		this.loveWalking = dto.isLoveWalking();
		this.extroversion = dto.isExtroversion();
		this.introversion = !dto.isExtroversion();
		this.levelOfStressOnJob = dto.getLevelOfStressOnJob();
		this.loveMystery = dto.isLoveMystery();
		this.loveMeditation = dto.getLoveMeditation();
		this.levelOfPatience = dto.getLevelOfPatience();
		this.levelOfPersistance = dto.getLevelOfPersistance();
		this.friendly = dto.getFriendly();
		
	}
	
    

}
