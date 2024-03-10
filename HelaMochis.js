let mochisVitrinaPrincipal = 0;
let mochisVitrinaSecundaria = 0;
let mochisBodega = 0;
let mochisVendidos = 0;
let contadorMochisVendidos = 0;
let empaquesVendidos = 0;
let contadorEmpaquesVendidos = 0;

const PRECIO_EMPAQUE = 700;
const PRECIO_HELADO = 5000;

function main() {
    console.log("\nBienvenida Mi Gaby<3 \nSere tu asistente para ayudarte con las cuentas");
    console.log("Que lindo poder acompañarte ^-^");
    console.log("\ndale clic a la pantalla con cariño para continuar :D\n");

    // Registrar mochis al inicio
    mochisVitrinaPrincipal = promptInt("Ingresa porfa la cantidad de Mochis en la Vitrina Principal");
    mochisVitrinaSecundaria = promptInt("a continuacion la cantidad de Mochis en la Vitrina Secundaria");
    mochisBodega = promptInt("Por ultimo la cantidad de Mochis en la Bodega");

    console.log("\n¡Perfecto! lo hiciste increible :3\n Espero poder ser de gran ayuda, verifica los datos a continuacion <3");

    while (true) {
        mostrarInformacion();

        console.log("Elige la opcion que deseas realizar\n presionando el numero + Enter");
        console.log("\n1. VENDER Mochiiss ");
        console.log("2. VENDER Empaques ");
        console.log("3. Mover Mochis de la Bodega a la Vitrina Principal");
        console.log("4. Mover Mochis de la Bodega a la Vitrina Secundaria");
        console.log("5. Mover Mochis de la SECUNDARIA a la Principal");
        console.log("6. Mover Mochis de la PRINCIPAL a la Secundaria");
        console.log("\n9. Salir");

        console.log("\n\t\t\t\t\t~fijate bien antes de dar Enter~");
        console.log("\t~~~~~tener en cuenta que si se da la opcion (9. Salir) se eliminaran los registros actuales~~~");
        const opcion = promptInt("Selecciona una opción");

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
                console.log("¡Gracias por usar el sistema de la Tienda de Mochis! \n Te mando un besote mi amor :$ bueno muchoss jeje <3 ");
                return;
            default:
                console.log("Opción no válida. Por favor, elige una opción válida.");
        }
    }
}

function moverMochis(origen, destino) {
    const cantidad = promptInt(`Ingrese la cantidad de Mochis a mover de ${origen} a ${destino}`);
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

                console.log(`\nSe movieron ${cantidad} de mochis exitosamente de ${origen} a ${destino}.`);
            } else {
                console.log("No hay suficientes mochis en la bodega.");
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

                console.log(`\nSe movieron ${cantidad} mochis exitosamente de ${origen} a ${destino}.`);
            } else {
                console.log("No hay suficientes mochis en la vitrina secundaria.");
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

                console.log(`\nSe movieron ${cantidad} mochis exitosamente de ${origen} a ${destino}.`);
            } else {
                console.log("No hay suficientes mochis en la vitrina secundaria.");
            }
            break;
    }
}

function venderMochi() {
    const cantidad = promptInt("Ingresa la cantidad de Mochis a vender");
    if (cantidad <= mochisVitrinaPrincipal + mochisVitrinaSecundaria) {
        const temp = mochisVitrinaPrincipal;
        mochisVitrinaPrincipal -= Math.min(cantidad, mochisVitrinaPrincipal);
        if (mochisVitrinaPrincipal === 0) {
            const temp2 = cantidad - temp;
            mochisVitrinaSecundaria -= Math.max(0, temp2 - mochisVitrinaPrincipal);
        }
        mochisVendidos += cantidad * PRECIO_HELADO;
        contadorMochisVendidos += cantidad;

        console.log(`\nMOCHIS VENDIDOS EXITOSAMENTE.\n\n la estas dando todisimaa ¡ERES LA MEJOOR! ~     se actualizo la tabla      ${cantidad} MOCHIS DIJERON BYEEE :P`);
        if (cantidad === 5) {
            console.log("Ufff 5 mochis? ñaaammm ¡Compaltaan!");
        }
        if (cantidad > 6) {
            console.log("\nDios mio, ¿tenian como antojo de mochis no? jsjsj \n jeje Te amochi muchi <3");
        }
    } else {
        console.log("No hay suficientes mochis en las vitrinas :(");
    }
}

function venderEmpaques() {
    const cantidadEmpaques = promptInt("Ingresa la cantidad de Empaques a vender");
    empaquesVendidos += cantidadEmpaques * PRECIO_EMPAQUE;
    contadorEmpaquesVendidos += cantidadEmpaques;

    if (cantidadEmpaques > 5) {
        console.log("¡Wow! Más de cinco empaques. esa es mas de la cantidad de empaques que se suele vender en un dia jsjs");
    }

    console.log("\nEMPAQUES VENDIDOS EXITOSAMENTE.   se actualizo la info de empaques en la tabla");
}

function mostrarInformacion() {
    console.log("\n\t\t\t----- Información de la Tienda de Mochis -----");
    console.log(`\t\t\t|  Mochis en la Vitrina Principal: ${mochisVitrinaPrincipal}`);
    console.log(`\t\t\t|  Mochis en la Vitrina Secundaria: ${mochisVitrinaSecundaria}`);
    console.log(`\t\t\t|  Mochis en la Bodega: ${mochisBodega}`);
    console.log(`\t\t\t|  Total Vendido: ${mochisVendidos}$`);
    console.log(`\t\t\t|  Cantidad de Mochis Vendidos: ${contadorMochisVendidos}`);
    console.log("\t\t\t----------------------------------------------");
    console.log(`\t\t\t|  Total vendido de Empaques: ${empaquesVendidos}$`);
    console.log(`\t\t\t|  Cantidad de Empaques Vendidos: ${contadorEmpaquesVendidos}`);
    console.log("\t\t\t----------------------------------------------\n");
}

function promptInt(message) {
    return parseInt(prompt(message));
}

// Llama a la función principal para iniciar la ejecución del programa
main();
