package com.controlinterno.controlinterno.dao;

import com.controlinterno.controlinterno.models.Pago;
import com.controlinterno.controlinterno.models.Rol;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RolDaoImp implements RolDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createRol(Rol rol) {
        entityManager.merge(rol);
    }

    @Override
    public List<Rol> readListaRoles() {
        return null;
    }

    @Override
    public Rol readRol(Long id) {
        Rol rol = entityManager.find(Rol.class, id);
        return rol;
    }

    @Override
    public void updateRol(Rol rol, long id) {
        Rol rolVerificado = entityManager.find(Rol.class, id);
        if(rolVerificado!=null) {
            entityManager.merge(rol);
        }
    }

    @Override
    public void deleteRol(Long id) {
        Rol rol = entityManager.find(Rol.class, id);
        entityManager.remove(rol);
    }
}
