package cl.desafiolatam.servicio;

import java.util.List;

import cl.desafiolatam.modelo.Cliente;

public abstract class Exportador {

	// metodo abstracto para exportar
	abstract void exportar(String fileName, List<Cliente> listaCliente);

}
