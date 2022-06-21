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
import sbnz.integracija.example.enums.PlaceForLiving;
import sbnz.integracija.example.model.Family;
import sbnz.integracija.example.model.Helper;
import sbnz.integracija.example.model.Pet;
import sbnz.integracija.example.model.SinglPerson;
import sbnz.integracija.example.repository.PetRepository;
import sbnz.integracija.example.repository.UserRepository;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Service
public class PetService {

	private final KieContainer kieContainer;

	private final PetRepository petRepository;

	@Autowired
	public PetService(KieContainer kieContainer, PetRepository repo) {
//		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
		this.petRepository = repo;
	}

	public Object addPet(PetDTO dto) {
		Pet pet = new Pet(dto);
		String types = "";
		for(String s: pet.getNotAllowdToLiveWith()) {
			types+=s;
		}
		pet.setNotLiveWith(types);
		this.petRepository.save(pet);
		return dto;
	}

	public Object getAll() {
//		Pet pet2 = new Pet((long)2, "golden fish", "fish", 12, 400, 5, 0,new ArrayList<String>(),5, 4, PlaceForLiving.INSIDE,3, false,3,false, 3,3, 1);
//		ArrayList<Pet> p =new ArrayList<Pet>();
//		p.add(pet2);
		return this.petRepository.findAll();
	}

	public Object findBestPetForFamilly(FormFamillyDTO dto) {
		List<String> notAll = new ArrayList<String>();
		List<String> alergic = new ArrayList<String>();
		List<String> afraid = new ArrayList<String>();
		List<String> liveWith = new ArrayList<String>();

		Family f = new Family(dto);
		f.setId(0L);
//		Family f = new Family((long)1, "Milica", "Milic", "milica@gmail.com", "123", true, 3, alergic, 400, 12,PlaceForLiving.INSIDE_OUTSIDE, afraid,
//				liveWith,3, true,true,true,true,true,true,0);
		
		Pet pet1 = new Pet((long) 1, "golden retriver", "dog", 12, 400, 9, 3, new ArrayList<String>(), 5, 4,
				PlaceForLiving.INSIDE_OUTSIDE, 3, true, 3, true, 3, 3, 1);
		Pet pet2 = new Pet((long) 2, "golden fish", "fish", 12, 400, 5, 0, new ArrayList<String>(), 5, 4,
				PlaceForLiving.INSIDE, 3, false, 3, false, 3, 3, 1);

		Helper h = new Helper();

		KieSession kieSession = kieContainer.newKieSession();

		List<Pet> recomedationPets = new ArrayList<Pet>();

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

	public Object findBestPetForSinglePerson(FormSinglePersonDTO dto) {

		// SinglPerson u = new SinglPerson((long)1, "Milica", "Milic",
		// "milica@gmail.com", "123", true, true, true, true, 3, true, 3, 3, 1, 4, 3,
		// notAll, 400, 12, PlaceForLiving.INSIDE_OUTSIDE, alergic, afraid);

		SinglPerson u = new SinglPerson(dto);
		u.setAfraidOf(new ArrayList<String>());
		u.setAlergicOn(new ArrayList<String>());
		u.setLiveWith(new ArrayList<String>());
		Pet pet1 = new Pet((long) 1, "golden retriver", "dog", 12, 400, 5, 3, new ArrayList<String>(), 3, 4,
				PlaceForLiving.INSIDE_OUTSIDE, 3, true, 3, true, 3, 3, 1);

		Pet pet2 = new Pet((long) 2, "golden fish", "fish", 12, 400, 5, 0, new ArrayList<String>(), 3, 4,
				PlaceForLiving.INSIDE, 3, false, 3, false, 3, 3, 1);

		Helper h = new Helper();

		KieSession kieSession = kieContainer.newKieSession();
		List<Pet> recomedationPets = new ArrayList<Pet>();
		kieSession.insert(u);
		kieSession.insert(pet1);
		kieSession.insert(h);

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

	public boolean delete(Long id) {

		Optional<Pet> pet = this.petRepository.findById(id);
		if (pet.isPresent()) {
			this.petRepository.delete(pet.get());
			return true;
		}
		return false;
	}

}
