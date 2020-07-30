/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Carlos
 */
public class ServidorSereci {

  public static void main (String args[]) { 
    int port=6789;  
    try {
      
      DatagramSocket socketUDP = new DatagramSocket(port);
      byte[] bufer = new byte[1000];

      while (true) {
        // Construimos el DatagramPacket para recibir peticiones
        DatagramPacket peticion =
          new DatagramPacket(bufer, bufer.length);

        // Leemos una petición del DatagramSocket
        socketUDP.receive(peticion);
        byte[] solicitud= peticion.getData();
        String mensaje=new String (solicitud); // Ver-fecha:Nombres,Apellidos,fecha
        mensaje=mensaje.trim();
        String [] comando = mensaje.split(":");
        String [] datos= comando[1].split(",");
        String resultado;
        if (datos[0].equals("Walter Jhamil") && datos[1].equals("Segovia Arellano")&& datos[2].equals("11-02-1996")  )
        {
            resultado="si:verificación correcta";
        }
        else
        {
            resultado="no:error fecha nacimiento no correcta";
        }
       
            
        // Construimos el DatagramPacket para enviar la respuesta
        DatagramPacket respuesta =
          new DatagramPacket(resultado.getBytes(), resultado.getBytes().length,
                             peticion.getAddress(), peticion.getPort());

        // Enviamos la respuesta, que es un eco
        socketUDP.send(respuesta);
      }

    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }

}

    

