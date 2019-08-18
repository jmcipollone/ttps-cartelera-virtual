package daos.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import daos.PerfilDao;
import modelos.Perfil;

@Repository("perfilDao")
@Transactional
public class PerfilDaoJpa extends EntidadDaoJpa<Perfil> implements PerfilDao {
	
	// Constructores
	
	public PerfilDaoJpa() {
		super(Perfil.class);
	}
	
	
	// Metodos para recuperacion de perfiles

	/**
	 * Recupera todos los perfiles registrados.
	 * 
	 * @return List<Perfil>
	 */
	@Override
	public List<Perfil> recuperarTodos() {
		TypedQuery<Perfil> q = this.em.createQuery("SELECT pe FROM Perfil pe", Perfil.class);
		List<Perfil> perfiles = q.getResultList();
		
		return perfiles;
	}

}
