package cl.desafiolatam.vista;

import java.util.Scanner;

import cl.desafiolatam.modelo.Cliente;
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
	
	// 6.8.- iniciarMenu, muestra el menu principal y recibe 
	// la entrada del teclado a través del scanner.
	// Contiene la lógica para denotar los demás métodos 
	// en base a la entrada del teclado.
	// 8.7.- Hint: El único método que no se debe sobreescribir es iniciarMenu, 
	// ya que contiene su implementación al inicio de la clase para formar el menú.
	public void iniciarMenu() {
		String opcion = "";
		boolean clsBfMenu = false;
		Utilidad utilidad = new Utilidad();
		
		try {
			// Presenta menú principal
			do {
				// Se indica si debe limpiar pantalla antes de presentar el menú
				if (clsBfMenu) {
					utilidad.limpiezaDePantalla();
				}
				clsBfMenu = true;
				System.out.println("******************************");
				System.out.println("*    SISTEMA DE CLIENTES     *");
				System.out.println("******************************");
				System.out.println("*  Menú disponible:          *");
				System.out.println("*  1 Listar   Clientes       *");
				System.out.println("*  2 Agregar  Cliente        *");
				System.out.println("*  3 Editar   Cliente        *");
				System.out.println("*  4 Cargar   Datos          *");
				System.out.println("*  5 Exportar Datos          *");
				System.out.println("*  6 Salir                   *");
				System.out.println("******************************");
				System.out.println("Ingrese una opción:");
				opcion = sc.nextLine();

				switch (opcion) {
				case "1": // Listar Clientes
					// Limpia pantalla
					utilidad.limpiezaDePantalla();
					if (clienteServicio.getListaClientes().isEmpty()) {
						// Si no hay clientes, muestra mensaje informativo
						System.out.println("Aún no existen clientes en la lista.");
					} else {
						// Si hay clientes, muestra lista de clientes
						listarClientes();
						System.out.printf("\n\n");
						System.out.println("Operación completada exitosamente...");
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
					// Limpia pantalla
					utilidad.limpiezaDePantalla();
					if (clienteServicio.getListaClientes().isEmpty()) {
						// Si no hay clientes, muestra mensaje informativo
						System.out.println("Aún no existen clientes en la lista como para editar uno.");
					} else {
						// Si hay clientes, se podrian editar los datos
						// invoca metodo para editar cliente
						editarCliente();
					}
					System.out.println("Presione Enter para volver al menu principal.");
					sc.nextLine();
					break;
				case "4":// Cargar Datos
					// Limpia pantalla
					utilidad.limpiezaDePantalla();
					// invoca metodo para importar datos
					importarDatos();
					System.out.println("Presione Enter para volver al menu principal.");
					sc.nextLine();
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
						System.out.println("\nLa opción ingresada no es válida.");
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
	// ya sea por importación o agregando a mano.
	@Override
	public void listarClientes() {
		// Invoca metodo listarClientes de la Clase ClienteServicio, por lo siguiente:
		// 9.3.- Generar el método público sin valor de retorno listarClientes 
		// e implementar el ciclo más idóneo para recorrer cada uno de los clientes.
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
		System.out.println("\nIngresa años como Cliente:");
		anios = sc.nextLine().trim();
		if (anios.trim().equals("")) {
			anios = "0 años";
		}else if(!anios.trim().contains("año")) {
			try {
				if (Integer.parseInt(anios) == 1) {
					anios = anios + " año";
				} else if (Integer.parseInt(anios) > 1) {
					anios = anios + " años";
				} else {
					anios = "0 años";
				}
			} catch (NumberFormatException e) {
				anios = "0 años";
			}
			
		}
		System.out.printf("\n\n");
		System.out.println("---------------------------------------");
		
		// Invoca metodo agregarCliente de la Clase ClienteServicio, por lo siguiente:
		// 9.4.- Generar un public void del método agregarCliente y pasarle
		// los parámetros de la clase Cliente.
		// Utiliza este método para guardar clientes en una instancia de cliente.
		clienteServicio.agregarCliente(run, nombre, apellido, anios);
	}

	// 8.3.- editarCliente, permite la edición de algún cliente 
	// en caso de requerirlo o cambiar el estado del cliente.
	@Override
	public void editarCliente() {
		String opEdit = "", run = "", nombre = "", apellido = "";
		String anios = "", estado = "", estadoInverso = "";
		boolean invocEditClienteServicio = true;
		Utilidad utilidad = new Utilidad();
		
		// Presenta menu de edición de datos
		do {
			System.out.println("-------------Editar Cliente-------------");
			System.out.println("Seleccione qué desea hacer:");
			System.out.println("1.-Cambiar el estado del Cliente");
			System.out.println("2.-Editar los datos ingresados del Cliente");
			System.out.println();
			System.out.println("Ingrese opcion:");
			System.out.println("----------------------------------------");
			System.out.println();
			opEdit = sc.nextLine().trim();
			if (!opEdit.trim().equals("1") && !opEdit.trim().equals("2")) {
				System.out.println("No se ingresó una opción válida. Intente nuevamente...");
				utilidad.tiempoDeEspera(2);
				utilidad.limpiezaDePantalla();
			}
		} while (!opEdit.trim().equals("1") && !opEdit.trim().equals("2"));
		
		// De haber ingresado una opción válida, entonces solicita el RUN
		System.out.println("Ingrese RUN del Cliente a editar: ");
		run = sc.nextLine().trim();
		
		// Busca el registro coincidente con el RUN ingresado
		int pos = -1, contador = 0;
		for (Cliente cli : clienteServicio.getListaClientes()) {
			if (cli.getRunCliente().equals(run)) {
				pos = contador;
			}
			contador++;
		}
		
		// Si existe coincidencia del RUN entonces
		// realiza operación correspondiente a la opción de edición ingresada
		if (pos >= 0) {
			Cliente cliEdit = clienteServicio.getListaClientes().get(pos);
			// Realiza una acción dependiendo de la opción ingresada
			if (opEdit.trim().equals("1")) {
				// En este caso, se buscará cambiar o mantener el estado del cliente
				System.out.println("-----Actualizando estado del Cliente----");
				// Verfica el estado del cliente
				if(String.valueOf(cliEdit.getEstado()).equalsIgnoreCase("activo")) {
					estado = "Activo"; 
					estadoInverso = "Inactivo";
				}else {
					estado = "Inactivo";
					estadoInverso = "Activo";
				}
				System.out.println("El estado actual es: " + estado);
				System.out.println("1.-Si desea cambiar el estado del Cliente a "+ estadoInverso);
				System.out.println("2.-Si desea mantener el estado del cliente "+ estado);
				System.out.println();
				System.out.println("Ingrese opción:");
				opEdit = sc.nextLine().trim();
				// Se ingresa 1, si el usuario prefiere cambiar el estado
				if (opEdit.equals("1")) {
					estado = estadoInverso;
				}else if(!opEdit.equals("1")&&!opEdit.equals("2")){
					System.out.println("La opción ingresada no es válida, por ende se mantendrá el estado.");
					invocEditClienteServicio = false;
				}
			} else {
				// En este caso, se quiere cambiar los datos ingresados en
				// un cliente, mediante la búsqueda por el RUN
				// Almacena datos del cliente
				run = cliEdit.getRunCliente();
				nombre = cliEdit.getNombreCliente();
				apellido = cliEdit.getApellidoCliente();
				anios = cliEdit.getAniosCliente();
				estado = String.valueOf(cliEdit.getEstado());
				// Presenta opciones de edicion de datos
				System.out.println("----Actualizando datos del Cliente-----");
				System.out.println("1.-El RUN del Cliente es: "+ run );
				System.out.println("2.-El Nombre del Cliente es: "+ nombre);
				System.out.println("3.-El Apellido del Cliente es: "+ apellido);
				System.out.println("4.-Los años como Cliente son: "+ anios);
				System.out.println();
				System.out.println("Ingrese una opción a editar de los datos del cliente:");
				opEdit = sc.nextLine().trim();
				// Valida la opción ingresada
				if(opEdit.equals("1")) {
					System.out.println("1.-Ingrese nuevo RUN del Cliente:");
					run = sc.nextLine().trim();
				}else if (opEdit.equals("2")) {
					System.out.println("2.-Ingrese nuevo Nombre del Cliente:");
					nombre = sc.nextLine().trim();
				}else if(opEdit.equals("3")) {
					System.out.println("3.-Ingrese nuevo Apellido del Cliente:");
					apellido = sc.nextLine().trim();
				}else if(opEdit.equals("4")) {
					System.out.println("4.-Ingrese nuevos años como Cliente:");
					anios = sc.nextLine().trim();
					if (anios.trim().equals("")) {
						anios = "0 años";
					}else if(!anios.trim().contains("año")) {
						try {
							if (Integer.parseInt(anios) == 1) {
								anios = anios + " año";
							} else if (Integer.parseInt(anios) > 1) {
								anios = anios + " años";
							} else {
								anios = "0 años";
							}
						} catch (NumberFormatException e) {
							anios = "0 años";
						}
					}
				}else {
					System.out.println("La opción ingresada no es válida, por ende se mantendrán los mismos datos.");
					invocEditClienteServicio = false;
				}
			}

			// Invoca metodo editarCliente de la Clase ClienteServicio, por lo siguiente:
			// 9.5.- Generar un public void del método editarCliente
			// y pasarle los parámetros de la clase Cliente.
			if (invocEditClienteServicio) {
				clienteServicio.editarCliente(run, nombre, apellido, anios, estado);
			}
		} else {
			System.out.println("No se ha encontrado el cliente con RUN: " + run);
		}
	}

	// 8.4.- cargarDatos, ejecuta la carga de datos del archivo “DBClientes.csv”.
	@Override
	public void importarDatos() {
		String rutaArchivo = "", opConfirmar = "";
		boolean invocCargarDatos = true;
		// Comprueba si existen clientes en la lista
		if (!clienteServicio.getListaClientes().isEmpty()) {
			// Si ya hay clientes en la lista, consulta al usuario
			System.out.println("Ya existen clientes en la lista.");
			System.out.println("¿Desea sobreescribir la lista con los datos a importar?");
			System.out.println("Ingrese 1 para confirmar:");
			opConfirmar = sc.nextLine().trim();
			if (!opConfirmar.equals("1")) {
				invocCargarDatos = false;
				System.out.println("Proceso importar datos cancelado por petición del usuario.");
			}
		}
		if (invocCargarDatos) {
			System.out.println("---------Cargar Datos en Windows---------------");
			System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
			rutaArchivo = sc.nextLine().trim();
			rutaArchivo = rutaArchivo + "\\" + fileName1;
			archivoServicio.cargarDatos(rutaArchivo);
		}
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
