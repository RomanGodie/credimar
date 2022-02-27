package com.controlinterno.controlinterno.dao;

import com.controlinterno.controlinterno.models.Pago;

import java.util.List;

public interface PagoDao {

    void createPago(Pago pago);
    List<Pago> readListaPagos();
    Pago readPago(Long id);
    void updatePago(Pago pago, long id);
    void deletePago(Long id);
}
