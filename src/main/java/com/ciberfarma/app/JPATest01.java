package com.ciberfarma.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.ciberfarma.model.Usuario;

public class JPATest01 {

	// grabar el objeto
	// 1. fabricar el acceso a los datos
	static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Semana_01");
	// 2. crear el manejador de entidades
	static EntityManager em = fabrica.createEntityManager();
	
	public static void main(String[] args) {
		// Crear un objeto de Usuario a grabar
				Usuario u = new Usuario();
				u.setCodigo(4);
				u.setNombre("Eren");
				u.setApellido("Lopez");
				u.setUsuario("usuario3@ciber.com");
				u.setClave("123");
				u.setFnacim("2000/10/15");
				u.setTipo(1);
				u.setEstado(1);
				

				
				// 3. empezar mi transacción
				em.getTransaction().begin();
				// proceso a realizar (persistencia)
				//em.persist(u);
				em.merge(u);
				// 4. confirmar la transacción
				em.getTransaction().commit();
	}

		
}
