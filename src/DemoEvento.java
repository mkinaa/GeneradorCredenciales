import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoEvento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CredencialPrototype plantilla = new CredencialPrototype();
        ArrayList<CredencialPrototype> credenciales = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar nueva credencial");
            System.out.println("2. Ver credenciales generadas");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el cargo: ");
                    String cargo = scanner.nextLine();

                    System.out.print("Ingrese el RUT: ");
                    String rut = scanner.nextLine();

                    LocalDate fechaCaducidad = null;
                    boolean fechaValida = false;

                    while (!fechaValida) {
                        try {
                            System.out.print("Ingrese la fecha de caducidad (AAAA-MM-DD): ");
                            String fechaStr = scanner.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
                            fechaCaducidad = LocalDate.parse(fechaStr, formatter);
                            fechaValida = true;
                        } catch (Exception e) {
                            System.out.println("Formato de fecha inválido. Por favor use el formato correcto (ej. 2025-05-12).");
                        }
                    }

                    CredencialPrototype clon = plantilla.clone();
                    clon.setNombre(nombre);
                    clon.setCargo(cargo);
                    clon.setRut(rut);
                    clon.setFechaCaducidad(fechaCaducidad);

                    credenciales.add(clon);
                    System.out.println("Credencial generada para: " + nombre + "\nNo olvidar que esta credencial vence el: " + fechaCaducidad);
                    break;

                case 2:
                    System.out.println("Credenciales generadas:");
                    for (CredencialPrototype c : credenciales) {
                        System.out.println("- Nombre: " + c.getNombre());
                        System.out.println("  Cargo: " + c.getCargo());
                        System.out.println("  RUT: " + c.getRut());
                        System.out.println("  Fecha de Caducidad: " + c.getFechaCaducidad());
                    }
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}

