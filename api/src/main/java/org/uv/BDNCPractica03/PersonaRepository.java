/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.BDNCPractica03;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author ian
 */
public interface PersonaRepository extends MongoRepository<Persona, String>{
    
}
