package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Direccion;
import entidades.Empleado;

public class Test1_OneToOne {

	 public static void main(String[] arg) {
		 try {
			 EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persistencia");
			 EntityManager emanager = emfactory.createEntityManager();
			 
			 Direccion d1 = new Direccion(1l, "calle1", "ciudad1", "pais1", 41001l);
			 Empleado e1 = new Empleado("e1", "Luisa", "Jimenez", d1);
			 
			 Direccion d2 = new Direccion(2l, "calle2", "ciudad2", "pais2", 41201l);
			 Empleado e2 = new Empleado("e2", "Luis", "RUS", d2);
			 
			 //Si se asocia una misma dirección a otro empleado fallaría al crear la base de datos
			 //por tener una relación 1 a 1 porque empleados diferentes no pueden tener la misma
			 //dirección por diseño.
			 
			 emanager.getTransaction().begin();
			 emanager.persist(d1);
			 emanager.persist(e1);
			 emanager.persist(d2);
			 emanager.persist(e2);
			 emanager.getTransaction().commit();
			 emanager.close();
			 emfactory.close();
		 } catch (Exception e) {
			 System.out.println("**Ha ocurrido un error al crear la BS**");
		 }
	 }
	
}