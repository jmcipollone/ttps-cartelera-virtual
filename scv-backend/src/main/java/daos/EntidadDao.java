package daos;

import java.io.Serializable;

/**
 * Interfaz genérica DAO
 * 
 * Define el conjunto de mensajes que entiende cualquier objeto de interacción con la BD (DAOs).
 * 
 * @author Juan Manuel Cipollone
 */
public interface EntidadDao<T> {
	
	// Metodos de creacion
	
	public T persistir(T entidad);
	
	// Metodos de actualizacion
	
	public T actualizar(T entidad);
	
	// Metodos de borrado
	
	public void borrar(T entidad);
	public T borrar(Serializable id);
	
	// Metodos de lectura
	
	public T recuperar(Serializable id);
	
	// Metodos de comprobacion
	
	public boolean existe(Serializable id);
		
}
