package dao;

import java.util.List;
import java.util.Optional;

/**
 * Esta interfaz define las operaciones básicas del patrón CRUD (Crear, Leer,
 * Actualizar, Eliminar) para una entidad genérica.
 * 
 * Las implementaciones de esta interfaz proporcionarán la lógica necesaria para
 * interactuar con una fuente de datos (como una base de datos) y permitirán la
 * realización de las siguientes operaciones:
 * 
 * @param <T> el tipo de la entidad sobre la que se realizarán las operaciones
 *            CRUD.
 */
public interface InterfazDao<T> {

	/**
	 * Crea un nuevo elemento en la base de datos.
	 *
	 * @param t el objeto que se desea crear.
	 */
	void create(T t);

	/**
	 * Obtiene un elemento de la base de datos por su identificador único.
	 * 
	 * La consulta puede no devolver ningún resultado.
	 *
	 * @param id el identificador único del elemento a obtener.
	 * @return puede contener el objeto encontrado o estar vacío si no se encuentra.
	 */
	Optional<T> get(int id);

	/**
	 * Obtiene todos los elementos de la base de datos.
	 *
	 * @return una lista de objetos que representa todos los elementos almacenados.
	 */
	List<T> getAll();

	/**
	 * Actualiza un elemento existente en la base de datos.
	 * 
	 * @param t el objeto con los nuevos datos a actualizar.
	 */
	void update(T t);

	/**
	 * Elimina un elemento de la base de datos.
	 * 
	 * @param t el objeto que se desea eliminar.
	 */
	void delete(T t);
}