import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *franciscoJavier
 */
class Bocateria {
    private Cliente primerPersonaEnLaCola;
    private int facturacionActual;
    private ArrayList<Cliente> clientesEnLaCola;
    private HashMap<Integer,Cliente> clientesDepachados;
    private int posicionEnLaCola;
    
    public  static int PRECIO_BOCADILLO = 5;

    public Bocateria() {
        clientesEnLaCola = new ArrayList<>();
        clientesDepachados = new HashMap<>();
        facturacionActual = 0;
        posicionEnLaCola = 1;
    }
    
    /**
     * crea un nuevo objeto Cliente y lo pone  a la cola de clientes que están
     * esperando a ser atendidos
     */
    public void llegaNuevoClienteALaCola(int numeroDeBocadillos){
        Cliente cliente = new Cliente(numeroDeBocadillos);
        cliente.setNumeroCliente(posicionEnLaCola);   
        clientesEnLaCola.add(cliente);
        posicionEnLaCola ++;
    }
    
     public void visualizaDatosClienteEnLaCola(){
        System.out.println("\n ======= Datos de clientes en al cola.");
        for(int i = 0; i < clientesEnLaCola.size(); i ++){
            int valor = clientesEnLaCola.get(i).getNumeroDeBocadillos();
            System.out.println("Cliente: " +clientesEnLaCola.get(i).getNumeroCliente()+ ": " +valor
                                    + " bocadillo/s (" +valor * PRECIO_BOCADILLO+ " euros)");
        }
    }
    
    /**
     * para despachar al cliente que está el primero de la cola 
     * La facturación de la tienda debe verse incrementada, la cola de la caja debe avanzar y el cliente debe pasar 
     * al registro de clientes despachados
     */
    public void depacharClienteActual(){
        Cliente cliente = clientesEnLaCola.remove(0);
        int valorBocadillos = cliente.getNumeroDeBocadillos() * PRECIO_BOCADILLO;
        clientesDepachados.put(cliente.getNumeroCliente(), cliente);
        facturacionActual += valorBocadillos;
    }
    
    /**
     * para poder ver los datos de la bocateria en el instante actual.
     */
    public void visualizaDatosBocateria(){
        System.out.println("\nFacturación actual: " +facturacionActual+ " euros." );
        //System.out.println("========== Estado de la cola.\n");
        visualizaDatosClienteEnLaCola();
        System.out.println("\nClientes despachados.");
        
        Iterator it = clientesDepachados.keySet().iterator();
        while(it.hasNext()){
            Integer clave = (Integer) it.next();
            int numBocadillos = clientesDepachados.get(clave).getNumeroDeBocadillos();
            System.out.println("Cliente: " +clientesDepachados.get(clave).getNumeroCliente()
            + ": " +numBocadillos + " bocadillo/s  ( " +numBocadillos * PRECIO_BOCADILLO+ " euros ) ");
        }
    
    }

}









