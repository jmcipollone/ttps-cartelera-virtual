package modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Entity
@Table(name="carteleras")
public class Cartelera {
	
	// Propiedades
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true, nullable=false, length=100)
	private String nombre;
	
	@Column(nullable=false, length=255)
	private String descripcion;
	
	@Column(nullable=false)
	private boolean habilitada;
	
	@Column(nullable=false)
	private Date instanteCreacion;
	
	// Relaciones
	
	@ManyToMany
	@JoinTable(
		name="carteleras_publicadores",
		joinColumns=@JoinColumn(name="carteleraId", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="usuarioId", referencedColumnName="id")			
	)
	private List<Usuario> publicadores;
	
	@ManyToMany
	@JoinTable(
		name="carteleras_interesados",
		joinColumns=@JoinColumn(name="carteleraId", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="usuarioId", referencedColumnName="id")
	)
	private List<Usuario> interesados;
	
	@ManyToMany
	@JoinTable(
		name="carteleras_tags",
		joinColumns=@JoinColumn(name="carteleraId", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="tagId", referencedColumnName="id")
	)
	private List<Tag> tags;
	
	@OneToMany(mappedBy="cartelera")
	private List<Publicacion> publicaciones;
	
	// Constructores
		
	public Cartelera(String nombre, String descripcion, List<Tag> tags) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.habilitada = true;
		this.instanteCreacion = new Date();
		this.publicadores = new ArrayList<Usuario>();
		this.interesados = new ArrayList<Usuario>();
		this.tags = tags;
		this.publicaciones = new ArrayList<Publicacion>();		
	}
	
	public Cartelera(String nombre, String descripcion) {
		this(nombre, descripcion, new ArrayList<Tag>());		
	}
	
	public Cartelera() {}
	
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
	
	// Metodos de gestion de tags
	
	public void agregarTag(Tag tag) {
		if (!tags.contains(tag)) {
			tags.add(tag);			
		}		
	}
	
	public void removerTag(Tag tag) {
		tags.remove(tag);	// No es necesario comprobar existencia del tag, puesto que el metodo remove() lo hace
	}
	
	// Metodos de gestion de publicaciones
	
	public void agregarPublicacion(Publicacion publicacion) {
		this.publicaciones.add(publicacion);
		publicacion.setCartelera(this);
	}
	
	public void removerPublicacion(Publicacion publicacion) {
		if (this.publicaciones.remove(publicacion)) {
			publicacion.setCartelera(null);			
		}		
	}
	
	public Publicacion obtenerUltimaPublicacion() {
		if (this.publicaciones.isEmpty()) {
			return null;
		}				
		return this.publicaciones.get(this.publicaciones.size()-1);
	}
	
	/**
	 * Recupera las publicaciones de una cartelera ordenadas por su fecha de creación en sentido descendente.
	 * 
	 * @return List<Publicacion>
	 */
	public List<Publicacion> obtenerPublicacionesOrdenadasPorFecha() {
		Comparator<Publicacion> comparadorPorFecha = new Comparator<Publicacion>() {
			@Override
			public int compare(Publicacion p1, Publicacion p2) {
				return p1.getInstanteCreacion().compareTo(p2.getInstanteCreacion());
			}			
		};
		List<Publicacion> publicacionesOrdenadas = new ArrayList<Publicacion>(this.publicaciones);		
		Collections.sort(publicacionesOrdenadas, comparadorPorFecha.reversed());
		
		return publicacionesOrdenadas;				
	}
	
	// Metodos de gestion de usuarios relacionados
	
	public void agregarPublicador(Usuario publicador) {
		this.publicadores.add(publicador);
		publicador.getCartelerasPermitidas().add(this);		
	}
	
	public void removerPublicador(Usuario publicador) {
		this.publicadores.remove(publicador);
		publicador.getCartelerasPermitidas().remove(this);
	}
	
	public void agregarInteresado(Usuario interesado) {
		this.interesados.add(interesado);
		interesado.getCartelerasConInteres().add(this);
	}
	
	public void removerInteresador(Usuario interesado) {
		this.interesados.remove(interesado);
		interesado.getCartelerasConInteres().remove(this);
	}
	
	/**
	 * Recupera el listado de alumnos interesados en la cartelera ordenado por el nombre completo de los alumnos. 
	 * 
	 * @return List<Usuario>
	 */
	public List<Usuario> obtenerAlumnosInteresados() {
		Comparator<Usuario> comparadorPorNombre = new Comparator<Usuario>() {
			@Override
			public int compare(Usuario u1, Usuario u2) {
				return u1.getNombreCompleto().compareTo(u2.getNombreCompleto());
			}			
		};		
		List<Usuario> alumnosInteresados = new ArrayList<>(this.interesados);
		Collections.sort(alumnosInteresados, comparadorPorNombre.reversed());
		
		return alumnosInteresados;		
	}
	
		
	// Metodos para habilitacion/inhanilitacion de una cartelera
		
	public void habilitar() {
		// Habilitar publicaciones de la cartelera
		for (Publicacion publicacion : this.publicaciones) {
			publicacion.setHabilitada(true);			
		}
		// Habilitar la propia cartelera
		this.setHabilitada(true);		
	}
	
	public void inhabilitar() {
		// Inhabilitar publicaciones de la cartelera
		for (Publicacion publicacion : this.publicaciones) {
			publicacion.setHabilitada(false);			
		}
		// Inhabilitar la propia cartelera
		this.setHabilitada(false);		
	}
			

}
