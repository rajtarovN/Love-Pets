package sbnz.integracija.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.dto.UserRegisterDTO;
import sbnz.integracija.example.model.Pet;

@RestController
public class UserController {
	
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserRegisterDTO> register(@RequestBody UserRegisterDTO dto) {
        return new ResponseEntity<>(this.userService.register(dto), HttpStatus.OK);
    }
}
