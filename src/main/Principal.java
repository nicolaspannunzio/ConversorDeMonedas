package main;

import consult.ConsultaMoneda;
import model.Historial;
import model.Moneda;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        List<Historial> historialList = new ArrayList<>();
        Moneda moneda = null;
        int opcion = 0;
        Double monto = 0.0;

        while(opcion != 9) {
            System.out.println("*************************************************");
            System.out.println("Bienvenidxs al conversor de monedas");
            System.out.println("""
                    1. Dolar a Pesos argentinos.
                    2. Pesos argentinos a Dolar.
                    3. Dolar a Real.
                    4. Real a Dolar.
                    5. Dolar a Franco suizo.
                    6. Franco suizo a Dolar.
                    7. Dolar a Euro.
                    8. Euro a Dolar.
                    9. SALIR.""");

            System.out.println("*************************************************");
            System.out.println("Ingrese una opción:");

            try{
                opcion = Integer.parseInt(scan.nextLine());

                if (opcion >= 1 && opcion <= 8) {
                    System.out.println("Ingrese el monto a convertir:");
                    monto  = Double.parseDouble(scan.nextLine());
                }

                switch (opcion) {
                    case 1:
                        moneda = consulta.buscaMoneda("USD", "ARS", monto);
                        historialList.add(new Historial("USD", "ARS", monto, moneda.conversion_result()));
                        System.out.println("El monto es: " + moneda.conversion_result() + " pesos argentinos");
                        break;
                    case 2:
                        moneda = consulta.buscaMoneda("ARS", "USD", monto);
                        historialList.add(new Historial("ARS", "USD", monto, moneda.conversion_result()));
                        System.out.println("El monto es: " + moneda.conversion_result() + " dólares");
                        break;
                    case 3:
                        moneda = consulta.buscaMoneda("USD", "BRL", monto);
                        historialList.add(new Historial("USD", "BRL", monto, moneda.conversion_result()));
                        System.out.println("El monto es: " + moneda.conversion_result() + " reales");
                        break;
                    case 4:
                        moneda = consulta.buscaMoneda("BRL", "USD", monto);
                        historialList.add(new Historial("BRL", "USD", monto, moneda.conversion_result()));
                        System.out.println("El monto es: " + moneda.conversion_result() + " dólares");
                        break;
                    case 5:
                        moneda = consulta.buscaMoneda("USD", "CHF", monto);
                        historialList.add(new Historial("USD", "CHF", monto, moneda.conversion_result()));
                        System.out.println("El monto es: " + moneda.conversion_result() + " francos suizos");
                        break;
                    case 6:
                        moneda = consulta.buscaMoneda("CHF", "USD", monto);
                        historialList.add(new Historial("CHF", "USD", monto, moneda.conversion_result()));
                        System.out.println("El monto es: " + moneda.conversion_result() + " dólares");
                        break;
                    case 7:
                        moneda = consulta.buscaMoneda("USD", "EUR", monto);
                        historialList.add(new Historial("USD", "EUR", monto, moneda.conversion_result()));
                        System.out.println("El monto es: " + moneda.conversion_result() + " euros");
                        break;
                    case 8:
                        moneda = consulta.buscaMoneda("EUR", "USD", monto);
                        historialList.add(new Historial("EUR", "USD", monto, moneda.conversion_result()));
                        System.out.println("El monto es: " + moneda.conversion_result() + " dólares");
                        break;
                    case 9:
                        System.out.println("Historial de conversiones:");
                        for (Historial h : historialList) {
                            System.out.println(h);
                        }
                        break;
                    case 10:
                        break;
                    default:
                        System.out.println("Ingrese un número válido");
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}