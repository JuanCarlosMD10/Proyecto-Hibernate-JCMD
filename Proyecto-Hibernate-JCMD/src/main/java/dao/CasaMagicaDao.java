package dao;

import modelo.CasaMagica;

/**
 * Clase DAO específica para manejar las operaciones CRUD de la entidad
 * CasaMagica. Esta clase extiende AbstractDao y establece la clase CasaMagica
 * como el tipo de entidad sobre la que se realizarán las operaciones de acceso
 * a datos.
 * 
 * @see AbstractDao
 * @see CasaMagica
 */
public class CasaMagicaDao extends AbstractDao<CasaMagica> {

	/**
	 * Constructor que configura la clase CasaMagica como la clase de entidad a
	 * manejar por este DAO.
	 */
	public CasaMagicaDao() {
		setClase(CasaMagica.class);
	}
}