package com.controlinterno.controlinterno.dao;

import com.controlinterno.controlinterno.models.Credito;

import java.util.List;

public interface CreditoDao {

    void createCredito(Credito credito);
    List<Credito> readListaCreditos();
    Credito readCredito(Long id);
    void updateCredito(Credito credito, long id);
    void deleteCredito(Long id);
}
