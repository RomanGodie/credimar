package com.controlinterno.controlinterno.dao;

import com.controlinterno.controlinterno.models.Credito;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CreditoDaoImp implements CreditoDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createCredito(Credito credito) {
        entityManager.merge(credito);
    }

    @Override
    public List<Credito> readListaCreditos() {
        String query = "FROM Credito";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Credito readCredito(Long id) {
        Credito credito = entityManager.find(Credito.class, id);
        return credito;
    }

    @Override
    public void updateCredito(Credito credito, long id) {
        Credito creditoVerificado = entityManager.find(Credito.class, id);
        if(creditoVerificado !=null) {
            entityManager.merge(credito);
        }
    }

    @Override
    public void deleteCredito(Long id) {
        Credito credito = entityManager.find(Credito.class, id);
        entityManager.remove(credito);
    }
}
