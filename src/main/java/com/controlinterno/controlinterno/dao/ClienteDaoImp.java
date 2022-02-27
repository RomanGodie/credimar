package com.controlinterno.controlinterno.dao;

import com.controlinterno.controlinterno.models.Cliente;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class ClienteDaoImp implements ClienteDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createCliente(Cliente cliente) {
        entityManager.merge(cliente);
    }

    @Override
    public Cliente readCliente(Long id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        return cliente;
    }

    @Override
    public List<Cliente> readListaClientes() {
        String query = "FROM Cliente";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void updateCliente(Cliente cliente, long id) {
        Cliente clienteVerificado = entityManager.find(Cliente.class, id);
        if(clienteVerificado !=null) {
            entityManager.merge(cliente);
        }
    }

    @Override
    public void deleteCliente(Long id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.remove(cliente);
    }
}
