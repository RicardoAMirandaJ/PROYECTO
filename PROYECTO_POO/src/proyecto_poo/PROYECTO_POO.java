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
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de materias: ");
        int numMaterias = sc.nextInt();
        double promedio = 0;
        for (int i = 1; i <= numMaterias; i++) {
            System.out.println("Materia " + i + ":");
            System.out.print("Asistencia (10%): ");
            double asistencia = sc.nextDouble();
            System.out.print("Examen (60%): ");
            double examen = sc.nextDouble();
            System.out.print("Tareas (20%): ");
            double tareas = sc.nextDouble();
            System.out.print("Participación (10%): ");
            double participacion = sc.nextDouble();
            double calificacionFinal = (asistencia * 0.1) + (examen * 0.6) + (tareas * 0.2) + (participacion * 0.1);
            System.out.println("Calificación final: " + calificacionFinal);
            promedio += calificacionFinal;
        }
        promedio /= numMaterias;
        System.out.println("Promedio general: " + promedio);
        if (promedio >= 7) {
            System.out.println("ACREDITA");
        } else {
            System.out.println("NO ACREDITA");
        }
    }
}
