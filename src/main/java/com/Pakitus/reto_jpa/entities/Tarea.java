package com.Pakitus.reto_jpa.entities;

import jakarta.persistence.*;

@Entity // indica que esta clase es una tabla
@Table(name = "tareas")
public class Tarea {

    @Id // indica que este atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String descripcion;

    private Boolean completada;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    // constructor vacío
    public Tarea() {}

    // constructor con parámetros
    public Tarea(String titulo, String descripcion, Boolean completada, Proyecto proyecto) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = completada;
        this.proyecto = proyecto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getCompletada() {
        return completada;
    }

    public void setCompletada(Boolean completada) {
        this.completada = completada;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                ", proyecto=" + proyecto +
                '}';
    }
}
