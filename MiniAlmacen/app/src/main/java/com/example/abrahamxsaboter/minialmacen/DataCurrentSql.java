package com.example.abrahamxsaboter.minialmacen;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abraham on 01/06/17.
 */

public class DataCurrentSql {
    private SQLiteDatabase database;
    private SqLiteHelper dbHelper;

    public DataCurrentSql(Context context){
       dbHelper = new SqLiteHelper(context);
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }
    public void clouse(){
        database.close();
    }

    public long crearRegistroPro(AlmacenesCon alma){
        ContentValues values = new ContentValues();
        values.put("nombre_pro",alma.getNombre());
        values.put("descripcion",alma.getDescripcion());
        values.put("tipo_pro",alma.getTipo_pro());
        values.put("cantidad",alma.getCantidad());
        long id = database.insert("producto",null,values);
        return id;

    }

    public ArrayList<AlmacenesCon> GetConsultaPro(){
        ArrayList<AlmacenesCon> almacenes = new ArrayList<AlmacenesCon>();
        Cursor cursor = database.query("producto",new String[]{"id_pro","nombre_almacen","descripcion","tipo_pro","cantidad"},null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            AlmacenesCon almacenesCon = cursorToContact(cursor);
            almacenes.add(almacenesCon);
            cursor.moveToNext();
        }
        cursor.close();
        return almacenes;
    }

    private AlmacenesCon cursorToContact(Cursor cursor) {
        AlmacenesCon alma1 = new AlmacenesCon(
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));
        alma1.setId(cursor.getLong(0));

        return alma1;
    }

    public ArrayList<UsuariosCon> GetUsuarios(String user, String pass){
        ArrayList<UsuariosCon> usuarios = new ArrayList<UsuariosCon>();
        String query= "SELECT usuario,contrasena FROM usuario_almacen WHERE usuario='" +
                user + "'AND contrasena='" + pass + "';";

        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.moveToFirst()){
            UsuariosCon usuariosCon = cursorToUser(cursor);
            usuarios.add(usuariosCon);
            cursor.moveToNext();
        }
        cursor.close();
        return usuarios;
    }

    private UsuariosCon cursorToUser(Cursor cursor) {
        UsuariosCon alma1 = new UsuariosCon(
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7));
        alma1.setId(cursor.getLong(0));

        return alma1;
    }




}
