package daos;

import java.util.List;

import modelos.Cartelera;
import modelos.Tag;

/**
 * Interfaz que define los mensajes del DAO responsable de almacenar y recuperar los objetos Cartelera de la BD.
 * 
 * @author Juan Manuel Cipollone
 */
public interface CarteleraDao extends EntidadDao<Cartelera> {
	
	public Cartelera recuperarPorNombre(String nombre);
	
	public List<Cartelera> recuperarTodas();
	
	public List<Cartelera> recuperarHabilitadas();
	
	public List<Cartelera> recuperarConTags(List<Tag> tags);
	
	public List<Cartelera> recuperarConTexto(String texto);
		
}
