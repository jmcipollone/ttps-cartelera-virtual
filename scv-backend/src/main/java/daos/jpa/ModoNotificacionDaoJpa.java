package daos.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import daos.ModoNotificacionDao;
import modelos.ModoNotificacion;

@Repository("modoNotificacionDao")
@Transactional
public class ModoNotificacionDaoJpa extends EntidadDaoJpa<ModoNotificacion> implements ModoNotificacionDao {
	
	// Constructor
	
	public ModoNotificacionDaoJpa() {
		super(ModoNotificacion.class);
	}

	
	// Metodos de recuperacion
	
	/**
	 * Recupera el modo de notificacion con el nombre dado.
	 * 
	 * @param String nombre
	 * @return ModoNotificacion
	 */
	public ModoNotificacion recuperarPorNombre(String nombre) {
		TypedQuery<ModoNotificacion> q = this.em.createQuery(
				"SELECT mn FROM ModoNotificacion mn WHERE mn.nombre = :nombre", 
				ModoNotificacion.class
		);
		q.setParameter("nombre", nombre);
		ModoNotificacion modo = q.getSingleResult();
		
		return modo;		
	}
	

	/**
	 * Recupera todos los modos de notificacion disponibles en el sistema.
	 * 
	 * @return List<ModoNotificacion>
	 */
	@Override
	public List<ModoNotificacion> recuperarTodos() {
		TypedQuery<ModoNotificacion> q = this.em.createQuery("SELECT mn FROM ModoNotificacion mn", ModoNotificacion.class);
		List<ModoNotificacion> modosNotificacion = q.getResultList();
		
		return modosNotificacion;
	}

}
