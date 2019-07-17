package modelos;

import java.util.Date;

/**
 * Clase del modelo que representa un tag.
 * 
 * Un tag es una etiqueta que se aplica a una cartelera o publicación con el objetivo de caracterizar la misma para facilitar
 * su búsqueda posterior.
 * 
 * @author Juan Manuel Cipollone
 *
 */
public class Tag {
	
	// Propiedades
	
	private long id;	
	private String nombre;	
	private Date instanteCreacion;
	
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

	public Date getInstanteCreacion() {
		return instanteCreacion;
	}

	public void setInstanteCreacion(Date instanteCreacion) {
		this.instanteCreacion = instanteCreacion;
	}

		
}
