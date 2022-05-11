/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.helidon.examples.microstream.storage;

import io.helidon.examples.microstream.storage.configuration.StorageManager;
import io.helidon.examples.microstream.model.Habitante;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class HabitanteStorage extends StorageManager{

      private final Set<Habitante> habitantes = new HashSet<>();
      
       public void add(final Habitante habitante) {
        Objects.requireNonNull(habitante, "habitante is required");
        this.habitantes.add(habitante);
    }
       
       /**
        * Para actualizar un objeto hay que removerlo y volverlo a agregar
        * @param habitante 
        */
       public void update(final Habitante habitante) {
        Objects.requireNonNull(habitante, "habitante is required");
           deleteById(habitante.getId());           
        this.habitantes.add(habitante);
    }

    public Set<Habitante> getHabitantes() {
        return Collections.unmodifiableSet(this.habitantes);
    }


    public Optional<Habitante> findById(final long id) {
        return this.habitantes.stream().filter(this.isIdEquals(id)).limit(1).findFirst();
    }

    public void deleteById(final long id) {
        this.habitantes.removeIf(this.isIdEquals(id));

    }

 
     private Predicate<Habitante> isIdEquals(final long id) {
        return p -> p.getId() == id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final HabitanteStorage inventory = (HabitanteStorage) o;
        return Objects.equals(this.habitantes, inventory.habitantes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.habitantes);
    }

    @Override
    public String toString() {
        return "Habitante{"
                + "habitantes="
                + this.habitantes
                + '}';
    }

}
