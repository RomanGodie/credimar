package com.controlinterno.controlinterno.dao;

import com.controlinterno.controlinterno.models.Agente;

import java.util.List;

public interface AgenteDao {

    void createAgente(Agente agente);
    Agente readAgente(Long id);
    Agente readAgentePorCredenciales(Agente agente);
    List<Agente> readListaAgentes();
    void updateAgente(Agente agente, long id);
    void deleteAgente(Long id);
}
