package sbnz.integracija.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.enums.PlaceForLiving;
import sbnz.integracija.example.facts.Item;
import sbnz.integracija.example.model.Pet;
import sbnz.integracija.example.model.User;
import sbnz.integracija.example.model.Family;
import sbnz.integracija.example.model.Helper;
import sbnz.integracija.example.model.SinglPerson;
import sbnz.integracija.repository.UserRepository;

@Service
public class SampleAppService {

	private static Logger log = LoggerFactory.getLogger(SampleAppService.class);

	private final KieContainer kieContainer;
	
	//@Autowired
	//private UserRepository userRepository;
	
	//@Autowired
    //private KieSession kieSession;
	
	//@Autowired
	//@Qualifier(value = "eventsSession")
	//private KieSession eventsSession;
	

	@Autowired
	public SampleAppService(KieContainer kieContainer) {
		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
	}

	public Item getClassifiedItem(Item i) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(i);
		kieSession.fireAllRules();
		kieSession.dispose();
		return i;
	}
	public Pet getClassifiedItem(Pet i) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(i);
		kieSession.fireAllRules();
		kieSession.dispose();
		return i;
	}
	
	public Pet findBestPet(Long id) {
		
		//Optional<sbnz.integracija.example.model.User> user = userRepository.findById(id);
		
		User u = new User();
		u.setLevelOfProtection(5);
		u.setId((long) 0);
		
		
		Pet pet1= new Pet();
		pet1.setId((long)0);
		pet1.setLevelOfProtection(1);
		
		Pet pet2= new Pet();
		pet2.setId((long)1);
		pet2.setLevelOfProtection(5);
		pet2.setName("dzeki");
		
		Helper h = new Helper();
		
		KieSession kieSession = kieContainer.newKieSession();
		//kieSession.setGlobal("id", u.getId());
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
		
		kieSession.getAgenda().getAgendaGroup("prepare-perfect-pet").setFocus();
		kieSession.fireAllRules();
		
		kieSession.getAgenda().getAgendaGroup("perfect-pet").setFocus();
		kieSession.fireAllRules();
		Pet pet = (Pet) kieSession.getGlobal("perfectPet");
		System.out.println(h.getText());
		System.out.println(pet);
		return pet;
	}
	
    public Pet findBestPet1(Long id) {
		
		//Optional<sbnz.integracija.example.model.User> user = userRepository.findById(id);
		
//		User u = new User();
//		u.setLevelOfProtection(5);
//		u.setId((long) 0);
    	
    	// Boolean active,
		//int loveRunning, int loveWalking, boolean levelOfExtroversion, int levelOfStressOnJob,
		//boolean loveMystery, int loveMeditation, int levelOfPatience, int levelOfPersistance, int friendly
    	
    	List<String> notAll = new ArrayList<String>();
    	notAll.add("a");
    	List<String> alergic = new ArrayList<String>();
    	alergic.add("a");
    	List<String> afraid = new ArrayList<String>();
    	afraid.add("a");
		SinglPerson u = new SinglPerson((long)1, "Milica", "Milic", "milica@gmail.com", "123", true, 3, 4, true, 3, true, 3, 3, 1, 4, 3, notAll, 400, 12, PlaceForLiving.INSIDE_OUTSIDE, alergic, afraid);
		Pet pet1 = new Pet((long)1, "golden retriver", "dog", 12, 400, 5, 3,new ArrayList<String>()  ,5, 4, PlaceForLiving.INSIDE_OUTSIDE,3, true,3,true, 3,3, 1);
		   
																				
		Pet pet2 = new Pet((long)2, "golden fish", "fish", 12, 400, 5, 0,new ArrayList<String>(),5, 4, PlaceForLiving.INSIDE,3, false,3,false, 3,3, 1);
		
		Helper h = new Helper();
		
		KieSession kieSession = kieContainer.newKieSession();
		//kieSession.setGlobal("id", u.getId());
		List<Pet> recomedationPets = new ArrayList<Pet>();
		//kieSession.setGlobal("recomendation", recomedationPets);
		kieSession.insert(u);
		kieSession.insert(pet1);
		kieSession.insert(pet2);
		kieSession.insert(h);
//		this.kieSession.getAgenda().getAgendaGroup("partner-requirements").setFocus();
//		this.kieSession.fireAllRules();
//		
//		this.kieSession.getAgenda().getAgendaGroup("partner-age").setFocus();
//		this.kieSession.fireAllRules();
		
		kieSession.getAgenda().getAgendaGroup("user-personality").setFocus();
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
    
    
    public Pet findBestPetChildren(Long id) {
		
    	List<String> notAll = new ArrayList<String>();
    	//notAll.add("a");
    	List<String> alergic = new ArrayList<String>();
    	//alergic.add("dog");
    	List<String> afraid = new ArrayList<String>();
    	//afraid.add("a");
    	List<String> liveWith = new ArrayList<String>();
    	//liveWith.add("dog");
    	
		Family f = new Family((long)1, "Milica", "Milic", "milica@gmail.com", "123", true, 3, alergic, 400, 12,PlaceForLiving.INSIDE_OUTSIDE, afraid,
				liveWith,3, true,true,true,true,true,true,0);
		
		Pet pet1 = new Pet((long)1, "golden retriver", "dog", 12, 400, 9, 3,new ArrayList<String>()  ,5, 4, PlaceForLiving.INSIDE_OUTSIDE,3, true,3,true, 3,3, 1);
		   
																				
		Pet pet2 = new Pet((long)2, "golden fish", "fish", 12, 400, 5, 0,new ArrayList<String>(),5, 4, PlaceForLiving.INSIDE,3, false,3,false, 3,3, 1);
		
		Helper h = new Helper();
		
		KieSession kieSession = kieContainer.newKieSession();
		//kieSession.setGlobal("id", u.getId());
		List<Pet> recomedationPets = new ArrayList<Pet>();
		//kieSession.setGlobal("recomendation", recomedationPets);
		kieSession.insert(f);
		kieSession.insert(pet1);
		kieSession.insert(pet2);
		kieSession.insert(h);
	
		kieSession.getAgenda().getAgendaGroup("childrens-personalities").setFocus();
		kieSession.fireAllRules();
		
		Pet pet = (Pet) kieSession.getGlobal("perfectPetForChildren");
		System.out.println(h.getText());
		System.out.println(pet);
		return pet;
	
	}
}
