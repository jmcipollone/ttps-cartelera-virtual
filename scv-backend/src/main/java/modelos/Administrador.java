package modelos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Clase que modela el perfil de los administradores que usan la aplicación.
 * 
 * @author Juan Manuel Cipollone
 *
 */
@Entity
@DiscriminatorValue("administrador")
public class Administrador extends Perfil {
	
	// Permisos sobre acciones del sistema
	
	@Override
	public boolean puedePublicar(Usuario usuario, Cartelera cartelera) {
		return true;
	}
	
	@Override
	public boolean puedeModificarPublicacion(Usuario usuario, Publicacion publicacion) {
		return true;
	}
	
	@Override
	public boolean puedeBorrarPublicacion(Usuario usuario, Publicacion publicacion) {
		return true;
	}
	
	@Override
	public boolean puedeAdministrarComentarios(Usuario usuario, Publicacion publicacion) {		
		return true;		
	}
	
	@Override
	public boolean puedeBorrarComentario(Usuario usuario, Publicacion publicacion, Comentario comentario) {
		return true;
	}

}
