package HELADERIAAAAAAA;

import java.util.Scanner;

public class MochisNORMAL {

    private static int mochisVitrinaPrincipal;
    private static int mochisVitrinaSecundaria;
    private static int mochisBodega;
    private static int mochisVendidos;
    private static int contadorMochisVendidos;
    private static int empaquesVendidos;
    private static int contadorEmpaquesVendidos;


    private static final int PRECIO_EMPAQUE = 700;
    private static final int PRECIO_HELADO = 5000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBienvenida Mi Gaby<3 \nSere tu asistente para ayudarte con las cuentas");
        System.out.println("Que lindo poder acompañarte ^-^");
        System.out.println("\ndale clic a la pantalla con cariño para continuar :D\n");

        // Registrar mochis al inicio
        System.out.print("\nIngresa porfa la cantidad de Mochis en la Vitrina Principal: ");
        mochisVitrinaPrincipal = scanner.nextInt();

        System.out.print("a continuacion la cantidad de Mochis en la Vitrina Secundaria: ");
        mochisVitrinaSecundaria = scanner.nextInt();

        System.out.print("Por ultimo la cantidad de Mochis en la Bodega: ");
        mochisBodega = scanner.nextInt();

        System.out.println("\n¡Perfecto! lo hiciste increible :3\n Espero poder ser de gran ayuda, verifica los datos a continuacion <3");

        while (true) {
            mostrarInformacion();

            System.out.println("Elige la opcion que deseas realizar\n presionando el numero + Enter");
            System.out.println("\n1. VENDER Mochiiss ");
            System.out.println("2. VENDER Empaques "); 
            System.out.println("3. Mover Mochis de la Bodega a la Vitrina Principal");
            System.out.println("4. Mover Mochis de la Bodega a la Vitrina Secundaria");
            System.out.println("5. Mover Mochis de la SECUNDARIA a la Principal");
            System.out.println("6. Mover Mochis de la PRINCIPAL a la Secundaria");
            System.out.println("\n9. Salir");

            System.out.println("\n\t\t\t\t\t~fijate bien antes de dar Enter~");
            System.out.println("\t~~~~~tener en cuenta que si se da la opcion (9. Salir) se eliminaran los registros actuales~~~");
            System.out.print("\nSelecciona una opción: ");
            
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    venderMochi();
                    break;
                case 2:
                    venderEmpaques();
                    break;
                case 3:
                    moverMochis("bodega", "vitrina principal");
                    break;
                case 4:
                    moverMochis("bodega", "vitrina secundaria");
                    break;
                case 5:
                    moverMochis("vitrina secundaria", "vitrina principal");
                    break;
                case 6:
                    moverMochis("vitrina principal", "vitrina secundaria");
                    break;
                case 9:
                    System.out.println("¡Gracias por usar el sistema de la Tienda de Mochis! \n Te mando un besote mi amor :$ bueno muchoss jeje <3 ");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }
        }
    }

    private static void moverMochis(String origen, String destino) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngrese la cantidad de Mochis a mover de " + origen + " a " + destino + ": ");
        int cantidad = scanner.nextInt();

        switch (origen) {
            case "bodega":
                if (cantidad <= mochisBodega) {
                    mochisBodega -= cantidad;

                    switch (destino) {
                        case "vitrina principal":
                            mochisVitrinaPrincipal += cantidad;
                            break;
                        case "vitrina secundaria":
                            mochisVitrinaSecundaria += cantidad;
                            break;
                    }

                    System.out.println("\nSe movieron " + cantidad + " de mochis exitosamente de " + origen + " a " + destino + ".");
                } else {
                    System.out.println("No hay suficientes mochis en la bodega.");
                }
                break;
            case "vitrina secundaria":
                if (cantidad <= mochisVitrinaSecundaria) {
                    mochisVitrinaSecundaria -= cantidad;

                    switch (destino) {
                        case "vitrina principal":
                            mochisVitrinaPrincipal += cantidad;
                            break;
                    }

                    System.out.println("\nSe movieron "+ cantidad +" mochis exitosamente de " + origen + " a " + destino + ".");
                } else {
                    System.out.println("No hay suficientes mochis en la vitrina secundaria.");
                }
                break;
            case "vitrina principal":
                if (cantidad <= mochisVitrinaPrincipal) {
                    mochisVitrinaPrincipal -= cantidad;

                    switch (destino) {
                        case "vitrina secundaria":
                            mochisVitrinaSecundaria += cantidad;
                            break;
                    }

                    System.out.println("\nSe movieron "+ cantidad +" mochis exitosamente de " + origen + " a " + destino + ".");
                } else {
                    System.out.println("No hay suficientes mochis en la vitrina secundaria.");
                }
                break;
        }
    }

    private static void venderMochi() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngresa la cantidad de Mochis a vender: ");
        int cantidad = scanner.nextInt();

        if (cantidad <= mochisVitrinaPrincipal + mochisVitrinaSecundaria) {
            int temp = mochisVitrinaPrincipal;
            mochisVitrinaPrincipal -= Math.min(cantidad, mochisVitrinaPrincipal);
            if(mochisVitrinaPrincipal == 0){
                int temp2 = cantidad - temp;
                mochisVitrinaSecundaria -= Math.max(0, temp2 - mochisVitrinaPrincipal);
            }
            //mochisVitrinaSecundaria -= Math.max(0, cantidad - mochisVitrinaPrincipal);
            mochisVendidos += cantidad * PRECIO_HELADO;
            contadorMochisVendidos += cantidad;

            System.out.println("\nMOCHIS VENDIDOS EXITOSAMENTE.\n\n la estas dando todisimaa ¡ERES LA MEJOOR! ~     se actualizo la tabla      " + cantidad + " MOCHIS DIJERON BYEEE :P");
            if(cantidad == 5){
                System.out.println("Ufff 5 mochis? ñaaammm ¡Compaltaan!");
            }
            if ((cantidad > 6)) {
                System.out.println("\nDios mio, ¿tenian como antojo de mochis no? jsjsj \n jeje Te amochi muchi <3");
            }
            //if(contadorMochisVendidos == 50){
             //   System.out.println("\nYA VENDISTE 50 MOCHISS? ERES ASOMBROSAAA MI AMOOOOR");
          //  }
        } else {
            System.out.println("No hay suficientes mochis en las vitrinas :(");
        }
    }

    private static void venderEmpaques() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("\nIngresa la cantidad de Empaques a vender: ");
        int cantidadEmpaques = scanner.nextInt();
    
            empaquesVendidos += cantidadEmpaques * PRECIO_EMPAQUE;
            contadorEmpaquesVendidos += cantidadEmpaques;

             if (cantidadEmpaques > 5) {
                System.out.println("¡Wow! Más de cinco empaques. esa es mas de la cantidad de empaques que se suele vender en un dia jsjs");
            }   

            System.out.println("\nEMPAQUES VENDIDOS EXITOSAMENTE.   se actualizo la info de empaques en la tabla");
    }
    

    private static void mostrarInformacion() {
        System.out.println("\n\t\t\t----- Información de la Tienda de Mochis -----");
        System.out.println("\t\t\t|  Mochis en la Vitrina Principal: " + mochisVitrinaPrincipal);
        System.out.println("\t\t\t|  Mochis en la Vitrina Secundaria: " + mochisVitrinaSecundaria);
        System.out.println("\t\t\t|  Mochis en la Bodega: " + mochisBodega);
        System.out.println("\t\t\t|  Total Vendido: " + mochisVendidos + "$");
        System.out.println("\t\t\t|  Cantidad de Mochis Vendidos: " + contadorMochisVendidos);
        System.out.println("\t\t\t----------------------------------------------");
        System.out.println("\t\t\t|  Total vendido de Empaques: " + empaquesVendidos + "$");
        System.out.println("\t\t\t|  Cantidad de Empaques Vendidos: " + contadorEmpaquesVendidos);

        System.out.println("\t\t\t----------------------------------------------\n");

    }
}