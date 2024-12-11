package Modelos;

public class Activo {

    private int idActivo;
    private String nombreActivo;
    private String descripcion;
    private int idGestion;
    private int cantidad;
    private double valorUnitario;

    // Constructor
    public Activo(int idActivo, String nombreActivo, String descripcion, int idGestion, int cantidad, double valorUnitario) {
        this.idActivo = idActivo;
        this.nombreActivo = nombreActivo;
        this.descripcion = descripcion;
        this.idGestion = idGestion;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    // Getters y Setters
    public int getIdActivo() {
        return idActivo;
    }

    public void setIdActivo(int idActivo) {
        this.idActivo = idActivo;
    }

    public String getNombreActivo() {
        return nombreActivo;
    }

    public void setNombreActivo(String nombreActivo) {
        this.nombreActivo = nombreActivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(int idGestion) {
        this.idGestion = idGestion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}