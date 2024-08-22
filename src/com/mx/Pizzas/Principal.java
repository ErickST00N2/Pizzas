package com.mx.Pizzas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mx.Pizzas.Pizzas;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Pizzería");

		// Inicializamos los objetos
		Pizzas pizza1 = new Pizzas("Pepperoni", "Grande", 180);
		Pizzas pizza2 = new Pizzas("Pepperoni", "Chica", 120);
		Pizzas pizza3 = new Pizzas("Pepperoni", "Mediana", 100);

		Pizzas pizza4 = new Pizzas("Hawaiana", "Grande", 200);
		Pizzas pizza5 = new Pizzas("Hawaiana", "Mediana", 170);
		Pizzas pizza6 = new Pizzas("Hawaiana", "Chica", 140);

		Pizzas pizza7 = new Pizzas("Mexicana", "Grande", 180);
		Pizzas pizza8 = new Pizzas("Mexicana", "Mediana", 120);
		Pizzas pizza9 = new Pizzas("Mexicana", "Chica", 100);

		// Objeto auxiliar
		Pizzas pizza = null;
		System.out.println();

		// Crear Lista de pizzas
		List<Pizzas> pizzas = new ArrayList<>();

		// Añadimos a la lista las pizzas
		pizzas.add(pizza1);
		pizzas.add(pizza2);
		pizzas.add(pizza3);
		pizzas.add(pizza4);
		pizzas.add(pizza5);
		pizzas.add(pizza6);
		pizzas.add(pizza7);
		pizzas.add(pizza8);
		pizzas.add(pizza9);

		// Imprimir los datos de las pizzas
		System.out.println("Los datos de la lista son: \n " + pizzas);
		System.out.println();

		// Variables para el menú
		Scanner scan = new Scanner(System.in);
		int menuP = 0, menuS = 0, indice = 0;
		String ingrediente, tamanio;
		int precio;
		String search;

		do {
			// Menú
			System.out.println("-------------MENU--------------");
			System.out.println("1. Agregar nuevo Registro");
			System.out.println("2. Mostrar lista");
			System.out.println("3. Editar");
			System.out.println("4. Buscar un elemento por atributo");
			System.out.println("5. Eliminar elemento");
			System.out.println("6. Contar todos los elementos de la lista");
			System.out.println("7. Salir del menu");
			System.out.println("Elige una opcion");
			menuP = scan.nextInt();

			switch (menuP) {
			case 1:
				// Agregar un nuevo registro
				System.out.println("1. Agregar nuevo Registro");

				System.out.println("Escribe el ingrediente de la pizza: ");
				scan = new Scanner(System.in);
				ingrediente = scan.nextLine();

				System.out.println("Escribe el tamaño de la pizza: ");
				scan = new Scanner(System.in);
				tamanio = scan.nextLine();

				System.out.println("Escribe el precio de la pizza: ");
				scan = new Scanner(System.in);
				precio = scan.nextInt();

				pizza = new Pizzas(ingrediente, tamanio, precio);

				// Verificamos si la pizza ya existe
				boolean existe = false;
				for (Pizzas p : pizzas) {
					if (p.getIngrediente().equalsIgnoreCase(ingrediente) && p.getTamanio().equalsIgnoreCase(tamanio)
							&& p.getPrecio() == precio) {
						existe = true;
						break;
					}
				}

				if (existe) {
					System.out.println("La pizza ya existe en la lista.");
				} else {
					// Agregamos a la lista
					pizzas.add(pizza);
					System.out.println("El registro de la pizza fue exitoso");
				}
				break;

			case 2:
				// Mostrar la lista
				System.out.println("2. Mostrar lista");
				System.out.println("La lista es: " + pizzas);
				break;

			case 3:
				// Editar un elemento en la lista
				System.out.println("3. Editar elemento");

				// Pedimos la posición del elemento a editar
				System.out.println("Escribe el índice a editar \nNOTA: EL ÍNDICE MÁXIMO QUE EXISTE POR AHORA ES: "
						+ (pizzas.size() - 1));
				scan = new Scanner(System.in);
				indice = scan.nextInt();

				if (indice < 0 || indice >= pizzas.size()) {
					System.out.println("Índice inválido.");
					break;
				}

				pizza = pizzas.get(indice);

				// Menú secundario para editar
				do {
					System.out.println("¿Qué valor actualizarás?");
					System.out.println("1. Editar ingrediente de la pizza");
					System.out.println("2. Editar tamaño de la pizza");
					System.out.println("3. Editar precio de la pizza");
					System.out.println("4. Salir");
					scan = new Scanner(System.in);
					menuS = scan.nextInt();

					switch (menuS) {
					case 1:
						System.out.println("1. Editar ingrediente de la pizza");
						System.out.println("Escribe el nuevo ingrediente: ");
						scan = new Scanner(System.in);
						ingrediente = scan.nextLine();
						pizza.setIngrediente(ingrediente);
						break;

					case 2:
						System.out.println("2. Editar tamaño de la pizza");
						System.out.println("Escribe el nuevo tamaño: ");
						scan = new Scanner(System.in);

						tamanio = scan.nextLine();
						pizza.setTamanio(tamanio);
						break;

					case 3:
						System.out.println("3. Editar precio de la pizza");
						System.out.println("Escribe el nuevo precio: ");
						scan = new Scanner(System.in);

						precio = scan.nextInt();
						pizza.setPrecio(precio);
						break;

					case 4:
						System.out.println("Hasta pronto!");
						break;
					}

				} while (menuS != 4);

				// Actualizamos la pizza en la lista
				pizzas.set(indice, pizza);
				System.out.println("Los datos actualizados son: \n " + pizzas);
				break;

			case 4:
				System.out.println("4. Buscar un elemento por atributo");

				System.out.println("¿Qué atributo deseas buscar?");
				System.out.println("1. Buscar por ingrediente");
				System.out.println("2. Buscar por tamaño");
				System.out.println("3. Buscar por precio");
				scan = new Scanner(System.in);

				menuS = scan.nextInt();

				switch (menuS) {
				case 1:
					System.out.println("Dame el ingrediente");
					scan = new Scanner(System.in);

					
					search = scan.nextLine();
					for (Pizzas pizzaAux : pizzas) {
						if (pizzaAux.getIngrediente().contains(search)) {
							System.out.println(pizzaAux);
						}
					}
					break;

				case 2:
					System.out.println("Dame el tamaño");
					scan = new Scanner(System.in);

					
					search = scan.nextLine();
					for (Pizzas pizzaAux : pizzas) {
						if (pizzaAux.getTamanio().contains(search)) {
							System.out.println(pizzaAux);
						}
					}
					break;

				case 3:
					System.out.println("Dame el precio");
					
					scan = new Scanner(System.in);
					int search2 = scan.nextInt();
					
					for (Pizzas pizzaAux : pizzas) {
						if (pizzaAux.getPrecio() == search2) {
							System.out.println(pizzaAux);
						}
					}
					break;
				}
				break;

			case 5:
				System.out.println("5. Eliminar un elemento");

				System.out.println("Escribe el índice a eliminar \nNOTA: EL ÍNDICE MÁXIMO QUE EXISTE POR AHORA ES: "
						+ (pizzas.size() - 1));
				scan = new Scanner(System.in);

				indice = scan.nextInt();
				if (indice < 0 || indice >= pizzas.size()) {
					System.out.println("Índice inválido. No se puede eliminar.");
					break;
				}

				pizza = pizzas.remove(indice);
				System.out.println("Elemento eliminado: \n" + pizza);
				break;

			case 6:
				System.out.println("6. Contar todos los elementos de la lista");
				System.out.println("El tamaño de la lista es: " + pizzas.size());
				break;

			case 7:
				System.out.println("Hasta pronto!");
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + menuP);
			}
		} while (menuP != 7);

		scan.close();
	}
}
