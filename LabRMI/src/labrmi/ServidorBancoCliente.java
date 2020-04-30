package labrmi;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBCursor;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;


public class ServidorBancoCliente {
       private static double montocliente;
    
    private static boolean verificar(int idcliente,double monto)
    {
       
       System.out.println("Verificando para:"+idcliente+"monto"+monto);
       
       ConexionMongoDB mongo=new ConexionMongoDB("BancoClientes");
       MongoDatabase m=mongo.conectar();
       //new Document("idcliente", idcliente)
       BasicDBObject criteria = new BasicDBObject();
       criteria.append("idcliente", idcliente);
       FindIterable<Document> iterable = m.getCollection("Clientes").find(criteria);
       iterable.forEach(new Block<Document>() {
            @Override
            public void apply( Document document) {

                List list = new ArrayList(document.values());
                montocliente=Double.parseDouble(list.get(3).toString());
                
                System.out.print(montocliente);
                
            }
        });
       if (monto<=montocliente)
           return true;
       else
           return false;
    }
    
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
                cadena = fromClient.readLine(); //cadena obtenida desde el lector idcliente,monto
                System.out.println("cadena recibida:"+cadena);
                String [] partes=cadena.split(","); 
                int idcliente=Integer.parseInt(partes[0]);
                double monto=Double.valueOf(partes[1]);
                String respuesta="";
                if (verificar(idcliente,monto))
                    respuesta="SI";
                else
                    respuesta="NO";
                toClient = new PrintStream(client.getOutputStream()); //prepara el objetopara devolver
                System.out.println(respuesta);
               
                //imprime cadena recibida desde el cliente
                //Thread.sleep(3000);
                 //for (int i=0;i<=10000000;i++);
                toClient.flush(); // 
                toClient.println(respuesta);
                
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
