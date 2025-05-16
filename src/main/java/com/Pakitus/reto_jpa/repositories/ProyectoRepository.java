package com.Pakitus.reto_jpa.repositories;

import com.Pakitus.reto_jpa.entities.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    //Un método derivado para buscar proyectos por nombre
    List<Proyecto> findByNombreIgnoreCase(String nombre);

    //Un método derivado para buscar proyectos por fecha de inicio
    List<Proyecto> findByFechaInicio(LocalDate fechaInicio);

    //Una consulta JPQL que encuentre todos los proyectos activos
    @Query("select p from Proyecto p where p.activo = true")
    List<Proyecto> findByActivoTrue();

}