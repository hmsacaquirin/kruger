package com.example.serviceinventory.repositories;

import com.example.serviceinventory.entities.Empleado;
import com.example.serviceinventory.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
}
