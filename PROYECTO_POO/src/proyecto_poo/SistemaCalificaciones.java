/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_poo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ricar
 */
public class SistemaCalificaciones {
    private List<Estudiante> estudiantes;
    private BufferedReader lector;
    private BufferedWriter escritor;

    public SistemaCalificaciones() {
        estudiantes = new ArrayList<>();
        lector = new BufferedReader(new InputStreamReader(System.in));
    }

    public void ejecutar() {
        try {
            escritor = new BufferedWriter(new FileWriter("D:\\calificaciones.txt"));

            System.out.println("¡Bienvenido al Sistema de Calificaciones!");

            boolean ejecutando = true;
            while (ejecutando) {
                System.out.println("1. Agregar Estudiante de Pregrado");
                System.out.println("2. Agregar Estudiante de Posgrado");
                System.out.println("3. Calcular Promedio de Calificaciones");
                System.out.println("4. Salir");
                System.out.print("Ingrese su opción: ");
                int opcion = Integer.parseInt(lector.readLine());

                switch (opcion) {
                    case 1:
                        agregarEstudiantePregrado();
                        break;
                    case 2:
                        agregarEstudiantePosgrado();
                        break;
                    case 3:
                        calcularPromedioCalificaciones();
                        break;
                    case 4:
                        ejecutando = false;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, intente nuevamente.");
                        break;
                }
            }

            escritor.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer o escribir el archivo.");
            e.printStackTrace();
        }
    }

    private void agregarEstudiantePregrado() {
        try {
            System.out.print("Ingrese el nombre del estudiante: ");
            String nombre = lector.readLine();

            System.out.print("Ingrese la edad del estudiante: ");
            int edad = Integer.parseInt(lector.readLine());

            EstudiantePregrado estudiante = new EstudiantePregrado(nombre, edad);

            boolean agregandoCalificaciones = true;
            while (agregandoCalificaciones) {
                System.out.print("Ingrese una asignatura (-1 para finalizar): ");
                String asignatura = lector.readLine();

                if (asignatura.equals("-1")) {
                    agregandoCalificaciones = false;
                } else {
                    System.out.print("Ingrese una calificación: ");
                    int calificacion = Integer.parseInt(lector.readLine());

                    estudiante.agregarCalificacion(asignatura, calificacion);
                }
            }

            estudiantes.add(estudiante);
            escribirEstudianteArchivo(estudiante);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer la entrada.");
            e.printStackTrace();
        }
    }

    private void agregarEstudiantePosgrado() {
        try {
            System.out.print("Ingrese el nombre del estudiante: ");
            String nombre = lector.readLine();

            System.out.print("Ingrese la edad del estudiante: ");
            int edad = Integer.parseInt(lector.readLine());

            EstudiantePosgrado estudiante = new EstudiantePosgrado(nombre, edad);
            
            boolean agregandoCalificaciones = true;
            while (agregandoCalificaciones) {
                System.out.print("Ingrese una asignatura (-1 para finalizar): ");
                String asignatura = lector.readLine();

                if (asignatura.equals("-1")) {
                    agregandoCalificaciones = false;
                } else {
                    System.out.print("Ingrese una calificación: ");
                    int calificacion = Integer.parseInt(lector.readLine());

                    estudiante.agregarCalificacion(asignatura, calificacion);
                }
            }

            estudiantes.add(estudiante);
            escribirEstudianteArchivo(estudiante);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer la entrada.");
            e.printStackTrace();
        }
    }

    private void calcularPromedioCalificaciones() {
        try {
            System.out.print("Ingrese el nombre del estudiante: ");
            String nombre = lector.readLine();

            boolean encontrado = false;
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getNombre().equals(nombre)) {
                    double promedio = estudiante.calcularPromedioCalificaciones();
                    System.out.println("Promedio de calificaciones para " + estudiante.getNombre() + ": " + promedio);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Estudiante no encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer la entrada.");
            e.printStackTrace();
        }
    }

    private void escribirEstudianteArchivo(Estudiante estudiante) {
        try {
            escritor.write("Nombre: " + estudiante.getNombre() + "\n");
            escritor.write("Edad: " + estudiante.getEdad() + "\n");

            if (estudiante instanceof EstudiantePregrado) {
                EstudiantePregrado estudiantePregrado = (EstudiantePregrado) estudiante;
                Map<String, List<Integer>> calificaciones = estudiantePregrado.calificaciones;

                escritor.write("Tipo: Estudiante de Pregrado\n");
                escritor.write("Calificaciones:\n");

                for (Map.Entry<String, List<Integer>> entry : calificaciones.entrySet()) {
                    String asignatura = entry.getKey();
                    List<Integer> califs = entry.getValue();

                    escritor.write("- Asignatura: " + asignatura + "\n");
                    escritor.write("  Calificaciones: " + califs.toString() + "\n");
                }
            } else if (estudiante instanceof EstudiantePosgrado) {
                EstudiantePosgrado estudiantePosgrado = (EstudiantePosgrado) estudiante;
                Map<String, List<Integer>> calificaciones = estudiantePosgrado.calificaciones;
                
                
                escritor.write("Tipo: Estudiante de Posgrado\n");
                escritor.write("Calificaciones:\n");
                
                for (Map.Entry<String, List<Integer>> entry : calificaciones.entrySet()) {
                    String asignatura = entry.getKey();
                    List<Integer> califs = entry.getValue();
                    
                    escritor.write("- Asignatura: " + asignatura + "\n");
                    escritor.write("  Calificaciones: " + califs.toString() + "\n");
                }
            }

            escritor.write("\n");
            escritor.flush();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }
}
