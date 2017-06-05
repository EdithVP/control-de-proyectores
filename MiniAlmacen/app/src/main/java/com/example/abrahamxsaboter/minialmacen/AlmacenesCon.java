package com.example.abrahamxsaboter.minialmacen;

/**
 * Created by Abraham on 01/06/2017.
 */

public class AlmacenesCon {
    private long Id;

    private String Nombre;
    private String Descripcion;
    private String tipo_pro;
    private String cantidad;



    public AlmacenesCon(String nombre, String descripcion, String tip_produ, String cuanto) {
        Nombre = nombre;
        Descripcion = descripcion;
        tipo_pro = tip_produ;
        cantidad = cuanto;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getTipo_pro() {
        return tipo_pro;
    }

    public void setTipo_pro(String tipo_pro) {
        this.tipo_pro = tipo_pro;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
