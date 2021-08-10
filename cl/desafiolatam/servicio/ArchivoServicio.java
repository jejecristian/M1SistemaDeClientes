package cl.desafiolatam.servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.modelo.CategoriaEnum;
import cl.desafiolatam.modelo.Cliente;

/*
13.- Crear la clase ArchivoServicio en el package servicio que extiende a la clase
Exportador. Esta contiene los siguientes requisitos:
- Crear el método cargarDatos que recibe por parámetro un String fileName, el
cual indica el nombre del archivo a cargar. Se deben realizar las
implementaciones correspondientes al interior del método usando FileReader
y BufferedReader (para lectura de archivos).
- Crear el método exportar que será una herencia proveniente de la clase
Exportador, cuyos parámetros serán los mismos que se van a implementar en
el paso 8.
*/
public class ArchivoServicio extends Exportador{
	
	private ClienteServicio clienteServicio = new ClienteServicio();
	
	public ArchivoServicio() {
		super();
	}

	public ArchivoServicio(ClienteServicio clienteServicio) {
		super();
		this.clienteServicio = clienteServicio;
	}

	public ClienteServicio getClienteServicio() {
		return clienteServicio;
	}

	public void setClienteServicio(ClienteServicio clienteServicio) {
		this.clienteServicio = clienteServicio;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArchivoServicio [clienteServicio=");
		builder.append(clienteServicio);
		builder.append("]");
		return builder.toString();
	}
	
	// 13.2.- Crear el método exportar que será una herencia proveniente 
	// de la clase Exportador, cuyos parámetros serán los mismos que se 
	// van a implementar en el paso 8.
	@Override
	void exportar(String fileName, List<Cliente> listaCliente) {
		System.out.println("---------Exportar Datos-----------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println();
		System.out.println("Ingrese una opción para exportar:");
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("---------Exportar Datos en Windows---------------");
		System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("Datos de clientes exportados correctamente en formato txt.");
	}
	
	//8.4.- cargarDatos, ejecuta la carga de datos del archivo “DBClientes.csv”.
	//13.1.- Crear el método cargarDatos que recibe por parámetro 
	//un String fileName, el cual indica el nombre del archivo a cargar.
	//Se deben realizar las implementaciones correspondientes al interior 
	//del método usando FileReader y BufferedReader (para lectura de archivos).
	public void cargarDatos(String fileName) {
		// Crea excepciones sobre existencia de ruta y archivo
		try {
			// Comprueba existencia del archivo
			File archivo = new File(fileName);
			if (archivo.exists() == false) {
				// Si el archivo no es encontrado, muestra mensaje informativo
				System.out.printf("\n");
				System.out.println("No se encontró el archivo en la ruta ingresada.");
			} else {
				// Si el archivo fue encontrado
				// Crea lista para recibir importacion
				ArrayList<Cliente> listaClientesImportados = new ArrayList<Cliente>();
				// Genera lectura del archivo
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String linea = br.readLine();
				// Se define contador de lineas fallidas
				int contador = 0;
				while (linea != null) {
					Cliente cliente = new Cliente();
					String[] datosImport = linea.split(",");
					if (datosImport.length == 5) {
						// Asgina valores de atributos del nuevo cliente
						cliente.setRunCliente(datosImport[0]);
						cliente.setNombreCliente(datosImport[1]);
						cliente.setApellidoCliente(datosImport[2]);
						cliente.setAniosCliente(datosImport[3]);
						if (datosImport[4].equalsIgnoreCase("inactivo")) {
							cliente.setEstado(CategoriaEnum.INACTIVO);
						}else {
							cliente.setEstado(CategoriaEnum.ACTIVO);
						}
						// Agrega cliente a la lista
						listaClientesImportados.add(cliente);
					}else {
						contador++;
					}
					linea = br.readLine();
				}
				br.close();
				if (contador > 0) {
					System.out.println();
					System.out.println("Proceso cargar datos cancelado. El contenido del archivo no es legible.");
				}else {
					// Establece la lista
					clienteServicio.setListaClientes(listaClientesImportados);
					// Imprime mensaje informativo
					System.out.println();
					System.out.println("-----------------------------------------------");
					System.out.println();
					System.out.println("Datos cargados correctamente en la lista");					
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
