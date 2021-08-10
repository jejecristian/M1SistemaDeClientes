package cl.desafiolatam.utilidades;

// 14.- Crear una clase Utilidad en package utilidades, 
// que contenga métodos reutilizables para el menú como 
// limpiar pantalla, mostrar mensajes, etc.
public class Utilidad {
	
	// Metodo que simula una limpieza de pantalla
	public void limpiezaDePantalla() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("");
		}
	}

	// Metodo que permite simular un tiempo de espera
	public void tiempoDeEspera(int tiempo) {
		try {
			Thread.sleep(tiempo*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
