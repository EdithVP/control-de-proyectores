package com.example.abrahamxsaboter.minialmacen;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int CALL_REQUEST_CODE = 1;
    private static final int CAMERA_REQUEST_CODE = 2;
    private Activity activity;
    private DataCurrentSql data;
    private TextInputEditText usu1,passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        usu1 = (TextInputEditText) findViewById(R.id.id_usuario);
        passw = (TextInputEditText) findViewById(R.id.id_contra);
        try {
            data = new DataCurrentSql(this);
            data.open();
        }catch (Exception e){
            data.open();
        }


    }

    public void SendData(View v) {

        SqLiteHelper admin=new SqLiteHelper(this,"almacen",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String usuario = usu1.getText().toString();
        String contrasena = passw.getText().toString();
        Cursor fila;
        fila=db.rawQuery("SELECT usuario,contrasena FROM usuario_almacen WHERE usuario='" +
                usuario + "'AND contrasena='" + contrasena + "'", null);
                //preguntamos si el cursor tiene algun valor almacenado
        if(fila.moveToFirst()==true) {
            //capturamos los valores del cursos y lo almacenamos en variable
            String usua = fila.getString(0);
            String pass = fila.getString(1);
            //preguntamos si los datos ingresados son iguales
            if (usuario.equals(usua) && contrasena.equals(pass)) {
                //si son iguales entonces vamos a otra ventana
                //Menu es una nueva actividad empty
                Intent ven = new Intent(this, menu_usuario.class);
                startActivity(ven);
                Toast.makeText(this,"Bienvenido "+usua,Toast.LENGTH_SHORT).show();
                //limpiamos las las cajas de texto
                usu1.setText("");
                passw.setText("");
            }
        }
    }

    public void EnviarRegistro(View v) {

        Intent intent = new Intent(this, registrar_usuarios.class);
        startActivity(intent);
    }

    public void ActualizarDatosUsuario(View v) {
        Intent intent = new Intent(this, ActualizarDatos.class);
        startActivity(intent);
    }

    public void Llamar_facebook(View v) {
        Uri uri = Uri.parse("https://www.facebook.com/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void Llamar_twitter(View v) {
        Uri uri = Uri.parse("https://twitter.com/?lang=es");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void AbrirYouTube(View v) {
        Uri uri = Uri.parse("https://www.youtube.com/channel/UCm_W9Ffk4EkCCEoncfIGHhw");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void AbrirSoporte(View v) {

        //Revisa si se tienen los permisos de llamar (se tienen que solicitar los permisos)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //Solicita el permiso de llamar
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST_CODE);
            return;
        }
        //Inicia la actividad
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:5575397412")));
    }
    public void AbrirAcercaDe(View v) {
        Intent intent = new Intent(this, acerca_De.class);
        startActivity(intent);
    }

    public boolean CheckPermission(String permission) {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), permission);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        }

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CAMERA_REQUEST_CODE:
                if (CheckPermission(Manifest.permission.CAMERA)) {

                } else {

                }
                break;
            //Permiso de camara
            case CALL_REQUEST_CODE:
                break;
        }
    }
}
