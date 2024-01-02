/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cantudorodrigo_pruebatec1;

import com.mycompany.cantudorodrigo_pruebatec1.persistencia.ControlPersistencia;
import java.util.Scanner;

/**
 *
 * @author rodri
 */
public class CantudoRodrigo_pruebatec1 {

    public static void main(String[] args) {
        ControlPersistencia empleadoControladora = new ControlPersistencia();
        Scanner scn = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("------------------------------------------------");
            System.out.println("|                Menu Empleados                |");
            System.out.println("|             Proyecto: pruebatec1             |");
            System.out.println("------------------------------------------------");
            System.out.println("|1. Crear emplead@.                            |");
            System.out.println("|2. Borrar emplead@.                           |");
            System.out.println("|3. Listar emplead@/@s por cargo.              |");
            System.out.println("|4. Listar los emplead@s de la tabla Emplead@s.|");
            System.out.println("|5. Editar emplead@ de la tabla Emplead@s.     |");
            System.out.println("|6. Salir.                                     |");
            System.out.println("------------------------------------------------");
            System.out.println("------------------------------------------------");

            System.out.print("Ingrese el número de la opción: ");
            opcion = scn.nextInt();
            System.out.println("------------------------------------------------");

            switch (opcion) {
                case 1:
                    System.out.println("Crear un empleado en la tabla Empleados");
                    empleadoControladora.createEmployee();
                    break;
                case 2:
                    System.out.println("Borrar el empleado de la tabla Empleados");
                    empleadoControladora.deleteEmployee();
                    break;
                case 3:
                    System.out.println("Listar empleados por Role");
                    empleadoControladora.getEmployeeRole();
                    break;
                case 4:
                    System.out.println("Listar empleados de la tabla Empleados");
                    empleadoControladora.findEmpleadosEntities();
                    break;
                case 5:
                    System.out.println("Editar empleados de la tabla Empleados");
                    empleadoControladora.editEmployee();
                    break;
                case 6:
                    System.out.println("Salir de la tabla Empleados ");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige nuevamente.");
                    break;
            }

        } while (opcion != 6);

        // Cerrar el scanner al salir
        scn.close();

    }
}
