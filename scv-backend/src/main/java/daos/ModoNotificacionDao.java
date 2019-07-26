package daos;

import java.util.List;

import modelos.ModoNotificacion;

public interface ModoNotificacionDao extends EntidadDao<ModoNotificacion> {
	
	public List<ModoNotificacion> recuperarTodos();

}
