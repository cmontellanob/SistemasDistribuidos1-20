/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labrmi;

import java.rmi.Naming;

/**
 *
 * @author Carlos
 */
public class ClienteReserva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       	IReserva reserva;
      
	try {
	    reserva=(IReserva)Naming.lookup("rmi://localhost/ServidorReserva");
            
	}
	catch (Exception e){
	    e.printStackTrace();
	}

    }
    
}
