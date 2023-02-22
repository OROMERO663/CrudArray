package crudArray;

import java.util.Arrays;

/**
 * Actividad 1. Salida de datos es una clase auxiliar para mostrar mensajes por consola
 * 
 * @author Oscar
 * @version 1
 */
public class SalidaDeDatos {

	/**
	 * El metodo MostrarInicio muestra el mensaje de bienvenida por consola
	 * Mensajes por consola: mensaje de bienvenida
	 * 
	 * @author Oscar
	 * @param texto1 Es el primer mensaje del inicio 
	 * @param texto2 Es el segundo mensaje del inicio 
	 * @param texto3 Es el tercer mensaje del inicio 
	 * @param texto4 Es el cuarto mensaje del inicio 
	 */
	public static void mostrarInicio(String texto1, String texto2, String texto3, String texto4) {

		System.out.println(texto1);
		System.out.println(texto2);
		System.out.println(texto3);
		System.out.println("*****************************");
		System.out.println(texto4);

	}

	/**
	 * El metodo MostrarMenu saca el menu de opciones por consola 
	 * Mensaje por consola: Menu principal
	 * 
	 * @author Oscar
	 */
	public static void mostrarMenu() {

		System.out.println("¿Qué quieres hacer con tu lista de juegos?");
		System.out.println("1 - Añadir");
		System.out.println("2 - Consultar");
		System.out.println("3 - Modificar");
		System.out.println("4 - Eliminar");
		System.out.println("5 - Salir");

	}

	/**
	 * El metodo TuLista da informacion de la lista de juegos actualizada
	 * Mensajes por consola: lista de juegos actualizada
	 * 
	 * @author Oscar
	 * @param juegos Es el Array que entra para mostrarlo por consola
	 */
	public static void TuLista(String[] juegos) {
		System.out.println("Tu lista de juegos actual es:");
		System.out.println(Arrays.toString(juegos));
		System.out.println("*****************************");
	}

	/**
	 * EL metodo Salida da el mensaje de salida del programa
	 * Mensaje por consola de finalizacion del programa
	 * 
	 * @author Oscar
	 */
	public static void Salida() {
		System.out.println("Has cerrado tu Juegoteca. Hasta pronto.");
		System.out.println("***************************************");
	}

}
