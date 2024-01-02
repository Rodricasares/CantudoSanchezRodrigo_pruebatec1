# ControlPersistencia - Aplicación CRUD de Empleados

Este proyecto implementa una aplicación básica en Java para realizar operaciones CRUD en la entidad `Empleados` utilizando JPA (Java Persistence API). La aplicación proporciona una interfaz de línea de comandos para interactuar con la base de datos de empleados.

## Estructura del Proyecto

- `ControlPersistencia.java`: Clase principal que contiene métodos para crear, editar, borrar, listar empleados y obtener empleados por cargo.
- `EmpleadosJpaController.java`: Controlador JPA que gestiona las operaciones CRUD en la base de datos para la entidad `Empleados`.
- `Empleados.java`: Clase que representa la entidad Empleados con sus atributos.

## Requisitos Previos

- Java JDK instalado en tu entorno de desarrollo.
- Configuración de una base de datos compatible con JPA (verifica tu archivo `persistence.xml`).

En la que agregamos la dependencia 

## Uso de la Aplicación

1. **Crear Empleado:**
    - Ingresa el nombre, apellido, cargo, salario y fecha de inicio del nuevo empleado.

Se interactúa con el usuario para solicitar los datos básicos para ingresar user a la base de datos empleados.

2. **Borrar Empleado:**
    - Muestra la lista de empleados y solicita el ID del empleado a borrar.

Mediante una impresión previa aprovechando el método findEmpleados(), le mostrará la lista de empleados para que el usuario mediante sus id decida qué usuario desea borrar.

3. **Editar Empleado:**
    - Muestra la lista de empleados y solicita el ID del empleado a editar.
    - Ingresa los nuevos datos del empleado.

Nuevamente implementó findempleados  y se le pasa la id como parámetro, para listar la base de datos y poder manipular los empleados, seguidamente deberá modificar cada campo del usuario seleccionado.

4. **Listar Empleados:**
    - Muestra la lista completa de empleados en la base de datos.

Mediante el método findEmpleados volvemos a listar únicamente lectura de la tabla empleados.

5. **Listar Empleados por Cargo:**
    - Solicita el cargo y muestra la lista de empleados que tienen ese cargo.
En este caso se lista la tabla empleados nuevamente con findEmpleados, pero para el filtrado utilizar un for each acompañado del método equalsIgnoreCase(cargo), al cual se le asigna el valor cargo para dicho filtrado. También se le adjunta un a variable boolean para en caso de que el cargo no se encuentre en la tabla el sistema lo haga saber.

## Ejecución del Programa

En la clase main he creado un menú “interactivo”, mediante el cual podremos ingresar a las diferentes opciones que nos proporciona nuestro CRUD con una estructura de control switch

. Ejecuta la clase `ControlPersistencia.java` desde tu entorno de desarrollo.

. Sigue las instrucciones en la consola para realizar las operaciones CRUD.

## Configuración Adicional

- Asegúrate de que tu archivo `persistence.xml` esté correctamente configurado para la unidad de persistencia.

- Revisa y ajusta la configuración de la base de datos en caso de ser necesario.

-------------------------------------------------Advertencias--------------------------------------------------------

¡Espero que este README te sea útil! Asegúrate de personalizarlo según las características específicas de tu proyecto y de proporcionar información adicional que pueda ser relevante para otros desarrolladores que utilicen tu aplicación. Siéntete libre de agregar secciones adicionales según sea necesario.


