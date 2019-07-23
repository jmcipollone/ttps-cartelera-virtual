package modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase del modelo que representa un tag.
 * 
 * Un tag es una etiqueta que se aplica a una cartelera o publicación con el objetivo de caracterizar la misma para facilitar
 * su búsqueda posterior.
 * 
 * @author Juan Manuel Cipollone
 *
 */
@Entity
@Table(name="tags")
public class Tag {
	
	// Propiedades
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;	
	
	@Column(unique=true, nullable=false, length=30)
	private String nombre;	
	
	@Column(nullable=false)
	private Date instanteCreacion;
	
	// Constructores
	
	public Tag(String nombre) {
		this.nombre = nombre;
		this.instanteCreacion = new Date();
	}
	
	public Tag() {}
	
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
