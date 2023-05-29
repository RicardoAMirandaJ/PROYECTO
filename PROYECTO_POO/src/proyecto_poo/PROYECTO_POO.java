/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_poo;

import java.util.Scanner;

/**
 *
 * @author ricar
 */
public class PROYECTO_POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del alumno: ");
        String nombreAlumno = scanner.nextLine();
        Alumno alumno = new Alumno(nombreAlumno);

        System.out.print("¿Cuántas materias tiene el alumno? ");
        int numMaterias = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numMaterias; i++) {
            System.out.print("Ingrese el nombre de la materia " + (i + 1) + ": ");
            String nombreMateria = scanner.nextLine();
            Materia materia = new Materia(nombreMateria);

            try {
                System.out.print("Ingrese la calificación de la materia: ");
                double calificacion = Double.parseDouble(scanner.nextLine());
                materia.setCalificacion(calificacion);
            } catch (NumberFormatException e) {
                System.out.println("La calificación ingresada no es válida. Se asignará 0.0 por defecto.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            alumno.agregarMateria(materia);
        }

        alumno.mostrarCalificaciones();
        }
    }
