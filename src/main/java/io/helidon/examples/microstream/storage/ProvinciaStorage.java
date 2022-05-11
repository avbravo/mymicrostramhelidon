/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.helidon.examples.microstream.storage;

import io.helidon.examples.microstream.model.Persona;
import io.helidon.examples.microstream.model.Provincia;
import io.helidon.examples.microstream.model.Provincia;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class ProvinciaStorage extends ManagedStorage{

      private final Set<Provincia> provincias = new HashSet<>();
      
       public void add(final Provincia provincia) {
        Objects.requireNonNull(provincia, "provincia is required");
        this.provincias.add(provincia);
    }

    public Set<Provincia> getProvincias() {
        return Collections.unmodifiableSet(this.provincias);
    }


    public Optional<Provincia> findById(final long id) {
        return this.provincias.stream().filter(this.isIdEquals(id)).limit(1).findFirst();
    }

    public void deleteById(final long id) {
        this.provincias.removeIf(this.isIdEquals(id));

    }

 
     private Predicate<Provincia> isIdEquals(final long id) {
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
        final ProvinciaStorage inventory = (ProvinciaStorage) o;
        return Objects.equals(this.provincias, inventory.provincias);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.provincias);
    }

    @Override
    public String toString() {
        return "Provincia{"
                + "provincias="
                + this.provincias
                + '}';
    }

}
