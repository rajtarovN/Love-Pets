package model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String type;

    @Column(nullable = true)
    private float hoursPerWeek;

    @Column(nullable = true)
    private float prise;
    @Column(nullable = true)
    private int adoptableOnKids; //stepen prilagodljivosti na decu
    @ManyToMany
    private List<Pet> notAllowdToLiveWith;
    @Column(nullable = true)
    private int levelOfActivity;
    @Column(nullable = true)
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
}
