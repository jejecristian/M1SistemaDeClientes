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

public class ArchivoServicio extends Exportador{
	
	private ClienteServicio clienteServicio = new ClienteServicio();
	private String rutaArchivo;
	
	public ArchivoServicio() {
		super();
	}

	public ArchivoServicio(ClienteServicio clienteServicio, String rutaArchivo) {
		super();
		this.clienteServicio = clienteServicio;
		this.rutaArchivo = rutaArchivo;
	}

	public ClienteServicio getClienteServicio() {
		return clienteServicio;
	}

	public void setClienteServicio(ClienteServicio clienteServicio) {
		this.clienteServicio = clienteServicio;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArchivoServicio [clienteServicio=");
		builder.append(clienteServicio);
		builder.append(", rutaArchivo=");
		builder.append(rutaArchivo);
		builder.append("]");
		return builder.toString();
	}

	@Override
	void exportar(String fileName, List<Cliente> listaCliente) {
		// TODO Auto-generated method stub
		
	}
	
	//8.4.- cargarDatos, ejecuta la carga de datos del archivo “DBClientes.csv”.
	//13.1.- Crear el método cargarDatos que recibe por parámetro 
	//un String fileName, el cual indica el nombre del archivo a cargar.
	//Se deben realizar las implementaciones correspondientes al interior 
	//del método usando FileReader y BufferedReader (para lectura de archivos).
	public void cargarDatos(String fileName) {
		// Arma ruta y nombre del archivo a importar
		// String aImportar = this.getRutaArchivo() + "/DBClientes.csv";
		String aImportar = this.getRutaArchivo() + fileName;

		// Crea excepciones sobre existencia de ruta y archivo
		try {
			// Comprueba existencia del directorio y archivo
			File carpeta = new File(this.getRutaArchivo());
			File archivo = new File(aImportar);
			if (carpeta.exists() == false) {
				// Si la ruta no existe, muestra mensaje informativo
				System.out.printf("\n");
				System.out.println("La ruta ingresada no existe.");
				System.out.println("Presione Enter para volver al menu principal.");
			} else {
				if (archivo.exists() == false) {
					// Si el archivo no existe, muestra mensaje informativo
					System.out.printf("\n");
					System.out.println("No existe el archivo dentro de la ruta ingresada.");
					System.out.println("Presione Enter para volver al menu principal.");
				} else {
					// Si la ruta y archivo sí existe
					// Crea lista para recibir importacion
					ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
					// Genera lectura del archivo
					FileReader fr = new FileReader(archivo);
					BufferedReader br = new BufferedReader(fr);
					String linea = br.readLine();
					while (linea != null) {
						Cliente cliente = new Cliente();
						String[] datosImport = linea.split(",");
						if (datosImport.length == 5) {
							// Asgina valores de atributos del nuevo cliente
							cliente.setRunCliente(datosImport[0]);
							cliente.setNombreCliente(datosImport[1]);
							cliente.setApellidoCliente(datosImport[2]);
							cliente.setAniosCliente(datosImport[3]);
							cliente.setEstado(CategoriaEnum.valueOf(datosImport[4]));
							// Agrega cliente a la lista
							listaCliente.add(cliente);
						} else {
							// IMPLEMENTAR ALGO POR SI EL CONTENIDO DE LA LISTA NO SIRVE
							// SON MAS, O SON MENOS, LOS DATOS QUE VIENEN EN LA LINEA
							// O VIENE CUALQUIER COSA EN LA LINEA
						}
						linea = br.readLine();
					}
					br.close();
					// Establece la lista
					clienteServicio.setListaClientes(listaCliente);
					// Imprime la lista, uno por cada linea
					System.out.printf("\n");
					for (Cliente cli : listaCliente) {
						System.out.println(cli.toString());
					}
					// Imprime mensaje informativo
					System.out.printf("\n");
					System.out.println("Datos cargados correctamente en la lista");
					System.out.println("Presione Enter para volver al menu principal.");
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
