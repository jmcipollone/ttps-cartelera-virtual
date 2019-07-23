package modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Clase del modelo que representa un mecanismo para notificar las novedades de una cartelera a un usuario interesado en la misma.
 * 
 * @author Juan Manuel Cipollone
 *
 */
@Entity
@Table(name="modos_notificacion")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="modo")
public abstract class ModoNotificacion {
	
	// Propiedades
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;	
	
	@Column(nullable=false, length=30)
	private String nombre;
	
	@Column(nullable=false)
	private Date instanteCreacion;
	
	// Constructores
	
	public ModoNotificacion() {}
	
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
