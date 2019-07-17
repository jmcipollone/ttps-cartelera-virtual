package modelos;

import java.util.Date;

/**
 * Clase del modelo que representa un mecanismo para notificar las novedades de una cartelera a un usuario interesado en la misma.
 * 
 * @author Juan Manuel Cipollone
 *
 */
public abstract class ModoNotificacion {
	
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
