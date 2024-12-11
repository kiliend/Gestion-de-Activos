package Modelos;

import java.util.Date;

public class GestionActivos {
    private int idGestion;
    private int idCliente;
    private int idEncargado;
    private int idOperarios;
    private int idFactura;
    private Date fecha;
    private String situacion;

    // Constructor
    public GestionActivos(int idGestion, int idCliente, int idEncargado, int idOperarios, 
                          int idFactura, Date fecha, String situacion) {
        this.idGestion = idGestion;
        this.idCliente = idCliente;
        this.idEncargado = idEncargado;
        this.idOperarios = idOperarios;
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.situacion = situacion;
    }

    // Getters y Setters
    public int getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(int idGestion) {
        this.idGestion = idGestion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(int idEncargado) {
        this.idEncargado = idEncargado;
    }

    public int getIdOperarios() {
        return idOperarios;
    }

    public void setIdOperarios(int idOperarios) {
        this.idOperarios = idOperarios;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }
}
