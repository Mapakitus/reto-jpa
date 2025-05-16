package com.Pakitus.reto_jpa.repositories;

import com.Pakitus.reto_jpa.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

    //Un método derivado para buscar tareas por título
    List<Tarea> findByTituloIgnoreCase(String titulo);

    //Un método derivado para contar cuántas tareas no están completadas
    long countByCompletadaFalse();

    //Una consulta JPQL que encuentre todas las tareas que pertenezcan a un mismo proyecto
    @Query("select t from Tarea t where t.proyecto.id = ?1")
    List<Tarea> findByProyecto_Id(Long id);

}