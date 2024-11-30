package controlador;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import dao.CasaMagicaDao;
import dao.CriaturaMagicaDao;
import dao.EventoMagicoDao;
import dao.ProfesorDao;
import modelo.CasaMagica;
import modelo.CriaturaMagica;
import modelo.CursoMagico;
import modelo.Estudiante;
import modelo.EventoMagico;
import modelo.Profesor;

/**
 * Clase principal para gestionar la creación y administración de objetos
 * relacionados con Hogwarts, como casas mágicas, estudiantes, profesores,
 * criaturas mágicas y eventos. Utiliza DAOs para persistir la información en la
 * base de datos y establecer relaciones entre las entidades.
 */
public class GestionaHogwarts {

	/**
	 * Método principal que crea objetos (casas, estudiantes, profesores, cursos,
	 * etc.), los asocia entre sí y los persiste en la base de datos mediante los
	 * DAOs correspondientes.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Instancias de DAOs
		CasaMagicaDao casaMagicaDao = new CasaMagicaDao();
		ProfesorDao profesorDao = new ProfesorDao();
		CriaturaMagicaDao criaturaMagicaDao = new CriaturaMagicaDao();
		EventoMagicoDao eventoMagicoDao = new EventoMagicoDao();

		// Crear casas mágicas
		CasaMagica gryffindor = new CasaMagica("Gryffindor");
		CasaMagica slytherin = new CasaMagica("Slytherin");

		// Crear estudiantes
		Estudiante harry = new Estudiante("Harry Potter", 15, "Intermedio", "Acebo y pluma de fénix");
		Estudiante hermione = new Estudiante("Hermione Granger", 15, "Avanzado", "Vid y nervio de dragón");
		Estudiante draco = new Estudiante("Draco Malfoy", 15, "Intermedio", "Espino y pelo de unicornio");

		// Crear conjunto de estudiantes para casas mágicas
		Set<Estudiante> estudiantesGryffindor = new HashSet<>();
		estudiantesGryffindor.add(harry);
		estudiantesGryffindor.add(hermione);

		Set<Estudiante> estudiantesSlytherin = new HashSet<>();
		estudiantesSlytherin.add(draco);

		// Insertar datos en casas mágicas
		gryffindor.setLemaCasaMagica("El valor y el coraje");
		gryffindor.setPuntuacionTotalCasaMagica(150);
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

		// Asignar cursos a un conjunto
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
		CriaturaMagica hipogrifo = new CriaturaMagica("Buckbeak", "Fantástica", "Feroz pero leal", "Bosques");
		CriaturaMagica basilisco = new CriaturaMagica("Basilisco", "Peligrosa", "Serpiente gigante letal",
				"Cámara Secreta");

		// Crear eventos mágicos
		EventoMagico torneo = new EventoMagico("Torneo de los Tres Magos", "Competencia mágica peligrosa",
				LocalDate.now().plusMonths(3).toString(), "Hogwarts");
		EventoMagico halloween = new EventoMagico("Fiesta de Halloween", "Celebración anual mágica",
				LocalDate.now().plusWeeks(1).toString(), "Gran Comedor");

		casaMagicaDao.create(gryffindor);
		casaMagicaDao.create(slytherin);

		profesorDao.create(dumbledore);
		profesorDao.create(snape);

		criaturaMagicaDao.create(hipogrifo);
		criaturaMagicaDao.create(basilisco);

		eventoMagicoDao.create(torneo);
		eventoMagicoDao.create(halloween);

		torneo.getEstudiantes().add(harry);
		halloween.getEstudiantes().add(draco);
		halloween.getEstudiantes().add(hermione);

		harry.getEventos().add(torneo);
		hermione.getEventos().add(halloween);
		draco.getEventos().add(halloween);

		hipogrifo.getEventos().add(torneo);
		basilisco.getEventos().add(halloween);

		torneo.getCriaturas().add(hipogrifo);
		halloween.getCriaturas().add(basilisco);

		eventoMagicoDao.update(torneo);
		eventoMagicoDao.update(halloween);
	}
}