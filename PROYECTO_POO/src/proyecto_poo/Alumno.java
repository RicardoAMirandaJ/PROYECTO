/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_poo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ricar
 */
public class Alumno {
    private String nombre;
    private List<Materia> materias;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.materias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public void mostrarCalificaciones() {
        System.out.println("Calificaciones de " + nombre + ":");
        for (Materia materia : materias) {
            System.out.println(materia.getNombre() + ": " + materia.getCalificacion());
        }
    }
}
