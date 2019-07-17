package modelos;

import java.util.Date;
import java.util.List;

/**
 * Clase del modelo que representa un usuario en la aplicacion
 * 
 * @author Juan Manuel Cipollone <jmcipollone@gmail.com>
 */
public class Usuario {
	
	// Propiedades
	
	private long id;
	private String nombreUsuario;
	private String clave;
	private String nombre;
	private String apellido;
	private boolean habilitado;
	private Date instanteCreacion;
	
	// Relaciones
	
	private Perfil perfil;
	private List<Cartelera> cartelerasPermitidas;
	private List<Cartelera> cartelerasConInteres;
	private ModoNotificacion modoNotificacion;
	private List<Publicacion> publicaciones;
	
	// Metodos getters/setters
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public boolean isHabilitado() {
		return habilitado;
	}
	
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Date getInstanteCreacion() {
		return instanteCreacion;
	}
	
	public void setInstanteCreacion(Date instanteCreacion) {
		this.instanteCreacion = instanteCreacion;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Cartelera> getCartelerasPermitidas() {
		return cartelerasPermitidas;
	}

	public void setCartelerasPermitidas(List<Cartelera> cartelerasPermitidas) {
		this.cartelerasPermitidas = cartelerasPermitidas;
	}

	public List<Cartelera> getCartelerasConInteres() {
		return cartelerasConInteres;
	}

	public void setCartelerasConInteres(List<Cartelera> cartelerasConInteres) {
		this.cartelerasConInteres = cartelerasConInteres;
	}

	public ModoNotificacion getModoNotificacion() {
		return modoNotificacion;
	}

	public void setModoNotificacion(ModoNotificacion modoNotificacion) {
		this.modoNotificacion = modoNotificacion;
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
		
}
