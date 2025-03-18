public class CuentaBancaria {
    private String titular;
    private double saldo;
    private String numeroCuenta;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String titular, double saldo, String numeroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    public void depositarDinero(double monto){
        this.saldo += monto;
    }

    public void retirarDinero(double monto){
        this.saldo-=monto;
    }

    public void mostrarInformacion(){
        System.out.println("El nombre del titular es: " + this.titular);
        System.out.println("El saldo de la cuenta es: " + this.saldo);
        System.out.println("El numero de cuenta es: " + this.numeroCuenta);
    }
}
