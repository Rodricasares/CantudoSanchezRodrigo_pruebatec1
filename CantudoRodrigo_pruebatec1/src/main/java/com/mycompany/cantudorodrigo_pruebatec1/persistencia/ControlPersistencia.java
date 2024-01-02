/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantudorodrigo_pruebatec1.persistencia;

import com.mycompany.cantudorodrigo_pruebatec1.logica.Empleados;
import com.mycompany.cantudorodrigo_pruebatec1.persistencia.exceptions.NonexistentEntityException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodri
 */
public class ControlPersistencia {

    EmpleadosJpaController empleadosControler = new EmpleadosJpaController();
    Scanner scn = new Scanner(System.in);

    public void createEmployee() {

        System.out.println("------------------------------------------");
        System.out.println("|            Crear Empleado              |");
        System.out.println("|                                        |");
        System.out.println("------------------------------------------");

        System.out.println("Ingresa el nombre del empleado:");
        String empleadoNombre = scn.nextLine();

        System.out.println("Ingresa el apellido del empleado:");
        String empleadoApellido = scn.nextLine();

        System.out.println("Ingresa el cargo del empleado:");
        String empleadoCargo = scn.nextLine().toLowerCase();

        System.out.println("Ingresa el salario del empleado:");
        double empleadoSalario = scn.nextDouble();

        System.out.println("Ingresa la fecha de inicio del empleado (Formato: YYYY-MM-DD):");
        scn.nextLine();

        String fechaInicioStr = scn.nextLine();

        Empleados crearEmpleado = new Empleados(empleadoNombre, empleadoApellido, empleadoCargo, empleadoSalario, fechaInicioStr);

        empleadosControler.create(crearEmpleado);

        System.out.println("El emplead@ fue creado con exito: " + "\nNombre: " + empleadoNombre + "\nApellido: " + empleadoApellido + "\nCargo: " + empleadoCargo);

    }

    //Burrar empleado por Id
    public void deleteEmployee() {
        System.out.println("------------------------------------------");
        System.out.println("|           Borrar Empleado              |");
        System.out.println("|                                        |");
        System.out.println("------------------------------------------");

        System.out.println(empleadosControler.findEmpleadosEntities());
        System.out.println("Ingresa el Id del emplead@ a eliminar: ");

        int id = (scn.nextInt());
        if (empleadosControler.findEmpleados(id) != null) {
            try {
                empleadosControler.destroy(id);
                System.out.println("\nEl empleado con Id: " + id + " a sido eliminado de la tabla Empleados");
                System.out.println(empleadosControler.findEmpleadosEntities());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ControlPersistencia.class.getName()).log(Level.SEVERE, "El" + id + " no se encuentra en nuestra base de datos Empleados", ex);
            }
        } else {
            System.out.println("No se puede eliminar el usuario con id: " + id + " ya que no existe en la tabla Empleados");
        }
    }

// editar empleado
    public void editEmployee() {
        System.out.println("------------------------------------------");
        System.out.println("|            Editar Empleado             |");
        System.out.println("------------------------------------------");
        System.out.println(empleadosControler.findEmpleadosEntities());
        //Insertar el Id del empleado a editar
        System.out.println("Ingresa Id del empleado a editar:");
        int id = scn.nextInt();
        scn.nextLine();

        Empleados editarEmpleado = empleadosControler.findEmpleados(id);

        if (editarEmpleado != null) {
            try {

                System.out.println("Editando registro nombre del empleado:");
                String empleadoNombre = scn.nextLine();

                System.out.println("Editando registro apellido del empleado:");
                String empleadoApellido = scn.nextLine();

                System.out.println("Editando registro cargo del empleado:");
                String empleadoCargo = scn.nextLine().toLowerCase();

                System.out.println("Editando registro salario del empleado:");
                double empleadoSalario = scn.nextDouble();

                System.out.println("Editando registro fecha de inicio del empleado (Formato: YYYY-MM-DD):");
                scn.nextLine();
                String fechaInicioStr = scn.nextLine();
                //LocalDate empleadoFechaInicio = LocalDate.parse(fechaInicioStr);

                editarEmpleado.setNombre(empleadoNombre);
                editarEmpleado.setApellidos(empleadoApellido);
                editarEmpleado.setCargo(empleadoCargo);
                editarEmpleado.setSalario(empleadoSalario);
                editarEmpleado.setFechaInicio(fechaInicioStr);

                //Editar el empleado
                empleadosControler.edit(editarEmpleado);

                System.out.println("El empleado con Id " + id + " se editó correctamente.");
            } catch (Exception ex) {
                System.err.println("Error al editar el empleado: " + ex.getMessage());
            }
        } else {
            System.out.println("No se encontró un empleado con el id:" + id + " no se encuentra en la tabla Empleados.");
        }
    }
//Listar emplead@s 

    public List<Empleados> findEmpleadosEntities() {
        System.out.println("------------------------------------------");
        System.out.println("|            Listar Empleados            |");
        System.out.println("|                                        |");
        System.out.println("------------------------------------------");

        System.out.println(empleadosControler.findEmpleadosEntities());

        return null;
    }
//Obtener lista  según el cargo de l@s emplead@s. 

    public void getEmployeeRole() {
        System.out.println("------------------------------------------");
        System.out.println("|            Listar empleado             |");
        System.out.println("|               por cargo                |");
        System.out.println("------------------------------------------");
        System.out.println("Ingrese el cargo a buscar: ");
        String cargo = scn.nextLine().toLowerCase();

        List<Empleados> listarEmpleados = empleadosControler.findEmpleadosEntities();

        boolean empleadosEncontrados = false;

        for (Empleados empleado : listarEmpleados) {
            if (empleado.getCargo().equalsIgnoreCase(cargo)) {
                String nombre = empleado.getNombre() + " Cargo: ·" + empleado.getCargo();
                System.out.println("Nombre: " + nombre);
                empleadosEncontrados = true;
            }
        }

        if (!empleadosEncontrados) {
            System.out.println("No se encontraron empleados con el cargo " + cargo + " especificado.");
        }
    }
}
