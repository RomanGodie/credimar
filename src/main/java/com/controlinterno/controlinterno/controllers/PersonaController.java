package com.controlinterno.controlinterno.controllers;

import com.controlinterno.controlinterno.dao.PersonaDao;
import com.controlinterno.controlinterno.models.Persona;
import com.controlinterno.controlinterno.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaDao personaDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/persona", method = RequestMethod.POST)
    public void registrarPersona(@RequestBody Persona persona){
        personaDao.createPersona(persona);
    }

    @RequestMapping(value = "api/persona/{id}", method = RequestMethod.GET)
    public Persona obtenerPersona(@RequestHeader(value="Authorization") String token, @PathVariable Long id ){

        if(!validarToken(token)){return null;}
        return personaDao.readPersona(id);
    }

    @RequestMapping(value = "api/personas", method = RequestMethod.GET)
    public List<Persona> obtenerListaPersonas(@RequestHeader(value="Authorization") String token){

        if(!validarToken(token)){return null;}
        return personaDao.readListaPersonas();

    }

    @RequestMapping(value = "api/persona/{id}", method = RequestMethod.POST)
    public void actualizarPersona(@RequestHeader (value="Authorization") String token, @PathVariable Long id, @RequestBody Persona persona){

        if(!validarToken(token)){return;}
        personaDao.updatePersona(persona, id);
    }

    @RequestMapping(value = "api/persona/{id}", method = RequestMethod.DELETE)
    public void eliminarPersona(@RequestHeader (value="Authorization") String token, @PathVariable Long id ){

        if(!validarToken(token)){return;}
        personaDao.deletePersona(id);
    }

    private boolean validarToken(String token){
        String agenteId = jwtUtil.getKey(token);
        return agenteId != null;
    }
}
