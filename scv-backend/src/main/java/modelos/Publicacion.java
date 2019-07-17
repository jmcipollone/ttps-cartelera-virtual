package modelos;

import java.util.Date;
import java.util.List;

/**
 * Clase del modelo que representa una publicación en una cartelera virtual.
 * 
 * Una publicación en una cartelera es un texto, que puede ir acompañado de recursos como enlaces o imágenes, que tiene como finalidad
 * comunicar cierta información a los usuarios alumnos que "siguen" la cartelera donde se realiza la publicación. Además, una publicación 
 * tiene un autor, y puede tener comentarios. 
 * 
 * @author Juan Manuel Cipollone
 *
 */
public class Publicacion {
	
	// Propiedades
	
	private long id;	
	private String titulo;	
	private String texto;	
	private boolean habilitada;	
	private boolean comentariosHabilitados;	
	private Date instanteCreacion;
	
	// Relaciones
	
	private Cartelera cartelera;
	private Usuario autor;
	private List<Tag> tags;
	private List<Comentario> comentarios;
	private List<RecursoPublicacion> recursos;
	
	// Getters/setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isHabilitada() {
		return habilitada;
	}

	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}

	public boolean isComentariosHabilitados() {
		return comentariosHabilitados;
	}

	public void setComentariosHabilitados(boolean comentariosHabilitados) {
		this.comentariosHabilitados = comentariosHabilitados;
	}

	public Date getInstanteCreacion() {
		return instanteCreacion;
	}

	public void setInstanteCreacion(Date instanteCreacion) {
		this.instanteCreacion = instanteCreacion;
	}

	public Cartelera getCartelera() {
		return cartelera;
	}

	public void setCartelera(Cartelera cartelera) {
		this.cartelera = cartelera;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<RecursoPublicacion> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<RecursoPublicacion> recursos) {
		this.recursos = recursos;
	}
		

}
