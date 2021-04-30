
package Cosas;

public class CajeroAutomatico implements Runnable{
    CuentaBancaria miCuenta = new CuentaBancaria();
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            try{
                retirarDinero(10);
                if(miCuenta.getSaldoActual()<0){
                    System.err.println("Saldo negtivo!!");
                }
                Thread.sleep(500);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            
        }
    }
    private synchronized void retirarDinero(int retirar){
        if(retirar < miCuenta.getSaldoActual()){
            System.out.println("Saldo actual=" + miCuenta.getSaldoActual());
            System.out.println("Usuario:" + Thread.currentThread().getName()+ " Retiro: $" +retirar);
            miCuenta.retirarSaldo(retirar);
            System.out.println("Retiro exitoso::Saldo Actual: " + miCuenta.getSaldoActual());
        }else{
            System.out.println("No hay suficiente dinero en la cuenta para realizar la transaccion");
        }
    }
}
