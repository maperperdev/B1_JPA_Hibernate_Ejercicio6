package JPAControladorDao;

import java.util.List;


import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entidades.Direccion;
import entidades.Empleado;




//@Stateless
public class DireccionFacadeImpl extends AbstractFacadeJPAImpl<Direccion> implements DireccionFacade {


public DireccionFacadeImpl() {

	super(Direccion.class);

}

public List<Direccion> mostrarTodos() {
    
    TypedQuery<Direccion> q = this.getEm().createQuery("SELECT p FROM Direccion AS p",Direccion.class);
	return q.getResultList();
}




}


