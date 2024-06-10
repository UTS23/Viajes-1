package com.viajes.brayan.repository;

import com.viajes.brayan.entidades.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByCorreo(String correo);
}
