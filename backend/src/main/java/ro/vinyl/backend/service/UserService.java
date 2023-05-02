package ro.vinyl.backend.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.vinyl.backend.model.User;
import ro.vinyl.backend.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> userList(){
        return userRepository.findAll();
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
    public User getUser(Integer id){
        return userRepository.findById(id).get();
    }
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
}
