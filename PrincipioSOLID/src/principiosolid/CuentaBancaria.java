
package principiosolid;

/**
 * @author Macario, Malanca y Pereyra
 */


// CLASE 1: CuentaBancaria
// Se aplica SRP separando esta clase para que SOLO se encargue de
// gestionar los datos de la cuenta y las operaciones financieras
// (depositar y retirar). Si mañana cambia la lógica del saldo,
// solo se modifica esta clase.

public class CuentaBancaria {
    // Se cambian los atributos a privados para encapsular correctamente
    private String titular;
    private String idCuenta;
    private double saldo;

    public CuentaBancaria(String titular, String idCuenta, double saldo) {
        this.titular = titular;
        this.idCuenta = idCuenta;
        this.saldo = saldo;
    }

    // Método para depositar: solo modifica el saldo
    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Depositado: $" + monto);
    }

    // Método para retirar: solo valida y modifica el saldo
    public void retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            System.out.println("Retirado: $" + monto);
        } else {
            System.out.println("¡Saldo insuficiente!");
        }
    }

    // Getters
    public String getTitular()  { return titular; }
    public String getIdCuenta() { return idCuenta; }
    public double getSaldo()    { return saldo; }
}
