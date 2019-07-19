package modelos;

/**
 * Clase del modelo que representa una imagen en una publicación.
 * 
 * @author Juan Manuel Cipollone
 *
 */
public class ImagenPublicacion extends RecursoPublicacion {
	
	// Propiedades
	
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
