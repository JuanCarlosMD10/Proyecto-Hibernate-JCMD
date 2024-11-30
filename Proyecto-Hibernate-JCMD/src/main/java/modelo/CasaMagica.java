package modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Representa una casa mágica en el sistema. Una casa mágica tiene un nombre, un
 * lema, una puntuación total, un conjunto de estudiantes que pertenecen a ella
 * y un profesor encargado de la casa.
 */
@Entity
@Table(name = "casas_magicas")
public class CasaMagica {

	/**
	 * Identificador único de la casa mágica en la base de datos.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCasaMagica;

	/**
	 * Nombre de la casa mágica.
	 */
	private String nombreCasaMagica;

	/**
	 * Lema de la casa mágica.
	 */
	private String lemaCasaMagica;

	/**
	 * Puntuación total acumulada por la casa mágica.
	 */
	private int puntuacionTotalCasaMagica;

	/**
	 * Conjunto de estudiantes que pertenecen a esta casa mágica.
	 */
	@OneToMany(mappedBy = "casa", cascade = CascadeType.ALL)
	private Set<Estudiante> estudiantes = new HashSet<>();

	/**
	 * Profesor encargado de supervisar y dirigir la casa mágica.
	 */
	@OneToOne(mappedBy = "casa")
	private Profesor jefeCasa;

	/**
	 * Constructor vacío para uso de JPA.
	 */
	public CasaMagica() {
		super();
	}

	/**
	 * Constructor con el nombre de la casa mágica.
	 * 
	 * @param nombreCasaMagica Nombre de la casa mágica.
	 */
	public CasaMagica(String nombreCasaMagica) {
		super();
		this.nombreCasaMagica = nombreCasaMagica;
	}

	/**
	 * Constructor con todos los atributos de la casa mágica.
	 * 
	 * @param nombreCasaMagica          Nombre de la casa mágica.
	 * @param lemaCasaMagica            Lema de la casa mágica.
	 * @param puntuacionTotalCasaMagica Puntuación total de la casa mágica.
	 * @param estudiantes               Conjunto de estudiantes en la casa mágica.
	 */
	public CasaMagica(String nombreCasaMagica, String lemaCasaMagica, int puntuacionTotalCasaMagica,
			Set<Estudiante> estudiantes) {
		super();
		this.nombreCasaMagica = nombreCasaMagica;
		this.lemaCasaMagica = lemaCasaMagica;
		this.puntuacionTotalCasaMagica = puntuacionTotalCasaMagica;
		this.estudiantes = estudiantes;
	}

	/**
	 * Obtiene el identificador de la casa mágica.
	 * 
	 * @return El id de la casa mágica.
	 */
	public int getIdCasaMagica() {
		return idCasaMagica;
	}

	/**
	 * Obtiene el nombre de la casa mágica.
	 * 
	 * @return El nombre de la casa mágica.
	 */
	public String getNombreCasaMagica() {
		return nombreCasaMagica;
	}

	/**
	 * Establece el nombre de la casa mágica.
	 * 
	 * @param nombreCasaMagica El nombre de la casa mágica.
	 */
	public void setNombreCasaMagica(String nombreCasaMagica) {
		this.nombreCasaMagica = nombreCasaMagica;
	}

	/**
	 * Obtiene el lema de la casa mágica.
	 * 
	 * @return El lema de la casa mágica.
	 */
	public String getLemaCasaMagica() {
		return lemaCasaMagica;
	}

	/**
	 * Establece el lema de la casa mágica.
	 * 
	 * @param lemaCasaMagica El lema de la casa mágica.
	 */
	public void setLemaCasaMagica(String lemaCasaMagica) {
		this.lemaCasaMagica = lemaCasaMagica;
	}

	/**
	 * Obtiene la puntuación total de la casa mágica.
	 * 
	 * @return La puntuación total de la casa mágica.
	 */
	public int getPuntuacionTotalCasaMagica() {
		return puntuacionTotalCasaMagica;
	}

	/**
	 * Establece la puntuación total de la casa mágica.
	 * 
	 * @param puntuacionTotalCasaMagica La puntuación total de la casa mágica.
	 */
	public void setPuntuacionTotalCasaMagica(int puntuacionTotalCasaMagica) {
		this.puntuacionTotalCasaMagica = puntuacionTotalCasaMagica;
	}

	/**
	 * Obtiene el conjunto de estudiantes que pertenecen a la casa mágica.
	 * 
	 * @return El conjunto de estudiantes de la casa mágica.
	 */
	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	/**
	 * Establece el conjunto de estudiantes que pertenecen a la casa mágica.
	 * 
	 * @param estudiantes El conjunto de estudiantes.
	 */
	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	/**
	 * Obtiene el profesor encargado de la casa mágica.
	 * 
	 * @return El profesor jefe de la casa mágica.
	 */
	public Profesor getJefeCasa() {
		return jefeCasa;
	}

	/**
	 * Establece el profesor encargado de la casa mágica.
	 * 
	 * @param jefeCasa El profesor jefe de la casa mágica.
	 */
	public void setJefeCasa(Profesor jefeCasa) {
		this.jefeCasa = jefeCasa;
	}

	/**
	 * Calcula el código hash de la casa mágica.
	 * 
	 * @return El código hash de la casa mágica.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(estudiantes, idCasaMagica, jefeCasa, lemaCasaMagica, nombreCasaMagica,
				puntuacionTotalCasaMagica);
	}

	/**
	 * Compara dos objetos de tipo CasaMagica para determinar si son iguales.
	 * 
	 * @param obj El objeto a comparar con la casa mágica.
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
		CasaMagica other = (CasaMagica) obj;
		return Objects.equals(estudiantes, other.estudiantes) && Objects.equals(idCasaMagica, other.idCasaMagica)
				&& Objects.equals(jefeCasa, other.jefeCasa) && Objects.equals(lemaCasaMagica, other.lemaCasaMagica)
				&& Objects.equals(nombreCasaMagica, other.nombreCasaMagica)
				&& Objects.equals(puntuacionTotalCasaMagica, other.puntuacionTotalCasaMagica);
	}
}