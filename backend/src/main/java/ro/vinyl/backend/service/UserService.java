package ro.vinyl.backend.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.vinyl.backend.exception.EmailAlreadyExistsException;
import ro.vinyl.backend.model.User;
import ro.vinyl.backend.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> userList(){
        return userRepository.findAll();
    }

    public void saveUser(User user){
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        //boolean emailExists = userRepository.existsByEmail(user.getEmail());
        if (isEmailExists(user.getEmail())) {
            throw new EmailAlreadyExistsException("Email address already exists.");
        }
        user.setPassword(encryptedPassword);
        userRepository.save(user);
    }
    public User getUser(Integer id){
        return userRepository.findById(id).get();
    }
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
    public boolean isPasswordValid(String enteredPassword, String encryptedPassword) {
        return passwordEncoder.matches(enteredPassword, encryptedPassword);
    }
    public boolean isEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean isIdExists(Integer id) {
        return userRepository.existsById(id);
    }

}
