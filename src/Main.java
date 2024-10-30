import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENU DE OPCIONES");
            System.out.println("1. Insertar Empleado");
            System.out.println("2. Consultar Empleados");
            System.out.println("3. Actualizar Empleado");
            System.out.println("4. Eliminar Empleado");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido paterno: ");
                    String paSurname = scanner.nextLine();
                    System.out.print("Ingrese el apellido materno: ");
                    String maSurname = scanner.nextLine();
                    System.out.print("Ingrese el email: ");
                    String email = scanner.nextLine();
                    System.out.print("Ingrese el salario: ");
                    double salario = scanner.nextDouble();
                    ConexionMySQL.insertarEmpleado(nombre, paSurname, maSurname, email, salario);
                    break;
                case 2:
                    ConexionMySQL.consultarEmpleados();
                    break;
                case 3:
                    System.out.print("Ingrese el ID del empleado a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese el nuevo apellido paterno: ");
                    String nuevoPaSurname = scanner.nextLine();
                    System.out.print("Ingrese el nuevo apellido materno: ");
                    String nuevoMaSurname = scanner.nextLine();
                    System.out.print("Ingrese el nuevo email: ");
                    String nuevoEmail = scanner.nextLine();
                    System.out.print("Ingrese el nuevo salario: ");
                    double nuevoSalario = scanner.nextDouble();
                    ConexionMySQL.actualizarEmpleado(idActualizar, nuevoNombre, nuevoPaSurname, nuevoMaSurname, nuevoEmail, nuevoSalario);
                    break;
                case 4:
                    System.out.print("Ingrese el ID del empleado a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    ConexionMySQL.eliminarEmpleado(idEliminar);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
