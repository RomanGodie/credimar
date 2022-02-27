package com.controlinterno.controlinterno.dao;

import com.controlinterno.controlinterno.models.Persona;

import java.util.List;

public interface PersonaDao {

    void createPersona(Persona persona);
    Persona readPersona(Long id);
    Persona readPersonaPorCredenciales(Persona persona);
    List<Persona> readListaPersonas();
    void updatePersona(Persona persona, long id);
    void deletePersona(Long id);
}
