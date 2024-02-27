package com.hibernate.hibernateMaven;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ClaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Si no usaramos los @Entity en las clases se usarian esto en el
		 * persistence.xml, dentro de <properties>: <!-- Mapeo de tus entidades -->
		 * <class>com.hibernate.hibernateMaven.Cliente</class>
		 * <class>com.hibernate.hibernateMaven.Tienda</class>
		 * <class>com.hibernate.hibernateMaven.Trabajador</class>
		 */
		/*try (EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("nombreUnidadPersistencia");
				EntityManager entityManager = entityManagerFactory.createEntityManager()) {*/
		try {
			// Crea el EntityManagerFactory utilizando la configuración definida en
			// persistence.xml
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("miUnidadPersistencia");

			// Crea un EntityManager a partir del EntityManagerFactory
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			/*
			DatosInicialesService datosInicialesService = new DatosInicialesService();
			datosInicialesService.setEntityManager(entityManager); // Configurar el EntityManager

			entityManager.getTransaction().begin();
			datosInicialesService.crearDatosIniciales();
			entityManager.getTransaction().commit();

			entityManager.close();
			entityManagerFactory.close();
*/
			//Con esto nos muestra los productos que ya existian en una tabla en sql y que no hemos generado nosotros (La sql esta dentro de Productos.Java).
			List<Productos> productosList = entityManager.createQuery("SELECT p FROM Productos p", Productos.class).getResultList();

	        for (Productos producto : productosList) {
	            System.out.println("ID: " + producto.getId());
	            System.out.println("Nombre: " + producto.getNombre());
	            System.out.println("Precio: " + producto.getPrecio());
	            System.out.println("Stock: " + producto.getStock());
	            System.out.println("---------------------------------------");
	        }

	        entityManager.close();
	        entityManagerFactory.close();
			/*
			 * // Realiza las operaciones que necesites utilizando el EntityManager // Por
			 * ejemplo, persistir un objeto en la base de datos
			 * entityManager.getTransaction().begin();
			 * 
			 * Tienda tienda = new Tienda(); // Inicializa los atributos de la tienda...
			 * 
			 * entityManager.persist(tienda);
			 * 
			 * entityManager.getTransaction().commit();
			 * 
			 * // Cierra el EntityManager y el EntityManagerFactory cuando ya no los
			 * necesites entityManager.close(); entityManagerFactory.close();
			 */
		} catch (Exception e) {
			System.out.println("Error en ClaseMain.java");
			e.printStackTrace();
		}
	}

}
