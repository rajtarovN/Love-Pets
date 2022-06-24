package sbnz.integracija.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.dto.FormFamillyDTO;
import sbnz.integracija.example.dto.FormSinglePersonDTO;
import sbnz.integracija.example.dto.PetDTO;
import sbnz.integracija.example.dto.PetNamesDTO;
import sbnz.integracija.example.dto.SinglePersonDTO;
import sbnz.integracija.example.enums.PlaceForLiving;
import sbnz.integracija.example.model.Family;
import sbnz.integracija.example.model.ForbiddenPet;
import sbnz.integracija.example.model.Helper;
import sbnz.integracija.example.model.Pet;
import sbnz.integracija.example.model.SinglPerson;
import sbnz.integracija.example.repository.PetRepository;
import sbnz.integracija.example.repository.UserRepository;
import sbnz.integracija.example.model.Location;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Service
public class PetService {

	private final KieContainer kieContainer;

	private final PetRepository petRepository;

	@Autowired
	public PetService(KieContainer kieContainer, PetRepository repo) {
		this.kieContainer = kieContainer;
		this.petRepository = repo;
	}

	public Object addPet(PetDTO dto) {
		Pet pet = new Pet(dto);
		String types = "";
		for(String s: pet.getNotAllowdToLiveWith()) {
			types+=s+" ";
		}
		pet.setNotLiveWith(types);
		this.petRepository.save(pet);
		return dto;
	}
	
	public void parseList(Pet pet) { 
		List<String> names = new ArrayList<>();
		for(String s: pet.getNotLiveWith().split(" ")) {
			names.add(s);
		}
		pet.setNotAllowdToLiveWith(names);
	}

	public Object getAll() {

		return this.petRepository.findAll();
	}

	public Object findBestPetForFamilly(FormFamillyDTO dto) {
		List<String> notAll = new ArrayList<String>();
		List<String> alergic = new ArrayList<String>();
		List<String> afraid = new ArrayList<String>();
		List<String> liveWith = new ArrayList<String>();

		Family f = new Family(dto);
		f.setId(0L);
		
		List<Pet> pets = this.petRepository.findAll();
		

		Helper h = new Helper();

		KieSession kieSession = kieContainer.newKieSession();

		List<Pet> recomedationPets = new ArrayList<Pet>();

		kieSession.insert(f);
		kieSession.insert(h);
		ArrayList<Pet> goodPets = new ArrayList<Pet>();
		for(Pet p: pets) {
			this.parseList(p);
			kieSession.insert(p);
			
			////
			kieSession.getAgenda().getAgendaGroup("childrens-personalities").setFocus();
			kieSession.fireAllRules();
			
			kieSession.getAgenda().getAgendaGroup("final-rule").setFocus();
			kieSession.fireAllRules();
			Pet pet = (Pet) kieSession.getGlobal("perfectPetForChildren");
			///
			goodPets.add(pet);	
		}
		return goodPets.get(0);
	}

	public Object findBestPetForSinglePerson(FormSinglePersonDTO dto) {

		SinglPerson u = new SinglPerson(dto);
		List<Pet> pets = this.petRepository.findAll();
		Helper h = new Helper();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(h);
		List<Pet> recomedationPets = new ArrayList<Pet>();
		kieSession.insert(u);
		
		ArrayList<Pet> goodPets = new ArrayList<Pet>();
		for(Pet p: pets) {
			this.parseList(p);
			kieSession.insert(p);
			
			//
			kieSession.getAgenda().getAgendaGroup("user-personality").setFocus();
			kieSession.fireAllRules();
			kieSession.getAgenda().getAgendaGroup("user-activity").setFocus();
			kieSession.fireAllRules();

			kieSession.getAgenda().getAgendaGroup("prepare-perfect-pet").setFocus();
			kieSession.fireAllRules();

			kieSession.getAgenda().getAgendaGroup("perfect-pet").setFocus();
			kieSession.fireAllRules();
			Pet pet = (Pet) kieSession.getGlobal("perfectPet");
			goodPets.add(pet);
		}
		System.out.println(goodPets.get(0));
		return goodPets.get(0);
	}

	public boolean delete(Long id) {

		Optional<Pet> pet = this.petRepository.findById(id);
		if (pet.isPresent()) {
			this.petRepository.delete(pet.get());
			return true;
		}
		return false;
	}

	public Object getNames() {
		List<Pet> pets= this.petRepository.findAll();
//		Pet pet1 = new Pet((long) 1, "golden retriver", "dog", 12, 400, 5, 3, new ArrayList<String>(), 3, 4,
//				PlaceForLiving.INSIDE_OUTSIDE, 3, true, 3, true, 3, 3, 1);
//
//		Pet pet2 = new Pet((long) 2, "golden fish", "fish", 12, 400, 5, 0, new ArrayList<String>(), 3, 4,
//				PlaceForLiving.INSIDE, 3, false, 3, false, 3, 3, 1);
//		List<Pet> pets= new ArrayList<>();
//		pets.add(pet1);
//		pets.add(pet2);
		ArrayList<PetNamesDTO> names =new ArrayList<>();
		for(Pet p: pets) {
			names.add(new PetNamesDTO(p));
		}
		return names;
	}
	public Pet isPetGoodForFamilly(Long id, FormFamillyDTO dto) {
		System.out.print("usao je!!!!!");
    	List<String> notAll = new ArrayList<String>();
    	//notAll.add("a");
    	List<String> alergic = new ArrayList<String>();
    	//alergic.add("dog");
    	List<String> afraid = new ArrayList<String>();
    	//afraid.add("a");
    	List<String> liveWith = new ArrayList<String>();
    	//liveWith.add("dog");
    	
    	KieSession ksession = kieContainer.newKieSession();
    	Family f = new Family((long)1, "Milica", "Milic", "milica@gmail.com", "123", true, 3, alergic, 400, 12,PlaceForLiving.INSIDE_OUTSIDE, afraid,
				liveWith,3, true,true,true,true,true,true,0);
		
		Pet pet1 = new Pet((long)1, "golden retriver", "dog", 12, 400, 9, 3,new ArrayList<String>()  ,5, 4, PlaceForLiving.INSIDE_OUTSIDE,3, true,3,true, 3,3, 1);
		   
		//todo lista stringova !!!!!!!!!!
		Helper h = new Helper();
//		ksession.insert( new ForbiddenPet("ForbiddenPets", "AlergicOn") );
//		ksession.insert( new ForbiddenPet("ForbiddenPets", "AfraidOf") );
//		
//		for(String s : f.getAfraidOf()) {
//			ksession.insert( new ForbiddenPet("AfraidOf", s) );
//		}
//
//		for(String s : f.getAlergicOn()) {
//			ksession.insert( new ForbiddenPet("AlergicOn", s) );
//		}
		ksession.insert( new Location("ForbiddenPets", "AlergicOn") );
		ksession.insert( new Location("ForbiddenPets", "AfraidOf") );
		
		for(String s : f.getAfraidOf()) {
			ksession.insert( new Location("AfraidOf", s) );
		}

		for(String s : f.getAlergicOn()) {
			ksession.insert( new Location("AlergicOn", s) );
		}
		
		
        ksession.insert( f );
        ksession.insert( h );
        ksession.insert(pet1);
        
        ksession.getAgenda().getAgendaGroup("childrens-personalities").setFocus();
		ksession.fireAllRules();
        
        ksession.insert( "go1" );
        ksession.fireAllRules();
        System.out.println("---");
        
        ksession.insert( "go2" );
        ksession.fireAllRules();
        System.out.println("---");
        
        Pet pet = (Pet) ksession.getGlobal("perfectPetForChildren");
        String exist = (String) ksession.getGlobal("petExist");
		System.out.println(h.getText());
		System.out.println(pet);
		if(exist!= null) {
			if(exist.equals("pet is in list")) {
				return null; //ako se nalazi u listi nije ok, i vrati se (ali ovo list je zapravo ono stablo)
			}
		}
		return pet;

    }

	public Object isPetGoodForSinglePerson(Long id, FormSinglePersonDTO dto ) {//
//		List<String> notAll = new ArrayList<String>();
//    	//notAll.add("a");
//    	List<String> alergic = new ArrayList<String>();
//    	//alergic.add("dog");
//    	List<String> afraid = new ArrayList<String>();
//    	//afraid.add("a");
//    	List<String> liveWith = new ArrayList<String>();
    	//liveWith.add("dog");
    	
    	KieSession ksession = kieContainer.newKieSession();
//        SinglPerson u = new SinglPerson((long)1, "Milica", "Milic", "milica@gmail.com", "123", true, true, true, true, 3, true, 3, 3, 1, 4, 3, notAll, 400, 12, PlaceForLiving.INSIDE_OUTSIDE, alergic, afraid);
//		Pet pet1 = new Pet((long)1, "golden retriver", "dog", 12, 400, 5, 3,new ArrayList<String>()  ,3, 4, PlaceForLiving.INSIDE_OUTSIDE,3, true,3,true, 3,3, 1);
    	SinglPerson u = new SinglPerson(dto);
    	Optional<Pet> pet1 = this.petRepository.findById(id);
		Helper h = new Helper();
		
        ksession.insert( u );
        ksession.insert( h );
        ksession.insert(pet1.get());
        
        ksession.insert( "go1" );
        ksession.fireAllRules();
        System.out.println("---");
        
        Pet pet = (Pet) ksession.getGlobal("perfectPetForChildren");
		System.out.println(h.getText());
		System.out.println(pet);
		return pet;
	}

}
