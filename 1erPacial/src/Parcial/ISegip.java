package Parcial;


import java.rmi.*;

public interface ISegip extends Remote {
    Respuesta Verificar(String CI,String Nombres,String Apellidos) throws RemoteException; 
}


