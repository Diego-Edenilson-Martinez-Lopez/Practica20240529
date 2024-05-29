import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Empleado> empleados = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese el ID del empleado:");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.println("Ingrese el nombre del empleado:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el apellido del empleado:");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese el departamento del empleado:");
            String departamento = scanner.nextLine();

            System.out.println("Ingrese el salario del empleado:");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer

            Empleado empleado = new Empleado(id, nombre, apellido, departamento, salario);
            empleados.add(empleado);

            System.out.println("¿Desea agregar otro empleado? (s/n):");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }

        Collections.sort(empleados, Comparator.comparingInt(Empleado::getId).reversed());

        System.out.println("Empleados registrados:");
        Iterator<Empleado> iterator = empleados.iterator();
        while (iterator.hasNext()) {
            Empleado empleado = iterator.next();
            System.out.println(empleado);
        }

        scanner.close();
    }
}
