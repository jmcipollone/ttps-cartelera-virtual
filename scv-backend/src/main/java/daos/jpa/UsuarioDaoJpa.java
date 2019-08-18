package daos.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import daos.UsuarioDao;
import modelos.Cartelera;
import modelos.Perfil;
import modelos.Usuario;

/**
 * Clase que modela DAOs responsables del almacenamiento y recuperacion de los usuarios en la BD
 * 
 * @author Juan Manuel Cipollone
 */
@Repository("usuarioDao")
@Transactional
public class UsuarioDaoJpa extends EntidadDaoJpa<Usuario> implements UsuarioDao {
	
	// Constructor
	
	public UsuarioDaoJpa() {
		super(Usuario.class);
	}
	
	
	// Metodos de recuperacion de usuarios

	/**
	 * Recupera el usuario con el nombre de usuario dado. 
	 * 
	 * @param String nombreUsuario
	 * @return Usuario
	 * @throws NoResultException
	 * @throws NonUniqueResultException
	 */
	@Override
	public Usuario recuperarPorNombreUsuario(String nombreUsuario) {
		TypedQuery<Usuario> q = this.em.createQuery(
			"SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario", 
			Usuario.class
		);
		q.setParameter("nombreUsuario", nombreUsuario);
		Usuario usuario = q.getSingleResult();
		
		return usuario;
	}

	/**
	 * Recupera todos los usuarios registrados en el sistema.
	 * 
	 * @return List<Usuario>
	 */
	@Override
	public List<Usuario> recuperarTodos() {
		TypedQuery<Usuario> q = this.em.createQuery("SELECT u FROM Usuario u", Usuario.class);
		List<Usuario> usuarios = q.getResultList();
		
		return usuarios;
	}

	/**
	 * Recupera los usuarios habilitados en el sistema.
	 * 
	 * Un usuario habilitado es aquel que puede iniciar sesion en el sistema.
	 * 
	 * @return List<Usuario>
	 */
	@Override
	public List<Usuario> recuperarHabilitados() {
		TypedQuery<Usuario> q = this.em.createQuery("SELECT u FROM Usuario u WHERE u.habilitado = :habilitado", Usuario.class);
		q.setParameter("habilitado", Boolean.TRUE);
		List<Usuario> usuarios = q.getResultList();
		
		return usuarios;
	}

	/**
	 * Recupera los usuarios que incluyen el nombre dado como parte de su nombre o apellido.
	 * 
	 * @return List<Usuario>
	 */
	@Override
	public List<Usuario> recuperarPorNombreyApellido(String nombre) {
		TypedQuery<Usuario> q = this.em.createQuery(
			"SELECT u FROM Usuario u WHERE u.nombre LIKE :nombre OR u.apellido LIKE :nombre", 
			Usuario.class
		);
		q.setParameter("nombre", "%" + nombre + "%");
		List<Usuario> usuarios = q.getResultList();
		
		return usuarios;
	}

	/**
	 * Recupera los usuarios que pertenecen al perfil dado.
	 * 
	 * @return List<Usuario>
	 */
	@Override
	public List<Usuario> recuperarPorPerfil(Perfil perfil) {
		TypedQuery<Usuario> q = this.em.createQuery(
			"SELECT u FROM Usuario u JOIN u.perfil p WHERE p.id = :perfilId", 
			Usuario.class
		);
		q.setParameter("perfilId", perfil.getId());
		List<Usuario> usuarios = q.getResultList();
		
		return usuarios;
	}

	/**
	 * Recupera los usuarios que pertenecen al menos uno de los perfiles dados.
	 * 
	 * @return List<Usuario>
	 */
	@Override
	public List<Usuario> recuperarPorPerfiles(List<Perfil> perfiles) {
		TypedQuery<Usuario> q = this.em.createQuery(
			"SELECT u FROM Usuario u JOIN u.perfil p WHERE p.id IN :perfilesIds", 
			Usuario.class
		);
		// Recuperar los ids de los perfiles especificados como parametro
		List<Long> perfilesIds = new ArrayList<Long>();
		for(Perfil perfil : perfiles) {
			perfilesIds.add(perfil.getId());
		}
		// Setear parametro a la consulta JPQL
		q.setParameter("perfilesIds", perfilesIds);		
		// Ejecutar consulta JPQL
		List<Usuario> usuarios = q.getResultList();
				
		return usuarios;
	}

	/**
	 * Recupera los usuarios autorizados a publicar en la cartelera dada.
	 * 
	 * @param Cartelera cartelera
	 * @return List<Usuario>
	 */
	@Override
	public List<Usuario> recuperarAutorizados(Cartelera cartelera) {
		TypedQuery<Usuario> q = this.em.createQuery(
			"SELECT u FROM Usuario u JOIN u.cartelerasPermitidas cp WHERE cp.id = :carteleraId", 
			Usuario.class
		);
		q.setParameter("carteleraId", cartelera.getId());
		List<Usuario> usuarios = q.getResultList();
		
		return usuarios;
	}

	/**
	 * Recupera los usuarios interesados en la cartelera especificada.
	 * 
	 * @param Cartelera cartelera
	 * @return List<Usuario>
	 */
	@Override
	public List<Usuario> recuperarInteresados(Cartelera cartelera) {
		TypedQuery<Usuario> q = this.em.createQuery(
			"SELECT u FROM Usuario u JOIN u.cartelerasConInteres ci WHERE ci.id = :carteleraId", 
			Usuario.class
		);
		q.setParameter("carteleraId", cartelera.getId());
		List<Usuario> usuarios = q.getResultList();
			
		return usuarios;
	}

	
	/**
	 * Recupera los usuarios no autorizados para publicar en la cartelera dada.
	 * 
	 * @param Cartelera cartelera
	 * @return List<Usuario>
	 */
	@Override
	public List<Usuario> recuperarNoAutorizados(Cartelera cartelera) {
		TypedQuery<Usuario> q = this.em.createQuery(
			"SELECT u "
			+ "FROM Usuario u "
			+ "WHERE u.id NOT IN ("
			+ 	"SELECT u2.id FROM Usuario u2 JOIN u2.cartelerasPermitidas cp WHERE cp.id = :carteleraId) ", 
			Usuario.class
		);
		q.setParameter("carteleraId", cartelera.getId());
		List<Usuario> usuarios = q.getResultList();
		
		return usuarios;
	}

}
