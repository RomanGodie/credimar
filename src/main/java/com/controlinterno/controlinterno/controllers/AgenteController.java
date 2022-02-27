package com.controlinterno.controlinterno.controllers;

import com.controlinterno.controlinterno.dao.AgenteDao;
import com.controlinterno.controlinterno.models.Agente;
import com.controlinterno.controlinterno.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgenteController {

    @Autowired
    private AgenteDao agenteDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/agente", method = RequestMethod.POST)
    public void registrarAgente(@RequestBody Agente agente){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, agente.getPassword());
        agente.setPassword(hash);
        agenteDao.createAgente(agente);
    }

    @RequestMapping(value = "api/agente/{id}", method = RequestMethod.GET)
    public Agente obtenerAgente(@RequestHeader(value="Authorization") String token, @PathVariable Long id ){

        if(!validarToken(token)){return null;}
        return agenteDao.readAgente(id);
    }

    @RequestMapping(value = "api/agentes", method = RequestMethod.GET)
    public List<Agente> obtenerListaAgentes(@RequestHeader(value="Authorization") String token){

        if(!validarToken(token)){return null;}
        return agenteDao.readListaAgentes();

    }

    @RequestMapping(value = "api/agente/{id}", method = RequestMethod.POST)
    public void actualizarAgente(@RequestHeader (value="Authorization") String token, @PathVariable Long id, @RequestBody Agente agente){

        if(!validarToken(token)){return;}
        agenteDao.updateAgente(agente, id);
    }

    @RequestMapping(value = "api/agente/{id}", method = RequestMethod.DELETE)
    public void eliminarAgente(@RequestHeader (value="Authorization") String token, @PathVariable Long id ){

        if(!validarToken(token)){return;}
        agenteDao.deleteAgente(id);
    }

    private boolean validarToken(String token){
        String agenteId = jwtUtil.getKey(token);
        return agenteId != null;
    }
}
