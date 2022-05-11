package io.helidon.examples.microstream.storage;


import io.helidon.examples.microstream.model.Persona;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class PersonaStorage extends StorageManager{

  
   
    private final Set<Persona> personas = new HashSet<>();
   
    public void add(final Persona persona) {
        Objects.requireNonNull(persona, "persona is required");
        this.personas.add(persona);
    }

    public Set<Persona> getPersonas() {
        return Collections.unmodifiableSet(this.personas);
    }

    public Optional<Persona> findById(final long id) {
        return this.personas.stream().filter(this.isIdEquals(id)).limit(1).findFirst();
    }

    public void deleteById(final long id) {
        this.personas.removeIf(this.isIdEquals(id));

    }

    private Predicate<Persona> isIdEquals(final long id) {
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
        final PersonaStorage inventory = (PersonaStorage) o;
        return Objects.equals(this.personas, inventory.personas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.personas);
    }

    @Override
    public String toString() {
        return "Inventory{"
                + "personas="
                + this.personas
                + '}';
    }

   
    
    
}
