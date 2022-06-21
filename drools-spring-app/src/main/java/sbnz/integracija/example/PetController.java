package sbnz.integracija.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sbnz.integracija.example.dto.PetDTO;
import sbnz.integracija.example.dto.SinglePersonDTO;
import sbnz.integracija.example.model.Pet;
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/api/pet")
public class PetController {
	
	@Autowired
	public PetService petService;
	
//	@Autowired
//	public PetController(PetService petService) {
//		this.petService = petService;
//	}
	
	    @ResponseBody
	    
	    @PostMapping(path = "/findBestPet")
	    @CrossOrigin(origins = "http://localhost:4200")
	    //@PreAuthorize("hasRole('ADMIN')")(@RequestBody SinglePersonDTO dto
	    public Pet findBestPet() throws Exception{
	    	return this.petService.findBestPet();
	    }

}
