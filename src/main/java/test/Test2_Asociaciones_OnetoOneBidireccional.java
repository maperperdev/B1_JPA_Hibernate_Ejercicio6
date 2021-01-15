package test;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidades.*;

public class Test2_Asociaciones_OnetoOneBidireccional {

	public static void main(String[] args) {
		/**
		 * Asociación bidireccional ONE to ONE sobre Empleado y PlazaParking:
			•  ambos lados de la relación deben estar anotados con @OneToOne, 
			 pero ahora uno de ellos debe indicar de manera explícita que la parte contraria
			  es dueña de la relación.
			•  mappedBy en la anotación de asociación de la parte no-dueña 
		 */
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persistencia");
				EntityManager emanager = emfactory.createEntityManager();
				
				Direccion d1= new Direccion (1l,"calle1","ciudad1","pais1",41001l);
				Direccion d2= new Direccion (2l,"calle2","ciudad2","pais2",41201l);
				PlazaParking p1=new PlazaParking("p100",1, 00);
				PlazaParking p2=new PlazaParking("p101",1, 01);
				Empleado e1 = new Empleado("e1","Luisa", "Jimenez", d1,p1);
				Empleado e2 = new Empleado("e2","Luis", "RUS", d2,p2);
			  			
				emanager.getTransaction().begin();
					emanager.persist(d1);
					emanager.persist(p1);
					emanager.persist(e1);
					//en el objeto tengo que relacionar el parking con el empleado con set
					p1.setEmpleado(e1);
					System.out.println("Empleado asignado a parking1 es (con un set): "+p1.getEmpleado());
				emanager.getTransaction().commit();	
				
				emanager.getTransaction().begin();
					emanager.persist(d2);
					emanager.persist(p2);
					emanager.persist(e2);
					
					p2.setEmpleado(e2);
					System.out.println("Empleado asignado a parking2 es (con un set): "+p2.getEmpleado());
				emanager.getTransaction().commit();
											
//				// consulta
				System.out.println("** Empleados en la BD:**");
				TypedQuery<Empleado> query = emanager.createQuery("Select e " + "from Empleado e ", Empleado.class);
				System.out.println(query.getResultList());
				
				
//				Empleado ide2=emanager.find(Empleado.class,"e2");
//				PlazaParking idp2=emanager.find(PlazaParking.class,"p100");
//				ide2.setPlaza(idp2);
//				idp2.setEmpleado(ide2);
//				System.out.println("E2 es: "+idp2.getEmpleado());
//
				emanager.close();
				emfactory.close();

	}

}
