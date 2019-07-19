package modelos;

/**
 * Clase del modelo que representa un recurso de una publicación.
 * 
 * @author Juan Manuel Cipollone
 *
 */
public class RecursoPublicacion {
	
	// Propiedades
	
	private long id;
	private String nombre;
	
	
	// Getters/setters
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Otras funciones
	
	public boolean esEnlace() {
		return false;
	}
	
	public boolean esImagen() {
		return false;
	}
	
	
	

}
