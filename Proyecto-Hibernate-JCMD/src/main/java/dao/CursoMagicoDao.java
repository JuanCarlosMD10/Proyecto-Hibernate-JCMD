package dao;

import modelo.CursoMagico;

/**
 * Clase DAO específica para manejar las operaciones CRUD de la entidad
 * CursoMagico. Esta clase extiende AbstractDao y establece la clase CursoMagico
 * como el tipo de entidad sobre la que se realizarán las operaciones de acceso
 * a datos.
 * 
 * @see AbstractDao
 * @see CursoMagico
 */
public class CursoMagicoDao extends AbstractDao<CursoMagico> {

	/**
	 * Constructor que configura la clase CursoMagico como la clase de entidad a
	 * manejar por este DAO.
	 */
	public CursoMagicoDao() {
		setClase(CursoMagico.class);
	}
}