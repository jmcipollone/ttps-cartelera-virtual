package modelos;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Clase del modelo que representa el perfil de los alumnos que usan la aplicacion.
 * 
 * @author Juan Manuel Cipollone
 * 
 */
@Entity
@DiscriminatorValue("alumno")
public class Alumno extends Perfil {
	
	@Override
	public List<Cartelera> ordenarCarteleras(Usuario usuario, List<Cartelera> carteleras) {
		return usuario.ordenarCartelerasSegunIntereses(carteleras);
	}
	
	@Override
	public boolean puedeBorrarComentario(Usuario usuario, Publicacion publicacion, Comentario comentario) {
		return comentario.getAutor().equals(usuario);
	}

}
