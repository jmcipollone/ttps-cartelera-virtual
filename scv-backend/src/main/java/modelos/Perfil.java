package modelos;

import java.util.Date;

/**
 * Clase del modelo que representa un perfil de usuario.
 * 
 * Un perfil de usuario determinar las acciones que puede llevar a cabo el usuario en la aplicacion.
 * 
 * @author Juan Manuel Cipollone
 */
public abstract class Perfil {
	
	// Propiedades
	
	protected long id;
	protected String nombre;
	protected String descripcion;
	protected Date instanteCreacion;
	
	
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
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Date getInstanteCreacion() {
		return instanteCreacion;
	}
	
	public void setInstanteCreacion(Date instanteCreacion) {
		this.instanteCreacion = instanteCreacion;
	}
	
		
}
