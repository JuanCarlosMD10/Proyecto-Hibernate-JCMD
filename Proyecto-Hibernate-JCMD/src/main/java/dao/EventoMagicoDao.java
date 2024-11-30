package dao;

import modelo.EventoMagico;

/**
 * Clase DAO específica para manejar las operaciones CRUD de la entidad
 * EventoMagico. Esta clase extiende AbstractDao y establece la clase
 * EventoMagico como el tipo de entidad sobre la que se realizarán las
 * operaciones de acceso a datos.
 * 
 * @see AbstractDao
 * @see EventoMagico
 */
public class EventoMagicoDao extends AbstractDao<EventoMagico> {

	/**
	 * Constructor que configura la clase EventoMagico como la clase de entidad a
	 * manejar por este DAO.
	 */
	public EventoMagicoDao() {
		setClase(EventoMagico.class);
	}
}