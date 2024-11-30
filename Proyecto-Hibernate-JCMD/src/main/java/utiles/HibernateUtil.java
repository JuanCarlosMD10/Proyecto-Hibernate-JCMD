package utiles;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Utilidad para la configuración y gestión de la sesión de Hibernate. Esta
 * clase proporciona un singleton para obtener una instancia de la fábrica de
 * sesiones de Hibernate y cerrar los recursos cuando ya no sean necesarios.
 */
public class HibernateUtil {

	/**
	 * Registro de servicios de Hibernate. Usado para configurar la sesión.
	 */
	private static StandardServiceRegistry registro;

	/**
	 * Fábrica de sesiones de Hibernate. Usada para crear sesiones de base de datos.
	 */
	private static SessionFactory factoriaSession;

	/**
	 * Obtiene la instancia de la fábrica de sesiones de Hibernate. Si aún no ha
	 * sido creada, la inicializa y la configura.
	 * 
	 * @return La instancia de {@link SessionFactory} configurada.
	 */
	public static SessionFactory getFactoriaSession() {
		if (factoriaSession == null) {
			// Crear y configurar el registro de servicios de Hibernate.
			registro = new StandardServiceRegistryBuilder().configure().build();
			// Crear las fuentes de metadatos de Hibernate.
			MetadataSources sources = new MetadataSources(registro);
			// Construir los metadatos a partir de las fuentes.
			Metadata metadatos = sources.getMetadataBuilder().build();
			// Crear la fábrica de sesiones a partir de los metadatos.
			factoriaSession = metadatos.buildSessionFactory();
		}
		return factoriaSession;
	}

	/**
	 * Cierra la fábrica de sesiones de Hibernate y libera los recursos. Este método
	 * debe ser llamado cuando ya no se necesiten más sesiones de Hibernate para
	 * evitar pérdidas de memoria o conexiones abiertas innecesarias.
	 */
	public static void shutdown() {
		if (registro != null) {
			// Destruir el registro de servicios de Hibernate.
			StandardServiceRegistryBuilder.destroy(registro);
		}
	}
}