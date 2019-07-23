package modelos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Clase que modela notificacion de una novedad en una cartelera a un usuario interesado mediante el envío de un mensaje de Facebook.
 * 
 * @author Juan Manuel Cipollone
 *
 */
@Entity
@DiscriminatorValue("facebook")
public class NotificacionFacebook extends ModoNotificacion {

}
