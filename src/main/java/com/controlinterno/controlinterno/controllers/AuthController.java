package com.controlinterno.controlinterno.controllers;


import com.controlinterno.controlinterno.dao.AgenteDao;
import com.controlinterno.controlinterno.models.Agente;
import com.controlinterno.controlinterno.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AgenteDao agenteDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Agente agente){

        Agente agenteAuth = agenteDao.readAgentePorCredenciales(agente);
        if(agenteAuth != null){
            String tokenJWT = jwtUtil.create(String.valueOf(agenteAuth.getId_agente()),agenteAuth.getCorreo_electronico());
            return tokenJWT;
        }else{
            return "FAIL";
        }

    }
}