package Parcial;
import java.io.*;
import java.net.*;

public class ServidorSeduca {
    
    public static void main(String[] args) throws InterruptedException{
        int port =5001; // puerto en el que escuchara el socket
        
        try {
            ServerSocket server = new ServerSocket(port); //instanciamos un servidor socket
            Socket client;      
            BufferedReader fromClient;  // buffer de lectura
            PrintStream toClient;       // stream para escritura
            while(true){   // ciclo al infinito para elfuncionamiento del server
                client = server.accept(); // el servidorse queda esperando establecer conexion 
                fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                String cadena;
                cadena = fromClient.readLine(); //cadena obtenida desde el lector verificar-rude
                String [] comando= cadena.split("-");
                String respuesta;
                //if comando[1].equals("verificar)
                if (comando[1].equals("WaSeAr11021996"))
                    respuesta="si:verificado con exito";
                else
                    respuesta="no:no se encontró el titulo de bachiller";
                            
                toClient = new PrintStream(client.getOutputStream()); //prepara el objetopara devolver
                System.out.println(respuesta);
                toClient.flush(); // 
                toClient.println(respuesta);
                
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
