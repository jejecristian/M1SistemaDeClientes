package cl.desafiolatam.modelo;

/*
4.- Crear la clase Cliente en package modelo, con los siguientes requisitos:
- String runCliente
- String nombreCliente
- String apellidoCliente
- String aniosCliente (se puede cambiar a int si lo desea)
- CategoriaEnum nombreCategoria
- Generar el constructor con parámetros
- Generar los getter y setter correspondientes
- Generar el toString para los parámetros
*/
public class Cliente {

	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String aniosCliente;
	private CategoriaEnum estado;

	public Cliente() {
		super();
	}

	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente) {
		super();
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.estado = CategoriaEnum.ACTIVO;
	}

	public String getRunCliente() {
		return runCliente;
	}

	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getAniosCliente() {
		return aniosCliente;
	}

	public void setAniosCliente(String aniosCliente) {
		this.aniosCliente = aniosCliente;
	}

	public CategoriaEnum getEstado() {
		return estado;
	}

	public void setEstado(CategoriaEnum estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [runCliente=");
		builder.append(runCliente);
		builder.append(", nombreCliente=");
		builder.append(nombreCliente);
		builder.append(", apellidoCliente=");
		builder.append(apellidoCliente);
		builder.append(", aniosCliente=");
		builder.append(aniosCliente);
		builder.append(", estado=");
		builder.append(estado);
		builder.append("]");
		return builder.toString();
	}

}
