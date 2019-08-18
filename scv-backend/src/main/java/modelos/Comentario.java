package modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase del modelo que representa un comentario de una publicación.
 * 
 * @author Juan Manuel Cipollone
 *
 */
@Entity
@Table(name="comentarios")
public class Comentario {
	
	// Propiedades
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;	
	
	@Column(nullable=false, length=1000)
	private String texto;
	
	@Column(nullable=false)
	private Date instanteCreacion;
	
	
	// Relaciones
	
	@ManyToOne
	@JoinColumn(name="publicacionId", nullable=false)
	private Publicacion publicacion;
	
	@ManyToOne
	@JoinColumn(name="autorId", nullable=false)
	private Usuario autor;
	
	// Constructores
	
	public Comentario() {}
	
	/**
	 * Crea un comentario para la publicacion con el texto y autor especificados.
	 * 
	 * @param texto
	 * @param publicacion
	 * @param autor
	 */
	public Comentario(String texto, Publicacion publicacion, Usuario autor) {
		this.texto = texto;
		this.instanteCreacion = new Date();
		this.publicacion = publicacion;
		this.autor = autor;
	}
	
	
	// Getters/setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getInstanteCreacion() {
		return instanteCreacion;
	}

	public void setInstanteCreacion(Date instanteCreacion) {
		this.instanteCreacion = instanteCreacion;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	
	

}
