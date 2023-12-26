import java.util.Scanner;

public class Cajero {

    private float saldo;
    private float tope;
    private Scanner teclado = new Scanner(System.in);

    private Cajero(float saldo, float tope) {
        this.saldo = saldo;
        this.tope = tope;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Meta usted los valores de su cuenta y el tope que le quiera agregar");
            System.exit(-1);
        }

        float saldo = Float.parseFloat(args[0]);
        float tope = Float.parseFloat(args[1]);
        Cajero cuentaBancaria = new Cajero(saldo, tope);
        cuentaBancaria.menu();
    }

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
                case "1" -> retirada();
                case "2" -> ingreso();
                case "3" -> bucle = false;
                default -> System.out.println("¡Vaya esa opción no es válida, intentelo de nuevo!");
            }
        }

    }

    private void retirada() {
        verif_saldo();
        funcionRetirada();
        verif_saldo();
    }

    private void ingreso(){
        verif_saldo();
        funcionIngreso();
        verif_saldo();
    }

    private void verif_saldo() {
        System.out.println("\nSu saldo actual es de: " + saldo + "€");
    }

    private void verif_tope(){
        System.out.println("\nTiene establecido ahora un tope de " + tope + "€");
    }

    private void funcionIngreso(){
        System.out.println("Teclee dinero a ingresar:");
        int opcion = teclado.nextInt();
        teclado.nextLine();
        System.out.println("\nUsted ingresó " + opcion +"€");
        saldo += opcion;
    }

    private void funcionRetirada(){
        System.out.println("Teclee dinero a retirar:");
        int opcion = teclado.nextInt();
        teclado.nextLine();
        if (opcion > tope) {
            System.out.println("\nIntenta retirar " + opcion + "€");
            verif_tope();
            verif_saldo();

        } else if (opcion <= tope){
            System.out.println("\nUsted retiró " + opcion +"€");
            saldo -= opcion;
    }
}
}

