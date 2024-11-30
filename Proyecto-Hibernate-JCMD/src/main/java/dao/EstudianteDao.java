package dao;

import modelo.Estudiante;

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
}