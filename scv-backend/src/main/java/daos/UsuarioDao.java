package daos;

import java.util.List;

import modelos.Cartelera;
import modelos.Perfil;
import modelos.Usuario;

/**
 * Interfaz que define los mensajes del DAO responsable de almacenar y recuperar los objetos Usuario de la BD.
 * 
 * @author Juan Manuel Cipollone
 */
public interface UsuarioDao extends EntidadDao<Usuario> {
	
	public Usuario recuperarPorNombreUsuario(String nombreUsuario);
	
	public List<Usuario> recuperarTodos();
	
	public List<Usuario> recuperarHabilitados();
	
	public List<Usuario> recuperarPorNombreyApellido(String nombre);
	
	public List<Usuario> recuperarPorPerfil(Perfil perfil);
	
	public List<Usuario> recuperarPorPerfiles(List<Perfil> perfiles);
	
	public List<Usuario> recuperarAutorizados(Cartelera cartelera);
	
	public List<Usuario> recuperarInteresados(Cartelera cartelera);
	
	public List<Usuario> recuperarNoAutorizados(Cartelera cartelera);	

}
