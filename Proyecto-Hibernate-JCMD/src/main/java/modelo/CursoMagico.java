package modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Representa un curso mágico en el sistema. Cada curso tiene un nombre, nivel,
 * duración, un profesor asignado y una lista de estudiantes inscritos.
 */
@Entity
@Table(name = "cursos_magicos")
public class CursoMagico {

	/**
	 * Identificador único del curso mágico en la base de datos.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCursoMagico;

	/**
	 * Nombre del curso mágico.
	 */
	private String nombreCursoMagico;

	/**
	 * Nivel del curso mágico (por ejemplo, "Principiante", "Intermedio",
	 * "Avanzado").
	 */
	private String nivelCursoMagico;

	/**
	 * Duración del curso mágico, medida en horas.
	 */
	private int duracionCursoMagico;

	/**
	 * Profesor que imparte el curso mágico. Relación de muchos a uno.
	 */
	@ManyToOne
	@JoinColumn(name = "profesor_id")
	private Profesor profesor;

	/**
	 * Conjunto de estudiantes inscritos en el curso mágico. Relación de muchos a
	 * muchos.
	 */
	@ManyToMany
	@JoinTable(name = "estudiantes_cursos", joinColumns = @JoinColumn(name = "curso_id"), inverseJoinColumns = @JoinColumn(name = "estudiante_id"))
	private Set<Estudiante> estudiantes = new HashSet<>();

	/**
	 * Constructor vacío para uso de JPA.
	 */
	public CursoMagico() {
		super();
	}

	/**
	 * Constructor con parámetros para crear un curso mágico.
	 * 
	 * @param nombreCursoMagico   Nombre del curso mágico.
	 * @param nivelCursoMagico    Nivel del curso mágico.
	 * @param duracionCursoMagico Duración del curso mágico.
	 */
	public CursoMagico(String nombreCursoMagico, String nivelCursoMagico, int duracionCursoMagico) {
		super();
		this.nombreCursoMagico = nombreCursoMagico;
		this.nivelCursoMagico = nivelCursoMagico;
		this.duracionCursoMagico = duracionCursoMagico;
	}

	/**
	 * Obtiene el identificador del curso mágico.
	 * 
	 * @return El id del curso mágico.
	 */
	public int getId() {
		return idCursoMagico;
	}

	/**
	 * Obtiene el nombre del curso mágico.
	 * 
	 * @return El nombre del curso mágico.
	 */
	public String getNombreCursoMagico() {
		return nombreCursoMagico;
	}

	/**
	 * Establece el nombre del curso mágico.
	 * 
	 * @param nombreCursoMagico El nombre del curso mágico.
	 */
	public void setNombreCursoMagico(String nombreCursoMagico) {
		this.nombreCursoMagico = nombreCursoMagico;
	}

	/**
	 * Obtiene el nivel del curso mágico.
	 * 
	 * @return El nivel del curso mágico.
	 */
	public String getNivelCursoMagico() {
		return nivelCursoMagico;
	}

	/**
	 * Establece el nivel del curso mágico.
	 * 
	 * @param nivelCursoMagico El nivel del curso mágico.
	 */
	public void setNivelCursoMagico(String nivelCursoMagico) {
		this.nivelCursoMagico = nivelCursoMagico;
	}

	/**
	 * Obtiene la duración del curso mágico.
	 * 
	 * @return La duración del curso mágico, en horas.
	 */
	public int getDuracionCursoMagico() {
		return duracionCursoMagico;
	}

	/**
	 * Establece la duración del curso mágico.
	 * 
	 * @param duracionCursoMagico La duración del curso mágico, en horas.
	 */
	public void setDuracionCursoMagico(int duracionCursoMagico) {
		this.duracionCursoMagico = duracionCursoMagico;
	}

	/**
	 * Obtiene el profesor que imparte el curso mágico.
	 * 
	 * @return El profesor que imparte el curso.
	 */
	public Profesor getProfesor() {
		return profesor;
	}

	/**
	 * Establece el profesor que imparte el curso mágico.
	 * 
	 * @param profesor El profesor que imparte el curso.
	 */
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	/**
	 * Obtiene el conjunto de estudiantes inscritos en el curso.
	 * 
	 * @return El conjunto de estudiantes.
	 */
	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	/**
	 * Establece el conjunto de estudiantes inscritos en el curso.
	 * 
	 * @param estudiantes El conjunto de estudiantes.
	 */
	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	/**
	 * Calcula el código hash del curso mágico.
	 * 
	 * @return El código hash del curso mágico.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(duracionCursoMagico, nivelCursoMagico, nombreCursoMagico);
	}

	/**
	 * Compara dos objetos de tipo CursoMagico para determinar si son iguales.
	 * 
	 * @param obj El objeto a comparar con el curso mágico.
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
		CursoMagico other = (CursoMagico) obj;
		return duracionCursoMagico == other.duracionCursoMagico
				&& Objects.equals(nivelCursoMagico, other.nivelCursoMagico)
				&& Objects.equals(nombreCursoMagico, other.nombreCursoMagico);
	}
}