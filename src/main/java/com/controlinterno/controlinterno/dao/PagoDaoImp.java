package com.controlinterno.controlinterno.dao;

import com.controlinterno.controlinterno.models.Pago;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PagoDaoImp implements PagoDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createPago(Pago pago) {
        entityManager.merge(pago);
    }

    @Override
    public List<Pago> readListaPagos() {
        String query = "FROM Pago";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Pago readPago(Long id) {
        Pago pago = entityManager.find(Pago.class, id);
        return pago;
    }

    @Override
    public void updatePago(Pago pago, long id) {
        Pago pagoVerificado = entityManager.find(Pago.class, id);
        if(pagoVerificado!=null) {
            entityManager.merge(pago);
        }
    }

    @Override
    public void deletePago(Long id) {
        Pago pago = entityManager.find(Pago.class, id);
        entityManager.remove(pago);
    }
}
