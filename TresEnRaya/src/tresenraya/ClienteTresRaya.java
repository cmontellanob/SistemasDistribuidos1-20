package tresenraya;

import java.io.*;
import java.net.*;

public class ClienteTresRaya {
    public static char[][] tabla={{'-','-','-'},{'-','-','-'},{'-','-','-'}};
    public static void main(String[] args){
        int port = 5055; // puerto de comunicacion
        char letra ; 
        {    
        mostrar(tabla);
      
                
        try{
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.print("Marca (x o)");
            String marca = br.readLine();
            
            System.out.print("Introduzca x(0..2)");
            String x = br.readLine();
            System.out.print("Introduzca y(0..2)");
            String y = br.readLine();
            
            String cadena="marcar:"+marca+":"+x+":"+y;
            System.out.println(cadena);
            
            Socket client = new Socket("localhost", port); //conectarse al socket
            
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            toServer.println(cadena);  //mandar alservidor 
            String result = fromServer.readLine();  // devolver del servidor
            System.out.println("cadena devuelta es: "+result);
            String[] Resultado=result.split(":");
            if (Resultado[0].equals("error"))
                System.out.print("error"+Resultado[1]);
            if (Resultado[0].equals("marcas"))
            {
                String[] primerafila=Resultado[1].split(","); 
                String[] segundafila=Resultado[2].split(","); 
                String[] tercerafila=Resultado[3].split(","); 
                
            }
            
                System.out.print("error"+Resultado[1]);
            
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        }
  
        
    }
    private static void mostrar(char [][] arreglo)
    {
        for (int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                if (arreglo[i][j]!='-')
                    System.out.print(arreglo[i][j]);
                else
                    System.out.print(" ");
                if (j!=2)
                {
                    System.out.print("|");
                }
            }
            System.out.println("");
            if (i!=2)
                {
                System.out.println("-+-+--");
                }
            
        }
    }
}
