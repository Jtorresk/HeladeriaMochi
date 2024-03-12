package HELADERIAAAAAAA;

import java.util.Scanner;

public class MochisTRANSFER {

    private static int mochisVitrinaPrincipal;
    private static int mochisVitrinaSecundaria;
    private static int mochisBodega;
    private static int mochisVendidos;
    private static int contadorMochisVendidos;
    private static int empaquesVendidos;
    private static int contadorEmpaquesVendidos;
    private static int mochisTransferidos;
    private static int contadorTransferidos;
    private static int totalVENDIDO;
    private static int contadorTOTAL;
    private static int dineroBASE;

    private static final int PRECIO_EMPAQUE = 1000;
    private static final int PRECIO_MOCHI = 5000;

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

        System.out.print("Ingresa el dinero de la BASE: ");
        dineroBASE = scanner.nextInt();

        System.out.print("Por ultimo la cantidad de Mochis en la Bodega: ");
        mochisBodega = scanner.nextInt();

        System.out.println("\n¡Perfecto! lo hiciste increible :3\n Espero poder ser de gran ayuda, verifica los datos a continuacion <3");


        //impresion del menu de opciones
        while (true) {
            mostrarInformacion();

            System.out.println("\t\t\tElige la opcion que deseas realizar presionando el numero + Enter");
            System.out.println("1. EFECTIVOOO");
            System.out.println("2. Vender Empaques "); 
            System.out.println("3. TRANSFEEEERENCIAAA");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("6. Mover Mochis de la BODEGA a la Vitrina PRINCIPAL");
            System.out.println("7. Mover Mochis de la BODEGA a la Vitrina Secundaria");
            System.out.println("8. Mover Mochis de la SECUNDARIA a la Principal");
            System.out.println("9. Mover Mochis de la PRINCIPAL a la Secundaria");
            System.out.println("000. Salir");
            System.out.println("\t\t\t\t\t~fijate bien antes de dar Enter~");
            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
                    registrarTransferencia();
                    break;
                case 6:
                    moverMochis("bodega", "vitrina principal");
                    break;
                case 7:
                    moverMochis("bodega", "vitrina secundaria");
                    break;
                case 8:
                    moverMochis("vitrina secundaria", "vitrina principal");
                    break;
                case 9:
                    moverMochis("vitrina principal", "vitrina secundaria");
                    break;
                case 000:
                    System.out.println("¡Gracias por usar el sistema de la Tienda de Mochis! \n Te mando un besote mi amor :$ bueno muchoss jeje <3 ");
                
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
                    System.out.println("1. Venderen Efectivo ~~ 2. Vender Empaque ~~ 3. Vender por Transferencia");
                    System.out.println("\t\t\t o    6, 7, 8, 9 si deseas surtir ");


            }

            totalVENDIDO = ( mochisTransferidos + mochisVendidos);
            contadorTOTAL = (contadorMochisVendidos + contadorTransferidos);
        }
    }

    /*private static void imprimirMensajeMotivacional() {
     
        System.out.println("Recuerda que ~~~~~");
        System.out.println("cada venta que haces ~~~~");
        System.out.println("es un pasito mas cerca de Italia <3");
    }*/

    private static void venderMochi() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngresa la cantidad de Mochis a vender: ");
        int cantidad = scanner.nextInt();

        if (cantidad <= mochisVitrinaPrincipal + mochisVitrinaSecundaria) {
            int temp = mochisVitrinaPrincipal;
            mochisVitrinaPrincipal -= Math.min(cantidad, mochisVitrinaPrincipal);
            if(mochisVitrinaPrincipal == 0){
                int temp1 = cantidad - temp;
                mochisVitrinaSecundaria -= Math.max(0, temp1 - mochisVitrinaPrincipal);
            }
            //mochisVitrinaSecundaria -= Math.max(0, cantidad - mochisVitrinaPrincipal);
            mochisVendidos += cantidad * PRECIO_MOCHI;
            contadorMochisVendidos += cantidad;

            System.out.println("\nMOCHIS VENDIDOS EXITOSAMENTE.\n\n la estas dando todisimaa ¡ERES LA MEJOOR! *~*     *se actualizo la tabla*      " + cantidad + " MOCHIS DIJERON BYEEE :P");
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

    private static void registrarTransferencia() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngresa la cantidad de Mochis TRANSFERIDOS: ");
        int cantidadTrans = scanner.nextInt();        
        if (cantidadTrans <= mochisVitrinaPrincipal + mochisVitrinaSecundaria) {
            int temp2 = mochisVitrinaPrincipal;
            mochisVitrinaPrincipal -= Math.min(cantidadTrans, mochisVitrinaPrincipal);
            if(mochisVitrinaPrincipal == 0){
                int temp3 = cantidadTrans - temp2;
                mochisVitrinaSecundaria -= Math.max(0, temp3 - mochisVitrinaPrincipal);
            }
            //mochisVitrinaSecundaria -= Math.max(0, cantidad - mochisVitrinaPrincipal);
            mochisTransferidos += cantidadTrans * PRECIO_MOCHI;
            contadorTransferidos += cantidadTrans;

            System.out.println("\nTRANSFERENCIA EXITOSA.\n\n no olvides tomar la foto uwu     *se actualizo la tabla*      " + cantidadTrans + " MOCHIS DIJERON BYEEE :P");
            if(cantidadTrans == 5){
                System.out.println("Ufff 5 mochis? ñaaammm ¡Compaltaan!");
            }
            if ((cantidadTrans > 6)) {
                System.out.println("\nDios mio, ¿tenian como antojo de mochis no? jsjsj \n jeje Te amochi muchi <3");
            }
            //if(contadorMochisVendidos == 50){
             //   System.out.println("\nYA VENDISTE 50 MOCHISS? ERES ASOMBROSAAA MI AMOOOOR");
          //  }
        } else {
            System.out.println("No hay suficientes mochis en las vitrinas :(");
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

    private static void venderEmpaques() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("\nIngresa la cantidad de Empaques a vender: ");
        int cantidadEmpaques = scanner.nextInt();
    
            empaquesVendidos += cantidadEmpaques * PRECIO_EMPAQUE;
            contadorEmpaquesVendidos += cantidadEmpaques;

             if (cantidadEmpaques > 5) {
                System.out.println("¡Wow! Más de cinco empaques. esa es mas de la cantidad de empaques que se suele vender en un dia jsjs");
            }   

            System.out.println("\nEMPAQUES VENDIDOS EXITOSAMENTE.   *se actualizo la info de empaques en la tabla*");
    }
    

    private static void mostrarInformacion() {
        System.out.println("\n\t\t\t----- Información de la Tienda de Mochis -----");
        System.out.println("\t\t\t|  Mochis en la Vitrina Principal: " + mochisVitrinaPrincipal);
        System.out.println("\t\t\t|  Mochis en la Vitrina Secundaria: " + mochisVitrinaSecundaria);
        System.out.println("\t\t\t|  Mochis en la Bodega: " + mochisBodega);
        System.out.println("\t\t\t|  Dinero de la BASE: " + dineroBASE);
        System.out.println("\t\t\t----------------------------------------------");
        System.out.println("\t\t\t|  Total Vendido TRANSFERENCIA: " + mochisTransferidos + "$");
        System.out.println("\t\t\t|  Cantidad de Mochis TRANSFERIDOS: " + contadorTransferidos);
        System.out.println("\t\t\t----------------------------------------------");
        System.out.println("\t\t\t|  Total Ventas EFECTIVO: " + mochisVendidos + "$");
        System.out.println("\t\t\t|  Cantidad de Mochis Vendidos en CASH : " + contadorMochisVendidos);
        System.out.println("\t\t\t----------------------------------------------");
        System.out.println("\t\t\t|  Total vendido de Empaques: " + empaquesVendidos + "$");
        System.out.println("\t\t\t|  Cantidad de Empaques Vendidos: " + contadorEmpaquesVendidos);
        System.out.println("\t\t\t----------------------------------------------");
        System.out.println("\t\t\t|  MOCHI~MONEY TOTAL  " + totalVENDIDO + "$");
        System.out.println("\t\t\t|  Cantidad de Mochis que dijeron BYE: " + contadorTOTAL);
        System.out.println("\t\t\t----------------------------------------------\n");
   
    }
}
