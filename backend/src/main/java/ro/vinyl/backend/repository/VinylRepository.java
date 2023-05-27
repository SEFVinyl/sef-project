package ro.vinyl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.vinyl.backend.model.Vinyl;

public interface VinylRepository extends JpaRepository<Vinyl, Integer> {
    void deleteVinylById(Integer id);

    boolean existsByName(String albumName);
}
