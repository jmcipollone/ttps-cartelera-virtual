package daos.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import daos.EntidadDao;

/**
 * Clase genérica DAO
 * 
 * Provee una implementación predeterminada para los mensajes definidos en la interfaz generida DAO.
 * 
 * @author Juan Manuel Cipollone
 */
@Transactional
public class EntidadDaoJpa<T> implements EntidadDao<T> {
	
	// Propiedades
	
	@PersistenceContext
	protected EntityManager em;
	
	protected Class<T> clase;
	
	// Constructores
	
	public EntidadDaoJpa(Class<T> clasePersistente) {
		this.clase = clasePersistente;
	}
	
	
	// Getters/setters
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Class<T> getClase() {
		return clase;
	}

	public void setClase(Class<T> clase) {
		this.clase = clase;
	}
	
	// Metodos de creacion
	
	@Override	
	public T persistir(T entidad) {
		this.em.persist(entidad);
		return entidad;		
	}
	
	// Metodos de actualizacion

	@Override
	public T actualizar(T entidad) {
		return this.em.merge(entidad);		
	}
	
	// Metodos de borrado

	@Override
	public void borrar(T entidad) {
		this.em.remove(entidad);		
	}

	@Override
	public T borrar(Serializable id) {
		T entidad = this.recuperar(id);
		if (entidad != null) {
			this.borrar(entidad);
		}
		return entidad;		
	}
	
	// Metodos de lectura

	@Override
	public T recuperar(Serializable id) {
		return this.em.find(this.clase, id);		
	}
	
	// Metodos de comprobacion

	@Override
	public boolean existe(Serializable id) {
		return this.recuperar(id) != null;
	}
	

}
