package modelos;

import java.util.Date;
import java.util.List;

/**
 * Clase del modelo que representa una cartelera virtual.
 * 
 * Una cartelera virtual es un componentes de la aplicación que contiene publicaciones afines al propósito de la cartelera. Una cartelera
 * tiene usuarios docentes/publicadores autorizados a publicar, así como también usuarios alumnos que registran interés en la cartelera y
 * que desean estar al tanto de las novedades de la misma.
 * 
 * @author Juan Manuel Cipollone
 *
 */
public class Cartelera {
	
	// Propiedades
	
	private long id;	
	private String nombre;
	private String descripcion;
	private boolean habilitada;
	private Date instanteCreacion;
	
	// Relaciones
	
	private List<Usuario> publicadores;
	private List<Usuario> interesados;
	private List<Tag> tags;
	private List<Publicacion> publicaciones;
	
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

	public boolean isHabilitada() {
		return habilitada;
	}

	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}

	public Date getInstanteCreacion() {
		return instanteCreacion;
	}

	public void setInstanteCreacion(Date instanteCreacion) {
		this.instanteCreacion = instanteCreacion;
	}

	public List<Usuario> getPublicadores() {
		return publicadores;
	}

	public void setPublicadores(List<Usuario> publicadores) {
		this.publicadores = publicadores;
	}

	public List<Usuario> getInteresados() {
		return interesados;
	}

	public void setInteresados(List<Usuario> interesados) {
		this.interesados = interesados;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	
	
	
	

}
