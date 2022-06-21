package sbnz.integracija.example.model;

import java.util.Collection;
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

import sbnz.integracija.example.enums.PlaceForLiving;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "system_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    protected Long id;

	 @Column(unique = false, nullable = true)
    protected String firstName;
	 
	 @Column(unique = false, nullable = true)
	    protected String username;

    @Column(unique = false, nullable = true)
    protected String lastName;

    @Column(unique = true, nullable = false)
    protected String email;

    @Column(unique = false, nullable = true)
    protected String password;

    @Column(unique = false, nullable = true)
    protected Boolean active;
    @Column(unique = false, nullable = true)
    protected int levelOfProtection;
    @Column(unique = false, nullable = true)
    protected int hoursPerWeek;
    @Column(unique = false, nullable = true)
    protected float price;
    @Column(unique = false, nullable = true)
    protected PlaceForLiving placeForLiving;
    @ElementCollection
    protected List<String> alergicOn; //ovo je tip zivotinje
    @ElementCollection
    protected List<String> afraidOf;
    @ElementCollection
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

    public void setUsername(String username) {
		this.username = username;
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
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
}
