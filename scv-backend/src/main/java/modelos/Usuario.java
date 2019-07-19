package modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	private String email;
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
	
	// Constructores
	
	public Usuario(String nombreU, String clave, String email, String nombre, String apellido, Perfil perfil, ModoNotificacion modo) {
		this.nombreUsuario = nombreU;
		this.clave = clave;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.habilitado = true;
		this.instanteCreacion = new Date();
		this.perfil = perfil;
		this.cartelerasPermitidas = new ArrayList<Cartelera>();
		this.cartelerasConInteres = new ArrayList<Cartelera>();
		this.modoNotificacion = modo;
		this.publicaciones = new ArrayList<Publicacion>();
	}
	
	
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	// Metodos adicionales
	
	public String getNombreCompleto() {
		return this.apellido + " " + this.nombre;
	}
	
	// Permisos sobre acciones del sistema
	
	public boolean puedePublicar(Cartelera cartelera) {
		return this.perfil.puedePublicar(this, cartelera);
	}
	
	public boolean puedeModificarPublicacion(Publicacion publicacion) {
		return this.perfil.puedeModificarPublicacion(this, publicacion);
	}
	
	public boolean puedeBorrarPublicacion(Publicacion publicacion) {
		return this.perfil.puedeBorrarPublicacion(this, publicacion);
	}
	
	public boolean puedeAdministrarComentarios(Publicacion publicacion) {
		return this.perfil.puedeAdministrarComentarios(this, publicacion);
	}
	
	public boolean puedeComentar(Publicacion publicacion) {
		return this.perfil.puedeComentar(this, publicacion);
	}
	
	public boolean puedeBorrarComentario(Publicacion publicacion, Comentario comentario) {
		return this.perfil.puedeBorrarComentario(this, publicacion, comentario);
	}
	
	
	// Metodos de gestion de carteleras permitidas
	
	public boolean tienePermiso(Cartelera cartelera) {
		return this.cartelerasPermitidas.contains(cartelera);
	}
	
	public void agregarPermiso(Cartelera cartelera) {
		this.cartelerasPermitidas.add(cartelera);
	}
	
	public void removerPermiso(Cartelera cartelera) {
		this.cartelerasPermitidas.remove(cartelera);
	}
	
	// Metodos de gestion de carteleras con interes
	
	public void agregarInteres(Cartelera cartelera) {
		this.cartelerasConInteres.add(cartelera);
	}
	
	public void removerInteres(Cartelera cartelera) {
		this.cartelerasConInteres.remove(cartelera);
	}
	
	
	// Metodos de gestion de publicaciones
	
	public boolean esAutor(Publicacion publicacion) {
		return this.publicaciones.contains(publicacion);
	}
	
	// Metodos de ordenacion de carteleras
	
	public List<Cartelera> ordenarCartelerasSegunPerfil(List<Cartelera> carteleras) {
		return this.perfil.ordenarCarteleras(this, carteleras);
	}
	
	public List<Cartelera> ordenarCartelerasSegunPermisos(List<Cartelera> carteleras) {
		List<Cartelera> cartelerasConPermiso = new ArrayList<Cartelera>();
		List<Cartelera> cartelerasSinPermiso = new ArrayList<Cartelera>();
		
		for (Cartelera cartelera : carteleras) {
			if (this.cartelerasPermitidas.contains(cartelera)) {
				cartelerasConPermiso.add(cartelera);
			} else {
				cartelerasSinPermiso.add(cartelera);
			}
		}
		
		Comparator<Cartelera> comparadorPorNombre = new Comparator<Cartelera>() {
			@Override
			public int compare(Cartelera c1, Cartelera c2) {
				return c1.getNombre().compareTo(c2.getNombre());
			}			
		};
		
		Collections.sort(cartelerasConPermiso, comparadorPorNombre);
		Collections.sort(cartelerasSinPermiso, comparadorPorNombre);				
		
		// Agrear al final de la coleccion de carteleras con permiso la coleccion de carteleras sin permisos
		cartelerasConPermiso.addAll(cartelerasSinPermiso);
		
		return cartelerasConPermiso;		
	}
	
	public List<Cartelera> ordenarCartelerasSegunIntereses(List<Cartelera> carteleras) {
		List<Cartelera> cartelerasConIntereses = new ArrayList<Cartelera>();
		List<Cartelera> cartelerasSinIntereses = new ArrayList<Cartelera>();
		
		for (Cartelera cartelera : carteleras) {
			if (this.cartelerasConInteres.contains(cartelera)) {
				cartelerasConIntereses.add(cartelera);
			} else {
				cartelerasSinIntereses.add(cartelera);
			}
		}
		
		Comparator<Cartelera> comparadorPorNombre = new Comparator<Cartelera>() {
			@Override
			public int compare(Cartelera c1, Cartelera c2) {
				return c1.getNombre().compareTo(c2.getNombre());
			}			
		};
		
		Collections.sort(cartelerasConIntereses, comparadorPorNombre);
		Collections.sort(cartelerasSinIntereses, comparadorPorNombre);				
		
		// Agrear al final de la coleccion de carteleras con permiso la coleccion de carteleras sin permisos
		cartelerasConIntereses.addAll(cartelerasSinIntereses);
		
		return cartelerasConIntereses;		
	}
	
		
}
