package crudArray;

import java.util.Arrays;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		/*
		 * Hacer el menu de opciones
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

		String[] juegos = new String[4];
		int eleccion;
		int posicion = -1;
		

		SalidaDeDatos.mostrarInicio("Bienvenido", "A tu juegoteca", "Puedes guardar hasta 20 juegos de mesa", "Tu lista actual de juegos es:");
		
		inicializar(juegos, "x");
		System.out.println(Arrays.toString(juegos));
		System.out.println("*************************");
		posicion = buscarLibre(juegos, "x");
		
		
		do {
			eleccion = SalidaDeDatos.mostrarMenu();

			eleccion = gestionar(eleccion);
			crear(juegos, "x", posicion);
			System.out.println(Arrays.toString(juegos));
			// 2 Consultar
			// 3 Modificar
			// 4 Eliminar
			// 5 Salir

		} while (eleccion == 5 || eleccion == 1);// el 5 va a ser SALIR
	}

	private static void inicializar(String[] lista, String dato) {

		int longitud = lista.length;

		for (int i = 0; i < longitud; i++) {
			lista[i] = dato;
		}

	}

	private static int gestionar(int eleccion) {
		// private - solo lo podemos usar en esta clase
		// void - en nuestra practica a lo mejor no tiene que ser void
		// int eleccion - es el parametro de entrada (el 1 añadir por ejemplo)
		
		Scanner lector = new Scanner(System.in);
		eleccion = lector.nextInt();
		lector.nextLine();
		
		switch (eleccion) {
		case 1:
			// AÑADIR
			//crear(juegos, "x", posicion); // llamada al metodo en private más abajo en este Main
			

			break;

		default:
			break;

		}
		return eleccion;
	}
	
	//BUSCAR EL PRIMER HUECO DISPONIBLE DEL ARRAY:

	private static int buscarLibre(String[] lista, String dato) {

		// recorrer el array hasta que encuentre un hueco vacio
		int posicion = -1;
		int longitud = lista.length;
		boolean encontrado = false;
		int contador = 0;

		while (contador < longitud && !encontrado) {
			if (lista[contador].equals(dato)) {
				encontrado = true;
				posicion = contador;
			}
			// si no lo he encontrado
			contador++;
		}

		return posicion;
	}

	private static void crear(String[] lista, String dato, int posicion) {
		// aqui haríamos el codigo para crear Array, para añadir el juego
		String nuevoJuego;
		System.out.println("Escribe el juego que quieres añadir");
		
		Scanner lector = new Scanner(System.in);
		nuevoJuego = lector.nextLine();
		lector.nextLine();
		
		int longitud = lista.length;
		boolean encontrado = false;
		int contador = 0;

		while (contador < longitud && !encontrado) {
			if (lista[contador].equals(dato)) {
				encontrado = true;
				lista[posicion] = nuevoJuego;
			}
			// si no lo he encontrado
			contador++;
		}
		
}
}
