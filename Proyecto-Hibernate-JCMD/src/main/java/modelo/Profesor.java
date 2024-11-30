package modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Representa un profesor en el sistema educativo mágico. Cada profesor tiene un
 * nombre, especialidad, nivel mágico, experiencia y puede estar asociado a una
 * casa mágica. Un profesor puede enseñar varios cursos mágicos.
 */
@Entity
@Table(name = "profesores")
public class Profesor {

	/**
	 * Identificador único del profesor en la base de datos.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProfesor;

	/**
	 * Nombre del profesor.
	 */
	private String nombreProfesor;

	/**
	 * Especialidad del profesor en el campo mágico (por ejemplo,
	 * "Transformaciones", "Pociones").
	 */
	private String especialidadProfesor;

	/**
	 * Nivel mágico del profesor (por ejemplo, "Magister", "Experto").
	 */
	private String nivelMagicoProfesor;

	/**
	 * Número de años de experiencia del profesor en el ámbito mágico.
	 */
	private int experienciaProfesor;

	/**
	 * Conjunto de cursos mágicos que enseña el profesor. Relación de uno a muchos
	 * con la clase CursoMagico.
	 */
	@OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
	private Set<CursoMagico> cursos = new HashSet<>();

	/**
	 * Casa mágica a la que pertenece el profesor. Relación de uno a uno con la
	 * clase CasaMagica.
	 */
	@OneToOne
	@JoinColumn(name = "casa_id")
	private CasaMagica casa;

	/**
	 * Constructor vacío para uso de JPA.
	 */
	public Profesor() {
		super();
	}

	/**
	 * Constructor con parámetros para crear un profesor.
	 * 
	 * @param nombreProfesor       El nombre del profesor.
	 * @param especialidadProfesor La especialidad del profesor.
	 * @param nivelMagicoProfesor  El nivel mágico del profesor.
	 * @param experienciaProfesor  La experiencia del profesor en años.
	 * @param cursos               El conjunto de cursos que enseña el profesor.
	 */
	public Profesor(String nombreProfesor, String especialidadProfesor, String nivelMagicoProfesor,
			int experienciaProfesor, Set<CursoMagico> cursos) {
		super();
		this.nombreProfesor = nombreProfesor;
		this.especialidadProfesor = especialidadProfesor;
		this.nivelMagicoProfesor = nivelMagicoProfesor;
		this.experienciaProfesor = experienciaProfesor;
		this.cursos = cursos;
	}

	/**
	 * Obtiene el identificador del profesor.
	 * 
	 * @return El identificador único del profesor.
	 */
	public int getIdProfesor() {
		return idProfesor;
	}

	/**
	 * Obtiene el nombre del profesor.
	 * 
	 * @return El nombre del profesor.
	 */
	public String getNombreProfesor() {
		return nombreProfesor;
	}

	/**
	 * Establece el nombre del profesor.
	 * 
	 * @param nombreProfesor El nombre del profesor.
	 */
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	/**
	 * Obtiene la especialidad del profesor.
	 * 
	 * @return La especialidad del profesor.
	 */
	public String getEspecialidadProfesor() {
		return especialidadProfesor;
	}

	/**
	 * Establece la especialidad del profesor.
	 * 
	 * @param especialidadProfesor La especialidad del profesor.
	 */
	public void setEspecialidadProfesor(String especialidadProfesor) {
		this.especialidadProfesor = especialidadProfesor;
	}

	/**
	 * Obtiene el nivel mágico del profesor.
	 * 
	 * @return El nivel mágico del profesor.
	 */
	public String getNivelMagicoProfesor() {
		return nivelMagicoProfesor;
	}

	/**
	 * Establece el nivel mágico del profesor.
	 * 
	 * @param nivelMagicoProfesor El nivel mágico del profesor.
	 */
	public void setNivelMagicoProfesor(String nivelMagicoProfesor) {
		this.nivelMagicoProfesor = nivelMagicoProfesor;
	}

	/**
	 * Obtiene la experiencia del profesor en años.
	 * 
	 * @return La experiencia en años del profesor.
	 */
	public int getExperienciaProfesor() {
		return experienciaProfesor;
	}

	/**
	 * Establece la experiencia en años del profesor.
	 * 
	 * @param experienciaProfesor La experiencia en años del profesor.
	 */
	public void setExperienciaProfesor(int experienciaProfesor) {
		this.experienciaProfesor = experienciaProfesor;
	}

	/**
	 * Obtiene el conjunto de cursos que enseña el profesor.
	 * 
	 * @return El conjunto de cursos que enseña el profesor.
	 */
	public Set<CursoMagico> getCursos() {
		return cursos;
	}

	/**
	 * Establece el conjunto de cursos que enseña el profesor.
	 * 
	 * @param cursos El conjunto de cursos que enseña el profesor.
	 */
	public void setCursos(Set<CursoMagico> cursos) {
		this.cursos = cursos;
	}

	/**
	 * Obtiene la casa mágica a la que pertenece el profesor.
	 * 
	 * @return La casa mágica del profesor.
	 */
	public CasaMagica getCasa() {
		return casa;
	}

	/**
	 * Establece la casa mágica a la que pertenece el profesor.
	 * 
	 * @param casa La casa mágica del profesor.
	 */
	public void setCasa(CasaMagica casa) {
		this.casa = casa;
	}

	/**
	 * Calcula el código hash del profesor.
	 * 
	 * @return El código hash del profesor.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(especialidadProfesor, experienciaProfesor, nivelMagicoProfesor, nombreProfesor);
	}

	/**
	 * Compara dos objetos de tipo Profesor para determinar si son iguales.
	 * 
	 * @param obj El objeto a comparar con el profesor.
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
		Profesor other = (Profesor) obj;
		return Objects.equals(especialidadProfesor, other.especialidadProfesor)
				&& experienciaProfesor == other.experienciaProfesor
				&& Objects.equals(nivelMagicoProfesor, other.nivelMagicoProfesor)
				&& Objects.equals(nombreProfesor, other.nombreProfesor);
	}
}