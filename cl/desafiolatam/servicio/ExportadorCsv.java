package cl.desafiolatam.servicio;

import java.util.List;

import cl.desafiolatam.modelo.Cliente;

public class ExportadorCsv extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaCliente) {
		for (Cliente cli : listaCliente) {
			// Recordar que archivos CSV van separados por coma
			System.out.println(cli.getNombreCliente() + ", " + cli.getApellidoCliente() + ", " 
			+ cli.getRunCliente() + ", " + cli.getAniosCliente()+", "+cli.getEstado());
		}

	}

}
