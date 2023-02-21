package crudArray;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		String[] juegos = new String[20];
		String[] generos = new String[20];
		String[] duraciones = new String[20];
		int eleccion;
		boolean salir = false;
		int posicion = -1;

		SalidaDeDatos.mostrarInicio("Bienvenido", "A tu juegoteca", "Puedes guardar hasta 20 juegos de mesa",
				"Tu lista actual de juegos es:");

		inicializar(juegos, "");
		inicializar(generos, "");
		inicializar(duraciones, "");
		System.out.println(Arrays.toString(juegos));
			/*Comprobación por pantalla de que los datos se están guardando correctamente
			 * System.out.println(Arrays.toString(generos));
			 * System.out.println(Arrays.toString(duraciones));
			 */
		System.out.println("*************************");

		do {
			SalidaDeDatos.mostrarMenu();
			posicion = buscarLibre(juegos, "");
			posicion = buscarLibre(generos, "");
			posicion = buscarLibre(duraciones, "");

			try {
				Scanner lector = new Scanner(System.in);
				eleccion = lector.nextInt();
				lector.nextLine();

				switch (eleccion) {
				case 1:
					crear2(juegos, generos, duraciones, "");
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

	private static void crear2(String[] lista, String[] lista2, String[] lista3, String dato) {

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
}