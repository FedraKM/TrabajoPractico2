package principiosolid;

/**
 *
 * @author Macario, Malanca y Pereyra
 */

// CLASE 2: ImpresionCuenta
// Extrae la responsabilidad de mostrar información a esta clase.
// Así, si el formato de impresión cambia, solo se modifica esta clase.

public class ImpresionCuenta {
    // Recibe la cuenta por parámetro para no acoplar esta clase
    // instancia específica — puedo reutilizarla con cualquier cuenta
    public void imprimirDetalles(CuentaBancaria cuenta) {
        System.out.println("-------------------------------");
        System.out.println("Titular de la cuenta : " + cuenta.getTitular());
        System.out.println("ID de la cuenta      : " + cuenta.getIdCuenta());
        System.out.println("Saldo actual         : $" + cuenta.getSaldo());
        System.out.println("-------------------------------");
    }
}
