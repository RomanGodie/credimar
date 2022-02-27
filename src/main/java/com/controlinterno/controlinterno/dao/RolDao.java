package com.controlinterno.controlinterno.dao;

import com.controlinterno.controlinterno.models.Rol;

import java.util.List;

public interface RolDao {

    void createRol(Rol rol);
    List<Rol> readListaRoles();
    Rol readRol(Long id);
    void updateRol(Rol rol, long id);
    void deleteRol(Long id);
}
