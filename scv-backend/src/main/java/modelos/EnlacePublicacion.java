package modelos;

/**
 * Clase del modelo que representa un enlace en una publicación.
 * 
 * @author Juan Manuel Cipollone
 *
 */
public class EnlacePublicacion extends RecursoPublicacion {
	
	// Propiedades
	
	private String url;

	
	// Getters/setters

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
