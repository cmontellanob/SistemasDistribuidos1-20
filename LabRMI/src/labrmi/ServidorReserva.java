package labrmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;


public class ServidorReserva 
    extends UnicastRemoteObject
    implements IReserva
	 
{
    ServidorReserva() throws java.rmi.RemoteException{
	super();
    }
    
    public static void main(String args[]) { 
	try {
	    ServidorReserva reserva=new ServidorReserva();
	    Naming.bind("ServidorReserva", reserva); 
            System.out.println("El servidor esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    } 
    public static double cotizardolar(String fecha)
    {
        IBancoCentral bancocentral;
        double cotizacion=0;
	try {
	    bancocentral=(IBancoCentral)Naming.lookup("rmi://localhost/BancoCentral");
            cotizacion=bancocentral.cotizaciondolar(fecha);
	}
	catch (Exception e){
	    e.printStackTrace();
	}
     return cotizacion;   
    }

    @Override
    public double Cotizar(String inicio, String fin, String fechacotizacion) throws RemoteException { 
        double aux=0;    
        switch (inicio)
        {
            case "26-06-19":
                aux=30;
                break;
            case "27-06-19":
                aux=25;
                break;
            case "28-06-19":
                aux=25;
                break;
            case "29-06-19":
                aux=35;
                break;
            case "30-06-19":
                aux=40;
                break;    
        }
    	
        
        double precio=cotizardolar(fechacotizacion)*aux;
     return precio;
    }
    public Boolean HayFondos(int idcliente,double monto )
    {
        int port = 5001; // puerto de comunicacion
        try{
            
            String cadena =String.valueOf(idcliente)+","+String.valueOf(monto);
            
            Socket client = new Socket("localhost", port); //conectarse al socket
            
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            toServer.println(cadena);  //mandar alservidor 
            String result = fromServer.readLine();  // devolver del servidor
            System.out.print("devuelto desde el servidor "+result);
            if (result.equals("SI"))
                return true;
            else
                return false;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    return false;
    }
    
    @Override
    public boolean reservar(String inicio, String fin, int idcliente, String fechacompra) throws RemoteException {
    double monto=Cotizar( inicio, fin, fechacompra);  
    return HayFondos(idcliente, monto);
        
    }

    
}




