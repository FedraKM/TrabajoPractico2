package principiosolid;

/**
 *
 * @author Macario, Malanca y Pereyra
 */

// CLASE 3: NotificacionEmail
// Separa el envío de notificaciones en su propia clase.

public class NotificacionEmail {
    public void enviarNotificacion(CuentaBancaria cuenta, String mensaje) {
        // Simula el envío del correo usando los datos de la cuenta
        System.out.println("Enviando correo a " + cuenta.getTitular() + ": " + mensaje);
    }
}
