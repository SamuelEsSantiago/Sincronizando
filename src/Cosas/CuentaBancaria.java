
package Cosas;

public class CuentaBancaria {
    private int saldoActual = 100;
    public int getSaldoActual(){
        return saldoActual;
    }
    public void retirarSaldo(int num){
        saldoActual -= num;
    }
}
