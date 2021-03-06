/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.helidon.examples.microstream.repository;

import io.helidon.examples.microstream.model.Persona;
import io.helidon.examples.microstream.storage.configuration.StorageManager;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import one.microstream.integrations.cdi.types.Store;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class PersonaRepositoryStorage implements PersonaRepository {

    private static final Logger LOGGER = Logger.getLogger(PersonaRepositoryStorage.class.getName());

    @Inject
    private StorageManager storage;

    @Override
    public Collection<Persona> getAll() {
        return this.storage.getPersonas();
    }

    @Override
    @Store
    public Persona save(final Persona item) {
        this.storage.add(item);
        return item;
    }

    @Override
    @Store
    public Persona update(final Persona item) {
        this.storage.add(item);
        return item;
    }

    @Override
    public Optional<Persona> findById(final long id) {
        LOGGER.info("Finding the item by id: " + id);
        return this.storage.findByIdPersona(id);
    }

    @Override
    @Store
    public void deleteById(final long id) {
        this.storage.deleteById(id);
    }

}
