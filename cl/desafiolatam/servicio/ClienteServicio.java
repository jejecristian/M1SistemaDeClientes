package cl.desafiolatam.servicio;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.modelo.CategoriaEnum;
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
		this.listaClientes.stream().forEach((cliente) -> {
			System.out.println("-------------Datos del Cliente-------------");
			System.out.println();
			System.out.println("RUN del Cliente: " + cliente.getRunCliente());
			System.out.println("Nombre del Cliente: " + cliente.getNombreCliente());
			System.out.println("Apellido del Cliente: " + cliente.getApellidoCliente());
			System.out.println("Años como Cliente: " + cliente.getAniosCliente());
			String estado = "";
			if (cliente.getEstado().equals(CategoriaEnum.ACTIVO)) {
				estado = "Activo";
			}else {
				estado = "Inactivo";
			}
			System.out.println("Categoría del Cliente: " + estado);
			System.out.println();
			System.out.println("-------------------------------------------");
		});
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
	public void editarCliente(String run, String nombre, String apellido, String anios, String estado) {
		for (Cliente cli : listaClientes) {
			if (cli.getRunCliente().equals(run)) {
				cli.setRunCliente(run);
				cli.setNombreCliente(nombre);
				cli.setApellidoCliente(apellido);
				cli.setAniosCliente(anios);
				if (estado.equalsIgnoreCase("activo")) {
					cli.setEstado(CategoriaEnum.ACTIVO);	
				}else {
					cli.setEstado(CategoriaEnum.INACTIVO);
				}
				System.out.println("----------------------------------------");
				System.out.println("Datos cambiados con éxito");
			}
		}
	}

}
