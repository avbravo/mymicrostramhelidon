/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.helidon.examples.microstream.repository;

import io.helidon.examples.microstream.model.Persona;
import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
public interface PersonaRepository {
    
    Collection<Persona> getAll();
    Persona save(Persona persona);
    Persona update(Persona persona);
    Optional<Persona> findById(long id)  ;
    void deleteById(long id);

}
