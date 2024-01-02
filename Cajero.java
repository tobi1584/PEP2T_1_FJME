import java.util.Locale;
import java.util.Scanner; // Importo Scanner, que servirá para que el usuario meta datos por teclado

public class Cajero { // Clase en la que se hará el programa

    private float saldo; // Atributo para el saldo del objeto
    private final float tope; // Atributo para el tope del objeto

    private final Scanner teclado = new Scanner(System.in).useLocale(Locale.US); // Objeto Scanner para entrada de datos

    // Constructor privado para inicializar saldo y tope del cajero
    private Cajero(float saldo, float tope) {
        this.saldo = saldo;
        this.tope = tope;
    }

    // Método principal main
    public static void main(String[] args) {
        if (args.length != 2) { // Verifica si se proporcionan dos argumentos al ejecutar el programa
            System.out.println("\n\033[1mMeta usted los valores de su cuenta y el tope que le quiera agregar.\033[0m");
            System.exit(-1); // Termina el programa si no se proporcionan los argumentos necesarios
        }

        // Meto los argumentos que variables tipo float
        float saldo = Float.parseFloat(args[0]);
        float tope = Float.parseFloat(args[1]);

        // Creo un objeto Cajero con los valores proporcionados
        Cajero cuentaBancaria = new Cajero(saldo, tope);
        cuentaBancaria.menu(); // Llamo al método menu() para iniciar el programa
    }

    // Método para mostrar el menú y manejar las opciones del cajero
    private void menu() {
        System.out.println("\t\t\t\t\033[4mPROGRAMA CAJERO AUTOMÁTICO\033[0m");

        boolean bucle = true;
        while (bucle) {
            // Menú de opciones
            System.out.println("\n\t\t\t\tMenú de Opciones");
            System.out.println("\t\t\t\t================\n");
            System.out.println("\t\t\t\t1) Retirada de dinero");
            System.out.println("\t\t\t\t2) Ingreso de dinero");
            System.out.println("\t\t\t\t3) Salir");
            System.out.print("\nDiga la opción que desea usar: ");
            String opcion = teclado.nextLine();
            System.out.println();

            switch (opcion) {
                case "1" -> retirada(); // Llama al método retirada()
                case "2" -> ingreso(); // Llama al método ingreso()
                case "3" -> bucle = false; // Si se teclea 3, termina el bucle
                default -> System.out.println("¡Vaya esa opción no es válida, intentelo de nuevo!");
            }
        }
    }

    // Método para realizar una retirada de dinero
    private void retirada() {
        verif_saldo(); // Muestra el saldo actual
        funcionRetirada(); // Realiza la retirada de dinero
        verif_saldo(); // Muestra el saldo actual después de la operación
    }

    // Método para realizar un ingreso de dinero
    private void ingreso() {
        verif_saldo();
        funcionIngreso();
        verif_saldo();
    }

    // Método para mostrar el saldo actual
    private void verif_saldo() {
        System.out.println("\nSu saldo actual es de: " + saldo + "€");
    }

    // Método para mostrar el tope actual
    private void verif_tope() {
        System.out.println("\nTiene establecido ahora un tope de " + tope + "€");
    }

    // Método para realizar un ingreso de dinero
    private void funcionIngreso() {
        System.out.print("Teclee dinero a ingresar: ");
        float opcion = teclado.nextFloat(); // Lee la cantidad de dinero a ingresar
        teclado.nextLine(); // Limpia el buffer del Scanner
        System.out.println("\nUsted ingresó " + opcion + "€");
        saldo += opcion; // Incrementa el saldo con la cantidad ingresada
    }

    // Método para realizar una retirada de dinero
    private void funcionRetirada() {
        System.out.print("Teclee dinero a retirar: ");
        float opcion = teclado.nextInt(); // Lee la cantidad de dinero a retirar
        teclado.nextLine(); // Limpia el buffer del Scanner
        if (opcion > saldo) {
            System.out.println("\n¡Vaya estas intentando retirar más dinero del que tienes!");
        } else if (opcion <= tope) {
            System.out.println("\nUsted retiró " + opcion + "€");
            saldo -= opcion; // Reduce el saldo con la cantidad retirada
        }else if (tope < opcion) {
            System.out.println("\nIntenta retirar " + opcion + "€");
            verif_tope(); // Muestra el tope actual si se excede
        }
    }
}