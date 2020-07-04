package pl.test.projectforsignup.services;


import org.springframework.stereotype.Service;
import pl.test.projectforsignup.exceptions.ResourceNotFoundException;
import pl.test.projectforsignup.models.UserClass;
import pl.test.projectforsignup.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserClass> getUsers(){
       return userRepository.findAll();
    }

    public UserClass addUser(UserClass userClass){
       return userRepository.save(userClass);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public UserClass updateUser(long id, UserClass user){
        return userRepository.findById(id).map(u -> {
            u.setUserName(user.getUserName());
            u.setPassword(user.getPassword());
            u.setUserRoles(user.getUserRoles());
            return userRepository.save(u);
        }).orElseThrow(() -> new ResourceNotFoundException("User was not found"));
    }
}
