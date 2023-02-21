package crudArray;

import java.util.Arrays;

public class SalidaDeDatos {

	public static void mostrarInicio(String texto1, String texto2, String texto3, String texto4) {

		System.out.println(texto1);
		System.out.println(texto2);
		System.out.println(texto3);
		System.out.println("*****************************");
		System.out.println(texto4);

	}

	public static void mostrarMenu() {

		System.out.println("¿Qué quieres hacer con tu lista de juegos?");
		System.out.println("1 - Añadir");
		System.out.println("2 - Consultar");
		System.out.println("3 - Modificar");
		System.out.println("4 - Eliminar");
		System.out.println("5 - Salir");

	}

	public static void TuLista(String[] juegos) {
		System.out.println("Tu lista de juegos actual es:");
		System.out.println(Arrays.toString(juegos));
		System.out.println("*****************************");
	}
	
	public static void Salida() {
		System.out.println("Has cerrado tu Juegoteca. Hasta pronto.");
		System.out.println("***************************************");
	}

}
