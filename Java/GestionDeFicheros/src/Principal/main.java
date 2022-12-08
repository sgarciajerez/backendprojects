package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class main {

	public static Scanner lector = new Scanner(System.in);

	public static void limpiar_pantalla() {

		for (int i = 0; i < 200; i++) {
			System.out.println(" ");
		}
	}

	public static String introducirRuta() {
		String ruta;
		ruta = JOptionPane.showInputDialog(null, "Inserte la ruta del archivo", "Insertar",
				JOptionPane.INFORMATION_MESSAGE); //abre cuadro de diálogo
		System.out.println("Ruta Introducida"); //nos informa por consola que todo va bien
		return ruta;
	}

	public static String introducirNombreDelArchivo() {
		String nombre;
		nombre = JOptionPane.showInputDialog(null, "Inserte el nombre del archivo (sin .txt)", "Insertar",
				JOptionPane.INFORMATION_MESSAGE);
		System.out.println("Nombre Introducido"); //nos informa por consola que todo va bien
		return nombre;
	}

	public static int tamanoListado() {
		int i;
		String numero_en_string; //el JOptionPanel devuelve un String

		try {
			numero_en_string = JOptionPane.showInputDialog(null, "¿Cuántas frases quiere introducir?", "Insertar",
					JOptionPane.INFORMATION_MESSAGE);
			i = Integer.valueOf(numero_en_string); //Transformamos el string en INT 
		} catch (Exception e) {
			System.out.println("Error. Introduzca un número por favor: ");
			numero_en_string = JOptionPane.showInputDialog(null, "¿Cuántas frases quiere introducir?", "Insertar",
					JOptionPane.INFORMATION_MESSAGE);
			i = Integer.valueOf(numero_en_string);
		}
		System.out.println("Tamaño introducido."); //nos informa por consola que todo va bien

		return i;
	}

	public static void main(String[] args) {

		String ruta_del_archivo = introducirRuta(); // pedimos la ruta del archivo
		String nombre_del_archivo = introducirNombreDelArchivo(); // pedimos el nombre del archivo
		int tamano_del_listado = tamanoListado(); // pedimos el numero de lineas que va a contener el archivo

		// vamos a añadir la ruta y el nombre del archivo para crear un nuevo documento
		// los concatenamos con un .txt para que el archivo creado sea de texto
		
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter(ruta_del_archivo + "\\" + nombre_del_archivo + ".txt"))) {
			String linea_del_archivo = "";
			int contador = 1; //lo empezamos en uno para poder mostarlo por pantalla de forma más natural

			while (contador <= tamano_del_listado) { //repetición mientras el contador sea menor que el tamaño indicado
				linea_del_archivo = JOptionPane.showInputDialog(null, ("Introduzca la frase " + contador) , "Insertar",
						JOptionPane.INFORMATION_MESSAGE); //aquí usamos también el contador
				bw.write(linea_del_archivo);
				bw.newLine();
				System.out.println("Frase " + contador + " introducida con éxito");
				contador++;
			}

		} catch (IOException e) {
			System.out.println("Error");
		}
		
		limpiar_pantalla();
		
		//mensaje de que todo va correctamente 
		
		System.out.println("Frases Introducidas con éxito");
		System.out.println("Ahora voy a mostrarlas por consola");
		System.out.println("Pulsa Intro para continuar...");
		lector.nextLine();
		
		limpiar_pantalla();
		try (BufferedReader br = new BufferedReader(new FileReader(ruta_del_archivo + "\\" + nombre_del_archivo + ".txt"))) {
			String linea_del_archivo; // string que lee cada linea del archivo
			String linea_sin_espacios; //el String que almacena las lineas del archivo sin espacios

			while ((linea_del_archivo = br.readLine()) !=null) {
				linea_sin_espacios=linea_del_archivo.replaceAll(" ", ""); //quitamos espacios
				System.out.println("- " + linea_del_archivo + ": contiene " + linea_sin_espacios.length() + " caracteres.");
				//damos el tamaño de linea_sin_espacios.length para contar los caracteres
			}

		} catch (IOException e) {
			System.out.println("Error");
		}
	}

}
