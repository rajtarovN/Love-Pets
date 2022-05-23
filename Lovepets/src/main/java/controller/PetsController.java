package controller;

import dto.PetDTO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.PetsService;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/pets")
public class PetsController {

    @Autowired
    private PetsService service;

    @ResponseBody
    @GetMapping(value = "/getAll")
    public void getAll() {

         service.proba(new PetDTO());

    }

}
