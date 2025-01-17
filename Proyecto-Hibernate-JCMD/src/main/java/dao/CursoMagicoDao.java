package dao;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import modelo.CursoMagico;
import utiles.HibernateUtil;

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

	/**
	 * Consulta que utiliza HQL para contar el número total de cursos mágicos
	 * almacenados en la base de datos.
	 * 
	 * @return El número total de cursos mágicos como un valor de tipo Long.
	 */
	public Long contarCursosMagicos() {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			// Consulta HQL para contar el total de registros en la tabla CursoMagico
			String hql = "SELECT COUNT(c) FROM CursoMagico c";
			TypedQuery<Long> query = session.createQuery(hql, Long.class);
			return query.getSingleResult();
		} finally {
			session.close();
		}
	}
}