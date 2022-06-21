package sbnz.integracija.example;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.enums.PlaceForLiving;
import sbnz.integracija.example.model.Helper;
import sbnz.integracija.example.model.Pet;
import sbnz.integracija.example.model.SinglPerson;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Service
public class PetService {
	
	private final KieContainer kieContainer;
	
	@Autowired
	public PetService(KieContainer kieContainer) {
//		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
	}
	
	public Pet findBestPet() {
		List<String> notAll = new ArrayList<String>();
    	//notAll.add("a");
    	List<String> alergic = new ArrayList<String>();
    	//alergic.add("a");
    	List<String> afraid = new ArrayList<String>();
    	//afraid.add("a");
//		SinglPerson u = new SinglPerson((long)1, "Milica", "Milic", "milica@gmail.com", "123", true, 3, 4, true, 3, true, 3, 3, 1, 4, 3, notAll, 400, 12, PlaceForLiving.INSIDE_OUTSIDE, alergic, afraid);
//		Pet pet1 = new Pet((long)1, "golden retriver", "dog", 12, 400, 5, 3,new ArrayList<String>()  ,3, 4, PlaceForLiving.INSIDE_OUTSIDE,3, true,3,true, 3,3, 1);
//		
    	SinglPerson u = new SinglPerson((long)1, "Milica", "Milic", "milica@gmail.com", "123", true, true, true, true, 3, true, 3, 3, 1, 4, 3, notAll, 400, 12, PlaceForLiving.INSIDE_OUTSIDE, alergic, afraid);
		Pet pet1 = new Pet((long)1, "golden retriver", "dog", 12, 400, 5, 3,new ArrayList<String>()  ,3, 4, PlaceForLiving.INSIDE_OUTSIDE,3, true,3,true, 3,3, 1);
		
																				
		Pet pet2 = new Pet((long)2, "golden fish", "fish", 12, 400, 5, 0,new ArrayList<String>(),3, 4, PlaceForLiving.INSIDE,3, false,3,false, 3,3, 1);
		
		Helper h = new Helper();
		
		KieSession kieSession = kieContainer.newKieSession();
		//kieSession.setGlobal("id", u.getId());
		List<Pet> recomedationPets = new ArrayList<Pet>();
		//kieSession.setGlobal("recomendation", recomedationPets);
		kieSession.insert(u);
		kieSession.insert(pet1);
		//kieSession.insert(pet2);
		kieSession.insert(h);
//		this.kieSession.getAgenda().getAgendaGroup("partner-requirements").setFocus();
//		this.kieSession.fireAllRules();
//		
//		this.kieSession.getAgenda().getAgendaGroup("partner-age").setFocus();
//		this.kieSession.fireAllRules();
		
		kieSession.getAgenda().getAgendaGroup("user-personality").setFocus();
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup("user-activity").setFocus();
		kieSession.fireAllRules();
		
		kieSession.getAgenda().getAgendaGroup("prepare-perfect-pet").setFocus();
		kieSession.fireAllRules();
		
		kieSession.getAgenda().getAgendaGroup("perfect-pet").setFocus();
		kieSession.fireAllRules();
		Pet pet = (Pet) kieSession.getGlobal("perfectPet");
		System.out.println(h.getText());
		System.out.println(pet);
		return pet;
	}

}
