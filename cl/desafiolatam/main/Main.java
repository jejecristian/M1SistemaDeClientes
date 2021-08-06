package cl.desafiolatam.main;

import cl.desafiolatam.vista.Menu;

public class Main {

	public static void main(String[] args) {
		/*
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
		*/
		Menu listadoMenu = new Menu();
		listadoMenu.iniciarMenu();

	}

}
