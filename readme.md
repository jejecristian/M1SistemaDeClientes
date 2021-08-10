echo #Proyecto Sistema de Clientes
Repositorio Git:
https://github.com/jejecristian/M1SistemaDeClientes.git

Nombre Alumno: 
Cristian Torres

Descripción:
Este proyecto contiene el desarrollo en Java del examen final del módulo 1.

Supuestos:
A continuación se indican casos supuestos que fueron implementados en el proyecto.

I.-
Se crea interface con metodos que son implementados por la clase Menu.
La interface es el siguiente:
public interface AccionesMenu {
	
	void listarClientes();

	void agregarCliente();

	void editarCliente();

	void importarDatos();

	void exportarDatos();

	void terminarPrograma();

}

II.-
El metodo exportar de la Clase ArchivoServicio, se ingresan solamente comentarios, 
ya que el enunciado no determina que se deba utilizar este médoto.
Es decir, que jamás será invocado.
El metodo es el siguiente:
@Override
void exportar(String fileName, List<Cliente> listaCliente) {
	//...
}

III.-
Se crea metodo auxiliar que permite guardar datos en un archivo previamente creado.
Esto para el uso de la exportación, tanto en ExportarCsv como en ExportarTxt.
Internamente la manera de exportar los datos cambia respecto si es en formato csv o txt.
El metodo es el siguiente:
public void llenarArchivo(String carpeta, String fileName, List<Cliente> listaCliente) {
	//...
}

IV.-
Se crean dos pruebas unitarias:
Una para validar que el metodo agregarCliente de la Clase ClienteServicio,
efectivamente permita guardar una lista de clientes, y esta se compara con
el caso de prueba expuesto en el test.
El metodo es el siguiente:
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

Otra prueba que permite validar que el metodo agregarCliente de la 
Clase ClienteServicio, permita guardar una lista de clientes, donde
al menos un cliente posee valores nulos, evaluando cada atributo, y luego
se compara la lista obtenida contra el caso de prueba expuesto en el test.
El metodo es el siguiente:
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