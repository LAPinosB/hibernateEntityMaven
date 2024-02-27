package com.hibernate.hibernateMaven;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * ESTA CLASE, SE INSTACIA DE LA BASE DE DATOS DE LA TABLA con esto ya puedes crear el dao y hacer actualizaciones
 * -- Crear la tabla de productos en la base de datos basepruebanueva
CREATE TABLE basepruebanueva.Productos (
    ID INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Precio DECIMAL(10, 2),
    Stock INT
);

-- Insertar algunos valores de ejemplo en la tabla Productos
INSERT INTO basepruebanueva.Productos (ID, Nombre, Precio, Stock) VALUES
(1, 'Camiseta', 19.99, 100),
(2, 'Pantalón', 29.99, 80),
(3, 'Zapatos', 49.99, 50),
(4, 'Sombrero', 9.99, 120),
(5, 'Calcetines', 4.99, 200);
 * */

@Entity
@Table(name = "productos")
public class Productos {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Precio")
    private double precio;

    @Column(name = "Stock")
    private int stock;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
