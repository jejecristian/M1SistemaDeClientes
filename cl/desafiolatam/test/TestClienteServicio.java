package cl.desafiolatam.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import cl.desafiolatam.modelo.Cliente;
import cl.desafiolatam.servicio.ClienteServicio;

// 15.- Añadir dependencias para pruebas Unitarias, 
// ver ejemplo en apartado Anexos al final del documento.

/*
16.- Escribir pruebas unitarias para ClienteServicio.
- Método agrearClienteTest para verificar el funcionamiento de agregarCliente
(se debe agregar un cliente para que el test corra de manera correcta).
- Método agrearClienteNullTest para verificar el funcionamiento de
agregarCliente en caso que vengan casos nulos (se debe agregar un cliente
nulo para que el test corra de manera correcta).
*/
//@DisplayName("Prueba de clase ClienteServicio")
public class TestClienteServicio {

	// 16.1.-  Método agrearClienteTest para verificar el 
	// funcionamiento de agregarCliente (se debe agregar un cliente 
	// para que el test corra de manera correcta).
	@Test
	public void agregarClienteTest() {
		System.out.println("Test agregarClienteTest():");
		Cliente clientePrueba = new Cliente("18.248.335-3", "Arturo", "Vidal", "1");
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		listaCliente.add(clientePrueba);
		ClienteServicio clienteServicio = new ClienteServicio(listaCliente);
		clienteServicio.agregarCliente("18.248.335-3", "Arturo", "Vidal", "1");
		Assert.assertEquals(listaCliente, clienteServicio.getListaClientes());
		System.out.println();
	}
	
	// 16.2.- Método agrearClienteNullTest para verificar el funcionamiento de
	// agregarCliente en caso que vengan casos nulos (se debe agregar 
	// un cliente nulo para que el test corra de manera correcta).
	@Test
	public void agrearClienteNullTest() {
		System.out.println("Test agrearClienteNullTest():");
		Cliente clientePrueba = new Cliente(null, null, null, null);
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		listaCliente.add(clientePrueba);
		ClienteServicio clienteServicio = new ClienteServicio(listaCliente);
		assertNull(clientePrueba.getRunCliente());
		assertNull(clientePrueba.getNombreCliente());
		assertNull(clientePrueba.getApellidoCliente());
		assertNull(clientePrueba.getAniosCliente());
		clienteServicio.agregarCliente(null, null, null, null);
		Assert.assertEquals(listaCliente, clienteServicio.getListaClientes());
		System.out.println();
	}

}
