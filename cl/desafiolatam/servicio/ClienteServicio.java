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
	
	
	
}
