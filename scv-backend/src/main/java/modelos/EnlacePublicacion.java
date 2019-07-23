package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clase del modelo que representa un enlace en una publicación.
 * 
 * @author Juan Manuel Cipollone
 *
 */
@Entity
@Table(name="enlaces_publicacion")
public class EnlacePublicacion extends RecursoPublicacion {
	
	// Propiedades
	
	@Column(nullable=false, length=255)
	private String url;

	
	// Getters/setters

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	// Otras funciones
	
	@Override
	public boolean esEnlace() {
		return true;
	}
	
	
}
