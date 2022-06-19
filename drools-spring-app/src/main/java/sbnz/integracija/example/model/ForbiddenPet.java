package sbnz.integracija.example.model;
import org.kie.api.definition.type.Position;

public class ForbiddenPet {
	   @Position(0)
	    private String pet;

	    @Position(1)
	    private String parent;

	    public ForbiddenPet(String pet, String parent) {
	        this.pet = pet;
	        this.parent = parent;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) { return true; }
	        if (o == null || getClass() != o.getClass()) { return false; }

	        ForbiddenPet fp1 = (ForbiddenPet) o;

	        if (pet != null ? !pet.equals(fp1.pet) : fp1.pet != null) { return false; }
	        if (parent != null ? !parent.equals(fp1.parent) : fp1.parent != null) { return false; }

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int result = pet != null ? pet.hashCode() : 0;
	        result = 31 * result + (parent != null ? parent.hashCode() : 0);
	        return result;
	    }

	    @Override
	    public String toString() {
	        return "Location{" +
	               "pet='" + pet + '\'' +
	               ", parent='" + parent + '\'' +
	               '}';
	    }

}
