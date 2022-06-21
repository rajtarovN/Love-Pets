package sbnz.integracija.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import sbnz.integracija.example.dto.PetDTO;
import sbnz.integracija.example.enums.PlaceForLiving;

@Entity
@Table(name = "pet")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pet {

	//todo dodati mesecno troskovi za hranu ili kao dodatni troskovi tipa akvarijum, ili kao neku napomenu pri odabiru ljubimca

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
	private Long id;
	
	 @Column(unique = false, nullable = true)
    private String name;

	 @Column(unique = false, nullable = true)
    private String type;

	 @Column(unique = false, nullable = true)
    private float hoursPerWeek;
	 
	 @Column(unique = false, nullable = true)
    private float price;
	 
	 @Column(unique = false, nullable = true)
    private int adoptableOnKids; //stepen prilagodljivosti na decu
	 
	 @Column(unique = false, nullable = true)
    private int minYears; //minimum godina koliko deca trebaju imate da bi ga prihvatili
	 
	 @Transient 
    private List<String> notAllowdToLiveWith;
	 
	 @Column(unique = false, nullable = true)
	    private String notLiveWith;
	 
    @Column(unique = false, nullable = true)
    private int levelOfActivity; //ovako ovo neka ide do 3, 3 je voli trc i setnju, 2 setnja, 1 nista 
    
    @Column(unique = false, nullable = true)
    private int degreeOfMolting; //stepen linjanja
    
    @Column(unique = false, nullable = true)
    private PlaceForLiving placeForLiving;
    
    @Column(unique = false, nullable = true)
    private int levelOfProtection;
    
    @Column(unique = false, nullable = true)
	private boolean extroversion;
    
    @Column(unique = false, nullable = true)
	private boolean introversion;
    
    @Column(unique = false, nullable = true)
	private int levelOfStressOnJob;
    
    @Column(unique = false, nullable = true)
	private boolean loveMystery;
    
    @Column(unique = false, nullable = true)
	private int loveMeditation;
    
    @Column(unique = false, nullable = true)
	private int levelOfPatience;
    
    @Column(unique = false, nullable = true)
	private int levelOfPersistance;
    
    
    

    public String getNotLiveWith() {
		return notLiveWith;
	}

	public void setNotLiveWith(String notLiveWith) {
		this.notLiveWith = notLiveWith;
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

    public int getMinYears() {
		return minYears;
	}

	public void setMinYears(int minYears) {
		this.minYears = minYears;
	}

	public PlaceForLiving getPlaceForLiving() {
		return placeForLiving;
	}

	public void setPlaceForLiving(PlaceForLiving placeForLiving) {
		this.placeForLiving = placeForLiving;
	}

	public int getLevelOfProtection() {
		return levelOfProtection;
	}

	public void setLevelOfProtection(int levelOfProtection) {
		this.levelOfProtection = levelOfProtection;
	}

	public Pet(String name2) {
		 this.name = name2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isExtroversion() {
		return extroversion;
	}

	public void setExtroversion(boolean extroversion) {
		this.extroversion = extroversion;
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

	

	public Pet(Long id, String name, String type, float hoursPerWeek, float prise, int adoptableOnKids, int minYears,
			List<String> notAllowdToLiveWith, int levelOfActivity, int degreeOfMolting, PlaceForLiving placeForLiving,
			int levelOfProtection, boolean extroversion, int levelOfStressOnJob, boolean loveMystery,
			int loveMeditation, int levelOfPatience, int levelOfPersistance) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.hoursPerWeek = hoursPerWeek;
		this.price = prise;
		this.adoptableOnKids = adoptableOnKids;
		this.minYears = minYears;
		this.notAllowdToLiveWith = notAllowdToLiveWith;
		this.levelOfActivity = levelOfActivity;
		this.degreeOfMolting = degreeOfMolting;
		this.placeForLiving = placeForLiving;
		this.levelOfProtection = levelOfProtection;
		this.extroversion = extroversion;
		this.levelOfStressOnJob = levelOfStressOnJob;
		this.loveMystery = loveMystery;
		this.loveMeditation = loveMeditation;
		this.levelOfPatience = levelOfPatience;
		this.levelOfPersistance = levelOfPersistance;
		this.introversion = !extroversion;
		System.out.println(this.levelOfProtection+"j");
	}

	public Pet() {
		super();
	}

	public Pet(PetDTO dto) {
		this.name = dto.getName();
		this.type = dto.getType();
		this.hoursPerWeek = dto.getHoursPerWeek();
		this.price = dto.getPrice();
		this.adoptableOnKids = dto.getAdoptableOnKids();
		this.minYears = dto.getMinYears();
		this.notAllowdToLiveWith = dto.getNotAllowdToLiveWith();
		this.levelOfActivity = dto.getLevelOfActivity();
		this.degreeOfMolting = dto.getDegreeOfMolting();
		this.placeForLiving = (dto.getPlaceForLiving().equals("inside") ? PlaceForLiving.INSIDE :
			dto.getPlaceForLiving().equals("outside")? PlaceForLiving.OUTSIDE : PlaceForLiving.INSIDE_OUTSIDE);
		this.levelOfProtection = dto.getLevelOfProtection();
		this.extroversion = dto.isExtroversion();
		this.levelOfStressOnJob = dto.getLevelOfStressOnJob();
		this.loveMystery = dto.isLoveMystery();
		this.loveMeditation = dto.getLoveMeditation();
		this.levelOfPatience = dto.getLevelOfPatience();
		this.levelOfPersistance = dto.getLevelOfPersistance();
		this.introversion = !dto.isExtroversion();
		this.notAllowdToLiveWith = new ArrayList<String>();
	}

	public boolean isIntroversion() {
		return introversion;
	}

	public void setIntroversion(boolean introversion) {
		this.introversion = introversion;
	}
	
}
