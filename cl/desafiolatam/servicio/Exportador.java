package cl.desafiolatam.servicio;

import java.util.List;

import cl.desafiolatam.modelo.Cliente;

/*
10. Crear una clase abstracta de nombre Exportador en package Servicio, que contenga
un m�todo abstracto para exportar, cuyos par�metros ser�n String fileName y
List<Cliente> listaClientes.
*/
public abstract class Exportador {

	// metodo abstracto para exportar
	abstract void exportar(String fileName, List<Cliente> listaCliente);

}
