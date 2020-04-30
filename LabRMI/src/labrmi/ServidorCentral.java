package labrmi;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        PreparedStatement pst = null;
        ResultSet rst = null;
        String sql = "select * from cotizaciones where fecha='"+fecha+"'";
        System.out.println(sql);

        try {
        ConexionPostgres posgres=new ConexionPostgres("BancoCentral");
        Connection conexion =posgres.conectar(); 
        pst = conexion.prepareStatement(sql);
        rst = pst.executeQuery();
        if (rst.next()){
            String cotizacion = rst.getString("precio");
            return Double.parseDouble(cotizacion);
                        
        }
        } catch (SQLException ex) {
            System.out.print("Error");
        }
        return 6.96;
        
    }


}


