package servicio;

import java.util.List;
import java.util.Optional;

import dao.CasaMagicaDao;
import dao.CriaturaMagicaDao;
import dao.CursoMagicoDao;
import dao.EstudianteDao;
import dao.EventoMagicoDao;
import dao.ProfesorDao;
import modelo.CasaMagica;
import modelo.CriaturaMagica;
import modelo.CursoMagico;
import modelo.Estudiante;
import modelo.EventoMagico;
import modelo.Profesor;

/**
 * Clase Servicio que actúa como una capa intermedia entre los controladores y
 * los DAOs. Contiene las instancias de los DAOs y proporciona operaciones CRUD
 * para cada modelo.
 */
public class Servicio {
	private CasaMagicaDao casaMagicaDao = new CasaMagicaDao();
	private CriaturaMagicaDao criaturaMagicaDao = new CriaturaMagicaDao();
	private CursoMagicoDao cursoMagicoDao = new CursoMagicoDao();
	private EstudianteDao estudianteDao = new EstudianteDao();
	private EventoMagicoDao eventoMagicoDao = new EventoMagicoDao();
	private ProfesorDao profesorDao = new ProfesorDao();

	/**
	 * Crea una nueva casa mágica.
	 * 
	 * @param casa La casa mágica a crear.
	 */
	public void crearCasaMagica(CasaMagica casa) {
		casaMagicaDao.create(casa);
	}

	/**
	 * Obtiene una casa mágica por su ID.
	 * 
	 * @param id El ID de la casa mágica a obtener.
	 * @return Un Optional que contiene la casa mágica si se encuentra, o
	 *         Optional.empty() si no se encuentra.
	 */
	public Optional<CasaMagica> obtenerCasaMagica(int id) {
		return casaMagicaDao.get(id);
	}

	/**
	 * Obtiene todas las casas mágicas.
	 * 
	 * @return Una lista con todas las casas mágicas.
	 */
	public List<CasaMagica> obtenerTodasLasCasasMagicas() {
		return casaMagicaDao.getAll();
	}

	/**
	 * Actualiza los datos de una casa mágica.
	 * 
	 * @param casa La casa mágica con los datos actualizados.
	 */
	public void actualizarCasaMagica(CasaMagica casa) {
		casaMagicaDao.update(casa);
	}

	/**
	 * Elimina una casa mágica.
	 * 
	 * @param casa La casa mágica a eliminar.
	 */
	public void eliminarCasaMagica(CasaMagica casa) {
		casaMagicaDao.delete(casa);
	}

	// Operaciones CRUD para CriaturaMagica

	/**
	 * Crea una nueva criatura mágica.
	 * 
	 * @param criatura La criatura mágica a crear.
	 */
	public void crearCriaturaMagica(CriaturaMagica criatura) {
		criaturaMagicaDao.create(criatura);
	}

	/**
	 * Obtiene una criatura mágica por su ID.
	 * 
	 * @param id El ID de la criatura mágica a obtener.
	 * @return Un Optional que contiene la criatura mágica si se encuentra, o
	 *         Optional.empty() si no se encuentra.
	 */
	public Optional<CriaturaMagica> obtenerCriaturaMagica(int id) {
		return criaturaMagicaDao.get(id);
	}

	/**
	 * Obtiene todas las criaturas mágicas.
	 * 
	 * @return Una lista con todas las criaturas mágicas.
	 */
	public List<CriaturaMagica> obtenerTodasLasCriaturasMagicas() {
		return criaturaMagicaDao.getAll();
	}

	/**
	 * Actualiza los datos de una criatura mágica.
	 * 
	 * @param criatura La criatura mágica con los datos actualizados.
	 */
	public void actualizarCriaturaMagica(CriaturaMagica criatura) {
		criaturaMagicaDao.update(criatura);
	}

	/**
	 * Elimina una criatura mágica.
	 * 
	 * @param criatura La criatura mágica a eliminar.
	 */
	public void eliminarCriaturaMagica(CriaturaMagica criatura) {
		criaturaMagicaDao.delete(criatura);
	}

	// Operaciones CRUD para CursoMagico

	/**
	 * Crea un nuevo curso mágico.
	 * 
	 * @param curso El curso mágico a crear.
	 */
	public void crearCursoMagico(CursoMagico curso) {
		cursoMagicoDao.create(curso);
	}

	/**
	 * Obtiene un curso mágico por su ID.
	 * 
	 * @param id El ID del curso mágico a obtener.
	 * @return Un Optional que contiene el curso mágico si se encuentra, o
	 *         Optional.empty() si no se encuentra.
	 */
	public Optional<CursoMagico> obtenerCursoMagico(int id) {
		return cursoMagicoDao.get(id);
	}

	/**
	 * Obtiene todos los cursos mágicos.
	 * 
	 * @return Una lista con todos los cursos mágicos.
	 */
	public List<CursoMagico> obtenerTodosLosCursosMagicos() {
		return cursoMagicoDao.getAll();
	}

	/**
	 * Actualiza los datos de un curso mágico.
	 * 
	 * @param curso El curso mágico con los datos actualizados.
	 */
	public void actualizarCursoMagico(CursoMagico curso) {
		cursoMagicoDao.update(curso);
	}

	/**
	 * Elimina un curso mágico.
	 * 
	 * @param curso El curso mágico a eliminar.
	 */
	public void eliminarCursoMagico(CursoMagico curso) {
		cursoMagicoDao.delete(curso);
	}

	// Operaciones CRUD para Estudiante

	/**
	 * Crea un nuevo estudiante.
	 * 
	 * @param estudiante El estudiante a crear.
	 */
	public void crearEstudiante(Estudiante estudiante) {
		estudianteDao.create(estudiante);
	}

	/**
	 * Obtiene un estudiante por su ID.
	 * 
	 * @param id El ID del estudiante a obtener.
	 * @return Un Optional que contiene el estudiante si se encuentra, o
	 *         Optional.empty() si no se encuentra.
	 */
	public Optional<Estudiante> obtenerEstudiante(int id) {
		return estudianteDao.get(id);
	}

	/**
	 * Obtiene todos los estudiantes.
	 * 
	 * @return Una lista con todos los estudiantes.
	 */
	public List<Estudiante> obtenerTodosLosEstudiantes() {
		return estudianteDao.getAll();
	}

	/**
	 * Actualiza los datos de un estudiante.
	 * 
	 * @param estudiante El estudiante con los datos actualizados.
	 */
	public void actualizarEstudiante(Estudiante estudiante) {
		estudianteDao.update(estudiante);
	}

	/**
	 * Elimina un estudiante.
	 * 
	 * @param estudiante El estudiante a eliminar.
	 */
	public void eliminarEstudiante(Estudiante estudiante) {
		estudianteDao.delete(estudiante);
	}

	// Operaciones CRUD para EventoMagico

	/**
	 * Crea un nuevo evento mágico.
	 * 
	 * @param evento El evento mágico a crear.
	 */
	public void crearEventoMagico(EventoMagico evento) {
		eventoMagicoDao.create(evento);
	}

	/**
	 * Obtiene un evento mágico por su ID.
	 * 
	 * @param id El ID del evento mágico a obtener.
	 * @return Un Optional que contiene el evento mágico si se encuentra, o
	 *         Optional.empty() si no se encuentra.
	 */
	public Optional<EventoMagico> obtenerEventoMagico(int id) {
		return eventoMagicoDao.get(id);
	}

	/**
	 * Obtiene todos los eventos mágicos.
	 * 
	 * @return Una lista con todos los eventos mágicos.
	 */
	public List<EventoMagico> obtenerTodosLosEventosMagicos() {
		return eventoMagicoDao.getAll();
	}

	/**
	 * Actualiza los datos de un evento mágico.
	 * 
	 * @param evento El evento mágico con los datos actualizados.
	 */
	public void actualizarEventoMagico(EventoMagico evento) {
		eventoMagicoDao.update(evento);
	}

	/**
	 * Elimina un evento mágico.
	 * 
	 * @param evento El evento mágico a eliminar.
	 */
	public void eliminarEventoMagico(EventoMagico evento) {
		eventoMagicoDao.delete(evento);
	}

	// Operaciones CRUD para Profesor

	/**
	 * Crea un nuevo profesor.
	 * 
	 * @param profesor El profesor a crear.
	 */
	public void crearProfesor(Profesor profesor) {
		profesorDao.create(profesor);
	}

	/**
	 * Obtiene un profesor por su ID.
	 * 
	 * @param id El ID del profesor a obtener.
	 * @return Un Optional que contiene el profesor si se encuentra, o
	 *         Optional.empty() si no se encuentra.
	 */
	public Optional<Profesor> obtenerProfesor(int id) {
		return profesorDao.get(id);
	}

	/**
	 * Obtiene todos los profesores.
	 * 
	 * @return Una lista con todos los profesores.
	 */
	public List<Profesor> obtenerTodosLosProfesores() {
		return profesorDao.getAll();
	}

	/**
	 * Actualiza los datos de un profesor.
	 * 
	 * @param profesor El profesor con los datos actualizados.
	 */
	public void actualizarProfesor(Profesor profesor) {
		profesorDao.update(profesor);
	}

	/**
	 * Elimina un profesor.
	 * 
	 * @param profesor El profesor a eliminar.
	 */
	public void eliminarProfesor(Profesor profesor) {
		profesorDao.delete(profesor);
	}
}