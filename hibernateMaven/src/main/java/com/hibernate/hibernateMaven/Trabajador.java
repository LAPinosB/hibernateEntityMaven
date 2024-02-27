package com.hibernate.hibernateMaven;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Trabajador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE_TRABAJADOR")
	private String nombre;
	@Column(name = "EDAD_TRABAJADOR")
	private int edad;
	@Column(name = "DNI_TRABAJADOR")
	private String dni;
	@Column(name = "SCC_TRABAJADOR")
	private String sscc;
	@ManyToOne
    @JoinColumn(name = "tienda_id")
    private Tienda tienda;

	// Constructor Vacio
	public Trabajador() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getSscc() {
		return sscc;
	}

	public void setSscc(String sscc) {
		this.sscc = sscc;
	}
	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}


}
