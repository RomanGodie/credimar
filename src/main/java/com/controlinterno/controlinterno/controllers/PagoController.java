package com.controlinterno.controlinterno.controllers;


import com.controlinterno.controlinterno.dao.PagoDao;
import com.controlinterno.controlinterno.models.Pago;
import com.controlinterno.controlinterno.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PagoController {

    @Autowired
    private PagoDao pagoDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/pago/{id}", method = RequestMethod.GET)
    public Pago obtenerPago(@RequestHeader(value="Authorization") String token, @PathVariable Long id ){

        if(!validarToken(token)){return null;}
        return pagoDao.readPago(id);
    }

    @RequestMapping(value = "api/pagos", method = RequestMethod.GET)
    public List<Pago> obtenerListaPagos(@RequestHeader(value="Authorization") String token){

        if(!validarToken(token)){return null;}
        return pagoDao.readListaPagos();

    }

    @RequestMapping(value = "api/pago", method = RequestMethod.POST)
    public void registrarPago(@RequestHeader(value="Authorization") String token, @RequestBody Pago pago){
        if(!validarToken(token)){return;}
        pagoDao.createPago(pago);
    }

    @RequestMapping(value = "api/pago/{id}", method = RequestMethod.DELETE)
    public void eliminarPago(@RequestHeader (value="Authorization") String token, @PathVariable Long id ){

        if(!validarToken(token)){return;}
        pagoDao.deletePago(id);
    }


    private boolean validarToken(String token){
        String agenteId = jwtUtil.getKey(token);
        return agenteId != null;
    }
}
