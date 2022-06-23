package sbnz.integracija.example.dto;

import java.util.List;

public class FormFamillyDTO {
	  private boolean activeness;
	  private int levelOfProtection;
	  private int hoursPerWeek;
	  private int price;
	  private String placeForLiving ;

	  private int childrenYears;
	  private boolean goodInSport ;
	  private boolean physiclyActive ;
	  private  boolean loveReserching;
	  private boolean moreTime ;
	  private boolean introvertEkstrovert ;
	  
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
	public int getChildrenYears() {
		return childrenYears;
	}
	public void setChildrenYears(int childrenYears) {
		this.childrenYears = childrenYears;
	}
	public boolean isGoodInSport() {
		return goodInSport;
	}
	public void setGoodInSport(boolean goodInSport) {
		this.goodInSport = goodInSport;
	}
	public boolean isPhysiclyActive() {
		return physiclyActive;
	}
	public void setPhysiclyActive(boolean physiclyActive) {
		this.physiclyActive = physiclyActive;
	}
	public boolean isLoveReserching() {
		return loveReserching;
	}
	public void setLoveReserching(boolean loveReserching) {
		this.loveReserching = loveReserching;
	}
	public boolean isMoreTime() {
		return moreTime;
	}
	public void setMoreTime(boolean moreTime) {
		this.moreTime = moreTime;
	}
	public boolean isIntrovertEkstrovert() {
		return introvertEkstrovert;
	}
	public void setIntrovertEkstrovert(boolean introvertEkstrovert) {
		this.introvertEkstrovert = introvertEkstrovert;
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
	
	public FormFamillyDTO(boolean activeness, int levelOfProtection, int hoursPerWeek, int price, String placeForLiving,
			int childrenYears, boolean goodInSport, boolean physiclyActive, boolean loveReserching, boolean moreTime,
			boolean introvertEkstrovert, List<String> liveWith, List<String> alergic, List<String> afraidOf) {
		super();
		this.activeness = activeness;
		this.levelOfProtection = levelOfProtection;
		this.hoursPerWeek = hoursPerWeek;
		this.price = price;
		this.placeForLiving = placeForLiving;
		this.childrenYears = childrenYears;
		this.goodInSport = goodInSport;
		this.physiclyActive = physiclyActive;
		this.loveReserching = loveReserching;
		this.moreTime = moreTime;
		this.introvertEkstrovert = introvertEkstrovert;
		this.liveWith = liveWith;
		this.alergic = alergic;
		this.afraidOf = afraidOf;
	}
	public FormFamillyDTO() {
		super();
	}
	  
	  

}
