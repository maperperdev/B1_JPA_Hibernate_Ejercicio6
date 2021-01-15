package JPAControladorDao;

import java.util.List;

import javax.persistence.TypedQuery;

import entidades.Proyecto;

//@Stateless
public class ProyectoFacadeImpl extends AbstractFacadeJPAImpl<Proyecto> implements ProyectoFacade {

	public ProyectoFacadeImpl() {

		super(Proyecto.class);

	}

	public List<Proyecto> mostrarTodos() {

		TypedQuery<Proyecto> q = this.getEm().createQuery("SELECT p FROM Proyecto AS p", Proyecto.class);
		return q.getResultList();
	}

	public List<Proyecto> buscarProyectoDeDepto(int dep) {
		TypedQuery<Proyecto> q = this.getEm()
				.createQuery("SELECT p FROM Proyecto p WHERE p.codDept.codDept =:seleccionado", Proyecto.class);
		q.setParameter("seleccionado", dep);
		return q.getResultList();
	}

}
