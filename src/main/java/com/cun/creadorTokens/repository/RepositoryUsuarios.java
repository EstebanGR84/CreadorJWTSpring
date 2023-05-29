package com.cun.creadorTokens.repository;

import com.cun.creadorTokens.entity.Usuarios;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("usuariosRepository")
public interface RepositoryUsuarios extends CrudRepository<Usuarios, String> {
    @Query(value = "SELECT COUNT(*) FROM USUARIOS WHERE Correo = :username", nativeQuery = true)
    int findByCorreo(String username);
}
