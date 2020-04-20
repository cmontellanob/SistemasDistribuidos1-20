/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteoperacionesjava;

/**
 *
 * @author Carlos
 */
public class ClienteOperacionesJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print( restar(5,2));
    }

    private static int restar(int a, int b) {
        clienteoperacionesjava.Servicio1_Service service = new clienteoperacionesjava.Servicio1_Service();
        clienteoperacionesjava.Servicio1 port = service.getServicio1Port();
        return port.restar(a, b);
    }
    
    
}
