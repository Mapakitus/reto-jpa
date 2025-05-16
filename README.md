### RETO PARA EL PROYECTO DE JPA DEL RETO SPRINGBOOT CERTIDEVS

### PARA COMPARTIR EL PROYECTO EN GITHUB, FILE, VCS, O GIT, SHARE PROJECT ON GITHUB


### INSTRUCCIONES DEL RETO


- Crea una entidad llamada Proyecto. La entidad debe tener los siguientes atributos:

    - Un identificador único (id) de tipo Long que sea la clave primaria y se genere automáticamente
    - Un nombre (nombre) de tipo String
    - Una descripción (descripcion) de tipo String
    - Una fecha de inicio (fechaInicio) de tipo LocalDate
    - Si el proyecto está activo o no (activo)

- Crea una entidad llamada Tarea. La entidad debe tener los siguientes atributos:

    Un identificador único (id) de tipo Long que sea la clave primaria y se genere automáticamente
    Un título (titulo) de tipo String
    Una descripción (descripcion) de tipo String
    Si la tarea está completada o no (completada)
    Una referencia al proyecto al que pertenece (proyecto) que establezca la relación ManyToOne
    
- Asegúrate de:
    
     Usar las anotaciones de JPA adecuadas para definir la entidad y sus propiedades
     Configurar correctamente la relación ManyToOne con la entidad Proyecto
     Implementar un constructor vacío y otro con todos los campos excepto el id
     Incluir métodos getter y setter para todos los atributos
     Implementar método toString()
     
- Después, crear los siguientes repositorios:

  - Un repositorio ProyectoRepository
  - Un repositorio TareaRepository
  
- A continuación, crear métodos y consultas JPQL:

- En ProyectoRepository:
    Un método derivado para buscar proyectos por nombre
    Un método derivado para buscar proyectos por fecha de inicio
    Una consulta JPQL que encuentre todos los proyectos activos
    En TareaRepository:
    Un método derivado para buscar tareas por título
    Un método derivado para contar cuántas tareas no están completadas
    Una consulta JPQL que encuentre todas las tareas tareas que pertenezcan a un mismo proyecto

- Por último:

   Crear dos objetos de tipo Proyecto
   Crear cinco objetos de tipo Tarea asociados a los proyectos creados
   Guardarlos en base de datos
   Probar todos los métodos y consultas creadas en los repositorios
