package test;

import java.util.List;

import JPAControladorDao.DepartamentoFacadeImpl;
import JPAControladorDao.DireccionFacadeImpl;
import JPAControladorDao.EmpleadoFacadeImpl;
import JPAControladorDao.PlazaParkingFacadeImpl;
import JPAControladorDao.ProyectoFacadeImpl;
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
		System.out.println("** Ejercicio1 CONSULTAS: MOSTRAR todos LOS EMPLEADOS");
		System.out.println("****                                          ******");
		List<Empleado> listaEmpleados = ef.mostrarTodos();
		System.out.println(listaEmpleados);
		
		
		/**
		 * Ejercicio 2: Crea un método que devuelva todos los proyectos del depto de código 1
		 * 
		 * Ejecución de sentencias JPQL (con createQuery) con parámetros dinánmicos
		 */
		
		System.out.println("** Ejercicio1 CONSULTAS: MOSTRAR todos los proyed del depto 1");
		System.out.println("****                                          ******");
		System.out.println(pyf.buscarProyectoDeDepto(1));
		
		
	}
}
