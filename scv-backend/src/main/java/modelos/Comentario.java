package modelos;

import java.util.Date;

/**
 * Clase del modelo que representa un comentario de una publicación.
 * 
 * @author Juan Manuel Cipollone
 *
 */
public class Comentario {
	
	// Propiedades
	
	private long id;	
	private String texto;	
	private Date instanteCreacion;
	
	
	// Relaciones
	
	private Usuario autor;
	
	
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
	
	

}
