package arrayOpcional;

import java.util.Scanner;

public class main {

	/*
	 * Método para pedir que el usuario pulse Intro
	 */

	public static void Intro() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Pulsa Intro...");
		sc.nextLine();
	}

	public static void Error() {
		System.out.println("Parece que todavía no has llenado tu lista");
		System.out.println("Pasa por las opciones 1-2 o 3 primero");
		Intro();
	}

	/**
	 * Metodo que pide un String por terminal
	 * 
	 * @return el texto introducido
	 */

	public static String pedirString() {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		String opcion = sc.nextLine();
		return opcion;
	}

	/**
	 * Metodo que pide un int por terminal
	 * 
	 * @return el número introducido
	 */
	public static int pedirNumero() {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		return num;

	}

	/*
	 * Función del caso 1
	 */

	public static String[] Llenar(String[] lista) {
		System.out.println("----------------------------------------------------------------------------------------");

		System.out.println("------ Escribe los nombres: ---------");
		Scanner sc = new Scanner(System.in);
		String opcion;

		for (int i = 0; i < lista.length; i++) {
			opcion = sc.nextLine();
			lista[i] = opcion;
		}

		return lista;

	}

	/*
	 * Función del caso 2
	 */

	public static String[] LlenarSinDuplicar(String[] lista) {
		System.out.println("----------------------------------------------------------------------------------------");

		System.out.println("------ Escribe los nombres: ---------");
		Scanner sc = new Scanner(System.in);
		String opcion;
		boolean encontrado = false;
		int indice = 0;

		// Vamos a crear un while que se repita hasta que llenemos la lista

		while (indice < lista.length) {
			opcion = sc.nextLine(); // nos da una palabra el usuario
			encontrado = false; // reiniciamos boolean

			// Si es la primera palabra, entonces la llenamos automáticamente

			if (indice == 0) {
				lista[indice] = opcion;
				indice++;
			} else { // sino, tiene que comprobar siempre si la palabra que vamos a introducir
						// ya se encuentra dentro del array

				for (int i = 0; i < indice; i++) {
					if (lista[i].equals(opcion)) {
						encontrado = true;
					}
				}
				if (!encontrado) { // si no ha encontrado el nombre, lo llenamos
					lista[indice] = opcion;
					indice++;
				} else { // si lo encuentra, le decimos que nos dé otra opción
					System.out.println("Usuario, dame un valor que no esté en el Array");
					Intro();
				}
			}
		}
		return lista;
	}

	/*
	 * Función del caso 3
	 */

	public static String[] Llenar1(String[] lista, int indice) {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("------ Escriba un nombre: ---------");
		Scanner sc = new Scanner(System.in);
		String opcion;

		// Hacemos que el usuario llene solo uno usando el índice del método main

		opcion = sc.nextLine();
		lista[indice] = opcion;
		Intro();
		return lista;
	}

	/*
	 * Funciones del caso 4
	 * La siguiente función nos sirve para cambiar el tamaño de la Array tipo Char 
	 * Dicho Array se encuentra en la función reemplazarLetra 
	 * (la de abajo a esta)
	 */

	public static char[] cambiaTamanoChar(char[] listaChar, int tamanoString) {

		// Esta funcion se basa en la de cambiar tamaño
		// Nos sirve para poder tener un Array tipo Char flexible en su tamaño
		// En este caso, no nos importan los valores que hay dentro del Array Char
		// Por lo tanto, lo llenamos de caracteres vacíos para evitar errores

		char[] aux = new char[tamanoString];

		for (int i = 0; i < tamanoString; i++) {
			aux[i] = ' ';
		}
		return aux;
	}

	public static String[] reemplazarLetra(char letra1, char letra2, String[] lista) {
		System.out.println("----------------------------------------------------------------------------------------");

		Scanner sc = new Scanner(System.in);
		int tamanoString; // para saber el tamaño de cada string almancenado en lista[]
		int indice;
		int indiceChar; // para trabajar con un nuevo array tipo Char

		System.out.println("Escribe la letra que quieres cambiar: ");
		letra1 = sc.nextLine().charAt(0); //para tomar el primer caracter escrito
		System.out.println("Escribe la letra por la que la quieres reemplazar: ");
		letra2 = sc.nextLine().charAt(0);

		/*
		 * creamos una nueva Array de tipo Char del tamaño de la String a la que la
		 * vamos a relacionar. Hay que restarle -1 porque recordemos que las Array
		 * empiezan a contar en 0.
		 */
		
		indice = 0;
		tamanoString = lista[indice].length() - 1;
		char[] listaChar = new char[tamanoString]; //creamos el nuevo array
		listaChar = lista[indice].toCharArray(); // Esto es lo que cambia el String del indice 'n' a tipo Char

		while (indice < lista.length) {  //creamos un bucle que analice todo el array lista[]
			if (indice != 0) { //esto lo hacemos para iniciar el Array fuera del bucle
				tamanoString = lista[indice].length() - 1; //reiniciamos el tamaño cada vez que empieza el bucle
				listaChar = cambiaTamanoChar(listaChar, tamanoString); // llamamos a la función para cambiar el tamaño
																		// del Array
				listaChar = lista[indice].toCharArray(); // Esto es lo que cambia el String del indice 'n' a tipo Char
			}

			indiceChar = 0; //iniciamos el indiceChar a cero

			while (indiceChar <= tamanoString) { //este bucle es para el array listaChar[]

				if (letra1 == listaChar[indiceChar]) { //si la letra dada por el usuario se encuentra en el array
					listaChar[indiceChar] = letra2;  //damos a esa letra su nuevo valor
					indiceChar++;
				} else {
					indiceChar++;
				}
			}
			lista[indice] = String.copyValueOf(listaChar); // esto nos convierte en String el Array tipo Char
			indice++;
		}

		System.out.println("Perfecto, hemos cambiado todas las " + letra1 + " por " + letra2);
		Intro();

		return lista;
	}

	/*
	 * Funcion del caso 5
	 */

	public static String[] quitarEspacios(String[] lista) {

		// Quitar espacios al principio y al final
		// Para ello usamos el ya existente método .trim() que elimina espacios delante
		// y detrás, pero no en medio

		System.out.println("----------------------------------------------------------------------------------------");

		for (int i = 0; i < lista.length; i++) {
			lista[i] = lista[i].trim(); // como los String son inmutables, hay que almacenar los nuevos String en el
										// array
		}

		System.out.println("Espacios delante y detrás del array eliminados con... ÉXITO!!");
		Intro();

		return lista;
	}

	/*
	 * Función del caso 6
	 */

	public static void imprimir(String[] lista) {

		Scanner sc = new Scanner(System.in);
		System.out.println("------ Los nombre son ---------");
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
		Intro();
	}

	/*
	 * Función del caso 7
	 */

	public static String[] reemplazarPorPosicion(String[] lista) {

		// Reemplazar un nombre dándole la posición

		Scanner sc = new Scanner(System.in);
		int indice;
		String nombre;

		// Damos las instrucciones

		System.out.println("Escribe la posición del nombre que quieres cambiar:");
		System.out.println("Puedes escribir un numero del 0 al " + (lista.length - 1));
		indice = sc.nextInt();

		// Si el número dado es menor que el tamaño del índice o mayor que cero
		// Entonces es un número válido para hacer de posición en el índice del array

		if (indice < lista.length && indice >= 0) {

			// le enseñamos la palabra que va a cambiar
			System.out.println("Gracias. Ahora escribe el nombre por el que quieres cambiar a " + lista[indice]);
			sc.nextLine();
			nombre = sc.nextLine();
			lista[indice] = nombre; // así lo cambiamos
			System.out.println("Perfecto. Lo hemos cambiado por " + lista[indice]); // enseñamos la nueva palabra
			Intro();
		} else {
			System.out.println("Vaya. has escrito un número que no está entre el 0 y el " + (lista.length - 1));
			System.out.println("Así no puedo ayudarte a cambiar lo que necesitas");
			Intro();
		}

		return lista;
	}

	// Funcion del caso 8

	public static String[] imprimirMayus(String[] lista) {

		// Imprimir lista en Mayus
		// Para ello usamos el método .toUpperCase()
		//esto no va a cambiar la lista, solo la va a imprimir en mayúsculas
		// si quisiéramos cambiarlas tendríamos que hacer lista[i]=lista[i].tuUpperCase();

		System.out.println("------ La lista en mayúsculas es---------");
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i].toUpperCase());
		}

		Intro();
		return lista;
	}

	// Funcion del caso 9

	public static String[] imprimirMinus(String[] lista) {

		// Imprimir lista en minus
		// Para ello usamos el método .toLowerCase()
		//esto no va a cambiar la lista, solo la va a imprimir en minúsculas


		System.out.println("------ La lista en minúscula es---------");
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i].toLowerCase());
		}
		Intro();
		return lista;
	}

	/*
	 * Función del caso 10
	 */

	public static String[] reemplazarNombre(String[] lista) {
		System.out.println("----------------------------------------------------------------------------------------");

		// Reemplazar un nombre por otro

		Scanner sc = new Scanner(System.in);
		int indice = 0, indice_encontrado = 0;
		String nombre1, nombre2;
		boolean encontrado = false;

		// Damos las instrucciones

		System.out.println("Escribe un nombre de esta lista para cambiarlo por otro");
		System.out.println("DEBES RESPETAR LAS MAYÚSCULAS!!");

		// imprimimos la lista para que vea las opciones que puede escribir
		
		imprimir(lista);

		System.out.println("Escribe aquí el nombre elegido:");
		nombre1 = sc.nextLine();

		// Vamos a comprobar si el nombre se encuentra o no en el índice
		// utilizamos un do while para que salga automáticamente del bucle en cuanto encuentre
		// el nombre1 dado por el usuario y así evitar recorrer el resto del array 

		do {
			if (nombre1.equals(lista[indice])) {
				encontrado = true;
				indice_encontrado = indice;
			}
			indice++;
		} while (indice < lista.length && !encontrado);

		// si lo encuentra, entonces le dejaremos cambiar el nombre elegido por otro

		if (encontrado) {
			System.out.println("Ahora escribe el nombre por el que quieras cambiarlo:");
			nombre2 = sc.nextLine();
			lista[indice_encontrado] = nombre2; // esto es lo que cambia el elemento en el array
			// le recordamos el cambio
			System.out.println("He cambiado con éxito " + nombre1 + " por " + nombre2);
			Intro();
		} else { //no lo encuentra, da error
			System.out.println("Vaya, parece que no hemos encontrado en la lista a " + nombre1);
			System.out.println("Asegúrate de que lo has escrito bien respetando las mayúsculas");
			Intro();
		}
		return lista;
	}

	/*
	 * Función del caso 11
	 */

	public static String[] darPosicion(String[] lista) {
		System.out.println("----------------------------------------------------------------------------------------");

		// Dame la posición de un nombre que te indico

		Scanner sc = new Scanner(System.in);
		int indice = 0;
		boolean encontrado = false;
		String nombre1;

		System.out.println("Escribe el nombre de la lista del que quieras conocer su posición");
		nombre1 = sc.nextLine();

		// Usamos un do while porque no nos interesa que el bucle vaya por todo el Array
		// Sino que salga del bucle en cuanto encuentre la palabra que nos el usuario
		// Con .equals comprobamos si existe el nombre que nos ha dado el usuario

		do {
			if (nombre1.equals(lista[indice])) {
				encontrado = true; // para salir del bucle cuando se encuentre
			}else { //hacemos if else para que el valor del indice se mantenga si encuentra la palabra
			indice++;
			}
		} while (indice < lista.length && !encontrado);

		if (encontrado) { // significa que ha encontrado la palabra
			System.out.println("El nombre " + nombre1 + " se encuentra en la posición " + indice);
			Intro();
		} else {
			System.out.println("Vaya, parece que no hemos encontrado en la lista a " + nombre1);
			System.out.println("Asegúrate de que lo has escrito bien respetando las mayúsculas");
			Intro();
		}
		return lista;
	}

	// Funcion del caso 12

	public static String[] vaciarArray(String[] lista) {
		System.out.println("----------------------------------------------------------------------------------------");

		// Vacía el array poniendo una cadena vacia en cada posición");

		Scanner sc = new Scanner(System.in);
		int respuesta;

		// vamos a hacer un switch para no vaciar el array automáticamente
		// por si el usuario se confunde al elegir la opcion

		System.out.println("¿Estás seguro que deseas vaciar tu lista?");
		System.out.println("1.-Si");
		System.out.println("2.-No");
		respuesta = sc.nextInt();
		sc.nextLine();

		switch (respuesta) {
		case 1:

			// esto es lo que vacía el array con una String " " vacía

			for (int i = 0; i < lista.length; i++) {
				lista[i] = " ";
			}
			System.out.println("Lista vaciada con éxito");
			Intro();
			break;
		case 2:
			System.out.println("Entonces no vaciaré la lista");
			Intro();
			break;
		default:
			System.out.println("Dame una respuesta válida (número 1 o 2)");
			Intro();
			break;
		}

		return lista;
	}

	/*
	 * Funcion del caso 13
	 */

	public static String[] darIndexPosicion(String[] lista) {
		System.out.println("----------------------------------------------------------------------------------------");

		// Te doy un nombre y una posición y la reemplazas en el array

		// definimos las variables

		Scanner sc = new Scanner(System.in);
		int indice, respuesta;
		String nombre1;

		// empezamos a programar

		System.out.println("Escribe la posicion del nombre que quieres cambiar");
		indice = sc.nextInt();
		sc.nextLine();

		// Decimos si es mayor o igual que el tamaño de la lista porque empezamos a
		// contar desde el 0

		if (indice >= lista.length || indice < 0) {

			// Le damos algunas opciones para que vea las palabras que existen

			System.out.println("Lo siento. Parece que no existe esa posición...");
			System.out.println("Puedes imprimir la lista en la opcion 6");
			System.out.println("Puedes consultar la cantidad de elementos en la opcion 17");
			Intro();

		} else {

			// Le preguntamos al usuario si está seguro del cambio
			// con lista[indice] imprimimos la palabra que hay en el numero que nos da el
			// usuario

			System.out.println("¿Seguro que quieres cambiar " + lista[indice] + "?");
			System.out.println("1.- Si");
			System.out.println("2.- No");
			respuesta = sc.nextInt();
			sc.nextLine();

			// abrimos switch case para trabajar con las opciones

			switch (respuesta) {
			case 1:
				System.out.println("Ahora escribe el nuevo nombre: ");
				nombre1 = sc.nextLine();
				lista[indice] = nombre1;
				System.out.println("NOMBRE CAMBIADO CON ÉXITO!!");
				Intro();
				break;
			case 2:
				System.out.println("Entonces no cambiaré " + lista[indice]);
				Intro();
				break;
			default:
				System.out.println("Dame una respuesta válida (número 1 o 2)");
				Intro();
				break;
			}
		}
		return lista;
	}

	// Función del caso 14

	public static String[] imprimirPrimeraLetra(String[] lista) {

		// Escribe una palabra formada de la primera letra en el array

		System.out.println("Las primeras letras de la lista forman la siguiente palabra: ");

		// este bucle for imprime el primer carácter gracias al charAt(0)

		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i].charAt(0));
		}
		Intro();
		return lista;
	}

	/*
	 * Función del caso 15
	 */

	public static String[] cambiaTamano(String[] lista, int tamano) {

		String[] aux = new String[tamano];

		for (int i = 0; i < lista.length; i++) {
			aux[i] = lista[i];
		}
		return aux;
	}

	/*
	 * Función del caso 16
	 */

	public static void imprimirPosicion(String[] lista) {
		System.out.println("----------------------------------------------------------------------------------------");
		Scanner sc = new Scanner(System.in);
		int indice;

		// Vamos a definir lo siguiente:

		System.out.println("Dame el número de la posición de la palabra de la que quieres saber su tamaño");
		System.out.println("Puedes darme un número del 0 al " + (lista.length - 1));
		indice = sc.nextInt();
		sc.nextLine();

		if (indice >= lista.length || indice < 0) { // para evitar errores
			System.out.println("Lo Siento. No se ha encontrado ninguna palabra en esa posición");
			Intro();
		} else {

			// Imprimimos el indice para que el usuario vea el número que nos ha dado
			// Con el .length() imprimimos lo que ocupa la palabra en cuestión

			System.out.println(
					"La palabra de la posición " + indice + " es " +lista[indice]+ " y tiene " + lista[indice].length() + " caracteres");
			Intro();
		}
	}

	public static void main(String[] args) {

		int option;
		int tamano;
		int indice = 0;
		char letra1 = ' ';
		char letra2 = ' ';
		boolean listaLlenada = false;

		System.out.println("Con cuantos nombres quieres trabajar");
		Scanner lector = new Scanner(System.in);

		tamano = pedirNumero();
		String[] lista = new String[tamano];

		do {
			System.out.println("Selecciona una opción");
			System.out.println(
					"----------------------------------------------------------------------------------------");
			System.out.println(
					"1. LLenar el Array----------------------------------------------------------------------");
			System.out.println(
					"2. LLenar el Array sin duplicados-------------------------------------------------------");
			System.out.println(
					"3. LLenar el Array uno a uno, es decir, insertar un solo nombre después del último------");
			System.out.println(
					"4. Cambia una letra por otra en todo el array-------------------------------------------");
			System.out.println(
					"5. Elimina los espacios de las palabras al principio y/o al final-----------------------");
			System.out.println(
					"6. Imprimir lista original--------------------------------------------------------------");
			System.out.println(
					"7. Reemplaza un nombre por su posición--------------------------------------------------");
			System.out.println(
					"8. Imprime toda la lista en mayúsculas--------------------------------------------------");
			System.out.println(
					"9. Imprime toda la lista en minúsculas--------------------------------------------------");
			System.out.println(
					"10. Cambia un nombre en la lista por otro-----------------------------------------------");
			System.out.println(
					"11. Obtén la posición del nombre que quieras--------------------------------------------");
			System.out.println(
					"12. Vacía el array con una cadena vacía en cada posición--------------------------------");
			System.out.println(
					"13. Ingresa una posición y reemplaza el nombre en su interior por otro------------------");
			System.out.println(
					"14. Imprime la palabra formada por la primera letra de cada palabra en la lista---------");
			System.out.println(
					"15. Cambia el tamaño de la lista--------------------------------------------------------");
			System.out.println(
					"16. Ingresa una posicón y obtén el número de caracteres de la palabra en esa posición---");
			System.out.println(
					"17. Obtén el número total de elementos que hay en la lista------------------------------");
			System.out.println(
					"0. Salir--------------------------------------------------------------------------------");

			option = pedirNumero();

			switch (option) {

			case 1:
				if (listaLlenada) { // esto lo hacemos para que no nos permita entrar si la lista ya está llena
					System.out.println("Parece que ya has llenado la lista...");
					Intro();
				} else {
					lista = Llenar(lista);
					listaLlenada = true;
					indice = lista.length; // esto lo hacemos para que funcione correctamente el caso 3 en caso de que
											// el usuario cambie el tamaño del Array por uno mayor
				}
				break;
			case 2:
				if (listaLlenada) { // esto lo hacemos para que no nos permita entrar si la lista ya está llena
					System.out.println("Parece que ya has llenado la lista...");
					lector.nextLine();
					Intro();

				} else {
					lista = LlenarSinDuplicar(lista);
					listaLlenada = true;
					indice = lista.length; // para que funcione el caso 3
				}
				break;
			case 3:
				if (!listaLlenada) {
					if (indice < lista.length) {
						lista = Llenar1(lista, indice);
						indice++;
					} else { // para que se complete el llenar la lista solo usando el caso 3
						System.out.println("Parece que has llenado toda tu lista");
						indice = lista.length;
						listaLlenada = true;
						Intro();
					}
				} else { // para evitar poder llenar la lista si ya está llena
					System.out.println("Parece que has llenado toda tu lista");
					Intro();
				}
				break;
			case 4:
				if (!listaLlenada) {// para evitar que puedan pasar por aquí sin llenar la lista
					Error();
				} else {
					lista = reemplazarLetra(letra1, letra2, lista);
				}
				break;
			case 5:
				if (!listaLlenada) {
					Error();
				} else {
					quitarEspacios(lista);
				}
				break;
			case 6:
				imprimir(lista);
				break;
			case 7:
				if (!listaLlenada) {
					Error();
				} else {
					reemplazarPorPosicion(lista);
				}
				break;
			case 8:
				if (!listaLlenada) {
					Error();
				} else {
					imprimirMayus(lista);
				}
				break;
			case 9:
				if (!listaLlenada) {
					Error();
				} else {
					imprimirMinus(lista);
				}
				break;
			case 10:
				if (!listaLlenada) {
					Error();
				} else {
					reemplazarNombre(lista);
				}
				break;
			case 11:
				if (!listaLlenada) {
					Error();
				} else {
					darPosicion(lista);
				}
				break;
			case 12:
				if (!listaLlenada) {
					Error();
				} else {
					vaciarArray(lista);
				}
				break;
			case 13:
				if (!listaLlenada) {
					Error();
				} else {
					darIndexPosicion(lista);
				}
				break;
			case 14:
				if (!listaLlenada) {
					Error();
				} else {
					imprimirPrimeraLetra(lista);
				}
				break;
			case 15:
				System.out.println("Dime el nuevo tamaño");
				lista = cambiaTamano(lista, pedirNumero());
				if (lista.length > indice) { // esto lo hacemos para saber si la lista es más o menos grande que la
												// anterior. Si es más grande, entonces podremos volver a llenar
					listaLlenada = false;
				}
				break;
			case 16:
				if (!listaLlenada) {
					Error();
				} else {
					imprimirPosicion(lista);
				}
				break;
			case 17:
				// vamos a sacar su tamaño -1 porque después para buscar posiciones de nombres
				// vamos a partir desde el número 0

				System.out.println("El índice de la lista va del 0 al " + (lista.length - 1));
				System.out.println("La lista contiene un total de " + lista.length + " palabras");
				Intro();
				break;
			}
		} while (option != 0);
		System.out.println("GRACIAS POR USARME!!!");
	}
}