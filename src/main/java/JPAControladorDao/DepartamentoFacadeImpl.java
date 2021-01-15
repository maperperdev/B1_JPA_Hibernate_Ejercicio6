package JPAControladorDao;

import java.util.List;


import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entidades.Departamento;




//@Stateless
public class DepartamentoFacadeImpl extends AbstractFacadeJPAImpl<Departamento> implements DepartamentoFacade {


public DepartamentoFacadeImpl() {

	super(Departamento.class);

}

public List<Departamento> mostrarTodos() {
    
    TypedQuery<Departamento> q = this.getEm().createQuery("SELECT p FROM Departamento AS p",Departamento.class);
	return q.getResultList();
}




}


