package cl.desafiolatam.main;

import cl.desafiolatam.vista.Menu;

// 5.- Crear la clase Main con m�todo public static void en el package main, 
// la cual usar� una instancia para iniciar el men�.
public class Main {

	public static void main(String[] args) {
		// Se crea instancia de men�
		Menu listadoMenu = new Menu();
		// Crear la clase Main que contenga m�todo main para 
		// iniciar el programa. Debe iniciar con el men�.
		// Invoca metodo que presenta el men�
		listadoMenu.iniciarMenu();
	}
}
