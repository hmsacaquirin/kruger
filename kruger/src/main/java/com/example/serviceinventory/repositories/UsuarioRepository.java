package com.example.serviceinventory.repositories;

import com.example.serviceinventory.entities.Person;
import com.example.serviceinventory.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<User,Long> {
}
