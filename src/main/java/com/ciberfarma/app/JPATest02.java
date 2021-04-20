package com.ciberfarma.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ciberfarma.model.Proveedor;

public class JPATest02 {
	
	static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Semana_01");
	// 2. crear el manejador de entidades
	static EntityManager em = fabrica.createEntityManager();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Proveedor p = new Proveedor();
		
		//p.setCodigo(0);
		p.setNombre("RaiderLegion");
		p.setTelefono("1234567890");
		p.setEmail("raiderLegion@gmail.com");
		
		// 3. empezar mi transacción
		em.getTransaction().begin();
		// proceso a realizar (persistencia)
		//em.persist(u);
		em.merge(p);
		// 4. confirmar la transacción
		em.getTransaction().commit();
	}

}
