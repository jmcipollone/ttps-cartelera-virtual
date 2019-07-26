package daos;

import java.util.List;

import modelos.Comentario;
import modelos.Publicacion;
import modelos.Usuario;

/**
 * Interfaz que define los mensajes del DAO responsable de almacenar y recuperar los objetos Comentario de la BD.
 * 
 * @author Juan Manuel Cipollone
 */
public interface ComentarioDao extends EntidadDao<Comentario> {
	
	public List<Comentario> recuperarPorPublicacion(Publicacion publicacion);
	
	public List<Comentario> recuperarPorAutor(Usuario autor);

}
