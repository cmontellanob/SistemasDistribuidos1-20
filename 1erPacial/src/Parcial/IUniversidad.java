package Parcial;


import java.rmi.*;

public interface IUniversidad extends Remote {
    Diploma EmitirDiploma(String CI,String Nombres, String PrimerApellido,String SegundoApellido,String fecha_nacimiento,String Carrera) throws RemoteException; 
}


