package sbnz.integracija.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.dto.FormFamillyDTO;
import sbnz.integracija.example.dto.FormSinglePersonDTO;
import sbnz.integracija.example.dto.PetDTO;
import sbnz.integracija.example.dto.SinglePersonDTO;
import sbnz.integracija.example.dto.UserRegisterDTO;
import sbnz.integracija.example.model.Pet;

@RestController
public class PetController {
	
	
	public final PetService petService;
	
	

	@Autowired
	public PetController(PetService petService) {
		this.petService = petService;
	}
	
	@RequestMapping(value = "/addPet", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> addPet(@RequestBody PetDTO dto) {
		System.out.println(dto.getName());
        return new ResponseEntity<>(this.petService.addPet(dto), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/getAllPets", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> getAllPets() {
		
        return new ResponseEntity<>(this.petService.getAll(), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findPetFamilly", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> findPetFamilly(@RequestBody FormFamillyDTO dto) {
        return new ResponseEntity<>(this.petService.findBestPetForFamilly(dto), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findPetSinglePerson", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> findPetSinglePerfon(@RequestBody FormSinglePersonDTO dto) {
		
        return new ResponseEntity<>(this.petService.findBestPetForSinglePerson(dto), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
		
        return new ResponseEntity<>(this.petService.delete(id), HttpStatus.OK);
    }
	@RequestMapping(value = "/getNames", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> getAllNames() {
		
        return new ResponseEntity<>(this.petService.getNames(), HttpStatus.OK);
    }
	@RequestMapping(value = "/familyBackward/{id}", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> familyBackward(@PathVariable Long id, @RequestBody FormFamillyDTO dto) {
		
        return new ResponseEntity<>(this.petService.isPetGoodForFamilly(id,dto),HttpStatus.OK);
    }
	
	@RequestMapping(value = "/singleBackward/{id}", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> singlPersonBackward(@PathVariable Long id, @RequestBody SinglePersonDTO dto) {
		
        return new ResponseEntity<>(this.petService.isPetGoodForSinglePerson(id,dto), HttpStatus.OK);
    }
}
