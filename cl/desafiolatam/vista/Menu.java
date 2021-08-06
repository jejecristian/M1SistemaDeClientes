package cl.desafiolatam.vista;

import java.util.Scanner;

import cl.desafiolatam.servicio.*;
import cl.desafiolatam.utilidades.*;

public class Menu implements AccionesMenu{
	ClienteServicio clienteServicio = new ClienteServicio();
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ExportadorCsv exportadorCsv = new ExportadorCsv();
	ExportadorTxt exportadorTxt = new ExportadorTxt();
	String fileName = "Clientes"; //para exportar el archivo
	String fileName1 = "DBClientes.csv"; //para importar el archivo
	Scanner sc = new Scanner(System.in);
	
	public void iniciarMenu() {
		String opcion = "";
		boolean clsBfMenu = false;
		Utilidad utilidad = new Utilidad();
		
		try {
			// Presenta men� principal
			do {
				// Se indica si debe limpiar pantalla antes de presentar el men�
				if (clsBfMenu) {
					utilidad.limpiezaDePantalla();
				}
				clsBfMenu = true;
				System.out.println("******************************");
				System.out.println("*    SISTEMA DE CLIENTES     *");
				System.out.println("******************************");
				System.out.println("*  Men� disponible:          *");
				System.out.println("*  1 Listar   Clientes       *");
				System.out.println("*  2 Agregar  Cliente        *");
				System.out.println("*  3 Editar   Cliente        *");
				System.out.println("*  4 Cargar   Datos          *");
				System.out.println("*  5 Exportar Datos          *");
				System.out.println("*  6 Salir                   *");
				System.out.println("******************************");
				System.out.println("Ingrese una opci�n:");
				opcion = sc.nextLine();

				switch (opcion) {
				case "1": // Listar Clientes
					// Limpia pantalla
					utilidad.limpiezaDePantalla();
					if (clienteServicio.getListaClientes().isEmpty()) {
						// Si no hay clientes, muestra mensaje informativo
						System.out.println("A�n no existen clientes en la lista.");
					} else {
						// Si hay clientes, muestra lista de clientes
						listarClientes();
						System.out.printf("\n\n");
						System.out.println("Operaci�n completada exitosamente...");
					}
					System.out.println("Presione Enter para volver al menu principal.");
					sc.nextLine();
					break;
				case "2": // Agregar Cliente
					// Invoca metodo que permite ingresar un nuevo cliente
					agregarCliente();
					System.out.println("Presione Enter para volver al menu principal.");
					sc.nextLine();
					break;
				case "3": // Editar Cliente
					/*
					// Limpia pantalla
					utilidad.limpiezaDePantalla();
					if (archivoServicio.getProductoServicio().getListaProductos().isEmpty()) {
						// Si no hay productos, muestra mensaje informativo
						System.out.println("A�n no existen productos en la lista.");
					} else {
						// Si hay productos, se podria editar un producto
						System.out.println("Editar Producto");
						System.out.println("Ingrese el n�mero 1 para editar los datos ingresados del Producto");
						respuesta = sc.nextLine();
						if (respuesta.equals("1")) {
							// Si la respuesta es 1 entonces podr�a editar producto
							System.out.println("Ingrese c�digo del producto:");
							codigo = sc.nextLine();
							// Invoca metodo que permite encontrar el producto y valida retorno
							if (archivoServicio.encontrarProducto(codigo)) {
								// Si el c�digo ingresado existe dentro de la lista de productos
								System.out.println("Ingrese la opci�n a editar de los datos del producto: ");
								dato = sc.nextLine();
								if (dato.equals("1")) {
									// Si ingres� opci�n v�lida para editar un dato
									System.out.println("Ingrese el nuevo nombre del producto: ");
									valor = sc.nextLine();
									// Invoca metodo que permite editar dato del producto
									archivoServicio.editarProducto(codigo, dato, valor);
								} else if (dato.equals("2")) {
									// Si ingres� opci�n v�lida para editar un dato
									System.out.println("Ingrese el nuevo c�digo del producto: ");
									valor = sc.nextLine();
									// Invoca metodo que permite editar dato del producto
									archivoServicio.editarProducto(codigo, dato, valor);
								} else if (dato.equals("3")) {
									// Si ingres� opci�n v�lida para editar un dato
									System.out.println("Ingrese el nuevo color del producto: ");
									valor = sc.nextLine();
									// Invoca metodo que permite editar dato del producto
									archivoServicio.editarProducto(codigo, dato, valor);
								} else if (dato.equals("4")) {
									// Si ingres� opci�n v�lida para editar un dato
									System.out.println("Ingrese la nueva descripci�n del producto: ");
									valor = sc.nextLine();
									// Invoca metodo que permite editar dato del producto
									archivoServicio.editarProducto(codigo, dato, valor);
								} else if (dato.equals("5")) {
									// Si ingres� opci�n v�lida para editar un dato
									System.out.println("Ingrese la nueva marca del producto: ");
									valor = sc.nextLine();
									// Invoca metodo que permite editar dato del producto
									archivoServicio.editarProducto(codigo, dato, valor);
								} else if (dato.equals("6")) {
									// Si ingres� opci�n v�lida para editar un dato
									System.out.println("Ingrese el nuevo precio del producto: ");
									valor = sc.nextLine();
									// Invoca metodo que permite editar dato del producto
									archivoServicio.editarProducto(codigo, dato, valor);
								} else if (dato.equals("7")) {
									// Si ingres� opci�n v�lida para editar un dato
									System.out.println("Ingrese la nueva talla del producto: ");
									valor = sc.nextLine();
									// Invoca metodo que permite editar dato del producto
									archivoServicio.editarProducto(codigo, dato, valor);
								} else {
									// Si ingres� una opci�n inv�lida para editar un dato
									System.out.printf("\n");
									System.out.println("No se editar�n datos, ya que no ingres� una opci�n v�lida.");
								}
							} else {
								// Si el c�digo ingresado no existe dentro de la lista de productos
								System.out.printf("\n");
								System.out.println("El c�digo ingresado no coincide con ningun producto.");
							}
						} else {
							// La respuesta fue distinto de 1 por ende no editar� producto
							System.out.printf("\n");
							System.out.println("No se editar�n datos, ya que no ingres� 1.");
						}
					}
					System.out.println("Presione Enter para volver al menu principal.");
					sc.nextLine();
					*/
					break;
				case "4":// Cargar Datos
					/*
					// Limpia pantalla
					utilidad.limpiezaDePantalla();
					// Valida nombre de la ruta
					String directorio = "";
					System.out.println("Cargar Datos");
					System.out.println("Ingrese la ruta en donde se encuentra el archivo");
					System.out.println("ProductosImportados.csv:");
					System.out.printf("\n");
					// Se espera que el usuario ingrese la ruta como por ejemplo:
					// "src/miCarpeta" ya que esta se incluye en el package con el archivo
					directorio = sc.nextLine();
					if (directorio.trim().length() == 0) {
						// Si el nombre de la ruta es vacio, muestra mensaje informativo
						System.out.printf("\n");
						System.out.println("El nombre del directorio ingresado no es v�lido.");
						System.out.println("Volviendo al men� principal...");
						// Uso del tiempo de espera
						utilidad.tiempoDeEspera(3);
					} else {
						// Si el nombre de la ruta es v�lida, podr�a importar datos
						if (archivoServicio.getProductoServicio().getListaProductos().isEmpty()) {
							// Si no hay productos importados, importa datos desde el csv
							// Asigna valor al atributo de ruta del archivo
							archivoServicio.setRutaArchivo(directorio);
							// Invoca metodo para importar datos
							archivoServicio.cargarDatos();
							sc.nextLine();
						} else {
							// Si hay productos importados, se consultara si desea importar nuevamente
							System.out.printf("\n");
							System.out.println("Ya existen datos cargados en la lista");
							System.out.println("�Desea cargar los datos nuevamente?");
							System.out.println("Ingrese 1 para continuar...");
							respuesta = sc.nextLine();
							if (respuesta.equals("1")) {
								// Si requiere importar nuevamente la lista
								// Asigna valor al atributo de ruta del archivo
								archivoServicio.setRutaArchivo(directorio);
								// Invoca metodo para importar datos
								archivoServicio.cargarDatos();
								sc.nextLine();
							} else {
								System.out.printf("\n");
								System.out.println("No se volvieron a cargar los datos, ya que no ingres� 1.");
								System.out.println("Presione Enter para volver al menu principal.");
								sc.nextLine();
							}
						}
					}
					*/
					break;
				case "5": // Exportar Datos
					break;
				case "6": // Salir
					// Invoca metodo que finaliza el programa
					terminarPrograma();
					break;
				default:
					if (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3") 
						&& !opcion.equals("4")&& !opcion.equals("5")&& !opcion.equals("6")) 
					{
						// Limpia pantalla
						utilidad.limpiezaDePantalla();
						System.out.println("\nLa opci�n ingresada no es v�lida.");
						System.out.println("Presione Enter para volver al menu principal.");
						sc.nextLine();
					}
				}
			} while (!opcion.equals("6"));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
		
	}
	
	// 8.1.- listarClientes, muestra lista de clientes agregados, 
	// ya sea por importaci�n o agregando a mano.
	@Override
	public void listarClientes() {
		// Invoca metodo listarClientes de la Clase ClienteServicio, por lo siguiente:
		// 9.3.- Generar el m�todo p�blico sin valor de retorno listarClientes 
		// e implementar el ciclo m�s id�neo para recorrer cada uno de los clientes.
		clienteServicio.listarClientes();
	}

	//8.2.- agregarCliente, solicita ingreso de datos y llena objeto de tipo Cliente.
	@Override
	public void agregarCliente() {
		// Se solicita datos del cliente y se guardan en las variales
		String run, nombre, apellido, anios;
		System.out.println("-------------Crear Cliente-------------");
		
		// Valida RUN
		do {
			System.out.println("\nIngresa RUN del Cliente:");
			run = sc.nextLine().trim();
			if (run.trim().equals("")) {
				System.out.println("El RUN del Cliente no puede ser nulo.");
			}
		} while (run.trim().equals(""));
		
		// Valida Nombre
		do {
			System.out.println("\nIngresa Nombre del Cliente:");
			nombre = sc.nextLine().trim();
			if (nombre.trim().equals("")) {
				System.out.println("El Nombre del Cliente no puede ser nulo.");
			}
		} while (nombre.trim().equals(""));
		
		// Valida Apellido
		do {
			System.out.println("\nIngresa Apellido del Cliente:");
			apellido = sc.nextLine().trim();
			if (apellido.trim().equals("")) {
				System.out.println("El Apellido del Cliente no puede ser nulo.");
			}
		} while (apellido.trim().equals(""));
		
		// Valida antiguedad
		System.out.println("\nIngresa a�os como Cliente:");
		anios = sc.nextLine().trim();
		if (anios.trim().equals("")) {
			anios = "0 a�os";
		}else if(!anios.trim().contains("a�o")) {
			try {
				if (Integer.parseInt(anios) == 1) {
					anios = anios + " a�o";
				} else if (Integer.parseInt(anios) > 1) {
					anios = anios + " a�os";
				} else {
					anios = "0 a�os";
				}
			} catch (NumberFormatException e) {
				anios = "0 a�os";
			}
			
		}
		System.out.printf("\n\n");
		System.out.println("---------------------------------------");
		
		// Invoca metodo agregarCliente de la Clase ClienteServicio, por lo siguiente:
		// 9.4.- Generar un public void del m�todo agregarCliente y pasarle
		// los par�metros de la clase Cliente.
		// Utiliza este m�todo para guardar clientes en una instancia de cliente.
		clienteServicio.agregarCliente(run, nombre, apellido, anios);
	}

	// 8.3.- editarCliente, permite la edici�n de alg�n cliente 
	// en caso de requerirlo o cambiar el estado del cliente.
	@Override
	public void editarCliente() {
		String opEdit, run, nombre, apellido, anios;
		run = "";
		nombre = "";
		apellido = "";
		anios = "";
		do {
			System.out.println("-------------Editar Cliente-------------");
			System.out.println("Seleccione qu� desea hacer:");
			System.out.println("1.-Cambiar el estado del Cliente");
			System.out.println("2.-Editar los datos ingresados del Cliente");
			System.out.println();
			System.out.println("Ingrese opcion:");
			System.out.println("----------------------------------------");
			System.out.println();
			opEdit = sc.nextLine().trim();
			if (!opEdit.trim().equals("1") && !opEdit.trim().equals("2")) {
				System.out.println("Ingrese una opci�n v�lida.");
			}
		} while (!opEdit.trim().equals("1") && !opEdit.trim().equals("2"));
		if(opEdit.trim().equals("1")) {
			// En este caso, se buscar� cambiar el estado del cliente
			System.out.println("Ingrese RUN del Cliente a editar: ");
			run = sc.nextLine();
			System.out.println("-----Actualizando estado del Cliente----");
			System.out.println("El estado actual es: "+"");
			System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
			System.out.println("2.-Si desea mantener el estado del cliente Activo");
			System.out.println();
			System.out.println("Ingrese opci�n:");
			opEdit = sc.nextLine();
			System.out.println("----------------------------------------");
			System.out.println("Datos cambiados con �xito");
			
		}else {
			// En este caso, se quiere cambiar los datos ingresados en 
			// un cliente, mediante la b�squeda por el RUN
			System.out.println("Ingrese RUN del Cliente a editar: ");
			System.out.println();
			System.out.println("-----Actualizando estado del Cliente----");
		}
		
		// Invoca metodo editarCliente de la Clase ClienteServicio, por lo siguiente:
		// 9.5.- Generar un public void del m�todo editarCliente 
		// y pasarle los par�metros de la clase Cliente.
		clienteServicio.editarCliente(run, nombre, apellido, anios);
	}

	@Override
	public void importarDatos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exportarDatos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void terminarPrograma() {
		Utilidad utilidad = new Utilidad();
		// Limpia pantalla
		utilidad.limpiezaDePantalla();
		System.out.println("Abandonando el sistema de clientes...");
		// Uso del tiempo de espera
		utilidad.tiempoDeEspera(2);
		System.out.println("Acaba de salir del sistema");
		
	}
}
