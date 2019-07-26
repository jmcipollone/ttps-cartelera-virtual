package daos;

import java.util.List;

import modelos.Perfil;

public interface PerfilDao extends EntidadDao<Perfil> {
	
	public List<Perfil> recuperarTodos();

}
