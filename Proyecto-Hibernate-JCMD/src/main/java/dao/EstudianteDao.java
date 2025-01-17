package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import modelo.Estudiante;
import utiles.HibernateUtil;

/**
 * Clase DAO específica para manejar las operaciones CRUD de la entidad
 * Estudiante. Esta clase extiende AbstractDao y establece la clase Estudiante
 * como el tipo de entidad sobre la que se realizarán las operaciones de acceso
 * a datos.
 * 
 * @see AbstractDao
 * @see Estudiante
 */
public class EstudianteDao extends AbstractDao<Estudiante> {

	/**
	 * Constructor que configura la clase Estudiante como la clase de entidad a
	 * manejar por este DAO.
	 */
	public EstudianteDao() {
		setClase(Estudiante.class);
	}

	/**
	 * Consulta que devuelve los nombres de todos los estudiantes almacenados en la
	 * base de datos.
	 * 
	 * @return Una lista de estudiantes con sus nombres.
	 */
	public List<Estudiante> obtenerNombresEstudiantes() {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "SELECT e.nombreEstudiante FROM Estudiante e";
			TypedQuery<Estudiante> query = session.createQuery(hql, Estudiante.class);
			return query.getResultList();
		} finally {
			session.close();
		}
	}

	/**
	 * Consulta que devuelve los nombres y edades de todos los estudiantes
	 * almacenados en la base de datos.
	 * 
	 * @return Una lista de arrays de estudiantes donde cada array contiene el
	 *         nombre y la edad de un estudiante.
	 */
	public List<Estudiante[]> obtenerNombresYEdadesEstudiantes() {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "SELECT e.nombreEstudiante, e.edadEstudiante FROM Estudiante e";
			TypedQuery<Estudiante[]> query = session.createQuery(hql, Estudiante[].class);
			return query.getResultList();
		} finally {
			session.close();
		}
	}

	/**
	 * Consulta parametrizada que devuelve los nombres de los estudiantes
	 * pertenecientes a una casa mágica específica.
	 * 
	 * @param idCasa El identificador de la casa mágica para filtrar los
	 *               estudiantes.
	 * @return Una lista de estudiantes que pertenecen a la casa indicada.
	 */
	public List<Estudiante> obtenerEstudiantesPorCasa(int idCasa) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "SELECT e.nombreEstudiante FROM Estudiante e WHERE e.casa.idCasaMagica = :idCasa";
			TypedQuery<Estudiante> query = session.createQuery(hql, Estudiante.class);
			query.setParameter("idCasa", idCasa);
			return query.getResultList();
		} finally {
			session.close();
		}
	}

	/**
	 * Consulta que calcula y devuelve el promedio de edad de los estudiantes
	 * almacenados en la base de datos.
	 * 
	 * @return El promedio de edad de los estudiantes como un valor decimal.
	 */
	public Double obtenerPromedioEdadEstudiantes() {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "SELECT AVG(e.edadEstudiante) FROM Estudiante e";
			TypedQuery<Double> query = session.createQuery(hql, Double.class);
			return query.getSingleResult();
		} finally {
			session.close();
		}
	}

	/**
	 * Operación de borrado que utiliza CriteriaBuilder para eliminar un estudiante
	 * específico identificado por su nombre.
	 * 
	 * @param nombreEstudiante El nombre del estudiante que se desea eliminar.
	 */
	public void eliminarEstudiantePorNombre(String nombreEstudiante) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			CriteriaBuilder cb = sesion.getCriteriaBuilder();
			CriteriaDelete<Estudiante> delete = cb.createCriteriaDelete(Estudiante.class);
			Root<Estudiante> root = delete.from(Estudiante.class);

			// Configuramos la condición para el borrado
			delete.where(cb.equal(root.get("nombreEstudiante"), nombreEstudiante));

			// Ejecutamos la consulta
			sesion.createQuery(delete).executeUpdate();
			transaccion.commit();
		} catch (Exception e) {
			if (transaccion != null) {
				transaccion.rollback();
			}
			e.printStackTrace();
		} finally {
			sesion.close();
		}
	}
}