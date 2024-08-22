package com.mx.Pizzas;

public class Pizzas {
	// Propiedades
	private String ingrediente;
	private String tamanio;
	private int precio;

	// Getters y Setters
	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	// ToString
	@Override
	public String toString() {
		return "Pizzas [\n" + "ingrediente=" + ingrediente + ", tamanio=" + tamanio + ", precio=" + precio + "]\n";
	}

	// Constructores
	public Pizzas() {

	}

	public Pizzas(String ingrediente, String tamanio, int precio) {
		
		this.ingrediente = ingrediente;
		this.tamanio = tamanio;
		this.precio = precio;
	}

}
