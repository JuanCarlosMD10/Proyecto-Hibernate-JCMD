package dao;

import modelo.CriaturaMagica;

/**
 * Clase DAO específica para manejar las operaciones CRUD de la entidad
 * CriaturaMagica. Esta clase extiende AbstractDao y establece la clase
 * CriaturaMagica como el tipo de entidad sobre la que se realizarán las
 * operaciones de acceso a datos.
 * 
 * @see AbstractDao
 * @see CriaturaMagica
 */
public class CriaturaMagicaDao extends AbstractDao<CriaturaMagica> {

	/**
	 * Constructor que configura la clase CriaturaMagica como la clase de entidad a
	 * manejar por este DAO.
	 */
	public CriaturaMagicaDao() {
		setClase(CriaturaMagica.class);
	}
}