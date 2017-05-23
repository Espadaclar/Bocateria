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
        System.out.println("\n======= Datos de clientes en al cola.==== ");
        if(clientesEnLaCola.size() > 0){
            for(int i = 0; i < clientesEnLaCola.size(); i ++){
                int valor = clientesEnLaCola.get(i).getNumeroDeBocadillos();
                System.out.println("Cliente: " +clientesEnLaCola.get(i).getNumeroCliente()+ ": " +valor
                    + " bocadillo/s (" +valor * PRECIO_BOCADILLO+ " euros)");
            }
        }
        else{
            System.out.println("____-______- Cola de clientes vacía.\n");
        }
    }

    /**
     * para despachar al cliente que está el primero de la cola 
     * La facturación de la tienda debe verse incrementada, la cola de la caja debe avanzar y el cliente debe pasar 
     * al registro de clientes despachados
     */
    public void depacharClienteActual(){
        if(!clientesEnLaCola.isEmpty()){   
            Cliente cliente = clientesEnLaCola.remove(0);
            int valorBocadillos = cliente.getNumeroDeBocadillos() * PRECIO_BOCADILLO;
            clientesDepachados.put(cliente.getNumeroCliente(), cliente);
            facturacionActual += valorBocadillos;
        }
        else{        
            System.out.println("______--___  Cola sin clientes.");
        }
    }

    /**
     * para poder ver los datos de la bocateria en el instante actual.
     */
    public void visualizaDatosBocateria(){
        System.out.println("\n *******************Estado actual de la Bocateria.**********");

        System.out.println("\n====== Facturación actual; "+facturacionActual+ " €.\n");
        visualizaDatosClienteEnLaCola();
        System.out.println("\n====== Clientes despachados. ========");
        Iterator it = clientesDepachados.keySet().iterator();
        while(it.hasNext()){
            Integer clave = (Integer) it.next();
            int numBocadillos = clientesDepachados.get(clave).getNumeroDeBocadillos();
            System.out.println("Cliente: " +clientesDepachados.get(clave).getNumeroCliente()
                + ": " +numBocadillos + " bocadillo/s  ( " +numBocadillos * PRECIO_BOCADILLO+ " euros ) ");
        }

    }

    /**
     * retorna la posición del primer cliente con mayor nº de bocadillos pedidos.
     */
    public int getPosicionPrimerClienteConMasBocadillos(){
        int colaVacia = -1;
        if(!clientesEnLaCola.isEmpty()){         
            int cont = 0;
            while( cont < clientesEnLaCola.size()  ){
                colaVacia = clientesEnLaCola.get(cont).getNumeroCliente();
                int numBocatas = clientesEnLaCola.get(cont).getNumeroDeBocadillos();
                for(Cliente cliente: clientesEnLaCola){
                    if(cliente.getNumeroDeBocadillos() > numBocatas){
                        numBocatas = cliente.getNumeroDeBocadillos();
                        colaVacia = cliente.getNumeroCliente();
                    }
                }
                cont ++;
            }
        }
        return colaVacia;
    }

    /**
     * se elimina un cliente de la cola de la bocatería.
     */
    public void clienteAbandonaCola(int num){
        int cont = 0;//control para que el parámetro num se ajuste al nº de clientes en la cola.
        if(num > 0 && cont < clientesEnLaCola.size() && clientesEnLaCola != null){
            int cont2 = clientesEnLaCola.size();//almacena el tamaño original de la cola.
            boolean encontrado = false;
            int cont6 = 0;// para eliminar de la cola a los que la abandonan antes de comprar.
            while(cont2 > 0 && !encontrado){
                if(clientesEnLaCola.get(cont6).getNumeroCliente() == num){
                    clientesEnLaCola.remove(cont6);
                    encontrado = true;
                }
                cont2 --;
                cont6 ++;
            }
        }
        else{
            System.out.println("Error, número no válido. ");
        }
    }

    /**
     * ordenarColaPorNumeroDeBocadillos
     */
    public void ordenarColaPorNumeroDeBocadillos(){
        for(int i = 1; i < clientesEnLaCola.size(); i ++){
            for(int u = 0; u < clientesEnLaCola.size(); u ++){
                if(clientesEnLaCola.get(i).getNumeroDeBocadillos() > clientesEnLaCola.get(u).getNumeroDeBocadillos()){
                    Cliente cliente = clientesEnLaCola.get(i);
                    clientesEnLaCola.set(i, clientesEnLaCola.get(u));
                    clientesEnLaCola.set(u, cliente);
                }
            }
        }
    }
}









