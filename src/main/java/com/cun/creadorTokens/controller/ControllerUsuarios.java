package com.cun.creadorTokens.controller;

import com.cun.creadorTokens.beans.EncryptorBean;
import com.cun.creadorTokens.entity.Usuarios;
import com.cun.creadorTokens.service.imp.ServiceImpUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ControllerUsuarios {
    @Autowired
    @Qualifier("UsuariosServiceImp")
    private ServiceImpUsuarios usuarioService;
    @Autowired
    private EncryptorBean encryptor;
    @GetMapping(path = "/users")
    public List<Usuarios> listUsuarios(){
        return  usuarioService.listAllUsuarios();
    }
    @GetMapping(path = "/generarJWT")
    public String enviarJWT(@RequestHeader("Authorization") String authorizationHeader){
        String[] data = encryptor.BasicAuthDecrypt(authorizationHeader);
        if(usuarioService.existsByCorreo(data[0]) > 0)
            return encryptor.createJWS(data[0]);
        else
            return "Usuario no valido";
    }

}
