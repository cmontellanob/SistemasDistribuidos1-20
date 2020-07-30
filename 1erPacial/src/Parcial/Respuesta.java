/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial;

import java.io.Serializable;

/**
 *
 * @author Carlos
 */
public class Respuesta  implements Serializable  {
    boolean estado ;
    String mensaje;
    
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Respuesta() {
        this.estado = false;
        this.mensaje = "";
    }
   
    
}
