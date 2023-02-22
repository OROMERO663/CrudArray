package crudArray;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Actividad 1. Programa para Incluir, Consultar, Modificar o Eliminar 
 * juegos de mesa en una Juegoteca con espacio para 20 juegos
 * 
 * @author Oscar
 * @version 1
 */
public class Principal {
	
	/**
	 * Metodo Principal muestra el menu de opciones y llama al metodo correspondiente para ejecutar la opcion elegida
	 * Interaccion por consola: pide al usuario elegir una opcion del menu
	 * Mensajes por consola: saca un mensaje de bienvenida al juego
	 * Mensajes por consola: saca un mensaje recordando la lista de juegos actualizada
	 * Mensajes por consola: saca un mensaje de error si el dato introducido no es valido
	 * 
	 * @author Oscar
	 * @param args Dato de entrada
	 */
	public static void main(String[] args) {

		String[] juegos = new String[20];
		String[] generos = new String[20];
		String[] duraciones = new String[20];
		int eleccion;
		boolean salir = false;

		SalidaDeDatos.mostrarInicio("Bienvenido", "A tu juegoteca", "Puedes guardar hasta 20 juegos de mesa",
				"Tu lista actual de juegos es:");

		inicializar(juegos, "");
		inicializar(generos, "");
		inicializar(duraciones, "");
		System.out.println(Arrays.toString(juegos));

		System.out.println("*****************************");

		do {
			SalidaDeDatos.mostrarMenu();

			try {
				Scanner lector = new Scanner(System.in);
				eleccion = lector.nextInt();
				lector.nextLine();

				switch (eleccion) {
				case 1:
					crear(juegos, generos, duraciones, "");
					SalidaDeDatos.TuLista(juegos);
					break;
				case 2:
					consultar(juegos, generos, duraciones);
					SalidaDeDatos.TuLista(juegos);
					break;
				case 3:
					modificar(juegos, generos, duraciones);
					SalidaDeDatos.TuLista(juegos);
					break;
				case 4:
					eliminar(juegos, generos, duraciones);
					SalidaDeDatos.TuLista(juegos);
					break;
				case 5:
					SalidaDeDatos.Salida();
					salir = true;
					break;

				default:
					System.out.println("No has elegido una opción válida");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes elegir una opción entre 1 y 5");
			}

		} while (!salir);

	}
	
	/**
	 * El metodo inicializar Inicializa un Array completo con un Dato de entrada
	 * 
	 * @author Oscar
	 * @param lista Es el Array que entra para ser inicializado
	 * @param dato Es el parametro con el que se llenan las posiciones del Array
	 */
	private static void inicializar(String[] lista, String dato) {

		int longitud = lista.length;

		for (int i = 0; i < longitud; i++) {
			lista[i] = dato;
		}
	}
	
	/**
	 * El metodo crear incluye un nuevo juego a la lista 
	 * Interaccion por consola: pide al usuario el nombre, genero y duracion de un juego de mesa
	 * Mensajes por consola: saca un mensaje de confirmacion si el juego se ha incluido en la lista
	 * Mensajes por consola: saca un mensaje de error si no se ha podido incluir el juego en la lista
	 * Asigna los datos introducidos por el usuario en una posicion de los Arrays correspondientes 
	 * 
	 * @author Oscar
	 * @param lista Es el Array que entra para que se le asigne el dato nombre requerido por consola
	 * @param lista2 Es el Array que entra para que se le asigne el dato genero requerido por consola
	 * @param lista3 Es el Array que entra para que se le asigne el dato duracion requerido por consola
	 * @param dato Es el parametro que tomamos como libre para asignar los datos introducidos por el usuario
	 */
	private static void crear(String[] lista, String[] lista2, String[] lista3, String dato) {

		String nuevoJuego;
		String nuevoGenero;
		String nuevaDuracion;
		int longitud = lista.length;
		boolean encontrado = false;
		int contador = 0;

		System.out.println("Escribe el juego que quieres añadir");

		Scanner lector = new Scanner(System.in);
		nuevoJuego = lector.nextLine();
		lector.nextLine();

		System.out.println("Escribe el género de " + nuevoJuego);

		Scanner lector2 = new Scanner(System.in);
		nuevoGenero = lector2.nextLine();
		lector2.nextLine();

		System.out.println("Escribe la duración media en minutos de " + nuevoJuego);

		Scanner lector3 = new Scanner(System.in);
		nuevaDuracion = lector3.nextLine();
		lector3.nextLine();

		do {
			if (lista[contador].equals(dato)) {
				encontrado = true;
				lista[contador] = nuevoJuego;
				lista2[contador] = nuevoGenero;
				lista3[contador] = nuevaDuracion;
				System.out.println("El juego " + nuevoJuego + " ha sido añadido a tu lista");
			}
			contador++;
			if (contador >= longitud && !encontrado) {
				System.out.println("No puedes añadir más juegos");
				System.out.println("Prueba con otras opciones");
			}
		} while (contador < longitud && !encontrado);

	}
	
	/**
	 * El metodo consultar permite consultar los datos guardados de un juego de la lista
	 * Interaccion por consola: pide al usuario el nombre del juego a consultar
	 * Mensajes por consola: saca los datos del juego consultado
	 * Mensajes por consola: saca mensaje de error si el juego consultado no esta en la lista
	 * Compara el dato introducido por el usuario con los almacenados el las distintas posiciones del Array juegos
	 * Encuentra coincidencia y saca por consola los datos almacenados en los Array juegos, generos, duraciones correspondientes a ese juego
	 * 
	 * @author Oscar
	 * @param lista Es el Array que entra para comparar el dato requerido por consola y dar la informacion acerca del nombre del juego
	 * @param lista2 Es el Array que entra para dar la informacion acerca del genero del juego
	 * @param lista3 Es el Array que entra para dar la informacion acerca de la duracion del juego
	 */
	private static void consultar(String[] lista, String[] lista2, String[] lista3) {

		String nombreJuego;
		int longitud = lista.length;
		boolean encontrado = false;
		int contador = 0;

		System.out.println("Escribe el juego que quieres consultar");

		Scanner lector = new Scanner(System.in);
		nombreJuego = lector.nextLine();
		lector.nextLine();

		do {
			if (lista[contador].equals(nombreJuego)) {
				System.out.println(nombreJuego + " está en tu lista, es un juego de " + lista2[contador]
						+ " y tiene una duración de " + lista3[contador] + " minutos ");
				encontrado = true;
			}
			contador++;
			if (contador == longitud && !encontrado) {
				System.out.println(nombreJuego + " no está en tu lista");
			}
		} while (contador < longitud && !encontrado);
	}
	
	/**
	 * El metodo modificar permite cambiar los datos de un juego guardado en la lista
	 * Interaccion por consola: pide al usuario el nombre de un juego de mesa guardado en la lista
	 * Interaccion por consola: pide al usuario el genero y la duracion si ha encontrado el juego en la lista
	 * Mensajes por consola: saca mensaje de error si el juego no esta en la lista
	 * Asigna los datos introducidos por el usuario en los Arrays correspondientes en la posicion 
	 * coincidente con la que ocupaba el nombre del juego introducido
	 * 
	 * @author Oscar
	 * @param lista Es el Array que entra para buscar la coincidencia con el dato introducido por el usuario en alguna de sus posiciones y en caso de encontrarse se le asigne el primer dato introducido por consola
	 * @param lista2 Es el Array que entra para que se le asigne el segundo dato requerido por consola
	 * @param lista3 Es el Array que entra para que se le asigne el tercer dato requerido por consola
	 */
	private static void modificar(String[] lista, String[] lista2, String[] lista3) {

		String modifJuego;
		String nombreJuego;
		String nuevoGenero;
		String nuevaDuracion;
		int longitud = lista.length;
		boolean encontrado = false;
		int contador = 0;

		System.out.println("Escribe el juego que quieres modificar de tu lista");

		Scanner lector = new Scanner(System.in);
		modifJuego = lector.nextLine();
		lector.nextLine();

		do {
			if (lista[contador].equals(modifJuego)) {
				encontrado = true;
				System.out.println("Escribe el nombre del juego actualizado");

				Scanner lector1 = new Scanner(System.in);
				nombreJuego = lector1.nextLine();
				lector1.nextLine();

				System.out.println("Escribe el genero de " + nombreJuego);

				Scanner lector2 = new Scanner(System.in);
				nuevoGenero = lector2.nextLine();
				lector1.nextLine();

				System.out.println("Escribe la duración en minutos de " + nombreJuego);

				Scanner lector3 = new Scanner(System.in);
				nuevaDuracion = lector3.nextLine();
				lector1.nextLine();

				lista[contador] = nombreJuego;
				lista2[contador] = nuevoGenero;
				lista3[contador] = nuevaDuracion;
			}
			contador++;
			if (contador == longitud && !encontrado) {
				System.out.println(modifJuego + " no está en tu lista");
			}
		} while (contador < longitud && !encontrado);

	}
	
	/**
	 * El metodo eliminar permite borrar un juego de la lista y sus datos asociados 
	 * Interaccion por consola: pide al usuario el nombre del juego a eliminar de la lista
	 * Mensajes por consola: saca mensaje confirmando que el juego ha sido eliminado
	 * Mensajes por consola: saca mensaje de error si el juego introducido no esta en la lista
	 * Compara el dato introducido por el usuario con los almacenados el las distintas posiciones del Array juegos
	 * Encuentra coincidencia y sustituye el dato encontrado por vacio, dejando libre la posicion en el Array juegos 
	 * y a su vez las correspondientes en los Arrays generos y duraciones
	 * 
	 * @author Oscar
	 * @param lista Es el Array que entra para comparar el dato requerido por consola y eliminar el dato nombre del juego de la posicion encontrada
	 * @param lista2 Es el Array que entra para eliminar el dato acerca del genero del juego
	 * @param lista3 Es el Array que entra para eliminar el dato acerca de la duracion del juego del juego
	 */
	private static void eliminar(String[] lista, String[] lista2, String[] lista3) {

		String eliminarJuego;
		String eliminarGenero;
		String eliminarDuracion;
		int longitud = lista.length;
		boolean encontrado = false;
		int contador = 0;

		System.out.println("Escribe el juego que quieres eliminar de tu lista");

		Scanner lector = new Scanner(System.in);
		eliminarJuego = lector.nextLine();
		lector.nextLine();

		do {
			if (lista[contador].equals(eliminarJuego)) {
				encontrado = true;
				lista[contador] = "";
				lista2[contador] = "";
				lista3[contador] = "";
				System.out.println("El juego " + eliminarJuego + " ha sido eliminado de tu lista");
			}
			contador++;
			if (contador == longitud && !encontrado) {
				System.out.println("El juego no está en tu lista");
			}
		} while (contador < longitud && !encontrado);
	}
}
