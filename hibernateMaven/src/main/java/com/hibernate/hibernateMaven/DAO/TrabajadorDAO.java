package com.hibernate.hibernateMaven.DAO;

import com.hibernate.hibernateMaven.Trabajador;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
public class TrabajadorDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Trabajador trabajador) {
		entityManager.persist(trabajador);
	}

	public void delete(Trabajador trabajadorId) {
			Trabajador trabajador = entityManager.find(Trabajador.class, trabajadorId);
	        if (trabajador != null) {
	            entityManager.remove(trabajador);
	        }
	}
}
