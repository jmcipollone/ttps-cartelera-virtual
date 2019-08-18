/**
 * 
 */
package daos.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import daos.CarteleraDao;
import modelos.Cartelera;
import modelos.Tag;

/**
 * Clase que modela los objetos DAOs responsables del almacenamiento y recuperación de los objetos Cartelera en la BD.
 * 
 * @author Juan Manuel Cipollone
 */
@Repository("carteleraDao")
@Transactional
public class CarteleraDaoJpa extends EntidadDaoJpa<Cartelera> implements CarteleraDao {
	
	// Constructores
	
	public CarteleraDaoJpa() {
		super(Cartelera.class);
	}
	
	// Metodos de recuperación de una cartelera
	
	
	/**
	 * Recupera la cartelera con el identificador dado.
	 * 
	 * Además inicializa las colecciones que podria llegar a necesitar.
	 * 
	 * @param long id
	 * @return
	 */
	public Cartelera recuperar(long id)
	{
		Cartelera cartelera;		
		try {
			Query q = this.em.createQuery("SELECT c, t FROM Cartelera c JOIN FETCH c.tags t WHERE c.id = :id");
			q.setParameter("id", id);
			cartelera = (Cartelera) q.getSingleResult();
			return cartelera;			
		} catch(NonUniqueResultException ex1) {
			return null;			
		} catch (NoResultException ex2) {
			return null;
		}
	}

	/**
	 * Recupera la cartelera con el nombre dado. Si no existe, retorna nulo.
	 * 
	 * @param String nombre
	 * @return Cartelera
	 */
	@Override
	public Cartelera recuperarPorNombre(String nombre) {
		Cartelera cartelera;		
		try {
			Query q = this.em.createQuery("SELECT c FROM Cartelera c WHERE c.nombre = :nombre");
			q.setParameter("nombre", nombre);
			cartelera = (Cartelera) q.getSingleResult();
			return cartelera;			
		} catch(NonUniqueResultException ex1) {
			return null;			
		} catch (NoResultException ex2) {
			return null;
		}
	}

	
	// Metodos de recuperacion de una coleccion de carteleras

	/**
	 * Recuperar todas las carteleras.
	 * 
	 * @return List<Cartelera>
	 */
	@Override
	public List<Cartelera> recuperarTodas() {		
		TypedQuery<Cartelera> q = this.em.createQuery("SELECT c FROM Cartelera c", Cartelera.class);		
		List<Cartelera> carteleras = q.getResultList();		
		
		return carteleras;
	}

	/**
	 * Recuperar las carteleras habilitadas.
	 * 
	 * @return List<Cartelera>
	 */
	@Override
	public List<Cartelera> recuperarHabilitadas() {
		TypedQuery<Cartelera> q = this.em.createQuery("SELECT c FROM Cartelera c WHERE c.habilitada = :flag", Cartelera.class);
		q.setParameter("flag", Boolean.TRUE);
		List<Cartelera> carteleras = q.getResultList();
		
		return carteleras;
	}
	
	/**
	 * Recuperar las carteleras cuyo nombre contiene el texto especificado.
	 * 
	 * @return List<Cartelera>
	 */
	@Override
	public List<Cartelera> recuperarConTexto(String texto) {
		TypedQuery<Cartelera> q = this.em.createQuery("SELECT c FROM Cartelera c WHERE c.nombre LIKE :texto", Cartelera.class);
		q.setParameter("texto", "%" + texto + "%");
		List<Cartelera> carteleras = q.getResultList();
				
		return carteleras;
	}

	/**
	 * Recuperar las carteleras con al menos uno de los tags asignados.
	 * 
	 * @return List<Cartelera>
	 */
	@Override
	public List<Cartelera> recuperarConTags(List<Tag> tags) {
		TypedQuery<Cartelera> q = this.em.createQuery(
			"SELECT DISTINCT c "
			+ "FROM Cartelera c INNER JOIN c.tags t "
			+ "WHERE t.id IN :tagsIds", 
			Cartelera.class
		);		
		// Recuperar los IDs de los tags dados
		List<Long> tagsIds = new ArrayList<Long>();
		for (Tag tag : tags) {
			tagsIds.add(tag.getId());			
		}		
		// Setear parametro a la consulta JPQL
		q.setParameter("tagsIds", tagsIds);		
		// Ejecutar consulta JPQL
		List<Cartelera> carteleras = q.getResultList();
				
		return carteleras;
	}
	

}
