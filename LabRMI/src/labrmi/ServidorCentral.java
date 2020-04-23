package labrmi;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;


public class ServidorCentral 
    extends UnicastRemoteObject
    implements IBancoCentral
	 
{
    ServidorCentral() throws java.rmi.RemoteException{
	super();
    }
    
    public static void main(String args[]) { 
	try {
	    ServidorCentral banco;
	    LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
	    banco=new ServidorCentral(); 
	    Naming.bind("BancoCentral", banco); 
            System.out.println("El servidor esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    } 

    @Override
    public double cotizaciondolar(String fecha) throws RemoteException {
        System.out.println("coditanzando para la fecha"+fecha);
        double aux=0;
        switch (fecha)
        {
            case "26-06-19": 
                aux=6.90;
                break;
            case "27-06-19": 
                aux=6.91;
                break;
            case "28-06-19": 
                aux=6.93;
                break;
            case "29-06-19": 
                aux=6.92;
                break;    
            case "30-06-19": 
                aux=6.96;
                break;
            default:
                aux=0;
        }
        return aux;
    }


}


