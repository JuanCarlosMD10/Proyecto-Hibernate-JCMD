package controlador;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import modelo.CasaMagica;
import modelo.CriaturaMagica;
import modelo.CursoMagico;
import modelo.Estudiante;
import modelo.EventoMagico;
import modelo.Profesor;
import servicio.Servicio;

/**
 * Clase principal del controlador que gestiona la creación, actualización y
 * consulta de diversos objetos mágicos dentro de la aplicación. Realiza las
 * operaciones de CRUD (crear, leer, actualizar, eliminar) sobre casas mágicas,
 * profesores, criaturas mágicas, estudiantes, eventos y cursos mágicos.
 * 
 * Esta clase simula un sistema para gestionar el mundo mágico inspirado en el
 * universo de Harry Potter.
 * 
 * @author Juan Carlos Mejías Doñoro
 * @version 1.0
 */
public class Controlador {

	/**
	 * Método principal que instancia y configura el sistema, creando casas mágicas,
	 * estudiantes, profesores, cursos, criaturas mágicas y eventos. Además, realiza
	 * operaciones de CRUD utilizando el servicio.
	 * 
	 * @param args Argumentos de la línea de comandos (no utilizados en este caso).
	 */
	public static void main(String[] args) {
		// Instancia de la capa servicio
		Servicio servicio = new Servicio();

		// Crear casas mágicas
		CasaMagica gryffindor = new CasaMagica("Gryffindor");
		CasaMagica slytherin = new CasaMagica("Slytherin");

		// Crear estudiantes
		Estudiante harry = new Estudiante("Harry Potter", 14, "Intermedio", "Acebo y pluma de fénix");
		Estudiante hermione = new Estudiante("Hermione Granger", 15, "Avanzado", "Vid y nervio de dragón");
		Estudiante draco = new Estudiante("Draco Malfoy", 13, "Intermedio", "Espino y pelo de unicornio");

		// Crear conjunto de estudiantes para casas mágicas
		Set<Estudiante> estudiantesGryffindor = new HashSet<>();
		estudiantesGryffindor.add(harry);
		estudiantesGryffindor.add(hermione);

		Set<Estudiante> estudiantesSlytherin = new HashSet<>();
		estudiantesSlytherin.add(draco);

		// Insertar datos en casas mágicas
		gryffindor.setLemaCasaMagica("El valor y el coraje");
		gryffindor.setPuntuacionTotalCasaMagica(100);
		gryffindor.setEstudiantes(estudiantesGryffindor);
		harry.setCasa(gryffindor);
		hermione.setCasa(gryffindor);
		slytherin.setLemaCasaMagica("La ambición y la astucia");
		slytherin.setPuntuacionTotalCasaMagica(120);
		slytherin.setEstudiantes(estudiantesSlytherin);
		draco.setCasa(slytherin);

		// Crear cursos mágicos
		CursoMagico defensaOscuras = new CursoMagico("Defensa Contra las Artes Oscuras", "Avanzado", 6);
		CursoMagico pociones = new CursoMagico("Pociones", "Intermedio", 6);

		// Crear conjunto de estudiantes para cursos
		Set<CursoMagico> cursosDumbledore = new HashSet<>();
		cursosDumbledore.add(defensaOscuras);

		Set<CursoMagico> cursosSnape = new HashSet<>();
		cursosSnape.add(pociones);

		// Relacionar estudiantes con cursos mágicos
		harry.getCursos().add(defensaOscuras);
		hermione.getCursos().add(defensaOscuras);
		defensaOscuras.getEstudiantes().add(harry);
		defensaOscuras.getEstudiantes().add(hermione);

		// Crear profesores con cursos y casas mágicas
		Profesor dumbledore = new Profesor("Albus Dumbledore", "Magia Avanzada", "Experto", 50, cursosDumbledore);
		dumbledore.setCasa(gryffindor);
		defensaOscuras.setProfesor(dumbledore);

		Profesor snape = new Profesor("Severus Snape", "Pociones", "Experto", 25, cursosSnape);
		snape.setCasa(slytherin);
		pociones.setProfesor(snape);

		// Crear criaturas mágicas
		CriaturaMagica colacuernoHungaro = new CriaturaMagica("Colacuerno Húngaro", "Fantástica",
				"Dragón muy agresivo con llamas mortales", "Montañas de Hungría");
		CriaturaMagica hedwig = new CriaturaMagica("Hedwig", "Mágica",
				"Lechuza blanca de ojos dorados que es la compañera leal de Harry Potter",
				"Hogwarts y la casa de los Dursley");
		CriaturaMagica basilisco = new CriaturaMagica("Basilisco", "Peligrosa", "Serpiente gigante letal",
				"Cámara Secreta");

		// Crear eventos mágicos
		EventoMagico torneo = new EventoMagico("Torneo de los Tres Magos",
				"Competencia estudiantil con desafíos mágicos variados", LocalDate.now().plusMonths(3).toString(),
				"Campo de Quidditch");
		EventoMagico halloween = new EventoMagico("Fiesta de Halloween",
				"Celebración mágica con disfraces y comida especial", LocalDate.now().plusWeeks(1).toString(),
				"Jardines de Hogwarts");
		EventoMagico guerra = new EventoMagico("Guerra de Hogwarts",
				"Guerra entre el ejército de Voldemort y el de Harry Potter", LocalDate.now().plusMonths(6).toString(),
				"Hogwarts");

		// Crear registros en la base de datos usando el servicio
		servicio.crearCasaMagica(gryffindor);
		servicio.crearCasaMagica(slytherin);

		servicio.crearProfesor(dumbledore);
		servicio.crearProfesor(snape);

		servicio.crearCriaturaMagica(colacuernoHungaro);
		servicio.crearCriaturaMagica(hedwig);
		servicio.crearCriaturaMagica(basilisco);

		servicio.crearEventoMagico(torneo);
		servicio.crearEventoMagico(halloween);
		servicio.crearEventoMagico(guerra);

		// Asignar estudiantes a eventos
		torneo.getEstudiantes().add(harry);
		halloween.getEstudiantes().add(draco);
		halloween.getEstudiantes().add(hermione);
		guerra.getEstudiantes().add(harry);
		guerra.getEstudiantes().add(hermione);
		guerra.getEstudiantes().add(draco);

		harry.getEventos().add(torneo);
		hermione.getEventos().add(halloween);
		draco.getEventos().add(halloween);
		harry.getEventos().add(guerra);
		hermione.getEventos().add(guerra);
		draco.getEventos().add(guerra);

		// Asignar criaturas a eventos
		colacuernoHungaro.getEventos().add(torneo);
		hedwig.getEventos().add(halloween);

		torneo.getCriaturas().add(colacuernoHungaro);
		halloween.getCriaturas().add(hedwig);

		// Eliminar el basilisco de la base de datos
		servicio.eliminarCriaturaMagica(basilisco);

		// Actualizar registros en la base de datos usando el servicio
		// Actualizar valores de las casas mágicas
		gryffindor.setLemaCasaMagica("El coraje y la amistad son nuestra fuerza");
		gryffindor.setPuntuacionTotalCasaMagica(49);
		slytherin.setLemaCasaMagica("La astucia y la ambición nos definen");
		// Actualizar casas mágicas
		servicio.actualizarCasaMagica(gryffindor);
		servicio.actualizarCasaMagica(slytherin);

		// Actualizar valores de los profesores
		dumbledore.setEspecialidadProfesor("Encantamientos y duelos mágicos");
		dumbledore.setExperienciaProfesor(60);
		snape.setEspecialidadProfesor("Pociones y magia oscura");
		// Actualizar profesores
		servicio.actualizarProfesor(dumbledore);
		servicio.actualizarProfesor(snape);

		// Actualizar valores de las criaturas mágicas
		colacuernoHungaro.setDescripcionCriaturaMagica("Dragón feroz con escamas blindadas y fuego más intenso");
		// Actualizar criaturas mágicas
		servicio.actualizarCriaturaMagica(colacuernoHungaro);

		// Actualizar valores de los eventos mágicos
		torneo.setDescripcionEventoMagico("Competencia mágica peligrosa");
		torneo.setUbicacionEventoMagico("Hogwarts");
		halloween.setDescripcionEventoMagico("Celebración anual mágica");
		halloween.setUbicacionEventoMagico("Gran Comedor");
		// Actualizar eventos mágicos
		servicio.actualizarEventoMagico(torneo);
		servicio.actualizarEventoMagico(halloween);

		// Actualizar valores de los estudiantes
		harry.setNivelMagicoEstudiante("Avanzado");
		harry.setVaritaEstudiante("Acebo y pluma de fénix (mejorada)");
		hermione.setNivelMagicoEstudiante("Experto");
		hermione.setVaritaEstudiante("Vid y nervio de dragón (potenciada)");
		draco.setNivelMagicoEstudiante("Avanzado");
		draco.setVaritaEstudiante("Espino y pelo de unicornio (reforzada)");
		// Actualizar estudiantes
		servicio.actualizarEstudiante(harry);
		servicio.actualizarEstudiante(hermione);
		servicio.actualizarEstudiante(draco);

		// Actualizar valores de los cursos mágicos
		defensaOscuras.setNivelCursoMagico("Experto");
		defensaOscuras.setDuracionCursoMagico(12);
		pociones.setNivelCursoMagico("Avanzado");
		// Actualizar cursos mágicos
		servicio.actualizarCursoMagico(defensaOscuras);
		servicio.actualizarCursoMagico(pociones);

		// Leer todas las casas mágicas
		List<CasaMagica> casasMagicas = servicio.obtenerTodasLasCasasMagicas();
		for (int i = 0; i < casasMagicas.size(); i++) {
			CasaMagica casa = casasMagicas.get(i);
			System.out.println("Casa Mágica: " + casa.getNombreCasaMagica());
		}

		// Leer una casa mágica específica por ID (ejemplo: id 1)
		Optional<CasaMagica> casaGryffindor = servicio.obtenerCasaMagica(1);
		if (casaGryffindor.isPresent()) {
			CasaMagica casa = casaGryffindor.get();
			System.out.println("Casa Mágica (ID 1): " + casa.getNombreCasaMagica());
		}

		// Leer todos los profesores
		List<Profesor> profesores = servicio.obtenerTodosLosProfesores();
		for (int i = 0; i < profesores.size(); i++) {
			Profesor profesor = profesores.get(i);
			System.out.println("Profesor: " + profesor.getNombreProfesor());
		}

		// Leer un profesor específico por ID (ejemplo: id 1)
		Optional<Profesor> profesorDumbledore = servicio.obtenerProfesor(1);
		if (profesorDumbledore.isPresent()) {
			Profesor profesor = profesorDumbledore.get();
			System.out.println("Profesor (ID 1): " + profesor.getNombreProfesor());
		}

		// Leer todas las criaturas mágicas
		List<CriaturaMagica> criaturas = servicio.obtenerTodasLasCriaturasMagicas();
		for (int i = 0; i < criaturas.size(); i++) {
			CriaturaMagica criatura = criaturas.get(i);
			System.out.println("Criatura Mágica: " + criatura.getNombreCriaturaMagica());
		}

		// Leer una criatura mágica específica por ID (ejemplo: id 1)
		Optional<CriaturaMagica> criaturaColacuerno = servicio.obtenerCriaturaMagica(1);
		if (criaturaColacuerno.isPresent()) {
			CriaturaMagica criatura = criaturaColacuerno.get();
			System.out.println("Criatura Mágica (ID 1): " + criatura.getNombreCriaturaMagica());
		}

		// Leer todos los cursos mágicos
		List<CursoMagico> cursos = servicio.obtenerTodosLosCursosMagicos();
		for (int i = 0; i < cursos.size(); i++) {
			CursoMagico curso = cursos.get(i);
			System.out.println("Curso Mágico: " + curso.getNombreCursoMagico());
		}

		// Leer un curso mágico específico por ID (ejemplo: id 1)
		Optional<CursoMagico> cursoDefensaOscuras = servicio.obtenerCursoMagico(1);
		if (cursoDefensaOscuras.isPresent()) {
			CursoMagico curso = cursoDefensaOscuras.get();
			System.out.println("Curso Mágico (ID 1): " + curso.getNombreCursoMagico());
		}

		// Leer todos los estudiantes
		List<Estudiante> estudiantes = servicio.obtenerTodosLosEstudiantes();
		for (int i = 0; i < estudiantes.size(); i++) {
			Estudiante estudiante = estudiantes.get(i);
			System.out.println("Estudiante: " + estudiante.getNombreEstudiante());
		}

		// Leer un estudiante específico por ID (ejemplo: id 1)
		Optional<Estudiante> estudianteHarry = servicio.obtenerEstudiante(1);
		if (estudianteHarry.isPresent()) {
			Estudiante estudiante = estudianteHarry.get();
			System.out.println("Estudiante (ID 1): " + estudiante.getNombreEstudiante());
		}

		// Leer todos los eventos mágicos
		List<EventoMagico> eventos = servicio.obtenerTodosLosEventosMagicos();
		for (int i = 0; i < eventos.size(); i++) {
			EventoMagico evento = eventos.get(i);
			System.out.println("Evento Mágico: " + evento.getNombreEventoMagico());
		}

		// Leer un evento mágico específico por ID (ejemplo: id 1)
		Optional<EventoMagico> eventoTorneo = servicio.obtenerEventoMagico(1);
		if (eventoTorneo.isPresent()) {
			EventoMagico evento = eventoTorneo.get();
			System.out.println("Evento Mágico (ID 1): " + evento.getNombreEventoMagico());
		}

		// Llamadas a consultas
		CasaMagica primeraCasa = servicio.obtenerPrimeraCasaMagica();
		System.out.println("Primera casa mágica: " + primeraCasa.getNombreCasaMagica());

		List<String> casasConAltaPuntuacion = servicio.obtenerCasasConPuntuacionMayor(50);
		System.out.println("Casas con puntuación mayor a 50: " + casasConAltaPuntuacion);

		List<Estudiante> nombresEstudiantes = servicio.obtenerNombresEstudiantes();
		System.out.println("Nombres de los estudiantes: " + nombresEstudiantes);

		List<Estudiante[]> nombresYEdades = servicio.obtenerNombresYEdadesEstudiantes();
		for (Object[] datos : nombresYEdades) {
			System.out.println("Estudiante: " + datos[0] + ", Edad: " + datos[1]);
		}

		List<Estudiante> estudiantesDeCasa = servicio.obtenerEstudiantesPorCasa(1);
		System.out.println("Estudiantes de la Casa con ID 1: " + estudiantesDeCasa);

		Double promedioEdad = servicio.obtenerPromedioEdadEstudiantes();
		System.out.println("Promedio de edad de los estudiantes: " + promedioEdad);

		Long totalCursos = servicio.contarCursosMagicos();
		System.out.println("Total de cursos mágicos: " + totalCursos);

		List<EventoMagico[]> eventosEnLugar = servicio.obtenerEventosPorUbicacionOrdenados("Hogwarts");
		for (Object[] evento : eventosEnLugar) {
			System.out.println("Evento: " + evento[0] + ", Fecha: " + evento[1]);
		}

		// Llamada al servicio para los ejercicios con CriteriaBuilder
		// Actualizar la puntuación de una casa mágica
		servicio.actualizarPuntuacionCasa(200, "Gryffindor");
		// Eliminar un estudiante pasándole el nombre
		servicio.eliminarEstudiantePorNombre("Draco Malfoy");
	}
}