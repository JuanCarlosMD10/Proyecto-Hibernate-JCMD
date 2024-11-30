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
import jakarta.persistence.Table;

/**
 * Representa un evento mágico en el sistema. Un evento tiene un nombre,
 * descripción, fecha, ubicación, y una lista de estudiantes y criaturas mágicas
 * que participan en él. Los estudiantes y las criaturas mágicas pueden estar
 * asociados a múltiples eventos mágicos.
 */
@Entity
@Table(name = "eventos_magicos")
public class EventoMagico {

	/**
	 * Identificador único del evento mágico en la base de datos.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEventoMagico;

	/**
	 * Nombre del evento mágico.
	 */
	private String nombreEventoMagico;

	/**
	 * Descripción del evento mágico.
	 */
	private String descripcionEventoMagico;

	/**
	 * Fecha en la que se celebra el evento mágico.
	 */
	private String fechaEventoMagico;

	/**
	 * Ubicación en la que se lleva a cabo el evento mágico.
	 */
	private String ubicacionEventoMagico;

	/**
	 * Conjunto de estudiantes que participan en el evento mágico. Relación de
	 * muchos a muchos con la clase Estudiante.
	 */
	@ManyToMany
	@JoinTable(name = "eventos_estudiantes", joinColumns = @JoinColumn(name = "id_evento_magico"), inverseJoinColumns = @JoinColumn(name = "id_estudiante"))
	private Set<Estudiante> estudiantes = new HashSet<>();

	/**
	 * Conjunto de criaturas mágicas presentes en el evento. Relación de muchos a
	 * muchos con la clase CriaturaMagica.
	 */
	@ManyToMany
	@JoinTable(name = "eventos_criaturas", joinColumns = @JoinColumn(name = "id_evento_magico"), inverseJoinColumns = @JoinColumn(name = "id_criatura_magica"))
	private Set<CriaturaMagica> criaturas = new HashSet<>();

	/**
	 * Constructor vacío para uso de JPA.
	 */
	public EventoMagico() {
		super();
	}

	/**
	 * Constructor con parámetros para crear un evento mágico.
	 * 
	 * @param nombreEventoMagico      El nombre del evento mágico.
	 * @param descripcionEventoMagico La descripción del evento mágico.
	 * @param fechaEventoMagico       La fecha en que se realiza el evento.
	 * @param ubicacionEventoMagico   La ubicación del evento.
	 */
	public EventoMagico(String nombreEventoMagico, String descripcionEventoMagico, String fechaEventoMagico,
			String ubicacionEventoMagico) {
		super();
		this.nombreEventoMagico = nombreEventoMagico;
		this.descripcionEventoMagico = descripcionEventoMagico;
		this.fechaEventoMagico = fechaEventoMagico;
		this.ubicacionEventoMagico = ubicacionEventoMagico;
	}

	/**
	 * Obtiene el identificador del evento mágico.
	 * 
	 * @return El identificador único del evento mágico.
	 */
	public int getIdEventoMagico() {
		return idEventoMagico;
	}

	/**
	 * Obtiene el nombre del evento mágico.
	 * 
	 * @return El nombre del evento mágico.
	 */
	public String getNombreEventoMagico() {
		return nombreEventoMagico;
	}

	/**
	 * Establece el nombre del evento mágico.
	 * 
	 * @param nombreEventoMagico El nombre del evento mágico.
	 */
	public void setNombreEventoMagico(String nombreEventoMagico) {
		this.nombreEventoMagico = nombreEventoMagico;
	}

	/**
	 * Obtiene la descripción del evento mágico.
	 * 
	 * @return La descripción del evento mágico.
	 */
	public String getDescripcionEventoMagico() {
		return descripcionEventoMagico;
	}

	/**
	 * Establece la descripción del evento mágico.
	 * 
	 * @param descripcionEventoMagico La descripción del evento mágico.
	 */
	public void setDescripcionEventoMagico(String descripcionEventoMagico) {
		this.descripcionEventoMagico = descripcionEventoMagico;
	}

	/**
	 * Obtiene la fecha del evento mágico.
	 * 
	 * @return La fecha del evento mágico.
	 */
	public String getFechaEventoMagico() {
		return fechaEventoMagico;
	}

	/**
	 * Establece la fecha del evento mágico.
	 * 
	 * @param fechaEventoMagico La fecha del evento mágico.
	 */
	public void setFechaEventoMagico(String fechaEventoMagico) {
		this.fechaEventoMagico = fechaEventoMagico;
	}

	/**
	 * Obtiene la ubicación del evento mágico.
	 * 
	 * @return La ubicación del evento mágico.
	 */
	public String getUbicacionEventoMagico() {
		return ubicacionEventoMagico;
	}

	/**
	 * Establece la ubicación del evento mágico.
	 * 
	 * @param ubicacionEventoMagico La ubicación del evento mágico.
	 */
	public void setUbicacionEventoMagico(String ubicacionEventoMagico) {
		this.ubicacionEventoMagico = ubicacionEventoMagico;
	}

	/**
	 * Obtiene el conjunto de estudiantes que participan en el evento mágico.
	 * 
	 * @return El conjunto de estudiantes que participan en el evento.
	 */
	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	/**
	 * Establece el conjunto de estudiantes que participan en el evento mágico.
	 * 
	 * @param estudiantes El conjunto de estudiantes que participan en el evento.
	 */
	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	/**
	 * Obtiene el conjunto de criaturas mágicas que participan en el evento.
	 * 
	 * @return El conjunto de criaturas mágicas en el evento.
	 */
	public Set<CriaturaMagica> getCriaturas() {
		return criaturas;
	}

	/**
	 * Establece el conjunto de criaturas mágicas que participan en el evento.
	 * 
	 * @param criaturas El conjunto de criaturas mágicas del evento.
	 */
	public void setCriaturas(Set<CriaturaMagica> criaturas) {
		this.criaturas = criaturas;
	}

	/**
	 * Calcula el código hash del evento mágico.
	 * 
	 * @return El código hash del evento mágico.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(descripcionEventoMagico, fechaEventoMagico, nombreEventoMagico, ubicacionEventoMagico);
	}

	/**
	 * Compara dos objetos de tipo EventoMagico para determinar si son iguales.
	 * 
	 * @param obj El objeto a comparar con el evento mágico.
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
		EventoMagico other = (EventoMagico) obj;
		return Objects.equals(descripcionEventoMagico, other.descripcionEventoMagico)
				&& Objects.equals(fechaEventoMagico, other.fechaEventoMagico)
				&& Objects.equals(nombreEventoMagico, other.nombreEventoMagico)
				&& Objects.equals(ubicacionEventoMagico, other.ubicacionEventoMagico);
	}
}