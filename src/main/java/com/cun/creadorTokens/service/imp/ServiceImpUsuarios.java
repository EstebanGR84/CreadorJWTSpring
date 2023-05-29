package com.cun.creadorTokens.service.imp;
import com.cun.creadorTokens.entity.Usuarios;
import com.cun.creadorTokens.repository.RepositoryUsuarios;
import com.cun.creadorTokens.service.ServiceUsuarios;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("UsuariosServiceImp")
@Transactional
public class ServiceImpUsuarios implements ServiceUsuarios {
    @Autowired
    @Qualifier("usuariosRepository")
    private RepositoryUsuarios repositoryUsuarios;
    @Override
    public List<Usuarios> listAllUsuarios() {
        return (List<Usuarios>) repositoryUsuarios.findAll();
    }

    @Override
    public int existsByCorreo(String correo) {
        return repositoryUsuarios.findByCorreo(correo);
    }
}

