/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.helidon.examples.microstream.repository;

import io.helidon.examples.microstream.model.Persona;
import io.helidon.examples.microstream.model.Habitante;
import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
public interface HabitanteRepository {
    
    Collection<Habitante> getAll();
    Habitante save(Habitante habitante);
    Habitante update(Habitante habitante);
    Optional<Habitante> findById(long id)  ;
    void deleteById(long id);

}
