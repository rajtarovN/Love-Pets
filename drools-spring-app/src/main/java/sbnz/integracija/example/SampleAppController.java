package sbnz.integracija.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public Pet getDog(@RequestParam(required = true) String id, @RequestParam(required = true) String name) {

//		Pet newPet = new Pet( name);
//
//		log.debug("----------------------------------------------------------------------------------------------------------------------------\n: "
//		+ "********************************************\n==========================================================");
//		log.debug("Item request received for: " + newPet);
//
//		Pet i2 = sampleService.getClassifiedItem(newPet);
		Pet i2 = this.sampleService.findBestPetChildren((long) 0);
		return i2;
	}
	
	
	
}
