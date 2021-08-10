package cl.desafiolatam.servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import cl.desafiolatam.modelo.Cliente;

// 11.- Crear una clase ExportadorCsv en el package servicio,
// que contenga un método exportar, cuyos parámetros serán
// String fileName y una List<Cliente> listaClientes.
// Se deben realizar las implementaciones correspondientes
// al interior del método usando PrintWriter y Filewriter
// para la exportación de archivos.
public class ExportadorCsv extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaCliente) {
		// Variables para trabajar la ruta del archivo
		String ruta = "";
		int largoStr;

		// Obtiene ruta proveniente del parametro fileName
		String[] datosImport = fileName.split("Clientes");
		ruta = datosImport[0];
		largoStr = ruta.length();
		ruta = ruta.substring(0, largoStr - 1);

		// Crea excepcion para la creacion del directorio y archivo
		try {
			File carpeta = new File(ruta);
			File archivo = new File(fileName);
			// Valida si existe la ruta
			if (carpeta.exists() == false) {
				// Si la ruta no existe entonces
				// Crea el directorio
				carpeta.mkdir();
				// Crea el archivo
				archivo.createNewFile();
				// Invoca metodo auxiliar para guardar datos en el archivo
				llenarArchivo(ruta, fileName, listaCliente);
			} else {
				// Si la ruta existe entonces
				// Valida si existe el archivo
				if (archivo.exists() == false) {
					// Si el archivo no existe entonces
					// Crea el archivo
					archivo.createNewFile();
					// Invoca metodo auxiliar para guardar datos en el archivo
					llenarArchivo(ruta, fileName, listaCliente);
				} else {
					// Si el archivo existe entonces
					// Elimina el archivo
					archivo.delete();
					// Crea el archivo
					archivo.createNewFile();
					// Invoca metodo auxiliar para guardar datos en el archivo
					llenarArchivo(ruta, fileName, listaCliente);
				}
			}
		} catch (IOException e) {
			System.out.println("\nNo se pudo crear directorio.");
			System.out.println(e.getMessage());
		}
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("Datos de clientes exportados correctamente en formato csv.");

	}

	// Metodo auxiliar que permite guardar datos en el archivo
	public void llenarArchivo(String carpeta, String fileName, List<Cliente> listaCliente) {
		String estado = "";
		// Crea excepcion para lectura de la lista de productos
		try {
			// Obtiene datos de ubicacion y nombre del archivo
			File documento = new File(fileName);
			// Inicializa escritura del archivo
			FileWriter fw = new FileWriter(documento);
			BufferedWriter bw = new BufferedWriter(fw);
			// Por cada cliente que contenga la lista, inserta una linea en el archivo
			for (Cliente cli : listaCliente) {
				// Rellena archivo en formato CSV, que van separados por coma
				cli.getRunCliente();
				cli.getNombreCliente();
				cli.getApellidoCliente();
				cli.getAniosCliente();
				cli.getEstado();
				// Valida el estado del cliente
				if (String.valueOf(cli.getEstado()).equalsIgnoreCase("activo")) {
					estado = "Activo";
				} else {
					estado = "Inactivo";
				}
				// Inserta datos en el archivo
				bw.write(cli.getRunCliente() + "," + cli.getNombreCliente() + "," + cli.getApellidoCliente() + ","
						+ cli.getAniosCliente() + "," + estado);
				bw.newLine();
			}
			// guarda datos en el archivo al cerrarlo
			bw.close();
		} catch (IOException e) {
			System.out.println("\nEl archivo no existe.");
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("\nLista fuera de rango.");
			System.out.println(e.getMessage());
		}
	}

}
