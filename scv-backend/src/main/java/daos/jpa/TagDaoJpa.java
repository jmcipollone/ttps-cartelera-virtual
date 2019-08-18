package daos.jpa;

import java.util.List;

import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import daos.TagDao;
import modelos.Tag;

@Repository("tagDao")
@Transactional
public class TagDaoJpa extends EntidadDaoJpa<Tag> implements TagDao  {

	// Constructor
	
	public TagDaoJpa() {
		super(Tag.class);
	}

	
	// Metodos de recuperacion de tags
	
	/**
	 * Recupera el tag con el nombre dado.
	 * 
	 * @param String nombre
	 * @return Tag
	 * @throws NonUniqueResultException
	 * @throws NoResultException
	 */
	@Override
	public Tag recuperarPorNombre(String nombre) {
		TypedQuery<Tag> q = this.em.createQuery(
			"SELECT t FROM Tag t WHERE t.nombre = :nombre", 
			Tag.class
		);
		q.setParameter("nombre", nombre);
		Tag tag = q.getSingleResult();
		
		return tag;
	}

	/**
	 * Recupera todos los tags registrados.
	 * 
	 * @return List<Tag>
	 */
	@Override
	public List<Tag> recuperarTodos() {
		TypedQuery<Tag> q = this.em.createQuery("SELECT t FROM Tag t", Tag.class);
		List<Tag> tags = q.getResultList();		
		
		return tags;
	}

	/**
	 * Recuperar los tags que incluyen el texto dado como parte de su nombre.
	 * 
	 * @param String texto
	 * @return List<Tag>
	 */
	@Override
	public List<Tag> recuperarConTexto(String texto) {
		TypedQuery<Tag> q = this.em.createQuery(
			"SELECT t FROM Tag t WHERE t.nombre LIKE :texto", 
			Tag.class
		);
		q.setParameter("texto", "%" + texto + "%");
		List<Tag> tags = q.getResultList();		
		
		return tags;
	}
	
	

}
