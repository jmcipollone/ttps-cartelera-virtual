package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase del modelo que representa un recurso de una publicación.
 * 
 * @author Juan Manuel Cipollone
 *
 */
@Entity
@Table(name="recursos_publicacion")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class RecursoPublicacion {
	
	// Propiedades
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, length=100)
	private String nombre;
	
	// Relaciones
	
	@ManyToOne
	@JoinColumn(name="publicacionId", nullable=false)
	private Publicacion publicacion;
	
	// Constructores
	
	public RecursoPublicacion() {}
	
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
	
	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	
	// Otras funciones		

	public boolean esEnlace() {
		return false;
	}
	
	public boolean esImagen() {
		return false;
	}
	
	
	

}
