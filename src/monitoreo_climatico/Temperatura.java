package monitoreo_climatico;

import java.util.Scanner;

public class Temperatura {
	
	//recibe los datos y los convierte si se pide o mantiene y coloca apellido en Celsius
	public static double ConversionTemperatura(double temperatura, String unidadOrigen) {
        unidadOrigen = unidadOrigen.toUpperCase();
        //toUpperCase permite que no afecte si es mayuscula o minuscula
        switch (unidadOrigen) {
	        case "FAHRENHEIT":
	        case "F":
	            return (temperatura - 32) * 5 / 9;
	        case "KELVIN":
	        case "K":
	            return temperatura - 273.15;
	        case "CELSIUS":
	        case "C":
	            return temperatura;
	        default:
	            System.out.println("Unidad no reconocida. Usa F, C o K.");
	            return -999;
    }
}
	//-------------------------------------------------------------------
	
	//-------------------------------------------------------------------
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		//solicitud de un valor numerico
        System.out.print("Ingrese el valor de la temperatura: ");
        double temp = scanner.nextDouble();
        scanner.nextLine(); // limpiar el salto de línea

        //------- entrega de resultado en consola -------------------------
        //utilice f, k, c para hacer mas simple la pregunta y limitar errores de escritura
        System.out.print("Ingrese la unidad de origen colocando la inicial: FAHRENHEIT (F), KELVIN (K) o CELSIUS (C): ");
        String unidad = scanner.nextLine();

        double resultado = ConversionTemperatura(temp, unidad);

        //si es celsius solo agrego apellido 
        if (resultado != -999) {
            System.out.printf("La temperatura convertida a Celsius es: %.2f°C%n", resultado);
        } 
        else {
            System.out.println("No se pudo realizar la conversión por unidad inválida.");
        }

        scanner.close();
	}
}
