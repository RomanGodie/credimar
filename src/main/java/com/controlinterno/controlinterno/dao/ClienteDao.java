package com.controlinterno.controlinterno.dao;

import com.controlinterno.controlinterno.models.Cliente;

import java.util.List;

public interface ClienteDao {

    void createCliente(Cliente cliente);
    Cliente readCliente(Long id);
    List<Cliente> readListaClientes();
    void updateCliente(Cliente cliente, long id);
    void deleteCliente(Long id);
}
