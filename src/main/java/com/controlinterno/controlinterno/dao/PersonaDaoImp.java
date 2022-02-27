package com.controlinterno.controlinterno.dao;

import com.controlinterno.controlinterno.models.Persona;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional

public class PersonaDaoImp implements PersonaDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createPersona(Persona persona) {
        entityManager.merge(persona);
    }

    @Override
    public Persona readPersona(Long id) {
        Persona persona = entityManager.find(Persona.class, id);
        return persona;
    }

    @Override
    public Persona readPersonaPorCredenciales(Persona persona) {
        String query = "FROM Persona WHERE numero_identificacion = :numero_identificacion";
        List<Persona> lista = entityManager.createQuery(query)
                .setParameter("numero_identificacion", persona.getNumero_identificacion())
                .getResultList();

        if(lista.isEmpty()){
            return null;
        }else{
            return lista.get(0);
        }
    }

    @Override
    public List<Persona> readListaPersonas() {
        String query = "FROM Persona";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void updatePersona(Persona persona, long id) {
        Persona personaVerificada = entityManager.find(Persona.class, id);
        if(personaVerificada!=null) {
            entityManager.merge(persona);
        }
    }

    @Override
    public void deletePersona(Long id) {
        Persona persona = entityManager.find(Persona.class, id);
        entityManager.remove(persona);
    }
}
