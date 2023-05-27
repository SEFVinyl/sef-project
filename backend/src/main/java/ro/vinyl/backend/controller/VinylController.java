package ro.vinyl.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.vinyl.backend.exception.VinylAlreadyExistsException;
import ro.vinyl.backend.model.Vinyl;
import ro.vinyl.backend.service.VinylService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/vinyl")
public class VinylController {
    @Autowired
    VinylService vinylService;

    @GetMapping("")
    public List<Vinyl> list(){
        return vinylService.vinylList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vinyl> get(@PathVariable Integer id){
        try{
            User user = vinylService.getVinyl(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Vinyl vinyl){
        try{
            vinylService.saveVinyl(vinyl);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (VinylAlreadyExistsException e){
            return new  ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Vinyl vinyl, @PathVariable Integer id){
        try{
            Vinyl existVinyl = vinylService.getVinyl(id);
            vinyl.setId(id);
            vinylService.saveVinyl(vinyl);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        vinylService.deleteVinyl(id);
    }
}

