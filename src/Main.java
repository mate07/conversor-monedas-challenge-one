//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
    Author: Vladimir Mate
    Type: Class Main
    Description: Cuerpo central del proyecto
 */

import com.google.gson.JsonSyntaxException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String monedas = """
               ******************************************************************
                       BIENVENIDOS - CHALLENGE ONE NEXT/ALURA LATAM
                       
                Divisas disponibles:
                
                    ARS - Peso Argentino
                    BOB - Boliviano Boliviano
                    BRL - Real Brasileño
                    CLP - Peso Chileno
                    COP - Peso Colombiano
                    USD - Dólar Estadounidense
                    
               ******************************************************************
                """;

        ConsultaMonedaApi conversorApi = new ConsultaMonedaApi();

        System.out.println(monedas);
        while (true){
            try{
                System.out.println("Elija la moneda a convertir (Ej. MXN):");
                String divisa = sc.next().toUpperCase();

                System.out.println("Elija la moneda objetivo (Ej. ZAR):");
                String cambio = sc.next().toUpperCase();

                System.out.println("Elija la cantidad a transformar:");
                double valor = sc.nextDouble();

                var convertido = conversorApi.convertirDivisa(divisa, cambio,valor);
                System.out.println("El valor "+ valor + " " + divisa + " es igual a " + convertido + " " + cambio);


            }catch (InputMismatchException | JsonSyntaxException e){
                System.out.println("Datos Inválidos.");
            }

            System.out.println("Escriba la palabra 'no' para dejar de convertir:");
            String opc = sc.next();

            if (opc .equalsIgnoreCase("no")){
                System.out.println("Gracias por utilizar nuestros servicios.");
                break;
            }
        }
    }
}