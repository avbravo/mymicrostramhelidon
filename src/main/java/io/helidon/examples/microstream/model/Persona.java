/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.helidon.examples.microstream.model;

import java.util.Objects;
import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

/**
 *
 * @author avbravo
 */
public class Persona {

    private final long id;
    private final String name;

    @JsonbCreator
    public Persona(
            @JsonbProperty("id") final long id,
            @JsonbProperty("name") final String name
    ) {
        this.id = id;
        this.name = name;

    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

 
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Persona persona = (Persona) o;
        return this.id == persona.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        return "Persona{"
                + "id="
                + this.id
                + ", name='"
                + this.name
               
                + '}';
    }
}
