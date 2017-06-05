package com.example.abrahamxsaboter.minialmacen;

/**
 * Created by Abraham on 04/06/2017.
 */

public class UsuariosCon {
    long id;
    private String usuario,nombre,ap_pat,ap_mat,edad,email,contrasena;

    public UsuariosCon(String user, String name, String ap_pat1, String ap_mat1,String edad1, String correo,String pass) {
        user = usuario;
        name = nombre;
        ap_pat1 = ap_pat;
        ap_mat1 = ap_mat;
        edad1 = edad;
        correo = email;
        pass = contrasena;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_pat() {
        return ap_pat;
    }

    public void setAp_pat(String ap_pat) {
        this.ap_pat = ap_pat;
    }

    public String getAp_mat() {
        return ap_mat;
    }

    public void setAp_mat(String ap_mat) {
        this.ap_mat = ap_mat;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
