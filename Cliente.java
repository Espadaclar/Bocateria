
class Cliente {
    private int numeroCliente;
    private Cliente siguienteEnLaCola;
    private int numeroDeBocadillos;
    public static int numeroClienteActual;

    public Cliente(int numeroDeBocadillos) {
        this.numeroDeBocadillos = numeroDeBocadillos;
        numeroCliente = 0;
    }
    
    public void setNumeroCliente(int num){
         numeroCliente = num;
    }
    
    public int getNumeroCliente(){
        return numeroCliente;
    }

    public Cliente getSiguienteEnLaCola() {
        return siguienteEnLaCola;
    }

    public int getNumeroDeBocadillos() {
        return numeroDeBocadillos;
    }

    public void setSiguienteEnLaCola(Cliente siguienteEnLaCola) {
        this.siguienteEnLaCola = siguienteEnLaCola;
    }

    @Override
    public String toString() {
        String datos = "";
        datos += "Número del cliente: " +numeroCliente+ "\n";
        datos += "Siguiente en la cola: " +siguienteEnLaCola+ "\n";
        datos += "Número de bocadillos adquiridos: " +numeroDeBocadillos+ "\n";
        return datos;
    }
    
    public void mostrarDatos(){
        System.out.println(this);
    }
}


















