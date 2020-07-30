package Parcial;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;


public class ServidorSegip 
    extends UnicastRemoteObject
    implements ISegip
	 
{
    ServidorSegip() throws java.rmi.RemoteException{
	super();
    }
    
    @Override
    public Respuesta Verificar(String CI, String Nombres, String Apellidos)  {
     Respuesta r=new Respuesta();
     if (CI.equals("1140506") && Nombres.equals("Walter Jhamil") && Apellidos.equals("Segovia Arellano")){
         r.setEstado(true);
         r.setMensaje("Los Datos son correctos");
     }
     else
     {
         r.setEstado(false);
         r.setMensaje("Los Datos de l CI NO son correctos");
     }
     
     return r;   
    }
    
    
    
    public static void main(String args[]) { 
	try {
	    ServidorSegip segip;
	    LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
	    segip=new ServidorSegip(); 
	    Naming.bind("segip", segip); 
            System.out.println("El servidor segip esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    } 

   

    
}


