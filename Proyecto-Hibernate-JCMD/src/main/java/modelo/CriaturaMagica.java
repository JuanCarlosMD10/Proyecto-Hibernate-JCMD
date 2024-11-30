package modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Representa una criatura mágica en el sistema. Cada criatura tiene un nombre,
 * tipo, descripción, hábitat y puede estar asociada a varios eventos mágicos
 * mediante una relación de muchos a muchos.
 */
@Entity
@Table(name = "criaturas_magicas")
public class CriaturaMagica {

	/**
	 * Identificador único de la criatura mágica en la base de datos.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCriaturaMagica;

	/**
	 * Nombre de la criatura mágica.
	 */
	private String nombreCriaturaMagica;

	/**
	 * Tipo de la criatura mágica (por ejemplo, bestia, espíritu, etc.).
	 */
	private String tipoCriaturaMagica;

	/**
	 * Descripción detallada de la criatura mágica.
	 */
	private String descripcionCriaturaMagica;

	/**
	 * Hábitat o lugar donde la criatura mágica suele habitar.
	 */
	private String habitatCriaturaMagica;

	/**
	 * Conjunto de eventos mágicos en los que participa la criatura mágica. Esta
	 * relación es de muchos a muchos.
	 */
	@ManyToMany(mappedBy = "criaturas")
	private Set<EventoMagico> eventos = new HashSet<>();

	/**
	 * Constructor vacío para uso de JPA.
	 */
	public CriaturaMagica() {
		super();
	}

	/**
	 * Constructor con parámetros para crear una criatura mágica.
	 * 
	 * @param nombreCriaturaMagica      Nombre de la criatura mágica.
	 * @param tipoCriaturaMagica        Tipo de la criatura mágica.
	 * @param descripcionCriaturaMagica Descripción de la criatura mágica.
	 * @param habitatCriaturaMagica     Hábitat de la criatura mágica.
	 */
	public CriaturaMagica(String nombreCriaturaMagica, String tipoCriaturaMagica, String descripcionCriaturaMagica,
			String habitatCriaturaMagica) {
		super();
		this.nombreCriaturaMagica = nombreCriaturaMagica;
		this.tipoCriaturaMagica = tipoCriaturaMagica;
		this.descripcionCriaturaMagica = descripcionCriaturaMagica;
		this.habitatCriaturaMagica = habitatCriaturaMagica;
	}

	/**
	 * Obtiene el identificador de la criatura mágica.
	 * 
	 * @return El id de la criatura mágica.
	 */
	public int getIdCriaturaMagica() {
		return idCriaturaMagica;
	}

	/**
	 * Obtiene el nombre de la criatura mágica.
	 * 
	 * @return El nombre de la criatura mágica.
	 */
	public String getNombreCriaturaMagica() {
		return nombreCriaturaMagica;
	}

	/**
	 * Establece el nombre de la criatura mágica.
	 * 
	 * @param nombreCriaturaMagica El nombre de la criatura mágica.
	 */
	public void setNombreCriaturaMagica(String nombreCriaturaMagica) {
		this.nombreCriaturaMagica = nombreCriaturaMagica;
	}

	/**
	 * Obtiene el tipo de la criatura mágica.
	 * 
	 * @return El tipo de la criatura mágica.
	 */
	public String getTipoCriaturaMagica() {
		return tipoCriaturaMagica;
	}

	/**
	 * Establece el tipo de la criatura mágica.
	 * 
	 * @param tipoCriaturaMagica El tipo de la criatura mágica.
	 */
	public void setTipoCriaturaMagica(String tipoCriaturaMagica) {
		this.tipoCriaturaMagica = tipoCriaturaMagica;
	}

	/**
	 * Obtiene la descripción de la criatura mágica.
	 * 
	 * @return La descripción de la criatura mágica.
	 */
	public String getDescripcionCriaturaMagica() {
		return descripcionCriaturaMagica;
	}

	/**
	 * Establece la descripción de la criatura mágica.
	 * 
	 * @param descripcionCriaturaMagica La descripción de la criatura mágica.
	 */
	public void setDescripcionCriaturaMagica(String descripcionCriaturaMagica) {
		this.descripcionCriaturaMagica = descripcionCriaturaMagica;
	}

	/**
	 * Obtiene el hábitat de la criatura mágica.
	 * 
	 * @return El hábitat de la criatura mágica.
	 */
	public String getHabitatCriaturaMagica() {
		return habitatCriaturaMagica;
	}

	/**
	 * Establece el hábitat de la criatura mágica.
	 * 
	 * @param habitatCriaturaMagica El hábitat de la criatura mágica.
	 */
	public void setHabitatCriaturaMagica(String habitatCriaturaMagica) {
		this.habitatCriaturaMagica = habitatCriaturaMagica;
	}

	/**
	 * Obtiene el conjunto de eventos mágicos en los que participa la criatura.
	 * 
	 * @return El conjunto de eventos mágicos.
	 */
	public Set<EventoMagico> getEventos() {
		return eventos;
	}

	/**
	 * Establece el conjunto de eventos mágicos en los que participa la criatura.
	 * 
	 * @param eventos El conjunto de eventos mágicos.
	 */
	public void setEventos(Set<EventoMagico> eventos) {
		this.eventos = eventos;
	}

	/**
	 * Calcula el código hash de la criatura mágica.
	 * 
	 * @return El código hash de la criatura mágica.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(descripcionCriaturaMagica, habitatCriaturaMagica, nombreCriaturaMagica, tipoCriaturaMagica);
	}

	/**
	 * Compara dos objetos de tipo CriaturaMagica para determinar si son iguales.
	 * 
	 * @param obj El objeto a comparar con la criatura mágica.
	 * @return true si los objetos son iguales, false en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CriaturaMagica other = (CriaturaMagica) obj;
		return Objects.equals(descripcionCriaturaMagica, other.descripcionCriaturaMagica)
				&& Objects.equals(habitatCriaturaMagica, other.habitatCriaturaMagica)
				&& Objects.equals(nombreCriaturaMagica, other.nombreCriaturaMagica)
				&& Objects.equals(tipoCriaturaMagica, other.tipoCriaturaMagica);
	}
}