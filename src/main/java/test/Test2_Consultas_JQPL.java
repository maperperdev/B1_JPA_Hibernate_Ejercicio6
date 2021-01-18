package test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import JPAControladorDao.DepartamentoFacadeImpl;
import JPAControladorDao.DireccionFacadeImpl;
import JPAControladorDao.EmpleadoFacadeImpl;
import JPAControladorDao.PlazaParkingFacadeImpl;
import JPAControladorDao.ProyectoFacadeImpl;
import entidades.Departamento;
import entidades.Direccion;
import entidades.Empleado;

public class Test2_Consultas_JQPL {
	public static void main(String[] args) {
		PlazaParkingFacadeImpl pf = new PlazaParkingFacadeImpl();
		DireccionFacadeImpl df = new DireccionFacadeImpl();
		EmpleadoFacadeImpl ef = new EmpleadoFacadeImpl();
		DepartamentoFacadeImpl dpf = new DepartamentoFacadeImpl();
		ProyectoFacadeImpl pyf = new ProyectoFacadeImpl();
		 
		/**
		 * Ejercicio 1: Crea un método con consulta JPQL y uso de createQuery que
		 * devuelva todos los empleados de la empresa
		 * 
		 * Ejecución de sentencia JQPL con createQuery en el método mostrarTodos
		 */
//		System.out.println("** Ejercicio1 CONSULTAS: MOSTRAR todos LOS EMPLEADOS");
//		System.out.println("****                                          ******");
//		List<Empleado> listaEmpleados = ef.mostrarTodos();
//		System.out.println(listaEmpleados);
//		
		
		/**
		 * Ejercicio 2: Crea un método que devuelva todos los proyectos del depto de código 1
		 * 
		 * Ejecución de sentencias JPQL (con createQuery) con parámetros dinánmicos
		 */
		
//		System.out.println("** Ejercicio2 CONSULTAS: MOSTRAR todos los proyed del depto 1");
//		System.out.println("****                                          ******");
//		System.out.println(pyf.buscarProyectosDeDepto(1));
//		
		
		/**
		 * Ejercicio 3
		 */
		
//		System.out.println("** Ejercicio3 CONSULTAS: MOSTRAR todos los empleado del depto1");
//		System.out.println("****                                          ******");
		//con notación punto
		
		//con consultas anidadas
		
//		System.out.println(pyf.buscarProyectosDeDepto_NotacionPunto("contabilidad"));
//		System.out.println(pyf.buscarProyectosDeDepto("contabilidad"));
//		System.out.println(pyf.buscar2ProyectosDeDepto("contabilidad"));
//		System.out.println(dpf.mostrarTodos().get(0).getEmpleados());
//		
//		
		
		/**
		 * Ejercicio 4 : Crea una consulta estática findAll que devuelva todos los empleados
		 * 
		 */
//		
//		TypedQuery query = ef.getEm().createNamedQuery(Empleado.BUSCAR_TODOS_EMPLEADOS, Empleado.class);
//		System.out.println(query.getFirstResult());
//		
		TypedQuery<Empleado> query1 = ef.getEm().createNamedQuery("Empleado.findAll", Empleado.class);
		System.out.println(query1.getFirstResult());
		
		
		/**
		 * Ejercicio 5: En una entidad se puede especidicar varias consultas estáticas.
		 * Crea varias consultas estáticas en Departamento
		 */
		
		TypedQuery<Departamento> query2 = ef.getEm().createNamedQuery(Departamento.ORDENAR_DESC_NOMBRE,
				Departamento.class);
		//mejor usar la primera
		//Query query2 = ef.getEm().createNamedQuery(Departamento.ORDENAR_DESC_NOMBRE);
		System.out.println(query2.getFirstResult());
		Query query3 = ef.getEm().createNamedQuery(Departamento.BUSCAR_CODDEPT);
		query3.setParameter("cod", 1);
		System.out.println(query3.getFirstResult());
		
		
		/** 
		 * Ejercicio 6:
		 * Crea una consulta nativa de SQL que devuelva todas las direcciones
		 * 
		 */
//		
//		Query query4 = df.getEm().createNativeQuery("SELECT * FROM DIRECCION", Direccion.class);
//		System.out.println(query4.getResultList());

		
		/**
		 * Ejercicio 7
		 * Crea una consulta nativa de SQL que devuelva el NOMBRE Y APELLIDOS DE todos los empleados
		 * 
		 */
		
		Query q = ef.getEm().createNativeQuery("SELECT nombre, apellidos FROM EMPLEADO WHERE CODDEPTO_FK = :dep");
		q.setParameter("dep", 1);
		
		//List de array de object
		
		@SuppressWarnings("unchecked")
		List<Object[]> emples2 = q.getResultList();
		
		for (Object[] a : emples2) {
			System.out.println("Empleado " + a[0] + " " + a[1]);
		}
		
		/**
		 * Ejercicio 8 
		 * Crea una consulta nativa de SQL que devuelva
		 */
		
		
		/**
		 * Ejercicio 10: Consulta en JPQL que devuelva el código más alto de empleado
		 * usado y el mínimo
		 * 
		 */
		
		Query q2 = df.getEm().createQuery("SELECT MAX(p.codEmpleado) FROM Empleado as p");
		Object result = q2.getSingleResult();
		System.out.println("El mayor código de empleado es: " + result);

		Query qn = df.getEm().createQuery("SELECT MIN(p.codEmpleado) FROM Empleado as p");
		Object result2 = qn.getSingleResult();
		System.out.println("El menor código de empleado es: " + result2);
	}
}
