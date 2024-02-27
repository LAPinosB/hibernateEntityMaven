package com.hibernate.hibernateMaven.Service;

import com.hibernate.hibernateMaven.Cliente;
import com.hibernate.hibernateMaven.Tienda;
import com.hibernate.hibernateMaven.Trabajador;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
public class DatosInicialesService {

    @PersistenceContext
    private EntityManager entityManager;
    
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void crearDatosIniciales() {
    	
    	// Crear tienda
        Tienda tienda = new Tienda();
        tienda.setCalle("Calle Principal");
        tienda.setNombre("Mi Tienda");
        
        entityManager.persist(tienda);
        
        // Crear clientes
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juan");
        cliente1.setEdad(30);
        cliente1.setDni("12345678A");
        cliente1.setTelefono(123456789L);
        cliente1.setCliente(true);
        cliente1.setTienda(tienda);

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("María");
        cliente2.setEdad(25);
        cliente2.setDni("87654321B");
        cliente2.setTelefono(987654321L);
        cliente2.setCliente(true);
        cliente2.setTienda(tienda);

        entityManager.persist(cliente1);
        entityManager.persist(cliente2);

        // Crear trabajadores
        Trabajador trabajador1 = new Trabajador();
        trabajador1.setNombre("Pedro");
        trabajador1.setEdad(35);
        trabajador1.setDni("11111111X");
        trabajador1.setSscc("SSCC1111");
        trabajador1.setTienda(tienda); 

        Trabajador trabajador2 = new Trabajador();
        trabajador2.setNombre("Ana");
        trabajador2.setEdad(28);
        trabajador2.setDni("22222222Y");
        trabajador2.setSscc("SSCC2222");
        trabajador2.setTienda(tienda);

        entityManager.persist(trabajador1);
        entityManager.persist(trabajador2);

        // Asociar clientes a la tienda
        tienda.getClientes().add(cliente1);
        tienda.getClientes().add(cliente2);

        // Asociar trabajadores a la tienda
        tienda.getTrabajadores().add(trabajador1);
        tienda.getTrabajadores().add(trabajador2);


    }
}
