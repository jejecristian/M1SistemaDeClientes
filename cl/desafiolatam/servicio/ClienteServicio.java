package cl.desafiolatam.servicio;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.modelo.Cliente;

public class ClienteServicio {
	List<Cliente> listaClientes = new ArrayList<Cliente>();

	public ClienteServicio() {
		super();
	}

	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClienteServicio [listaClientes=");
		builder.append(listaClientes);
		builder.append("]");
		return builder.toString();
	}

	// 9.3.- Generar el método público sin valor de retorno listarClientes e
	// implementar el ciclo más idóneo para recorrer cada uno de los clientes.
	public void listarClientes() {
		for (Cliente cli : listaClientes) {
			System.out.println("-------------Datos del Cliente-------------");
			System.out.println();
			System.out.println("RUN del Cliente: " + cli.getRunCliente());
			System.out.println("Nombre del Cliente: " + cli.getNombreCliente());
			System.out.println("Apellido del Cliente: " + cli.getApellidoCliente());
			System.out.println("Años como Cliente: " + cli.getAniosCliente());
			System.out.println("Categoría del Cliente: " + cli.getEstado());
			System.out.println();
			System.out.println("-------------------------------------------");
		}
	}

	// 9.4.- Generar un public void del método agregarCliente y pasarle
	// los parámetros de la clase Cliente.
	// Utiliza este método para guardar clientes en una instancia de cliente.
	public void agregarCliente(String run, String nombre, String apellido, String anios) {
		Cliente nuevoCliente = new Cliente(run, nombre, apellido, anios);
		listaClientes.add(nuevoCliente);
		System.out.println("\nEl cliente ha sido agregado exitosamente.");
	}

	// 9.5.- Generar un public void del método editarCliente
	// y pasarle los parámetros de la clase Cliente.
	public void editarCliente(String run, String nombre, String apellido, String anios) {
		for (Cliente cli : listaClientes) {
			if (cli.getRunCliente().equals(run)) {
				
			}
		}
	}

}
