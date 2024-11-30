package dao;

import modelo.Profesor;

/**
 * Clase DAO específica para manejar las operaciones CRUD de la entidad
 * Profesor. Esta clase extiende AbstractDao y establece la clase Profesor como
 * el tipo de entidad sobre la que se realizarán las operaciones de acceso a
 * datos.
 * 
 * @see AbstractDao
 * @see Profesor
 */
public class ProfesorDao extends AbstractDao<Profesor> {

	/**
	 * Constructor que configura la clase Profesor como la clase de entidad a
	 * manejar por este DAO.
	 */
	public ProfesorDao() {
		setClase(Profesor.class);
	}
}