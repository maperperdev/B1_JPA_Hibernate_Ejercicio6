package JPAControladorDao;

import java.util.List;


import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entidades.Empleado;




//@Stateless
public class EmpleadoFacadeImpl extends AbstractFacadeJPAImpl<Empleado> implements EmpleadoFacade {


public EmpleadoFacadeImpl() {

	super(Empleado.class);

}

public List<Empleado> mostrarTodos() {
    
    TypedQuery<Empleado> q = this.getEm().createQuery("SELECT p FROM Empleado AS p",Empleado.class);
	return q.getResultList();
}




}


