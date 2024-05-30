/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/RestController.java to edit this template
 */
package org.uv.BDNCPractica03;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author ian
 */
@RestController
@RequestMapping("/url")
@CrossOrigin(origins = "*")
public class PersonaController {
    @Autowired
    private PersonaRepository repository;
    
    @GetMapping()
    public List<Persona> list() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Persona> get(@PathVariable String id) {
        return repository.findById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Persona input) {
        Optional<Persona> persona = repository.findById(id);
        if (persona.isPresent()){
            input.setId(id);
            repository.deleteById(id);
            repository.save(input);
            return ResponseEntity.ok(input);
        }
        else{
            return null;
        }
    }
    
    @PostMapping()
    public ResponseEntity<?> post(@RequestBody Persona input) {
        repository.save(input);
        if (repository.findById(input.getId()).isPresent()){
            return ResponseEntity.ok(input);
        }
        else{
            return null;
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        repository.deleteById(id);
        if (repository.findById(id).isEmpty()){
            return ResponseEntity.ok(id);
        }
        else{
            return null;
        }
    }
    
}
