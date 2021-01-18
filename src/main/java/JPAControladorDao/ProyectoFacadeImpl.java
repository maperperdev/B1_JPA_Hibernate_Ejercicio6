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
	
	@Override
	public List<Proyecto> buscarProyectosDeDepto(Integer dep) {
		TypedQuery<Proyecto> q = this.getEm()
				.createQuery("SELECT p FROM Proyecto p WHERE p.codDept.codDept =:seleccionado", Proyecto.class);
		q.setParameter("seleccionado", dep);
		return q.getResultList();
	}

	//Con subconsulta
	@Override
	public List<Proyecto> buscarProyectosDeDepto(String nombreDept) {
		TypedQuery<Proyecto> q = this.getEm()
				.createQuery("SELECT p FROM Proyecto p WHERE p.codDept IN "
						+ "(SELECT d.nombre FROM Departamento d WHERE d.nombre =:seleccionado", Proyecto.class);
		q.setParameter("seleccionado", nombreDept);
		return q.getResultList();
	}

	//otra forma: con JOIN
	@Override
	public List<Proyecto> buscar2ProyectosDeDepto(String nombreDept) {
		TypedQuery<Proyecto> q = this.getEm().createQuery("SELECT p FROM Proyecto p JOIN Departamento d "
				+ "ON p.codDept = d.codDept WHERE d.dnombre = :seleccionado", Proyecto.class);
		q.setParameter("seleccionado", nombreDept);
		return q.getResultList();
	}
	
	//Otra forma con notación punto
	@Override
	public List<Proyecto> buscarProyectosDeDepto_NotacionPunto(String nombreDept) {
		TypedQuery<Proyecto> q = this.getEm().createQuery("SELECT p FROM Proyecto p "
				+ "WHERE p.codDept.dnombre= :seleccionado", Proyecto.class);
		q.setParameter("seleccionado", nombreDept);
		return q.getResultList();
	}

}
