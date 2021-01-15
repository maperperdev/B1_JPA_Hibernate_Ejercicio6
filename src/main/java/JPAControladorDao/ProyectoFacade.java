package JPAControladorDao;

import java.util.List;


import entidades.Proyecto;

public interface ProyectoFacade extends AbstractFacadeJPA<Proyecto>{
	 public List<Proyecto> mostrarTodos();
	 public List<Proyecto> buscarProyectoDeDepto(int dep);
	 public List<Proyecto> buscarProyectosDeDepto(String nombreDept);
	 public List<Proyecto> buscar2ProyectosDeDepto(String nombreDept);
	 public List<Proyecto> buscarProyectosDeDepto_NotacionPunto(String nombreDept);	
}