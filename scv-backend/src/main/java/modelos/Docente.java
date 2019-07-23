package modelos;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Clase del modelo que representa el perfil de los docentes que usan la aplicacion.
 * 
 * @author Juan Manuel Cipollone
 *
 */
@Entity
@DiscriminatorValue("docente")
public class Docente extends Perfil {
	
	// Permisos sobre acciones del sistema
	
	@Override
	public boolean puedePublicar(Usuario usuario, Cartelera cartelera) {
		return usuario.tienePermiso(cartelera);
	}
	
	@Override
	public boolean puedeModificarPublicacion(Usuario usuario, Publicacion publicacion) {
		return usuario.esAutor(publicacion);
	}
	
	@Override
	public boolean puedeBorrarPublicacion(Usuario usuario, Publicacion publicacion) {
		return usuario.esAutor(publicacion);
	}
	
	@Override
	public List<Cartelera> ordenarCarteleras(Usuario usuario, List<Cartelera> carteleras) {
		return usuario.ordenarCartelerasSegunPermisos(carteleras);
	}
	
	@Override
	public boolean puedeAdministrarComentarios(Usuario usuario, Publicacion publicacion) {		
		return usuario.esAutor(publicacion);		
	}
	
	@Override
	public boolean puedeBorrarComentario(Usuario usuario, Publicacion publicacion, Comentario comentario) {
		return usuario.esAutor(publicacion) || comentario.getAutor().equals(usuario);
	}

}
