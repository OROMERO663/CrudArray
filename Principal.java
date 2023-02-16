package crudArray;

import java.util.Arrays;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		String[] juegos = new String[20];
		int eleccion;
		boolean salir = false;
		int posicion = -1;

		SalidaDeDatos.mostrarInicio("Bienvenido", "A tu juegoteca", "Puedes guardar hasta 20 juegos de mesa",
				"Tu lista actual de juegos es:");

		inicializar(juegos, "");
		System.out.println(Arrays.toString(juegos));
		System.out.println("*************************");

		do {
			SalidaDeDatos.mostrarMenu();
			posicion = buscarLibre(juegos, "");

			Scanner lector = new Scanner(System.in);
			eleccion = lector.nextInt();
			lector.nextLine();

			switch (eleccion) {
			case 1:
				crear2(juegos, "");
				SalidaDeDatos.TuLista(juegos);
				break;
			case 2:
				consultar(juegos);
				SalidaDeDatos.TuLista(juegos);
				break;
			case 3:
				modificar(juegos);
				SalidaDeDatos.TuLista(juegos);
				break;
			case 4:
				eliminar(juegos);
				SalidaDeDatos.TuLista(juegos);
				break;
			case 5:
				salir = true;
				break;

			default:
				System.out.println("No has elegido una opción válida");
				break;
			}

		} while (!salir);

	}

	private static void inicializar(String[] lista, String dato) {

		int longitud = lista.length;

		for (int i = 0; i < longitud; i++) {
			lista[i] = dato;
		}

	}

	private static int buscarLibre(String[] lista, String dato) {

		int posicion = -1;
		int longitud = lista.length;
		boolean encontrado = false;
		int contador = 0;

		while (contador < longitud && !encontrado) {
			if (lista[contador].equals(dato)) {
				encontrado = true;
				posicion = contador;
			}
			contador++;
		}
		return posicion;
	}

	private static void consultar(String[] lista) {

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
				System.out.println("El juego está en tu lista");
				encontrado = true;
			}
			contador++;
			if (contador == longitud && !encontrado) {
				System.out.println("El juego no está en tu lista");
			}
		} while (contador < longitud && !encontrado);
	}

	private static void modificar(String[] lista) {

		String modifJuego;
		String nombreJuego;
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
				System.out.println("Escribe el nuevo juego modificado");

				Scanner lector1 = new Scanner(System.in);
				nombreJuego = lector1.nextLine();
				lector1.nextLine();

				lista[contador] = nombreJuego;
			}
			contador++;
			if (contador == longitud && !encontrado) {
				System.out.println("El juego no está en tu lista");
			}
		} while (contador < longitud && !encontrado);

	}

	private static void eliminar(String[] lista) {

		String eliminarJuego;
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
				System.out.println("El juego " + eliminarJuego + " ha sido eliminado de tu lista");
			}
			contador++;
			if (contador == longitud && !encontrado) {
				System.out.println("El juego no está en tu lista");
			}
		} while (contador < longitud && !encontrado);
	}

	private static void crear2(String[] lista, String dato) {

		String nuevoJuego;
		int longitud = lista.length;
		boolean encontrado = false;
		int contador = 0;

		System.out.println("Escribe el juego que quieres añadir");

		Scanner lector = new Scanner(System.in);
		nuevoJuego = lector.nextLine();
		lector.nextLine();

		do {
			if (lista[contador].equals(dato)) {
				encontrado = true;
				lista[contador] = nuevoJuego;
				System.out.println("El juego " + nuevoJuego + " ha sido añadido a tu lista");
			}
			contador++;
			if (contador >= longitud && !encontrado) {
				System.out.println("No puedes añadir más juegos");
				System.out.println("Prueba con otras opciones");
			}
		} while (contador < longitud && !encontrado);

	}
}

/*
 * MENU MAL HECHO private static int gestionar(int eleccion) { // private - solo
 * lo podemos usar en esta clase // void - en nuestra practica a lo mejor no
 * tiene que ser void // int eleccion - es el parametro de entrada (el 1 añadir
 * por ejemplo)
 * 
 * Scanner lector = new Scanner(System.in); eleccion = lector.nextInt();
 * lector.nextLine();
 * 
 * switch (eleccion) { case 1: // AÑADIR // crear(juegos, "x", posicion); //
 * llamada al metodo en private más abajo en // este Main
 * 
 * 
 * break;
 * 
 * default: break;
 * 
 * } return eleccion; }
 */

/*
 * CREAR MAL HECHO, DENTRO DEL CASE 1 if (posicion >= 4) {
 * System.out.println("No puedes añadir más juegos"); } else if (posicion <
 * juegos.length) {
 * 
 * crear(juegos, "", posicion); SalidaDeDatos.TuLista(juegos); }
 */

/*
 * CREAR MAL HECHO DENTRO DEL METODO CREAR private static void crear(String[]
 * lista, String dato, int posicion) { // aqui haríamos el codigo para crear
 * Array, para añadir el juego String nuevoJuego; int longitud = lista.length;
 * boolean encontrado = false; int contador = 0;
 * 
 * System.out.println("Escribe el juego que quieres añadir");
 * 
 * Scanner lector = new Scanner(System.in); nuevoJuego = lector.nextLine();
 * lector.nextLine();
 * 
 * 
 * while (contador < longitud && !encontrado) { if
 * (lista[contador].equals(dato)) { encontrado = true; lista[posicion] =
 * nuevoJuego; } // si no lo he encontrado contador++; }
 * 
 * }
 */

/*
 * APUNTES: Hacer el menu de opciones
 * 
 * 1 Crear 2 consultar 3 Modificar 4 Eliminar - puede que se haga Modificando
 * por hueco vacio 5 Salir
 * 
 * Tema: Juegoteca Juego y 4 máximo para probar Ampliar a 20 juegos cuando
 * funcione
 * 
 * Luego ampliar a Juego Categoria Jugadores
 *
 * 
 * Hacer la opcion Crear Te tiene que pedir el nombre del juego y guardarlo en
 * el primer hueco libre del array
 * 
 * Luego intentar que te pida el Nombre Categ y Jugadores
 *
 * Hacer la opcion consultar
 * 
 * Te tiene que dejar ver si tienes un juego guardado (buscar por nombre)
 * 
 * Lo veo dificil pero podrían buscar tambien por categoria y jugadores??
 * 
 * Hacer la opcion modificar
 * 
 * Te deja modificar el nombre
 * 
 * Te deja modificar el nombre cat y jug
 * 
 * Hacer la opcion Eliminar
 * 
 * Lo mismo que modificar pero modifica a vacio ese hueco se me ocurre un
 * consultar primero y modificar a vacio después
 * 
 * Hacer la opcion Salir - finaliza el programa
 * 
 * 
 */
