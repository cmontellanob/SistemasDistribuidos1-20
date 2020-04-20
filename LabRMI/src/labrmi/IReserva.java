/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Carlos
 */
public interface IReserva extends Remote  {
    
    double Cotizar(String inicio,String fin,String fechacotizacion) throws RemoteException; 
    boolean reservar(String inicio,String fin,int idcliente,String fechacompra) throws RemoteException;
    
}
