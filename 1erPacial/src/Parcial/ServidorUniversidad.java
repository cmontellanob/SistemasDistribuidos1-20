package Parcial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorUniversidad
        extends UnicastRemoteObject
        implements IUniversidad {

    ServidorUniversidad() throws java.rmi.RemoteException {
        super();
    }

    public static void main(String args[]) {
        try {
            ServidorUniversidad emisor;
//	    LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            emisor = new ServidorUniversidad();
            Naming.bind("universidad", emisor);
            System.out.println("El servidor universidad esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Diploma EmitirDiploma(String CI, String Nombres, String PrimerApellido, String SegundoApellido, String fecha_nacimiento, String Carrera) {
        Diploma d = new Diploma();
        boolean sinerrores = true;
        try {
         
            //llamar SEGIP cliente
            ISegip segip;
            segip= (ISegip) Naming.lookup("rmi://localhost/segip");
            Respuesta respuesta = segip.Verificar(CI, Nombres, PrimerApellido + " " + SegundoApellido);

            if (!respuesta.getEstado()) {
                d.setMensaje(respuesta.getMensaje());
                sinerrores = false;
            }
            //
            //llamar SEDUCA 

            int port = 5001; // puerto de comunicacion
            Socket client = new Socket("localhost", port); //conectarse al socket  // dd-mm-aa
            String rude = Nombres.substring(0, 2) + PrimerApellido.substring(0, 2) + SegundoApellido.substring(0, 2) + fecha_nacimiento.substring(0, 2) + fecha_nacimiento.substring(3, 5) + fecha_nacimiento.substring(6);
            System.out.print(rude);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            toServer.println("verificar-" + rude);  //mandar alservidor 
            String respuestaseduca = fromServer.readLine();  // devolver del servidor
            String[] respuestas_seduca = respuestaseduca.split(":");

            if (respuestas_seduca[0].equals("no")) {
                d.setMensaje(d.getMensaje() + "-" + respuestas_seduca[1]);
                sinerrores = false;
            }

            // 
            // Lamada SEreci
            int puerto = 6789;

            String dato = "Ver-fecha:" + Nombres + "," + PrimerApellido + " " + SegundoApellido + "," + fecha_nacimiento;
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = dato.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion
                    = new DatagramPacket(mensaje, dato.length(), hostServidor,
                            puerto);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta2
                    = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta2);

            String respuestasereci = new String (respuesta2.getData());  // devolver del servidor
            String[] respuestas_sereci = respuestasereci.split(":");

            if (respuestas_sereci[0].equals("no")) {
                d.setMensaje(d.getMensaje() + "-" + respuestas_sereci[1]);
                sinerrores = false;
            }
            socketUDP.close();

        } catch (NotBoundException ex) {
            Logger.getLogger(ServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        } 
    if (sinerrores)
    {
      d.setNombrecompleto(Nombres +" "+PrimerApellido+" "+SegundoApellido);
      d.setCarrera(Carrera);
      d.setMensaje("");
    }
       return d; 
    }

}
