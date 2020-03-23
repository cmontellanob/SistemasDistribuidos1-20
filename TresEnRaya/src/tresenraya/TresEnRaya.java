/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Carlos
 */
public class TresEnRaya {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int port =5055; // puerto en el que escuchara el socket
    Raya juego=new Raya();    
        try {
            ServerSocket server = new ServerSocket(port); //instanciamos un servidor socket
            Socket client;      
            BufferedReader fromClient;  // buffer de lectura
            PrintStream toClient;       // stream para escritura
            String Resultado="";
            while(true){   // ciclo al infinito para elfuncionamiento del server
                client = server.accept(); // el servidorse queda esperando establecer conexion 
                fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                String cadena;
                cadena = fromClient.readLine(); //cadena obtenida desde el lector
                System.out.print(cadena);
                String [] opciones=cadena.split(":");
                if (opciones[0].compareTo("iniciar")==0) // este seria el codigo para reiniciar eljuego
                    juego.Reiniciar();
                if (opciones[0].compareTo("marcar")==0) // este seria el codigo para reiniciar eljuego
                {
                     Resultado=juego.marcar(Integer.parseInt(opciones[2]), Integer.parseInt(opciones[3]), opciones[1].charAt(0));
                }       
                if (opciones[0].compareTo("marcaciones")==0) // este seria el codigo para reiniciar eljuego
                {
                     Resultado=juego.marcaciones();
                }  
                toClient = new PrintStream(client.getOutputStream()); //prepara el objetopara devolver
                System.out.println(Resultado);
                toClient.flush(); // 
                toClient.println(Resultado);
                
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    
    }
    
}
