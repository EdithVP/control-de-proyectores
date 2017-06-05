package com.example.abrahamxsaboter.minialmacen;


import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abraham on 29/05/2017.
 */

public class SqLiteHelper extends SQLiteOpenHelper {
    //tablas
    private static final String TABLE_NAME_1 = "usuario_almacen";
    private static final String TABLE_NAME_2 = "producto";


    //llaves primarias
    private static final String KEY_ROWID_1 = "id_user";
    private static final String KEY_ROWID_2 = "id_pro";


    private static final String DATABASE_NAME = "almacen"; //nombre de la base
    private static final int DATABASE_VERSION = 1; // version de la base de datos

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME_1; //query de eliminar duplicados

    private static final String SQL_DELETE_ENTRIES_2 =
            "DROP TABLE IF EXISTS " + TABLE_NAME_2; //query de eliminar duplicados

    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME_1 + " ( " + KEY_ROWID_1 + " integer primary key autoincrement," +
            "usuario text not null, nombre text not null , ap_pat text not null, ap_mat text,edad text not null, correo text not null" +
            ", contrasena text not null)"; //query para crear la tabla y atributos
    private static final String DATABASE_CREATE_1 = "CREATE TABLE " + TABLE_NAME_2 + " (" + KEY_ROWID_2 + " integer primary key autoincrement," +
            "nombre_almacen text not null, descripcion text, tipo_pro text not null, cantidad integer not null)"; //query para crear la tabla y atributos


    public SqLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SqLiteHelper ( Context context, String s, Object o, int i ) {
        super ( context, s, (SQLiteDatabase.CursorFactory) o, i );
    }
    // se crea la base de datos



    @Override
    public void onCreate(SQLiteDatabase db) {
        //ejecuta la BD
        db.execSQL(DATABASE_CREATE);
        //Inserta un valor en la tabla
        db.execSQL("INSERT INTO " + TABLE_NAME_1 + "("
                + "usuario,nombre,ap_pat,ap_mat,edad,correo,contrasena) VALUES('AbrahamYeah','Abraham','Mares','Sánchez'," +
                "'22','abrahamyeahmares@gmail.com','malitos15')");

        db.execSQL(DATABASE_CREATE_1);
        db.execSQL("INSERT INTO " + TABLE_NAME_2 + "("
                + "nombre_almacen,descripcion,tipo_pro,cantidad) VALUES('Proyectores'," +
                "'Almacén dedicado a contener proyectores para uso académico y con motivos educativos.'" +
                ",'Material Didactico',19)");

    }
    //borra los registros (actualiza los datos)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_DELETE_ENTRIES_2);
        onCreate(db);

    }
}



