package sbnz.integracija.example.model;

import java.util.List;

import sbnz.integracija.example.enums.PlaceForLiving;

/**
 * @author rajta
 *
 */
public class Family extends User{
	
	private int childrenYears;
	
	private boolean goodInSport;
	
	private boolean physiclyActive;
	
	private boolean loveReserching;
	
	private boolean moreTime;
	
	private boolean introvertEkstrovert; 
	
	private boolean sthNew;
	
	private int personalities; //kao stepen osobina

	public int getChildrenYears() {
		return childrenYears;
	}

	public void setChildrenYears(int childrenYears) {
		this.childrenYears = childrenYears;
	}

	
	public boolean getMoreTime() {
		return moreTime;
	}

	public void setMoreTime(boolean moreTime) {
		this.moreTime = moreTime;
	}

	public boolean isSthNew() {
		return sthNew;
	}

	public void setSthNew(boolean sthNew) {
		this.sthNew = sthNew;
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

	public void setPhysiclyActive(boolean moreActivity) {
		this.physiclyActive = moreActivity;
	}

	public boolean isLoveReserching() {
		return loveReserching;
	}

	public void setLoveReserching(boolean loveReserching) {
		this.loveReserching = loveReserching;
	}

	public Family(Long id, String firstName, String lastName, String email, String password, Boolean active) {
		super(id, firstName, lastName, email, password, active);
	}

	public boolean isIntrovertEkstrovert() {
		return introvertEkstrovert;
	}

	public void setIntrovertEkstrovert(boolean introvertEkstrovert) {
		this.introvertEkstrovert = introvertEkstrovert;
	}

	public int getPersonalities() {
		return personalities;
	}

	public void setPersonalities(int personalities) {
		this.personalities = personalities;
	}

	public Family(Long id, String firstName, String lastName, String email, String password, Boolean active,
			int levelOfProtection, List<String> alergicOn, float price, int time, PlaceForLiving place,
			List<String> afraidof, List<String> liveWith, int childrenYears, boolean goodInSport,
			boolean physiclyActive, boolean loveReserching, boolean moreTime, boolean introvertEkstrovert,
			boolean sthNew, int personalities) {
		super(id, firstName, lastName, email, password, active, levelOfProtection, alergicOn, price, time, place,
				afraidof, liveWith);
		this.childrenYears = childrenYears;
		this.goodInSport = goodInSport;
		this.physiclyActive = physiclyActive;
		this.loveReserching = loveReserching;
		this.moreTime = moreTime;
		this.introvertEkstrovert = introvertEkstrovert;
		this.sthNew = sthNew;
		this.personalities = personalities;
	}

//	public Family(Long id, String firstName, String lastName, String email, String password, Boolean active,
//			int childrenYears, boolean goodInSport, boolean physiclyActive, boolean loveReserching, boolean moreTime,
//			boolean introvertEkstrovert, boolean sthNew, int personalities) {
//		super(id, firstName, lastName, email, password, active);
//		this.childrenYears = childrenYears;
//		this.goodInSport = goodInSport;
//		this.physiclyActive = physiclyActive;
//		this.loveReserching = loveReserching;
//		this.moreTime = moreTime;
//		this.introvertEkstrovert = introvertEkstrovert;
//		this.sthNew = sthNew;
//		this.personalities = personalities;
//	}

	
}
