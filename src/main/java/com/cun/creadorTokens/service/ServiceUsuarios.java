package com.cun.creadorTokens.service;

import com.cun.creadorTokens.entity.Usuarios;

import java.util.List;

public interface ServiceUsuarios {
    public abstract List<Usuarios> listAllUsuarios();
    public abstract int existsByCorreo(String correo);
}
