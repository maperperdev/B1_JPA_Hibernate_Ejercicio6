package JPAControladorDao;

import java.util.List;


import entidades.Proyecto;

public interface ProyectoFacade extends AbstractFacadeJPA<Proyecto>{
	 public List<Proyecto> mostrarTodos();
	
}