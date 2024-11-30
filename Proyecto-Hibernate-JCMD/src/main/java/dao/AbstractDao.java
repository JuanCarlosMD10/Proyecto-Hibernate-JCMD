package dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.TypedQuery;
import utiles.HibernateUtil;

/**
 * Clase base abstracta para operaciones de acceso a datos (DAO) en Hibernate.
 * Proporciona métodos comunes para realizar operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) sobre entidades genéricas utilizando la sesión de
 * Hibernate.
 *
 * @param <T> El tipo de la entidad que esta clase manejará, que debe ser una
 *            clase de entidad JPA.
 */
public abstract class AbstractDao<T> implements InterfazDao<T> {

	/**
	 * Clase de la entidad sobre la cual se realizan las operaciones CRUD.
	 */
	private Class<T> clase;

	/**
	 * Crea una nueva entidad en la base de datos. Este método inicia una
	 * transacción y persiste la entidad en la base de datos.
	 *
	 * @param t La entidad que se desea crear.
	 */
	@Override
	public void create(T t) {
		executeInsideTransaction(t);
	}

	/**
	 * Recupera una entidad de la base de datos por su identificador único.
	 *
	 * @param id El identificador de la entidad a recuperar.
	 * @return que contiene la entidad si se encuentra, o si no se encuentra.
	 */
	@Override
	public Optional<T> get(int id) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		return Optional.ofNullable(sesion.find(clase, id));
	}

	/**
	 * Recupera todas las entidades almacenadas en la base de datos.
	 *
	 * @return Una lista de todas las entidades.
	 */
	@Override
	public List<T> getAll() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "FROM " + clase.getName();
		TypedQuery<T> query = sesion.createQuery(queryString, clase);
		List<T> resultados = query.getResultList();
		return resultados;
	}

	/**
	 * Actualiza una entidad en la base de datos. Este método ejecuta una
	 * transacción y fusiona los cambios de la entidad en la base de datos.
	 *
	 * @param t La entidad con los datos actualizados.
	 */
	@Override
	public void update(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		executeInsideTransaction(sesion, sesion.merge(t));
	}

	/**
	 * Elimina una entidad de la base de datos. Este método inicia una transacción,
	 * elimina la entidad y luego confirma la transacción.
	 *
	 * @param t La entidad a eliminar.
	 */
	@Override
	public void delete(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		// Registramos una transacción
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.remove(t);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}
	}

	/**
	 * Ejecuta una transacción en la que se persiste una entidad. Se utiliza para la
	 * creación de nuevas entidades en la base de datos.
	 *
	 * @param sesion La sesión de Hibernate para realizar la operación.
	 * @param objeto La entidad a persistir.
	 */
	private void executeInsideTransaction(Session sesion, T objeto) {
		// Registramos una transacción
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.persist(objeto);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}
	}

	/**
	 * Ejecuta una transacción en la que se persiste una entidad. Este método
	 * utiliza la fábrica de sesiones de Hibernate para abrir una nueva sesión.
	 *
	 * @param objeto La entidad a persistir.
	 */
	private void executeInsideTransaction(T objeto) {
		executeInsideTransaction(HibernateUtil.getFactoriaSession().openSession(), objeto);
	}

	/**
	 * Obtiene la clase de la entidad que maneja este DAO.
	 * 
	 * @return La clase de la entidad.
	 */
	public Class<T> getClase() {
		return clase;
	}

	/**
	 * Establece la clase de la entidad que será manejada por este DAO.
	 *
	 * @param clase La clase de la entidad.
	 */
	public void setClase(Class<T> clase) {
		this.clase = clase;
	}
}