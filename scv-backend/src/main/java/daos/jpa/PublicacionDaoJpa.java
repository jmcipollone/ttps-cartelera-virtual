package daos.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import daos.PublicacionDao;
import modelos.Cartelera;
import modelos.Publicacion;
import modelos.Tag;
import modelos.Usuario;


/**
 * Clase que modela DAOs responsables del almacenamiento y recuperacion de las publicaciones en la BD
 * 
 * @author Juan Manuel Cipollone
 */
@Repository("publicacionDao")
@Transactional
public class PublicacionDaoJpa extends EntidadDaoJpa<Publicacion> implements PublicacionDao {

	// Constructores
	
	public PublicacionDaoJpa() {
		super(Publicacion.class);
	}	
	
	// Metodos de recuperacion de publicaciones
	
	/**
	 * Recupera todas las publicaciones registradas.
	 * 
	 * @return List<Publicacion>
	 */
	@Override
	public List<Publicacion> recuperarTodas() {
		TypedQuery<Publicacion> q = this.em.createQuery("SELECT p FROM Publicacion p", Publicacion.class);
		List<Publicacion> publicaciones = q.getResultList();
		
		return publicaciones;
	}

	/**
	 * Recupera las publicaciones pertenecientes a la cartelera dada.
	 * 
	 * @param Cartelera cartelera
	 * @return List<Publicacion>
	 */
	@Override
	public List<Publicacion> recuperarPorCartelera(Cartelera cartelera) {
		TypedQuery<Publicacion> q = this.em.createQuery(
				"SELECT p FROM Publicacion p JOIN p.cartelera c WHERE c.id = :carteleraId", 
				Publicacion.class
		);
		q.setParameter("carteleraId", cartelera.getId());
		List<Publicacion> publicaciones = q.getResultList();
		
		return publicaciones;
	}

	/**
	 * Recupera las publicaciones realizadas por el usuario dado.
	 * 
	 * @param Usuario autor
	 * @return List<Publicacion>
	 */
	@Override
	public List<Publicacion> recuperarPorAutor(Usuario autor) {
		TypedQuery<Publicacion> q = this.em.createQuery(
				"SELECT p FROM Publicacion p JOIN p.autor a WHERE a.id = :autorId", 
				Publicacion.class
		);
		q.setParameter("autorId", autor.getId());
		List<Publicacion> publicaciones = q.getResultList();
		
		return publicaciones;
	}

	/**
	 * Recupera las publicaciones con al menos uno de los tags dados.
	 * 
	 * @param List<Tag> tags
	 * @return List<Publicacion>
	 */
	@Override
	public List<Publicacion> recuperarConTags(List<Tag> tags) {
		TypedQuery<Publicacion> q = this.em.createQuery(
				"SELECT DISTINCT p "
				+ "FROM Publicacion p INNER JOIN p.tags t "
				+ "WHERE t.id IN :tagsIds", 
				Publicacion.class
		);
		// Recuperar los IDs de los tags dados
		List<Long> tagsIds = new ArrayList<Long>();
		for (Tag tag : tags) {
			tagsIds.add(tag.getId());			
		}		
		// Setear parametro a la consulta JPQL
		q.setParameter("tagsIds", tagsIds);		
		// Ejecutar consulta JPQL
		List<Publicacion> publicaciones = q.getResultList();
		
		return publicaciones;
	}

	/**
	 * Recupera las publicaciones que contienen el string dado en su titulo.
	 * 
	 * @param String titulo
	 * @return List<Publicacion>
	 */
	@Override
	public List<Publicacion> recuperarPorTitulo(String titulo) {
		TypedQuery<Publicacion> q = this.em.createQuery(
				"SELECT p FROM Publicacion p WHERE p.titulo LIKE :titulo", 
				Publicacion.class
		);
		q.setParameter("titulo", "%" + titulo + "%");
		List<Publicacion> publicaciones = q.getResultList(); 
		
		return publicaciones;
	}

}
