package daos;

import java.util.List;

import modelos.Tag;

public interface TagDao extends EntidadDao<Tag> {
	
	public Tag recuperarPorNombre(String nombre);
	
	public List<Tag> recuperarTodos();
	
	public List<Tag> recuperarConTexto(String texto);
	
}
