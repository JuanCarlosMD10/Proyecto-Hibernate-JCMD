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

	// Operaciones CRUD

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

	// Métodos avanzados

	// CasaMagicaDao
	/**
	 * Obtiene la primera casa mágica almacenada en la base de datos.
	 * 
	 * Esta consulta limita el número de resultados devueltos a 1 y ordena las casas
	 * mágicas por su identificador en orden ascendente.
	 * 
	 * @return La primera casa mágica encontrada en la base de datos.
	 */
	public CasaMagica obtenerPrimeraCasaMagica() {
		return casaMagicaDao.obtenerPrimeraCasaMagica();
	}

	/**
	 * Obtiene una lista con los nombres de las casas mágicas cuya puntuación total
	 * es mayor que el valor especificado.
	 * 
	 * Esta consulta filtra las casas mágicas en función de su puntuación y devuelve
	 * únicamente sus nombres.
	 * 
	 * @param minPuntuacion La puntuación mínima requerida.
	 * @return Una lista de nombres de casas mágicas que cumplen con la condición.
	 */
	public List<String> obtenerCasasConPuntuacionMayor(int minPuntuacion) {
		return casaMagicaDao.obtenerCasasConPuntuacionMayor(minPuntuacion);
	}

	// EstudianteDao
	/**
	 * Obtiene una lista con los nombres de todos los estudiantes registrados en la
	 * base de datos.
	 * 
	 * Esta consulta devuelve únicamente el campo del nombre de los estudiantes.
	 * 
	 * @return Una lista con los nombres de todos los estudiantes.
	 */
	public List<Estudiante> obtenerNombresEstudiantes() {
		return estudianteDao.obtenerNombresEstudiantes();
	}

	/**
	 * Obtiene una lista con los nombres y las edades de todos los estudiantes
	 * registrados en la base de datos.
	 * 
	 * Esta consulta devuelve múltiples campos (nombre y edad) de cada estudiante.
	 * 
	 * @return Una lista de arrays de objetos, donde cada array contiene el nombre y
	 *         la edad de un estudiante.
	 */
	public List<Estudiante[]> obtenerNombresYEdadesEstudiantes() {
		return estudianteDao.obtenerNombresYEdadesEstudiantes();
	}

	/**
	 * Obtiene una lista con los nombres de los estudiantes que pertenecen a una
	 * casa mágica específica.
	 * 
	 * Esta consulta está parametrizada para filtrar los estudiantes según el
	 * identificador de su casa.
	 * 
	 * @param idCasa El identificador de la casa mágica.
	 * @return Una lista con los nombres de los estudiantes que pertenecen a la casa
	 *         especificada.
	 */
	public List<Estudiante> obtenerEstudiantesPorCasa(int idCasa) {
		return estudianteDao.obtenerEstudiantesPorCasa(idCasa);
	}

	/**
	 * Calcula el promedio de edad de todos los estudiantes registrados en la base
	 * de datos.
	 * 
	 * Esta consulta utiliza la función de agregación AVG para obtener el promedio.
	 * 
	 * @return El promedio de edad de los estudiantes como un valor decimal.
	 */
	public Double obtenerPromedioEdadEstudiantes() {
		return estudianteDao.obtenerPromedioEdadEstudiantes();
	}

	// CursoMagicoDao
	/**
	 * Cuenta el número total de cursos mágicos registrados en la base de datos.
	 * 
	 * Esta consulta utiliza la función de agregación COUNT para calcular la
	 * cantidad.
	 * 
	 * @return El número total de cursos mágicos registrados.
	 */
	public Long contarCursosMagicos() {
		return cursoMagicoDao.contarCursosMagicos();
	}

	// EventoMagicoDao
	/**
	 * Obtiene una lista de eventos mágicos que se llevan a cabo en una ubicación
	 * específica, ordenados por fecha.
	 * 
	 * Esta consulta filtra los eventos mágicos según su ubicación y los ordena en
	 * orden ascendente por su fecha.
	 * 
	 * @param ubicacion La ubicación específica donde se realizarán los eventos.
	 * @return Una lista de arrays de objetos, donde cada array contiene el nombre y
	 *         la fecha de un evento mágico.
	 */
	public List<EventoMagico[]> obtenerEventosPorUbicacionOrdenados(String ubicacion) {
		return eventoMagicoDao.obtenerEventosPorUbicacionOrdenados(ubicacion);
	}

	// Ejercicios con CriteriaBuilder
	/**
	 * Actualiza la puntuación total de una casa mágica específica basada en su
	 * nombre.
	 * 
	 * Esta operación utiliza CriteriaBuilder para construir dinámicamente una
	 * consulta de actualización.
	 * 
	 * @param nuevaPuntuacion La nueva puntuación a asignar a la casa.
	 * @param nombreCasa      El nombre de la casa mágica cuyo valor será
	 *                        actualizado.
	 */
	public void actualizarPuntuacionCasa(int nuevaPuntuacion, String nombreCasa) {
		casaMagicaDao.actualizarPuntuacionCasa(nuevaPuntuacion, nombreCasa);
	}

	/**
	 * Elimina un estudiante de la base de datos según su nombre.
	 * 
	 * Esta operación utiliza CriteriaBuilder para construir dinámicamente una
	 * consulta de eliminación.
	 * 
	 * @param nombreEstudiante El nombre del estudiante que será eliminado.
	 */
	public void eliminarEstudiantePorNombre(String nombreEstudiante) {
		estudianteDao.eliminarEstudiantePorNombre(nombreEstudiante);
	}

}