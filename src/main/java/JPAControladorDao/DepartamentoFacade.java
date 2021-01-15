package JPAControladorDao;

import java.util.List;

import entidades.Departamento;

public interface DepartamentoFacade extends AbstractFacadeJPA<Departamento>{
	 public List<Departamento> mostrarTodos();
	
}