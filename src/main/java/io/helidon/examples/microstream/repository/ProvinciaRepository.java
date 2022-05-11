/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.helidon.examples.microstream.repository;

import io.helidon.examples.microstream.model.Persona;
import io.helidon.examples.microstream.model.Provincia;
import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
public interface ProvinciaRepository {
    
    Collection<Provincia> getAll();
    Provincia save(Provincia provincia);
    Provincia update(Provincia provincia);
    Optional<Provincia> findById(long id)  ;
    void deleteById(long id);

}
