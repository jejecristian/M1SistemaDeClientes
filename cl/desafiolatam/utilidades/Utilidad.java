package cl.desafiolatam.utilidades;

public class Utilidad {
	
	public void limpiezaDePantalla() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("");
		}
	}

	public void tiempoDeEspera(int tiempo) {
		try {
			Thread.sleep(tiempo*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
