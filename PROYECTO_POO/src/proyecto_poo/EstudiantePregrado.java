/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ricar
 */
class EstudiantePregrado implements Estudiante {
    private String nombre;
    private int edad;
    Map<String, List<Integer>> calificaciones;

    public EstudiantePregrado(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificaciones = new HashMap<>();
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getEdad() {
        return edad;
    }

    @Override
    public double calcularPromedioCalificaciones() {
        if (calificaciones.isEmpty()) {
            return 0;
        }

        double total = 0;
        int count = 0;

        for (List<Integer> califs : calificaciones.values()) {
            for (int calif : califs) {
                total += calif;
                count++;
            }
        }

        return total / count;
    }

    public void agregarCalificacion(String asignatura, int calificacion) {
        if (!calificaciones.containsKey(asignatura)) {
            calificaciones.put(asignatura, new ArrayList<>());
        }
        calificaciones.get(asignatura).add(calificacion);
    }
}
