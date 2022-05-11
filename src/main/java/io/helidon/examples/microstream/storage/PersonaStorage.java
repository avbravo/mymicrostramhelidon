package io.helidon.examples.microstream.storage;

/*-
 * #%L
 * microstream-examples-helidon-mp
 * %%
 * Copyright (C) 2019 - 2021 MicroStream Software
 * %%
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is
 * available at https://www.gnu.org/software/classpath/license.html.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 * #L%
 */
import io.helidon.examples.microstream.model.Persona;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class PersonaStorage extends ManagedStorage{

  
   
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
