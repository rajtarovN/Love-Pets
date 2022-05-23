package service;

import dto.PetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PetRepository;

@Service
public class PetsService {
    @Autowired
    private PetRepository petRepository;

    //    @Autowired
//    private KieService kieService;

    public void proba(PetDTO pet) {
        System.out.println("Pets:");
//        kieService.getRuleSession().getAgenda().getAgendaGroup("transport_type").setFocus();
//        kieService.getRuleSession().insert(tickets);
//        kieService.getRuleSession().fireAllRules();
    }
}
