package dao;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import modelo.EventoMagico;
import utiles.HibernateUtil;

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

	/**
	 * Consulta que utiliza HQL para obtener eventos mágicos en una ubicación
	 * específica, ordenados por fecha de forma ascendente.
	 * 
	 * @param ubicacion La ubicación específica en la que se encuentran los eventos
	 *                  mágicos.
	 * @return Una lista de arreglos de objetos donde cada arreglo contiene el
	 *         nombre del evento y su fecha.
	 */
	public List<EventoMagico[]> obtenerEventosPorUbicacionOrdenados(String ubicacion) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			// Consulta HQL para filtrar por ubicación y ordenar por fecha
			String hql = "SELECT e.nombreEventoMagico, e.fechaEventoMagico FROM EventoMagico e "
					+ "WHERE e.ubicacionEventoMagico = :ubicacion ORDER BY e.fechaEventoMagico ASC";
			TypedQuery<EventoMagico[]> query = session.createQuery(hql, EventoMagico[].class);
			query.setParameter("ubicacion", ubicacion);
			return query.getResultList();
		} finally {
			session.close();
		}
	}
}