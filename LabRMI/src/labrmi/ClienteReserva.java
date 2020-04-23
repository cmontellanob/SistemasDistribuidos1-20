/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labrmi;

import java.rmi.Naming;
import java.util.Scanner;

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
       Scanner sc=new Scanner(System.in);
	try {
	    reserva=(IReserva)Naming.lookup("rmi://localhost/ServidorReserva");
            int op=0;
            do
            {
             System.out.println("1. Cotizar");
             System.out.println("2. Reservar");
             System.out.println("3. Salir");
             System.out.println("Introducir opcion");
             
            op =sc.nextInt();
             
             switch (op)
             {
                 case 1:
                     double cotizacion=reserva.Cotizar("26-06-19", "26-06-19", "26-06-19");
                     System.out.println(cotizacion);
                     break;
                 case 2:
                     System.out.print("introduzca el id del cliente");
                     int idcliente=sc.nextInt();
                     if ( reserva.reservar("26-06-19", "26-06-19",idcliente, "26-06-19"))
                         System.out.print("se logro hacer la reserva");
                     else
                         System.out.print("ERROR no se logro hacer la reserva");
                                 
                     break;
                     
             }
             
            } while  (op!=3);
	}
	catch (Exception e){
	    e.printStackTrace();
	}

    }
    
}
