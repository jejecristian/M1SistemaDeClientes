package cl.desafiolatam.main;

import cl.desafiolatam.vista.Menu;

// 5.- Crear la clase Main con método public static void en el package main, 
// la cual usará una instancia para iniciar el menú.
public class Main {

	public static void main(String[] args) {
		// Se crea instancia de menú
		Menu listadoMenu = new Menu();
		// Crear la clase Main que contenga método main para 
		// iniciar el programa. Debe iniciar con el menú.
		// Invoca metodo que presenta el menú
		listadoMenu.iniciarMenu();
	}
}
