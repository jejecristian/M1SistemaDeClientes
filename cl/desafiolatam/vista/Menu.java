package cl.desafiolatam.vista;

import java.util.List;
import java.util.Scanner;

import cl.desafiolatam.modelo.Cliente;
//import cl.desafiolatam.servicio.ClienteServicio;

public class Menu implements AccionesMenu{
	List<Cliente> listaCliente;
	Scanner sca;
	
	public Menu(List<Cliente> listaCliente, Scanner sca) {
		super();
		this.listaCliente = listaCliente;
		this.sca = sca;
	}

	//private ClienteServicio clienteServicio = new ClienteServicio();

	@Override
	public void listarClientes() {
		System.out.println("Sección para listar Clientes");
		for (Cliente cli : this.listaCliente) {
			System.out.println(cli.toString());
		}
		
	}

	@Override
	public void agregarCliente() {
		System.out.println("Seccion Agregar Cliente");
		System.out.println("Ingrese nombre del cliente:");
		String nombre = sca.nextLine().trim();
		System.out.println("Ingrese apellido del cliente:");
		String apellido = sca.nextLine().trim();
		System.out.println("Ingrese run del cliente:");
		String run = sca.nextLine().trim();
		System.out.println("Ingrese años del cliente:");
		String anios = sca.nextLine().trim();
		
		Cliente cliente = new Cliente(run, nombre, apellido, anios);
		listaCliente.add(cliente);
		System.out.println("El cliente ha sido agregado exitosamente.");
	}

	@Override
	public void editarCliente() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
}
