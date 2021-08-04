package cl.desafiolatam.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cl.desafiolatam.modelo.CategoriaEnum;
import cl.desafiolatam.modelo.Cliente;
import cl.desafiolatam.vista.Menu;

public class Main {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente();
		cliente1.setNombreCliente("Juan Carlos");
		cliente1.setApellidoCliente("Bodoque");
		cliente1.setRunCliente("1-7");
		cliente1.setAniosCliente("42");
		cliente1.setEstado(CategoriaEnum.INACTIVO);
		System.out.println("Cliente 1 es: \n"+cliente1.toString());
		
		Cliente cliente2 = new Cliente("1-7", "Alexis", "Sanchez", "34");
		System.out.println("Cliente 2 es: \n"+cliente2.toString());
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		Scanner sca = new Scanner(System.in);
		
		Menu listadoMenu = new Menu(listaClientes, sca);
		String opcion = "";
		do {
			System.out.println("Ingrese una opción: ");
			opcion = sca.nextLine();
			switch (opcion) {
				case "1":
					listadoMenu.listarClientes();
					break;
				case "2":
					listadoMenu.agregarCliente();
					break;
				case "3":
					listadoMenu.editarCliente();
					break;
				case "4":
					listadoMenu.importarDatos();
					break;
				case "5":
					listadoMenu.exportarDatos();
					break;
				case "6":
					System.out.println("Hasta pronto...");
					break;
			}

		} while (!opcion.equals("6"));

		sca.close();

	}

}
