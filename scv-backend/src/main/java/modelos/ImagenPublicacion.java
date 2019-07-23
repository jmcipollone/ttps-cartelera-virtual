package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clase del modelo que representa una imagen en una publicación.
 * 
 * @author Juan Manuel Cipollone
 *
 */
@Entity
@Table(name="imagenes_publicacion")
public class ImagenPublicacion extends RecursoPublicacion {
	
	// Propiedades
	
	@Column(nullable=false, length=255)
	private String path;

	
	// Getters/setters
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	// Otras funciones
	
	@Override
	public boolean esImagen() {
		return true;
	}

}
