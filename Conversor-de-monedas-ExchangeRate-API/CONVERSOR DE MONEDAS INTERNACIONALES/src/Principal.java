import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int monedaBase;
        int monedaObjetivo;
        String codigoMonedaBase = null;
        String codigoMonedaObjetivo = null;
        double tasaDeCambio;
        double cantidadAConvertir;
        double resultado;
        String reinicio;



        Menu.mostrarMenu();

        while (true) {
            System.out.println("Selecciona la moneda que deseas CAMBIAR:");
            Scanner opc1 = new Scanner(System.in);
            try {
                monedaBase = opc1.nextInt();
                if(monedaBase < 1 || monedaBase > 11) {
                    System.out.println("xxx Opción inválida - Verifica las opciones xxx");
                    continue;
                }
                codigoMonedaBase = switch (monedaBase) {
                    case 1 -> "ARS";
                    case 2 -> "BOB" ;
                    case 3 -> "CLP";
                    case 4 -> "COP";
                    case 5 -> "MXN";
                    case 6 -> "USD";
                    case 7 -> "CAD";
                    case 8 -> "EUR";
                    case 9 -> "RUB";
                    case 10 -> "SEK";
                    case 11 -> "NOK";
                    default -> codigoMonedaBase;
                };
            } catch (InputMismatchException e) {
                System.out.println("xxx Opción inválida - Verifica las opciones xxx");
                continue;
            }
            System.out.println("Selecciona el TIPO DE CAMBIO que deseas realizar:");
            Scanner opc2 = new Scanner(System.in);
            try {
                monedaObjetivo = opc2.nextInt();
                if(monedaObjetivo < 1 || monedaObjetivo > 11) {
                    System.out.println("xxx Opción inválida - Verifica las opciones xxx");
                    continue;
                }
                codigoMonedaObjetivo = switch (monedaObjetivo) {
                    case 1 -> "ARS";
                    case 2 -> "BOB" ;
                    case 3 -> "CLP";
                    case 4 -> "COP";
                    case 5 -> "MXN";
                    case 6 -> "USD";
                    case 7 -> "CAD";
                    case 8 -> "EUR";
                    case 9 -> "RUB";
                    case 10 -> "SEK";
                    case 11 -> "NOK";
                    default -> codigoMonedaObjetivo;
                };
            } catch (InputMismatchException e) {
                System.out.println("xxx Opción inválida - Verifica las opciones xxx");
                continue;
            }
            System.out.println(("Ingrese la cantidad de dinero a cambiar [" +  codigoMonedaBase + "]:"));
            Scanner entradaDinero = new Scanner(System.in);
            try {
                cantidadAConvertir = entradaDinero.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("xxx Favor de ingresar un número xxx");
                continue;
            }
            tasaDeCambio = RetornaTasaDeCambio.buscarTasaDeCambio(codigoMonedaBase, codigoMonedaObjetivo);
            resultado = (tasaDeCambio * cantidadAConvertir);

            System.out.println("El valor de " + cantidadAConvertir + " ["+ codigoMonedaBase + "] corresponden  al valor final de =>>> " + new DecimalFormat("#.##").format(resultado) + " [" + codigoMonedaObjetivo + "]");
            System.out.println("Desea realizar otra conversion ?  SI(S) NO(N)  ");

            Scanner respPregunta = new Scanner(System.in);

                try {
                    reinicio = respPregunta.nextLine();
                        if (reinicio.length() != 1 || !Character.isLetter(reinicio.charAt(0))) {
                            throw new IllegalArgumentException("xxx Favor de ingresar la LETRA correspondiente xxx");
                        }
                        if (reinicio.equalsIgnoreCase("S")) {
                            // Assuming Menu.mostrarMenu() is defined elsewhere
                            Menu.mostrarMenu();
                        } else if (reinicio.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            System.out.println("xxx Opcion invalida - Saliendo el programa xxx");
                            break;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("xxx Opcion invalida - Saliendo el programa xxx");
                        break;
                }

        }
    }
}
