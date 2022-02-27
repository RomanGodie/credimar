package com.controlinterno.controlinterno.dao;

import com.controlinterno.controlinterno.models.Agente;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional

public class AgenteDaoImp implements AgenteDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createAgente(Agente agente) {
        entityManager.merge(agente);
    }

    @Override
    public Agente readAgente(Long id) {
        Agente agente = entityManager.find(Agente.class, id);
        return agente;
    }

    @Override
    public Agente readAgentePorCredenciales(Agente agente) {
        String query = "FROM Agente WHERE correo_electronico = :correo_electronico";
        List<Agente> lista = entityManager.createQuery(query)
                .setParameter("correo_electronico", agente.getCorreo_electronico())
                .getResultList();

        if(lista.isEmpty()){
            return null;
        }else{
            String passwordHashed = lista.get(0).getPassword();
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            if(argon2.verify(passwordHashed, agente.getPassword())){
                return lista.get(0);
            }else{
                return null;
            }
        }
    }

    @Override
    public List<Agente> readListaAgentes() {
        String query = "FROM Agente";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void updateAgente(Agente agente, long id) {
        Agente agenteVerificado = entityManager.find(Agente.class, id);
        if(agenteVerificado!=null) {
            entityManager.merge(agente);
        }
    }

    @Override
    public void deleteAgente(Long id) {
        Agente agente = entityManager.find(Agente.class, id);
        entityManager.remove(agente);
    }
}
