package com.controlinterno.controlinterno.controllers;

import com.controlinterno.controlinterno.dao.CreditoDao;
import com.controlinterno.controlinterno.models.Credito;
import com.controlinterno.controlinterno.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreditoController {

    @Autowired
    private CreditoDao creditoDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/credito/{id}", method = RequestMethod.GET)
    public Credito obtenerCredito(@RequestHeader(value="Authorization") String token, @PathVariable Long id ){

        if(!validarToken(token)){return null;}
        return creditoDao.readCredito(id);
    }

    @RequestMapping(value = "api/creditos", method = RequestMethod.GET)
    public List<Credito> obtenerListaCreditos(@RequestHeader(value="Authorization") String token){

        if(!validarToken(token)){return null;}
        return creditoDao.readListaCreditos();

    }

    @RequestMapping(value = "api/credito", method = RequestMethod.POST)
    public void registrarCredito(@RequestHeader(value="Authorization") String token, @RequestBody Credito credito){
        if(!validarToken(token)){return;}
        creditoDao.createCredito(credito);
    }

    @RequestMapping(value = "api/credito/{id}", method = RequestMethod.DELETE)
    public void eliminarCredito(@RequestHeader (value="Authorization") String token, @PathVariable Long id ){

        if(!validarToken(token)){return;}
        creditoDao.deleteCredito(id);
    }


    private boolean validarToken(String token){
        String agenteId = jwtUtil.getKey(token);
        return agenteId != null;
    }
}
