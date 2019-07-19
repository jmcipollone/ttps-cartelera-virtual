package modelos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	private List<RecursoPublicacion> recursos;
	private List<Comentario> comentarios;	
	
	// Constructores
	
	public Publicacion(Cartelera cartelera, String titulo, String texto, boolean comentariosHabilitados, Usuario autor,
			List<RecursoPublicacion> recursos, List<Tag> tags) {
		this.titulo = titulo;
		this.texto = texto;
		this.habilitada = true;
		this.comentariosHabilitados = comentariosHabilitados;
		this.instanteCreacion = new Date();
		this.cartelera = cartelera;
		this.autor = autor;
		this.tags = tags;
		this.recursos = recursos;
		this.comentarios = new ArrayList<Comentario>();
	}
	
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
	
	// Funciones referidas al instante de creacion
	
	public String getFechaCreacion() {
		DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		String fechaCreacion = formateador.format(this.instanteCreacion);
		
		return fechaCreacion;
	}
	
	public String getHoraCreacion() {
		DateFormat formateador = new SimpleDateFormat("HH:mm:ss");
		String horaCreacion = formateador.format(instanteCreacion);
		
		return horaCreacion;
	}
	
	// Funciones de gestion de recursos
	
	public boolean tieneRecursos() {
		return !this.recursos.isEmpty();
	}
	
	public void agregarRecurso(RecursoPublicacion recurso) {
		if (!recursos.contains(recurso)) {
			recursos.add(recurso);
		}		
	}
	
	public void removerRecurso(RecursoPublicacion recurso) {
		recursos.remove(recurso);
	}
	
	public List<EnlacePublicacion> obtenerEnlaces() {
		List<EnlacePublicacion> enlaces = new ArrayList<EnlacePublicacion>();		
		for (RecursoPublicacion recurso : this.recursos) {
			if (recurso.esEnlace()) {
				enlaces.add((EnlacePublicacion) recurso);
			}
		}		
		return enlaces;				
	}
	
	public List<ImagenPublicacion> obtenerImagenes() {
		List<ImagenPublicacion> imagenes = new ArrayList<ImagenPublicacion>();
		for (RecursoPublicacion recurso : this.recursos) {
			if (recurso.esImagen()) {
				imagenes.add((ImagenPublicacion) recurso);
			}
		}		
		return imagenes;		
	}
	
	// Funciones de gestion de tags
	
	public void agregarTag(Tag tag) {
		if (!this.tags.contains(tag)) {
			this.tags.add(tag);
		}
	}
	
	public void removerTag(Tag tag) {
		this.tags.remove(tag);
	}	
	
	// Funciones de gestion de comentarios
	
	public int getNumeroDeComentarios() {
		return this.comentarios.size();		
	}
	
	public boolean tieneComentarios() {
		return !this.comentarios.isEmpty();
	}
	
	public void agregarComentario(Comentario comentario) {
		this.comentarios.add(comentario);
	}
	
	public void removerComentario(Comentario comentario) {
		this.comentarios.remove(comentario);
	}
		
}
