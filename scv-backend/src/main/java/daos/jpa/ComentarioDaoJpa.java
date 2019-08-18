package daos.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import daos.ComentarioDao;
import modelos.Comentario;
import modelos.Publicacion;
import modelos.Usuario;

/**
 * DAO responsable del almacenamiento y recuperación de comentarios desde la BD.
 * 
 * @author Juan Manuel Cipollone
 */
@Repository("comentarioDao")
@Transactional
public class ComentarioDaoJpa extends EntidadDaoJpa<Comentario> implements ComentarioDao {

	// Constructor 
	
	public ComentarioDaoJpa() {
		super(Comentario.class);
	}
	
	
	// Metodos de recuperacion de comentarios
	
	/**
	 * Recupera los comentarios de la publicacion dada.
	 * 
	 * @param Publicacion publicacion
	 * @return List<Comentario>
	 */
	@Override
	public List<Comentario> recuperarPorPublicacion(Publicacion publicacion) {
		TypedQuery<Comentario> q = this.em.createQuery(
			"SELECT co FROM Comentario co JOIN co.publicacion p WHERE p.id = :publicacionId", 
			Comentario.class
		);
		q.setParameter("publicacionId", publicacion.getId());
		List<Comentario> comentarios = q.getResultList();
		
		return comentarios;
	}

	/**
	 * Recupera los comentarios del autor dado.
	 * 
	 * @param Usuario autor
	 * @return List<Comentario>
	 */
	@Override
	public List<Comentario> recuperarPorAutor(Usuario autor) {
		TypedQuery<Comentario> q = this.em.createQuery(
			"SELECT co FROM Comentario co JOIN co.autor a WHERE a.id = :autorId", 
			Comentario.class
		);
		q.setParameter("autorId", autor.getId());
		List<Comentario> comentarios = q.getResultList();
			
		return comentarios;
	}

}
