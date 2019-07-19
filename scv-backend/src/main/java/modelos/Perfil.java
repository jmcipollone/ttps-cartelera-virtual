package modelos;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Clase del modelo que representa un perfil de usuario.
 * 
 * Un perfil de usuario determinar las acciones que puede llevar a cabo el usuario en la aplicacion.
 * 
 * @author Juan Manuel Cipollone
 */
public abstract class Perfil {
	
	// Propiedades
	
	protected long id;
	protected String nombre;
	protected String descripcion;
	protected Date instanteCreacion;
	
	
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
	
	public Date getInstanteCreacion() {
		return instanteCreacion;
	}
	
	public void setInstanteCreacion(Date instanteCreacion) {
		this.instanteCreacion = instanteCreacion;
	}

	// Permisos sobre acciones del sistema
	
	public boolean puedePublicar(Usuario usuario, Cartelera cartelera) {
		// Retorna falso por defecto, debe redefinirse en las subclases que requieran modificar este comportamiento predeterminado
		return false;
	}

	public boolean puedeModificarPublicacion(Usuario usuario, Publicacion publicacion) {
		// Retorna falso por defecto, debe redefinirse en las subclases que requieran modificar este comportamiento predeterminado
		return false;
	}

	public boolean puedeBorrarPublicacion(Usuario usuario, Publicacion publicacion) {
		// Retorna falso por defecto, redefinir en las subclases que sea necesario
		return false;
	}

	public List<Cartelera> ordenarCarteleras(Usuario usuario, List<Cartelera> carteleras) {
		// Retorna, por defecto, las carteleras ordenadas por nombre
		Comparator<Cartelera> comparadorPorNombre = new Comparator<Cartelera>() {
			@Override
			public int compare(Cartelera c1, Cartelera c2) {
				return c1.getNombre().compareTo(c2.getNombre());
			}			
		};	
		Collections.sort(carteleras, comparadorPorNombre);

		return carteleras;
	}

	public boolean puedeAdministrarComentarios(Usuario usaurio, Publicacion publicacion) {
		// Retorna falso por defecto, redefinir en las subclases que sea necesario
		return false;		
	}

	public boolean puedeComentar(Usuario usuario, Publicacion publicacion) {
		// Retorna true por defecto, redefinir en las subclases que resulte necesario
		return true;
	}

	public boolean puedeBorrarComentario(Usuario usuario, Publicacion publicacion, Comentario comentario) {
		// Retorna false por defecto, redefinir en las subclases que sea necesario
		return false;
	}
	
	
		
}
