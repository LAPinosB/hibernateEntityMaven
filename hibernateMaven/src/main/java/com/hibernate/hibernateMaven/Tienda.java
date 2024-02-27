package com.hibernate.hibernateMaven;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tienda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String calle;
	private String nombre;
	@Column(name = "NUMERO_COMPRADORES")
	private int numClientes;
	@OneToMany(mappedBy = "tienda")
	private List<Cliente> clientes;
	@OneToMany(mappedBy = "tienda")
	private List<Trabajador> trabajadores;
	
	public Tienda() {
		this.clientes = new ArrayList<Cliente>();
		this.trabajadores = new ArrayList<Trabajador>();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumClientes() {
		return numClientes;
	}
	public void setNumClientes(int numClientes) {
		this.numClientes = numClientes;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Trabajador> getTrabajadores() {
		return trabajadores;
	}
	public void setTrabajadores(List<Trabajador> trabajador) {
		this.trabajadores = trabajador;
	}
}
