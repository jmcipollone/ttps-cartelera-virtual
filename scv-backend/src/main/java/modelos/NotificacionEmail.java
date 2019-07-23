package modelos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Clase que modela notificación de una novedad en una cartelera a un usuario interesado mediante el envío de un mail.
 * 
 * @author Juan Manuel Cipollone
 *
 */
@Entity
@DiscriminatorValue("email")
public class NotificacionEmail extends ModoNotificacion {

}
