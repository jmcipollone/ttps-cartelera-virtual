package daos;

import java.util.List;

import modelos.Cartelera;
import modelos.Publicacion;
import modelos.Tag;
import modelos.Usuario;

/**
 * Interfaz que define los mensajes del DAO responsable de almacenar y recuperar los objetos Publicacion de la BD.
 * 
 * @author Juan Manuel Cipollone
 */
public interface PublicacionDao extends EntidadDao<Publicacion> {
	
	public List<Publicacion> recuperarTodas();
	
	public List<Publicacion> recuperarPorCartelera(Cartelera cartelera);
	
	public List<Publicacion> recuperarPorAutor(Usuario autor);
	
	public List<Publicacion> recuperarConTags(List<Tag> tags);
	
	public List<Publicacion> recuperarPorTitulo(String titulo);

}
