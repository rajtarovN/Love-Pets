package sbnz.integracija.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.dto.UserRegisterDTO;
import sbnz.integracija.example.facts.Item;
import sbnz.integracija.example.model.Pet;

@RestController
public class SampleAppController {
	private static Logger log = LoggerFactory.getLogger(SampleAppController.class);

	private final SampleAppService sampleService;

	@Autowired
	public SampleAppController(SampleAppService sampleService) {
		this.sampleService = sampleService;
	}

	@RequestMapping(value = "/item", method = RequestMethod.GET, produces = "application/json")
	public Item getQuestions(@RequestParam(required = true) String id, @RequestParam(required = true) String name,
			@RequestParam(required = true) double cost, @RequestParam(required = true) double salePrice) {

		Item newItem = new Item(Long.parseLong(id), name, cost, salePrice);

		log.debug("Item request received for: " + newItem);

		Item i2 = sampleService.getClassifiedItem(newItem);

		return i2;
	}
	
	@RequestMapping(value = "/dog", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")
	public Pet getDog(@RequestParam(required = true) String id, @RequestParam(required = true) String name) {

//		Pet newPet = new Pet( name);
//
//		log.debug("----------------------------------------------------------------------------------------------------------------------------\n: "
//		+ "********************************************\n==========================================================");
//		log.debug("Item request received for: " + newPet);
//
//		Pet i2 = sampleService.getClassifiedItem(newPet);
		Pet i2 = this.sampleService.bek2();//findBestPetChildren((long)0);//findBestPetChildren((long) 0);//sampleService.bek2();//this.sampleService.findBestPetChildren((long) 0);
		return i2;
	}
	@CrossOrigin(origins ="*")
	@RequestMapping(value = "/reg", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> reg() {
		
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}
	
	
	
	
	
}
