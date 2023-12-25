import java.util.Scanner;  // Importación de la clase Scanner para entrada de datos

// Clase del programa
public class Cajero {

    // Método principal
    public static void main(String[] args) {
        // Atributos - Aquí se obtienen y asignan valores a partir de los argumentos pasados al programa
        float verif_saldo = Float.parseFloat(args[1]);  // Se convierte el segundo argumento a un número decimal
        int verif_tope = Integer.parseInt(args[0]);  // Se convierte el primer argumento a un número entero

        // Llamada al método del menú
        menu();
    }

    // Método del menú
    public static void menu() {
        System.out.println("\t\t\t\t\033[4mPROGRAMA CAJERO AUTOMÁTICO\033[0m");  // Encabezado del programa

        boolean bucle = true;  // Variable para controlar el bucle del menú
        while (bucle) {
            // Menú de opciones
            System.out.println("\n\t\t\t\tMenú de Opciones");
            System.out.println("\t\t\t\t================\n");
            System.out.println("1) Retirada de dinero");
            System.out.println("2) Ingreso de dinero");
            System.out.println("3) Salir");

            // Selector de opción por parte del usuario
            System.out.println("\nDiga la opción que desea usar: ");
            int opcion;
            Scanner teclado = new Scanner(System.in);
            opcion = teclado.nextInt();  // Se lee la opción ingresada por el usuario

            // Bucle para validar la opción ingresada por el usuario
            while (opcion < 1 || opcion > 3) {
                System.out.println("¡Vaya esa opción no es válida, intentelo de nuevo!");
                System.out.println("\nDiga la opción que desea usar: ");
                opcion = teclado.nextInt();  // Se vuelve a leer la opción si es inválida
            }
            // Se muestra la opción escogida por el usuario
            System.out.println("\nOpción: " + opcion);

            // Lógica para cada opción seleccionada por el usuario
            if (opcion == 1)
                retirada();  // llamada al método retirada
            else if (opcion == 2)
                System.out.println("Adios");  // llamad al método ingreso
            else
                bucle = false;  // Termina el bucle
        }
    }
    public static void retirada(){
        System.out.println();
    }
}
