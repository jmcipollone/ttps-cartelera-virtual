package modelos;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Clase que modela el perfil de los publicadores que usan la aplicación.
 * 
 * @author Juan Manuel Cipollone
 *
 */
@Entity
@DiscriminatorValue("publicador")
public class Publicador extends Perfil {
	
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
