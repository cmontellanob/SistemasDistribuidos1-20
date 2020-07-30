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
public class Diploma  implements Serializable  {
    private String nombrecompleto;
    private String carrera;
    private String fecha;
    private String mensaje;

    public Diploma() {
        this.nombrecompleto = "";
        this.carrera = "";
        this.fecha = "26-07-20";
        this.mensaje = "";
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
