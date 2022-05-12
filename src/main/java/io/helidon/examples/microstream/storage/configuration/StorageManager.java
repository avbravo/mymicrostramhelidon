package io.helidon.examples.microstream.storage.configuration;

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
import io.helidon.examples.microstream.model.Habitante;
import io.helidon.examples.microstream.model.Persona;
import io.helidon.examples.microstream.model.Product;
import io.helidon.examples.microstream.model.Provincia;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import one.microstream.integrations.cdi.types.Storage;

@Storage
public class StorageManager {

    private final Set<Product> products = new HashSet<>();

    public void add(final Product product) {
        Objects.requireNonNull(product, "product is required");
        this.products.add(product);
    }
    
      /**
        * Para actualizar un objeto hay que removerlo y volverlo a agregar
        * @param habitante 
        */
       public void update(final Product product) {
        Objects.requireNonNull(product, "product is required");
           deleteById(product.getId());           
        this.products.add(product);
    }

    public Set<Product> getProducts() {
        return Collections.unmodifiableSet(this.products);
    }

    public Optional<Product> findById(final long id) {
        return this.products.stream().filter(this.isIdEquals(id)).limit(1).findFirst();
    }

    public void deleteById(final long id) {
        this.products.removeIf(this.isIdEquals(id));

    }

    private Predicate<Product> isIdEquals(final long id) {
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
        final StorageManager inventory = (StorageManager) o;
        return Objects.equals(this.products, inventory.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.products);
    }

    @Override
    public String toString() {
        return "Inventory{"
                + "products="
                + this.products
                + '}';
    }

   
     private final Set<Provincia> provincias = new HashSet<>();
      
       public void add(final Provincia provincia) {
        Objects.requireNonNull(provincia, "provincia is required");
        this.provincias.add(provincia);
    }
       
         /**
        * Para actualizar un objeto hay que removerlo y volverlo a agregar
        * @param habitante 
        */
       public void update(final Provincia provincia) {
        Objects.requireNonNull(provincia, "provincia is required");
           deleteById(provincia.getId());           
        this.provincias.add(provincia);
    }

    public Set<Provincia> getProvincias() {
        return Collections.unmodifiableSet(this.provincias);
    }


    public Optional<Provincia> findByIdProvincia(final long id) {
        return this.provincias.stream().filter(this.isIdEqualsProvincia(id)).limit(1).findFirst();
    }

    public void deleteByIdProvincia(final long id) {
        this.provincias.removeIf(this.isIdEqualsProvincia(id));

    }

 
     private Predicate<Provincia> isIdEqualsProvincia(final long id) {
        return p -> p.getId() == id;
    }

   

/***
 * ------------------
 */
     

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
           deleteByIdHabitante(habitante.getId());           
        this.habitantes.add(habitante);
    }

    public Set<Habitante> getHabitantes() {
        return Collections.unmodifiableSet(this.habitantes);
    }


    public Optional<Habitante> findByIdHabitante(final long id) {
        return this.habitantes.stream().filter(this.isIdEqualsHabitante(id)).limit(1).findFirst();
    }

    public void deleteByIdHabitante(final long id) {
        this.habitantes.removeIf(this.isIdEqualsHabitante(id));

    }

 
     private Predicate<Habitante> isIdEqualsHabitante(final long id) {
        return p -> p.getId() == id;
    }

      /**
     * Persona
     */
     final Set<Persona> personas = new HashSet<>();
    
public   void add(final Persona persona) {
        Objects.requireNonNull(persona, "persona is required");
        this.personas.add(persona);
    }

 /**
        * Para actualizar un objeto hay que removerlo y volverlo a agregar
        * @param habitante 
        */
       public   void update(final Persona persona) {
        Objects.requireNonNull(persona, "persona is required");
           deleteByIdPersona(persona.getId());           
        this.personas.add(persona);
    }
    
    public   Set<Persona> getPersonas() {
        return Collections.unmodifiableSet(this.personas);
    }

    public   Optional<Persona> findByIdPersona(final long id) {
        return this.personas.stream().filter(this.isIdEqualsPersona(id)).limit(1).findFirst();
    }

    public    void deleteByIdPersona(final long id) {
        this.personas.removeIf(this.isIdEqualsPersona(id));

    }

       private Predicate<Persona> isIdEqualsPersona(final long id) {
        return p -> p.getId() == id;
    }
    
}
