package Parcial;

import java.net.MalformedURLException;
import java.rmi.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteUniversidad {

    public static void main(String args[]) {
        try {
            IUniversidad universidad;
            universidad = (IUniversidad) Naming.lookup("rmi://localhost/universidad");
            String CI = "1140506";
            String Nombres = "Walter Jhamil";
            String PrimerApellido = "Segovia";
            String SegundoApellido = "Arellano";
            String fecha_nacimiento = "11-02-1996";
            String Carrera = "Ing. en Ciencias de la Computación";
            Diploma alumno = universidad.EmitirDiploma(CI, Nombres, PrimerApellido, SegundoApellido, fecha_nacimiento, Carrera);
            if (alumno.getMensaje().isEmpty()) {
                System.out.println("*********************************");
                System.out.println("Nombre Completo:   " + alumno.getNombrecompleto());
                System.out.println("Carrera:   " + alumno.getCarrera());
                System.out.println("Fecha:   " + alumno.getFecha());
                System.out.println("*********************************");
                
            }
            else
            {
                System.out.println("********** ERROR ************");
                System.out.println(alumno.getMensaje());
                System.out.println("*********************************");
                
                
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}