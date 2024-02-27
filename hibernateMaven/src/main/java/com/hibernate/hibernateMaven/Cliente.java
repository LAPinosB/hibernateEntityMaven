package com.hibernate.hibernateMaven;

import com.hibernate.hibernateMaven.DAO.clienteDAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE_CLIENTE")
	private String nombre;
	@Column(name = "EDAD_CLIENTE")
	private int edad;
	@Column(name = "DNI_CLIENTE")
	private String dni;
	@Column(name = "TELEFONO_CLIENTE")
	private Long telefono;
	@Column(name = "ES_CLIENTE")
	private Boolean cliente;
	@ManyToOne
	@JoinColumn(name = "tienda_id")
	private Tienda tienda;
	@Transient
	private clienteDAO dao = new clienteDAO();
	/*
	 * @Transient: Esta anotación se utiliza para indicar que un campo de tu clase
	 * no debe ser mapeado a una columna en la base de datos. Es útil para campos
	 * que no son persistentes. Una maravisha
	 * 
	 * @Temporal: Se utiliza para mapear campos de tipo Date o Calendar a columnas
	 * de tipo temporal en la base de datos.
	 * 
	 * @ManyToOne, @OneToMany, @OneToOne, @ManyToMany: Estas anotaciones se utilizan
	 * para mapear relaciones entre entidades en la base de datos.
	 */
	@Transient
	private String sexo;

	// Constructor Vacio
	public Cliente() {
	}

	// Metodos
	// Metodo para buscar un cliente por su ID
	public void buscarCliente(Long idCliente) {
		// Llamada al método findById para buscar el cliente por su ID
		Cliente cliente = dao.findById(idCliente);

		// Verificar si se encontró el cliente
		if (cliente != null) {
			// Mostrar los datos del cliente
			System.out.println("Cliente encontrado:");
			System.out.println("ID: " + cliente.getId());
			System.out.println("Nombre: " + cliente.getNombre());
			System.out.println("Edad: " + cliente.getEdad());
			// Aquí puedes mostrar los demás campos del cliente si es necesario
		} else {
			// Si el cliente no se encuentra, mostrar un mensaje indicando que no se
			// encontró
			System.out.println("Cliente no encontrado con ID: " + idCliente);
		}
	}
	
	public void actualizarCliente(Long idCliente, String nuevoNombre, int nuevaEdad, String nuevoDni, Long nuevoTelefono) {
	    // Llamada al método findById para buscar el cliente por su ID
	    Cliente cliente = dao.findById(idCliente);

	    // Verificar si se encontró el cliente
	    if (cliente != null) {
	        // Actualizar los datos del cliente
	        cliente.setNombre(nuevoNombre);
	        cliente.setEdad(nuevaEdad);
	        cliente.setDni(nuevoDni);
	        cliente.setTelefono(nuevoTelefono);

	        // Guardar los cambios en la base de datos
	        dao.update(cliente);
	        System.out.println("Cliente actualizado correctamente.");
	    } else {
	        // Si el cliente no se encuentra, mostrar un mensaje indicando que no se encontró
	        System.out.println("Cliente no encontrado con ID: " + idCliente + ". No se pudo actualizar.");
	    }
	}

	// GETTER AND SETTERS
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

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public Boolean getCliente() {
		return cliente;
	}

	public void setCliente(Boolean cliente) {
		this.cliente = cliente;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public clienteDAO getDao() {
		return dao;
	}

	public void setDao(clienteDAO dao) {
		this.dao = dao;
	}
}
