import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsumoAPI consulta = new ConsumoAPI();
        String menu = """
                *******************************************************
                            Bienvenido/a al conversor de monedas:
                
                Elija una opción válida:
                1) Dólar --> Peso argentino
                2) Peso argentino --> Dólar
                3) Dólar --> Real brasileño
                4) Real brasileño --> Dólar
                5) Dólar --> Peso colombiano
                6) Peso colombiano --> Dólar
                7) Dólar --> Peso Chileno
                8) Peso Chileno --> Dólar
                9) Peso colombiano --> Real brasileño
                0 Salir
                *******************************************************
                """;
        int opcionMenu = -1;
        long cantidadAConvertir = 0;
        Moneda moneda;

        while (opcionMenu != 0) {
            System.out.println(menu);
            try {
                opcionMenu = Integer.valueOf(lectura.nextLine());
                switch (opcionMenu) {
                    case 1:
                        System.out.println("Digite el valor a convertir:");
                        cantidadAConvertir = Long.valueOf(lectura.nextLine());
                        moneda = consulta.buscarConversion("USD", "ARS", cantidadAConvertir);
                        System.out.println("El valor " + cantidadAConvertir + " [" + moneda.base_code() + "] "
                                + "corresponde al valor final de " + moneda.conversion_result() +
                                " [" + moneda.target_code() + "]");
                        break;
                    case 2:
                        System.out.println("Digite el valor a convertir:");
                        cantidadAConvertir = Long.valueOf(lectura.nextLine());
                        moneda = consulta.buscarConversion("ARS", "USD", cantidadAConvertir);
                        System.out.println("El valor " + cantidadAConvertir + " [" + moneda.base_code() + "] "
                                + "corresponde al valor final de " + moneda.conversion_result() +
                                " [" + moneda.target_code() + "]");
                        break;
                    case 3:
                        System.out.println("Digite el valor a convertir:");
                        cantidadAConvertir = Long.valueOf(lectura.nextLine());
                        moneda = consulta.buscarConversion("USD", "BRL", cantidadAConvertir);
                        System.out.println("El valor " + cantidadAConvertir + " [" + moneda.base_code() + "] "
                                + "corresponde al valor final de " + moneda.conversion_result() +
                                " [" + moneda.target_code() + "]");
                        break;
                    case 4:
                        System.out.println("Digite el valor a convertir:");
                        cantidadAConvertir = Long.valueOf(lectura.nextLine());
                        moneda = consulta.buscarConversion("BRL", "USD", cantidadAConvertir);
                        System.out.println("El valor " + cantidadAConvertir + " [" + moneda.base_code() + "] "
                                + "corresponde al valor final de " + moneda.conversion_result() +
                                " [" + moneda.target_code() + "]");
                        break;
                    case 5:
                        System.out.println("Digite el valor a convertir:");
                        cantidadAConvertir = Long.valueOf(lectura.nextLine());
                        moneda = consulta.buscarConversion("USD", "COP", cantidadAConvertir);
                        System.out.println("El valor " + cantidadAConvertir + " [" + moneda.base_code() + "] "
                                + "corresponde al valor final de " + moneda.conversion_result() +
                                " [" + moneda.target_code() + "]");
                        break;
                    case 6:
                        System.out.println("Digite el valor a convertir:");
                        cantidadAConvertir = Long.valueOf(lectura.nextLine());
                        moneda = consulta.buscarConversion("COP", "USD", cantidadAConvertir);
                        System.out.println("El valor " + cantidadAConvertir + " [" + moneda.base_code() + "] "
                                + "corresponde al valor final de " + moneda.conversion_result() +
                                " [" + moneda.target_code() + "]");
                        break;
                    case 7:
                        System.out.println("Digite el valor a convertir:");
                        cantidadAConvertir = Long.valueOf(lectura.nextLine());
                        moneda = consulta.buscarConversion("USD", "CLP", cantidadAConvertir);
                        System.out.println("El valor " + cantidadAConvertir + " [" + moneda.base_code() + "] "
                                + "corresponde al valor final de " + moneda.conversion_result() +
                                " [" + moneda.target_code() + "]");
                        break;
                    case 8:
                        System.out.println("Digite el valor a convertir:");
                        cantidadAConvertir = Long.valueOf(lectura.nextLine());
                        moneda = consulta.buscarConversion("CLP", "USD", cantidadAConvertir);
                        System.out.println("El valor " + cantidadAConvertir + " [" + moneda.base_code() + "] "
                                + "corresponde al valor final de " + moneda.conversion_result() +
                                " [" + moneda.target_code() + "]");
                    case 9:
                        System.out.println("Digite el valor a convertir:");
                        cantidadAConvertir = Long.valueOf(lectura.nextLine());
                        moneda = consulta.buscarConversion("COP", "BRL", cantidadAConvertir);
                        System.out.println("El valor " + cantidadAConvertir + " [" + moneda.base_code() + "] "
                                + "corresponde al valor final de " + moneda.conversion_result() +
                                " [" + moneda.target_code() + "]");
                    case 0:
                        System.out.println("Finalizando el programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Ha ingresado un valor inválido. Intente nuevamente.");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación.");
            }
        }
    }
}