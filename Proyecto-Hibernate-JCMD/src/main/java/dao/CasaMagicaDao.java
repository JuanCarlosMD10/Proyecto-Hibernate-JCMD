package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import modelo.CasaMagica;
import utiles.HibernateUtil;

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

	/**
	 * Consulta que obtiene la primera casa mágica en la base de datos ordenada por
	 * su identificador de forma ascendente.
	 * 
	 * @return La primera instancia de CasaMagica ordenada por ID.
	 */
	public CasaMagica obtenerPrimeraCasaMagica() {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "FROM CasaMagica c ORDER BY c.idCasaMagica ASC";
			TypedQuery<CasaMagica> query = session.createQuery(hql, CasaMagica.class);
			query.setMaxResults(1);
			return query.getSingleResult();
		} finally {
			session.close();
		}
	}

	/**
	 * Consulta parametrizada que obtiene los nombres de las casas mágicas cuya
	 * puntuación total sea mayor que un valor mínimo especificado.
	 * 
	 * @param minPuntuacion La puntuación mínima para filtrar las casas mágicas.
	 * @return Una lista con los nombres de las casas mágicas que cumplen con el
	 *         criterio.
	 */
	public List<String> obtenerCasasConPuntuacionMayor(int minPuntuacion) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "FROM CasaMagica c WHERE c.puntuacionTotalCasaMagica > :minPuntuacion";
			TypedQuery<CasaMagica> query = session.createQuery(hql, CasaMagica.class);
			query.setParameter("minPuntuacion", minPuntuacion);

			List<CasaMagica> casas = query.getResultList();
			List<String> nombres = new ArrayList<>();
			for (CasaMagica casa : casas) {
				nombres.add(casa.getNombreCasaMagica());
			}
			return nombres;
		} finally {
			session.close();
		}
	}

	/**
	 * Operación de actualización que utiliza CriteriaBuilder para modificar la
	 * puntuación total de una casa mágica específica identificada por su nombre.
	 * 
	 * @param nuevaPuntuacion La nueva puntuación total que se asignará a la casa.
	 * @param nombreCasa      El nombre de la casa mágica que se actualizará.
	 */
	public void actualizarPuntuacionCasa(int nuevaPuntuacion, String nombreCasa) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			CriteriaBuilder cb = sesion.getCriteriaBuilder();
			CriteriaUpdate<CasaMagica> update = cb.createCriteriaUpdate(CasaMagica.class);
			Root<CasaMagica> root = update.from(CasaMagica.class);

			// Configuramos el campo a actualizar y la condición
			update.set(root.get("puntuacionTotalCasaMagica"), nuevaPuntuacion)
					.where(cb.equal(root.get("nombreCasaMagica"), nombreCasa));

			// Ejecutamos la consulta
			sesion.createQuery(update).executeUpdate();
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