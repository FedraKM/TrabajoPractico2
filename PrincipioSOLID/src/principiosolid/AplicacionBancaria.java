package principiosolid;

/**
 *
 * @author Macario, Malanca y Pereyra
 */

// CLASE PRINCIPAL: AplicacionBancaria
// Ahora el main actúa como orquestador: crea los objetos y delega
// cada responsabilidad a quien corresponde. 

public class AplicacionBancaria {
    public static void main(String[] args) {
        // Crea la cuenta solo con los datos que le corresponden
        CuentaBancaria cuenta = new CuentaBancaria("Juan", "12345678", 1000);

        // Delega las operaciones financieras a la propia cuenta
        cuenta.depositar(500);
        cuenta.retirar(200);

        // Delega la impresión a su clase especializada
        ImpresionCuenta impresion = new ImpresionCuenta();
        impresion.imprimirDetalles(cuenta);

        // Delega la notificación a su clase especializada
        NotificacionEmail notificacion = new NotificacionEmail();
        notificacion.enviarNotificacion(cuenta, "¡Notificación exitosa!");
    }
}
