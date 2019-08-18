package modelos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Entity
@Table(name="publicaciones")
public class Publicacion {
	
	// Propiedades
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;	
	
	@Column(nullable=false, length=100)
	private String titulo;
	
	@Column(nullable=false, length=1000)
	private String texto;	
	
	@Column(nullable=false)
	private boolean habilitada;
	
	@Column(nullable=false)
	private boolean comentariosHabilitados;
	
	@Column(nullable=false)
	private Date instanteCreacion;
	
	// Relaciones
	
	@ManyToOne
	@JoinColumn(name="carteleraId", nullable=false)
	private Cartelera cartelera;
	
	@ManyToOne
	@JoinColumn(name="autorId", nullable=false)
	private Usuario autor;
	
	@ManyToMany
	@JoinTable(
		name="publicaciones_tags",
		joinColumns=@JoinColumn(name="publicacionId", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="tagId", referencedColumnName="id")
	)
	private List<Tag> tags;
	
	@OneToMany(mappedBy="publicacion", cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	private List<RecursoPublicacion> recursos;
	
	@OneToMany(mappedBy="publicacion")
	private List<Comentario> comentarios;
	
	
	// Constructores
	
	/**
	 * Crea una publicacion especificando su cartelera, titulo, texto, si admite o no comentarios, autor, recursos y tags.
	 * 
	 * Las colecciones de recursos y tags asociados a la publicacion no se asignan en forma directa, sino que se deben agregar sus
	 * elementos uno a uno para asegurar de que se mantenga una relacion de conocimiento bidireccional.
	 * 
	 * @param cartelera
	 * @param titulo
	 * @param texto
	 * @param comentariosHabilitados
	 * @param autor
	 * @param recursos
	 * @param tags
	 */
	public Publicacion(Cartelera cartelera, String titulo, String texto, boolean comentariosHabilitados, Usuario autor,
			List<RecursoPublicacion> recursos, List<Tag> tags) {
		this.titulo = titulo;
		this.texto = texto;
		this.habilitada = true;
		this.comentariosHabilitados = comentariosHabilitados;
		this.instanteCreacion = new Date();
		this.cartelera = cartelera;
		this.autor = autor;		
		this.comentarios = new ArrayList<Comentario>();		
		this.tags = new ArrayList<Tag>();
		for (Tag tag : tags) {
			this.agregarTag(tag);			
		}		
		this.recursos = new ArrayList<RecursoPublicacion>();
		for (RecursoPublicacion recurso : recursos) {
			this.agregarRecurso(recurso);			
		}			
	}
	
	/**
	 * Crea una publicacion especificando su cartelera, titulo, texto, si admite o no comentarios, y su autor.
	 * 
	 * Las colecciones de recursos y tags se crean vacías mendiante este constructor.
	 * 
	 * @param cartelera
	 * @param titulo
	 * @param texto
	 * @param comentariosHabilitados
	 * @param autor
	 */
	public Publicacion(Cartelera cartelera, String titulo, String texto, boolean comentariosHabilitados, Usuario autor) {		
		this(cartelera, titulo, texto, comentariosHabilitados, autor, new ArrayList<RecursoPublicacion>(), new ArrayList<Tag>());		
	}
	
	/**
	 * Crea una publicacion sin inicializar sus propiedades.
	 *
	 */
	public Publicacion() {}
	
	
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
		this.recursos.add(recurso);
		recurso.setPublicacion(this);
	}
	
	public void removerRecurso(RecursoPublicacion recurso) {
		if (this.recursos.remove(recurso)) {
			recurso.setPublicacion(null);
		}
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
		comentario.setPublicacion(this);
	}
	
	public void removerComentario(Comentario comentario) {
		if (this.comentarios.remove(comentario)) {
			comentario.setPublicacion(null);
		}
	}
		
}
