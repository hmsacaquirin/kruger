package com.example.serviceinventory.repositories;

import com.example.serviceinventory.entities.Empleado;
import com.example.serviceinventory.entities.User;
import com.example.serviceinventory.model.Listas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    @Query(value = "select * from  empleado where id_person= :id_person ", nativeQuery = true)
    Empleado findPersonByIdPerson(@Param("id_person") Long id);

    @Query(value = "select p.cedula,p.nombres,p.apellido,e.fecha_nacimiento,e.direccion_domicilio,e.celular,e.estado_vacunacion,CASE WHEN e.tipo_vacuna IS NULL THEN '' ELSE e.tipo_vacuna END,CASE WHEN e.fecha_vacunacion IS NULL THEN '' ELSE e.fecha_vacunacion END,CASE WHEN e.numero_dosis IS NULL THEN 0 ELSE e.numero_dosis END from  person p inner join empleado e on  p.id=e.id_person where e.estado_vacunacion= :estado_vacunacion ", nativeQuery = true)
    List<Object[]> findEmpleadoByEstadoVacunacion(@Param("estado_vacunacion") String estadoVacunacion);

    @Query(value = "select p.cedula,p.nombres,p.apellido,e.fecha_nacimiento,e.direccion_domicilio,e.celular,e.estado_vacunacion,CASE WHEN e.tipo_vacuna IS NULL THEN '' ELSE e.tipo_vacuna END,CASE WHEN e.fecha_vacunacion IS NULL THEN '' ELSE e.fecha_vacunacion END,CASE WHEN e.numero_dosis IS NULL THEN 0 ELSE e.numero_dosis END from  person p inner join empleado e on  p.id=e.id_person where e.tipo_vacuna= :tipo_vacuna ", nativeQuery = true)
    List<Object[]> findEmpleadoByTipoVacuna(@Param("tipo_vacuna") String tipoVacuna);

    @Query(value = "select p.cedula,p.nombres,p.apellido,e.fecha_nacimiento,e.direccion_domicilio,e.celular,e.estado_vacunacion,CASE WHEN e.tipo_vacuna IS NULL THEN '' ELSE e.tipo_vacuna END,CASE WHEN e.fecha_vacunacion IS NULL THEN '' ELSE e.fecha_vacunacion END,CASE WHEN e.numero_dosis IS NULL THEN 0 ELSE e.numero_dosis END from  person p inner join empleado e on  p.id=e.id_person where e.fecha_vacunacion BETWEEN  :fecha1 and :fecha2 ", nativeQuery = true)
    List<Object[]> findEmpleadoByFechas(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);
}
