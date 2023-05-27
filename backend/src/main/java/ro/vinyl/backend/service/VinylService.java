package ro.vinyl.backend.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.vinyl.backend.exception.VinylAlreadyExistsException;
import ro.vinyl.backend.model.Vinyl;
import ro.vinyl.backend.repository.VinylRepository;

import java.util.List;

@Service
@Transactional
public class VinylService {
    @Autowired
    private VinylRepository vinylRepository;


    public List<Vinyl> userList(){
        return vinylRepository.findAll();
    }

    public void saveVinyl(Vinyl vinyl){
        //boolean emailExists = userRepository.existsByEmail(user.getEmail());
        if (isVinylExists(vinyl.getName())) {
            throw new VinylAlreadyExistsException("Vinyl already exists!");
        }
        vinylRepository.save(vinyl);
    }
    public User getVinyl(Integer id){
        return vinylRepository.findById(id).get();
    }
    public void deleteVinyl(Integer id){
        vinylRepository.deleteById(id);
    }
    public boolean isVinylExists(String albumName) {
        return vinylRepository.existsByName(albumName);
    }

    public boolean isIdExists(Integer id) {
        return vinylRepository.existsById(id);
    }

}
