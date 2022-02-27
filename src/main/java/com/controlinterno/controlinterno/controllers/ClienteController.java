package com.controlinterno.controlinterno.controllers;


import com.controlinterno.controlinterno.dao.ClienteDao;
import com.controlinterno.controlinterno.models.Cliente;
import com.controlinterno.controlinterno.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/cliente/{id}", method = RequestMethod.GET)
    public Cliente obtenerCliente(@RequestHeader (value="Authorization") String token, @PathVariable Long id ){

        if(!validarToken(token)){return null;}
        return clienteDao.readCliente(id);
    }

    @RequestMapping(value = "api/clientes", method = RequestMethod.GET)
    public List<Cliente> obtenerListaClientes(@RequestHeader(value="Authorization") String token){

        if(!validarToken(token)){return null;}
        return clienteDao.readListaClientes();

    }

    @RequestMapping(value = "api/cliente", method = RequestMethod.POST)
    public void registrarCliente(@RequestHeader(value="Authorization") String token, @RequestBody Cliente cliente){
        if(!validarToken(token)){return;}
        clienteDao.createCliente(cliente);
    }

    @RequestMapping(value = "api/cliente/{id}", method = RequestMethod.DELETE)
    public void eliminarCliente(@RequestHeader (value="Authorization") String token, @PathVariable Long id ){

        if(!validarToken(token)){return;}
        clienteDao.deleteCliente(id);
    }


    private boolean validarToken(String token){
        String agenteId = jwtUtil.getKey(token);
        return agenteId != null;
    }
}
