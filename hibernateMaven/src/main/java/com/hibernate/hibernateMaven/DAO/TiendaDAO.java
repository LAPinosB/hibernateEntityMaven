package com.hibernate.hibernateMaven.DAO;

import com.hibernate.hibernateMaven.Tienda;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
public class TiendaDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Tienda tienda) {
		entityManager.persist(tienda);
	}
	
	public void delete(Tienda tiendaId) {
		Tienda tienda = entityManager.find(Tienda.class, tiendaId);
        if (tienda != null) {
            entityManager.remove(tienda);
        }
    }

}
