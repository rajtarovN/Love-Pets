package sbnz.integracija.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

import sbnz.integracija.example.dto.UserLoginDTO;
import sbnz.integracija.example.dto.UserRegisterDTO;
import sbnz.integracija.example.model.User;
import sbnz.integracija.example.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	 @Autowired
	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	
	public UserRegisterDTO register(UserRegisterDTO dto) {
		User u = userRepository.findByUsername(dto.getUsername()).orElse(null);
		if(u==null) {
			User newUser = new User(dto);
			userRepository.save(newUser);
			dto.setPassword("");
			return dto;
		}
		return null;
	}
	public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }


	public UserLoginDTO login(UserLoginDTO dto) {
		java.util.Optional<User> u = userRepository.findByUsername(dto.getUsername());
		if(u.get()!=null) {
			if(u.get().getPassword().equals(dto.getPassword())) {
				dto.setPassword("");
				return dto;
			}
		}
		return null;
	}

}
