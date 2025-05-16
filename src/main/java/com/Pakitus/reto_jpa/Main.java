package com.Pakitus.reto_jpa;

import com.Pakitus.reto_jpa.entities.Proyecto;
import com.Pakitus.reto_jpa.entities.Tarea;
import com.Pakitus.reto_jpa.repositories.ProyectoRepository;
import com.Pakitus.reto_jpa.repositories.TareaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		ApplicationContext spring = SpringApplication.run(com.Pakitus.reto_jpa.Main.class, args);

		//Obtener el repositorio de Proyecto
		ProyectoRepository proyectoRepository = spring.getBean(ProyectoRepository.class);
		//Obtener el repositorio de Tarea
		TareaRepository tareaRepository = spring.getBean(TareaRepository.class);

		//Crear dos objetos de tipo proyecto
		Proyecto proyecto1 = new Proyecto("Métodos Derivados", "Proyecto para aprender métodos derivados en SpringBoot", LocalDate.of(2025, 5, 10), true);
		Proyecto proyecto2 = new Proyecto("Consultas JPQL", "Proyecto para aprender consultas JPQL en SpringBoot", LocalDate.of(2025, 5, 10), true);

		//Guardar los proyectos en la base de datos
		proyectoRepository.saveAll(List.of(proyecto1, proyecto2));


		//crear 5 tareas
		Tarea tarea1 = new Tarea("Crear un método findByNombre", "Vamos a buscar por nombre", true, proyecto1);
		Tarea tarea2 = new Tarea("Crear un método countBy", "Vamos a contar cuantos están activos", false, proyecto1);
		Tarea tarea3 = new Tarea("Crear un método findByActivo", "Vamos a buscar los activos", true, proyecto1);
		Tarea tarea4 = new Tarea("Crear una consulta JPQL de proyectos", "Consulta JPQL sobre proyectos", false, proyecto2);
		Tarea tarea5 = new Tarea("Crear una consulta JPQL de tareas", "Consulta JPQL sobre tareas", true, proyecto2);

		//Guardar las tareas en la base de datos
		tareaRepository.saveAll(List.of(tarea1, tarea2, tarea3, tarea4, tarea5));


		//Probar List<Proyecto> findByNombreIgnoreCase(String nombre);
		String nombreBuscado = "MÉTODOS DERIVADOS";
		List<Proyecto> proyectosEncontrados = proyectoRepository.findByNombreIgnoreCase(nombreBuscado);
		if (proyectosEncontrados.isEmpty()) {
			System.out.println("No se encontró ningún proyecto con el nombre: " + nombreBuscado);		}
		else {
			for (Proyecto proyecto : proyectosEncontrados) {
				System.out.println("Proyectos encontrados por nombre '" + nombreBuscado + "': " + proyecto.getNombre());
			}
		}

		//Probar List<Proyecto> findByFechaInicio(LocalDate fechaInicio);
		LocalDate fechaBuscada = LocalDate.of(2025, 5, 10);
		List<Proyecto> proyectosPorFecha = proyectoRepository.findByFechaInicio(fechaBuscada);
		System.out.println("Proyectos con fecha de inicio: " + fechaBuscada);
		if (proyectosPorFecha.isEmpty()) {
			System.out.println("No se encontró ningún proyecto con fecha de inicio: " + fechaBuscada);
		} else {
			for (Proyecto proyecto : proyectosPorFecha) {
				System.out.println(proyecto.getNombre() + ": " + proyecto.getDescripcion());
			}
		}

		//Probar @Query("select p from Proyecto p where p.activo = true")
		//    List<Proyecto> findByActivoTrue();
		List<Proyecto> proyectosActivos = proyectoRepository.findByActivoTrue();
		System.out.println("Proyectos activos: ");
		if (proyectosActivos.isEmpty()) {
			System.out.println("No se han encontrado proyectos activos");
		} else {
			for (Proyecto proyecto : proyectosActivos) {
				System.out.println(proyecto.getNombre() + ": " + proyecto.getDescripcion());
			}
		}

		//Probar List<Tarea> findByTituloIgnoreCase(String titulo);
		String tituloBuscado = "Crear un método findByNombre";
		List<Tarea> tareasEncontradas = tareaRepository.findByTituloIgnoreCase(tituloBuscado);
		if (tareasEncontradas.isEmpty()) {
			System.out.println("No se encontró ninguna tarea con el título: " + tituloBuscado);
		} else {
			for (Tarea tarea : tareasEncontradas) {
				System.out.println("Tareas encontradas por título '" + tituloBuscado + "': " + tarea.getTitulo());
			}
		}

		//Probar long countByCompletadaFalse();
		long tareasNoCompletadas = tareaRepository.countByCompletadaFalse();
		System.out.println("Número de tareas NO completadas: " + tareasNoCompletadas);

		//Probar @Query("select t from Tarea t where upper(t.proyecto.nombre) = upper(?1)")
		//    List<Tarea> findByProyecto_NombreIgnoreCase(String nombre);
		Long proyectoId = proyecto2.getId();
		List<Tarea> tareasProyecto = tareaRepository.findByProyecto_Id(proyectoId);
		if (tareasProyecto.isEmpty()) {
			System.out.println("El proyecto con id " + proyectoId + " no tiene tareas.");
		} else {
			System.out.println("Tareas del proyecto con id " + proyectoId + ":");
			for (Tarea tarea : tareasProyecto) {
				System.out.println(tarea.getTitulo() + ": " +
						(tarea.getCompletada() ? "Completada" : "No completada"));
			}
		}

	}

}
