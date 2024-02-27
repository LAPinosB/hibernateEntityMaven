package com.hibernate.hibernateMaven.DAO;

import com.hibernate.hibernateMaven.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
public class clienteDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public void save(Cliente cliente) {
		entityManager.persist(cliente);
	}

	public void delete(Cliente clienteId) {
		Cliente cliente = entityManager.find(Cliente.class, clienteId);
		if (cliente != null) {
			entityManager.remove(cliente);
		}
	}

	public void update(Cliente cliente) {
		if (cliente != null) {
			entityManager.merge(cliente);
		}
	}

	public Cliente findById(Long idCliente) {
		if (idCliente != null) {
			return entityManager.find(Cliente.class, idCliente);
		} else {
			return null; // Devolver null si idCliente es null
		}
	}
}
