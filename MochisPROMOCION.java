package HELADERIAAAAAAA;

import java.util.Scanner;
import java.util.Random;

public class MochisPROMOCION {

    private static int mochisVitrinaPrincipal;
    private static int mochisVitrinaSecundaria;
    private static int mochisBodega;
    private static int mochisVendidos;
    private static int contadorMochisVendidos;
    private static int empaquesVendidos;
    private static int contadorEmpaquesVendidos;
    //private static int mochisTransferidos;
    //private static int contadorTransferidos;
    private static int promoVendidos;
    private static int promo2Vendidos;
    private static int contadorPromo1;
    private static int contadorPromo2;
    private static int totalVENDIDO;
    private static int contadorTOTAL;


    private static final int PRECIO_EMPAQUE = 1000;
    private static final int PRECIO_MOCHI = 5000;
    private static final int cantidadP1 = 3;
    private static final int cantidadP2 = 5;

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

            System.out.println("\t\t\tElige la opcion que deseas realizar presionando el numero + Enter");
            System.out.println("1. PROMO 1");
            System.out.println("2. PROMO 2 ");
            System.out.println("3. VENDER Mochiiss ");
            System.out.println("4. VENDER Empaques "); 
            System.out.println("5. Mover Mochis de la Bodega a la Vitrina Principal");
            System.out.println("6. Mover Mochis de la Bodega a la Vitrina Secundaria");
            System.out.println("7. Mover Mochis de la SECUNDARIA a la Principal");
            System.out.println("8. Mover Mochis de la PRINCIPAL a la Secundaria");
            //System.out.println("9. TRANSFERENCIA");
            System.out.println("000. Salir");

            System.out.println("\t\t\t\t\t~fijate bien antes de dar Enter~");
            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("\nSelecciona una opción: ");
            
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    promo1(cantidadP1);
                    break;
                case 2:
                    promo2(cantidadP2);
                    break;
                case 3:
                    venderMochi();
                    break;
                case 4:
                    venderEmpaques();
                    break;
                case 5:
                    moverMochis("bodega", "vitrina principal");
                    break;
                case 6:
                    moverMochis("bodega", "vitrina secundaria");
                    break;
                case 7:
                    moverMochis("vitrina secundaria", "vitrina principal");
                    break;
                case 8:
                    moverMochis("vitrina principal", "vitrina secundaria");
                    break;
                /*case 9:
                    registrarTransferencia();
                    break;*/
                case 000:
                    System.out.println("¡Gracias por usar el sistema de la Tienda de Mochis! \n Te mando un besote mi amor :$ bueno muchoss jeje <3 ");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }

            totalVENDIDO = (promoVendidos + promo2Vendidos + mochisVendidos);
            contadorTOTAL = (contadorMochisVendidos + contadorPromo1 + contadorPromo2);
        }
    }

    private static void promo1(int cantidadP1) {

        System.out.print("PAGA 2 Y EL TERCERO SE LO LLEVA CON 50% DE DESCUENTOO ");

        if (cantidadP1 <= mochisVitrinaPrincipal + mochisVitrinaSecundaria) {
            int temp = mochisVitrinaPrincipal;
            mochisVitrinaPrincipal -= Math.min(cantidadP1, mochisVitrinaPrincipal);
            if(mochisVitrinaPrincipal == 0){
                int temp2 = cantidadP1 - temp;
                mochisVitrinaSecundaria -= Math.max(0, temp2 - mochisVitrinaPrincipal);
            }
            //mochisVitrinaSecundaria -= Math.max(0, cantidad - mochisVitrinaPrincipal);
            promoVendidos += (cantidadP1 * PRECIO_MOCHI)-2500;
            contadorPromo1 += cantidadP1;

            System.out.println("\nPROMOCION EXITOSA.\n\t\t\t *se actualizo la tabla*      " + cantidadP1 + " MOCHIS DIJERON BYEEE :P");

        } else {
            System.out.println("No hay suficientes mochis en las vitrinas :(");
        }
    } 

   
    private static void imprimirMensajeMotivacional() {
     
        System.out.println("Recuerda que ~~~~~");
        System.out.println("cada venta que haces ~~~~");
        System.out.println("es un pasito mas cerca de Italia <3");
    }

    

       private static void promo2(int cantidadP2) {

        System.out.print("\nPAGA 4 Y EL QUINTO ES COMPLETAMENTE GRATIIIS ");

        if (cantidadP2 <= mochisVitrinaPrincipal + mochisVitrinaSecundaria) {
            int temp = mochisVitrinaPrincipal;
            mochisVitrinaPrincipal -= Math.min(cantidadP2, mochisVitrinaPrincipal);
            if(mochisVitrinaPrincipal == 0){
                int temp2 = cantidadP2 - temp;
                mochisVitrinaSecundaria -= Math.max(0, temp2 - mochisVitrinaPrincipal);
            }
            //mochisVitrinaSecundaria -= Math.max(0, cantidad - mochisVitrinaPrincipal);
            promo2Vendidos += ((cantidadP2-1) * PRECIO_MOCHI);
            contadorPromo2 += cantidadP2;

            System.out.println("\nPROMOCION EXITOSA.\n\t\t\t *se actualizo la tabla*      " + cantidadP2 + " MOCHIS DIJERON BYEEE :P");

        } else {
            System.out.println("No hay suficientes mochis en las vitrinas :(");
        }

    }

    /*private static void registrarTransferencia() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngresa la cantidad de Mochis que se vendieron: ");
        int cantidadtrans = scanner.nextInt();

        mochisTransferidos += cantidadtrans * PRECIO_MOCHI;
        contadorTransferidos += cantidadtrans;
        System.out.println("\nTRANSFERENCIA EXITOSA.\n\n no olvides tomar la foto uwu     *se actualizo la tabla*      " + cantidadtrans + " MOCHIS DIJERON BYEEE :P");
        


    }*/

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
        System.out.println("\t\t\t----------------------------------------------");
        System.out.println("\t\t\t|  (3x2)PROMO 1 : " + contadorPromo1 + " mochis vendidos : " + promoVendidos + "$"); 
        System.out.println("\t\t\t|  (5x4)PROMO 2 : " + contadorPromo2 + " mochis vendidos : " + promo2Vendidos + "$");
       // System.out.println("\t\t\t----------------------------------------------");
       // System.out.println("\t\t\t|  Total Vendido TRANSFERENCIA: " + mochisTransferidos + "$");
       // System.out.println("\t\t\t|  Cantidad de Mochis TRANSFERIDOS: " + contadorTransferidos);
        System.out.println("\t\t\t----------------------------------------------");
        System.out.println("\t\t\t|  Total Ventas sin promocion: " + mochisVendidos + "$");
        System.out.println("\t\t\t|  Cantidad de Mochis Vendidos Sin Promo: " + contadorMochisVendidos);
        System.out.println("\t\t\t----------------------------------------------");
        System.out.println("\t\t\t|  Total vendido de Empaques: " + empaquesVendidos + "$");
        System.out.println("\t\t\t|  Cantidad de Empaques Vendidos: " + contadorEmpaquesVendidos);
        System.out.println("\t\t\t----------------------------------------------");
        System.out.println("\t\t\t|  LUKAZZ TOTALES  " + totalVENDIDO + "$");
        System.out.println("\t\t\t|  Cantidad de mochis que dijeron BYE: " + contadorTOTAL);
        System.out.println("\t\t\t----------------------------------------------\n");
   
    }
}
