package sbnz.integracija.example.dto;

import java.util.List;

public class FormSinglePersonDTO {
	private boolean activeness;
	  private int levelOfProtection;
	  private int hoursPerWeek;
	  private int price;
	  private String placeForLiving ;
	  
	  private  boolean loveRunning;
	  private  boolean loveWalking;
	  private  boolean extroversion;
	  private  boolean introversion;
	  private int levelOfStressOnJob;
	  private boolean loveMystery;
	  private int loveMeditation;
	  private int levelOfPatience;
	  private int levelOfPersistance;
	  private int friendly;
	  
	  private List<String> liveWith;
	  private List<String> alergic;
	  private List<String> afraidOf;
	public boolean isActiveness() {
		return activeness;
	}
	public void setActiveness(boolean activeness) {
		this.activeness = activeness;
	}
	public int getLevelOfProtection() {
		return levelOfProtection;
	}
	public void setLevelOfProtection(int levelOfProtection) {
		this.levelOfProtection = levelOfProtection;
	}
	public int getHoursPerWeek() {
		return hoursPerWeek;
	}
	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPlaceForLiving() {
		return placeForLiving;
	}
	public void setPlaceForLiving(String placeForLiving) {
		this.placeForLiving = placeForLiving;
	}
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
	
	public List<String> getLiveWith() {
		return liveWith;
	}
	public void setLiveWith(List<String> liveWith) {
		this.liveWith = liveWith;
	}
	public List<String> getAlergic() {
		return alergic;
	}
	public void setAlergic(List<String> alergic) {
		this.alergic = alergic;
	}
	public List<String> getAfraidOf() {
		return afraidOf;
	}
	public void setAfraidOf(List<String> afraidOf) {
		this.afraidOf = afraidOf;
	}
	public FormSinglePersonDTO() {
		super();
	}
	public FormSinglePersonDTO(boolean activeness, int levelOfProtection, int hoursPerWeek, int price,
			String placeForLiving, boolean loveRunning, boolean loveWalking, boolean extroversion, boolean introversion,
			int levelOfStressOnJob, boolean loveMystery, int loveMeditation, int levelOfPatience,
			int levelOfPersistance, int friendly, List<String> liveWith, List<String> alergic, List<String> afraidOf) {
		super();
		this.activeness = activeness;
		this.levelOfProtection = levelOfProtection;
		this.hoursPerWeek = hoursPerWeek;
		this.price = price;
		this.placeForLiving = placeForLiving;
		this.loveRunning = loveRunning;
		this.loveWalking = loveWalking;
		this.extroversion = extroversion;
		this.introversion = introversion;
		this.levelOfStressOnJob = levelOfStressOnJob;
		this.loveMystery = loveMystery;
		this.loveMeditation = loveMeditation;
		this.levelOfPatience = levelOfPatience;
		this.levelOfPersistance = levelOfPersistance;
		this.friendly = friendly;
		this.liveWith = liveWith;
		this.alergic = alergic;
		this.afraidOf = afraidOf;
	}
	  
	  

}
