/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.helidon.examples.microstream.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import one.microstream.reference.Lazy;


/**
 *
 * @author avbravo
 */
public class Habitante {

    private final long id;
    private final String name;
    private final Provincia provincia;
    private List<Persona> personas =new ArrayList<>();





    @JsonbCreator
    public Habitante(
            @JsonbProperty("id") final long id,
            @JsonbProperty("name") final String name,
            @JsonbProperty("personas") final List<Persona> personas,
            @JsonbProperty("provincia") final Provincia provincia
    ) {
        this.id = id;
        this.name = name;
        this.personas =personas;
        this.provincia= provincia;

    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
    public Provincia getProvincia(){
        return this.provincia;
    }

    public List<Persona> getPersonas(){
        return this.personas;
    }
 
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Habitante persona = (Habitante) o;
        return this.id == persona.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        

        String text="";
        text = personas.stream().map(p -> " "+p.toString()).reduce(text, String::concat);
      
        return "Persona{"
                + "id="
                + this.id
                + ", name='"
                + this.name
                + ", provincia='"
                + this.provincia.toString()
               + ", personas="
                +text
                + '}';
    }
}
