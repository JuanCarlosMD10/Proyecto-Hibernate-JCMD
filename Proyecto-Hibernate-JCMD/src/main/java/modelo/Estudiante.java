package modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Representa a un estudiante en el sistema. Un estudiante tiene un nombre,
 * edad, nivel mágico, una varita, una casa asignada y está inscrito en varios
 * cursos y eventos mágicos.
 */
@Entity
@Table(name = "estudiantes")
public class Estudiante {

	/**
	 * Identificador único del estudiante en la base de datos.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstudiante;

	/**
	 * Nombre del estudiante.
	 */
	private String nombreEstudiante;

	/**
	 * Edad del estudiante.
	 */
	private int edadEstudiante;

	/**
	 * Nivel mágico del estudiante (por ejemplo, "Principiante", "Intermedio",
	 * "Avanzado").
	 */
	private String nivelMagicoEstudiante;

	/**
	 * Varita que usa el estudiante.
	 */
	private String varitaEstudiante;

	/**
	 * Casa mágica a la que pertenece el estudiante. Relación de muchos a uno.
	 */
	@ManyToOne
	@JoinColumn(name = "casa_id")
	private CasaMagica casa;

	/**
	 * Conjunto de cursos mágicos en los que el estudiante está inscrito. Relación
	 * de muchos a muchos.
	 */
	@ManyToMany(mappedBy = "estudiantes")
	private Set<CursoMagico> cursos = new HashSet<>();

	/**
	 * Conjunto de eventos mágicos en los que el estudiante participa. Relación de
	 * muchos a muchos.
	 */
	@ManyToMany(mappedBy = "estudiantes")
	private Set<EventoMagico> eventos = new HashSet<>();

	/**
	 * Constructor vacío para uso de JPA.
	 */
	public Estudiante() {
		super();
	}

	/**
	 * Constructor con parámetros para crear un estudiante.
	 * 
	 * @param nombreEstudiante      Nombre del estudiante.
	 * @param edadEstudiante        Edad del estudiante.
	 * @param nivelMagicoEstudiante Nivel mágico del estudiante.
	 * @param varitaEstudiante      Varita del estudiante.
	 */
	public Estudiante(String nombreEstudiante, int edadEstudiante, String nivelMagicoEstudiante,
			String varitaEstudiante) {
		super();
		this.nombreEstudiante = nombreEstudiante;
		this.edadEstudiante = edadEstudiante;
		this.nivelMagicoEstudiante = nivelMagicoEstudiante;
		this.varitaEstudiante = varitaEstudiante;
	}

	/**
	 * Obtiene el identificador del estudiante.
	 * 
	 * @return El id del estudiante.
	 */
	public int getIdEstudiante() {
		return idEstudiante;
	}

	/**
	 * Obtiene el nombre del estudiante.
	 * 
	 * @return El nombre del estudiante.
	 */
	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	/**
	 * Establece el nombre del estudiante.
	 * 
	 * @param nombreEstudiante El nombre del estudiante.
	 */
	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	/**
	 * Obtiene la edad del estudiante.
	 * 
	 * @return La edad del estudiante.
	 */
	public int getEdadEstudiante() {
		return edadEstudiante;
	}

	/**
	 * Establece la edad del estudiante.
	 * 
	 * @param edadEstudiante La edad del estudiante.
	 */
	public void setEdadEstudiante(int edadEstudiante) {
		this.edadEstudiante = edadEstudiante;
	}

	/**
	 * Obtiene el nivel mágico del estudiante.
	 * 
	 * @return El nivel mágico del estudiante.
	 */
	public String getNivelMagicoEstudiante() {
		return nivelMagicoEstudiante;
	}

	/**
	 * Establece el nivel mágico del estudiante.
	 * 
	 * @param nivelMagicoEstudiante El nivel mágico del estudiante.
	 */
	public void setNivelMagicoEstudiante(String nivelMagicoEstudiante) {
		this.nivelMagicoEstudiante = nivelMagicoEstudiante;
	}

	/**
	 * Obtiene la varita del estudiante.
	 * 
	 * @return La varita del estudiante.
	 */
	public String getVaritaEstudiante() {
		return varitaEstudiante;
	}

	/**
	 * Establece la varita del estudiante.
	 * 
	 * @param varitaEstudiante La varita del estudiante.
	 */
	public void setVaritaEstudiante(String varitaEstudiante) {
		this.varitaEstudiante = varitaEstudiante;
	}

	/**
	 * Obtiene la casa a la que pertenece el estudiante.
	 * 
	 * @return La casa del estudiante.
	 */
	public CasaMagica getCasa() {
		return casa;
	}

	/**
	 * Establece la casa a la que pertenece el estudiante.
	 * 
	 * @param casa La casa del estudiante.
	 */
	public void setCasa(CasaMagica casa) {
		this.casa = casa;
	}

	/**
	 * Obtiene el conjunto de cursos mágicos en los que el estudiante está inscrito.
	 * 
	 * @return El conjunto de cursos del estudiante.
	 */
	public Set<CursoMagico> getCursos() {
		return cursos;
	}

	/**
	 * Establece el conjunto de cursos en los que el estudiante está inscrito.
	 * 
	 * @param cursos El conjunto de cursos del estudiante.
	 */
	public void setCursos(Set<CursoMagico> cursos) {
		this.cursos = cursos;
	}

	/**
	 * Obtiene el conjunto de eventos mágicos en los que el estudiante participa.
	 * 
	 * @return El conjunto de eventos del estudiante.
	 */
	public Set<EventoMagico> getEventos() {
		return eventos;
	}

	/**
	 * Establece el conjunto de eventos en los que el estudiante participa.
	 * 
	 * @param eventos El conjunto de eventos del estudiante.
	 */
	public void setEventos(Set<EventoMagico> eventos) {
		this.eventos = eventos;
	}

	/**
	 * Calcula el código hash del estudiante.
	 * 
	 * @return El código hash del estudiante.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edadEstudiante, nivelMagicoEstudiante, nombreEstudiante, varitaEstudiante);
	}

	/**
	 * Compara dos objetos de tipo Estudiante para determinar si son iguales.
	 * 
	 * @param obj El objeto a comparar con el estudiante.
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
		Estudiante other = (Estudiante) obj;
		return edadEstudiante == other.edadEstudiante
				&& Objects.equals(nivelMagicoEstudiante, other.nivelMagicoEstudiante)
				&& Objects.equals(nombreEstudiante, other.nombreEstudiante)
				&& Objects.equals(varitaEstudiante, other.varitaEstudiante);
	}
}