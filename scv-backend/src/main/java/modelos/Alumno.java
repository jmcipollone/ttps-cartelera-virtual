package modelos;

import java.util.List;

/**
 * Clase del modelo que representa el perfil de los alumnos que usan la aplicacion.
 * 
 * @author Juan Manuel Cipollone
 * 
 */
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
