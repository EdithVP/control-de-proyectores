package com.example.abrahamxsaboter.minialmacen;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

public class registrar_usuarios extends AppCompatActivity {

    private TextInputEditText usuario,nombre,ap_pat,ap_mat,edad,correo,contrasena,contrasena2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuarios);
        //Aplica el botón atras en el ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        usuario = (TextInputEditText)findViewById(R.id.id_nuevo_usuario);
        nombre = (TextInputEditText)findViewById(R.id.id_nombre);
        ap_pat = (TextInputEditText)findViewById(R.id.id_app_paterno);
        ap_mat = (TextInputEditText)findViewById(R.id.id_app_materno);
        edad = (TextInputEditText)findViewById(R.id.id_app_edad);
        correo = (TextInputEditText)findViewById(R.id.id_app_correo);
        contrasena = (TextInputEditText)findViewById(R.id.id_nuevo_contra);
        contrasena2 = (TextInputEditText)findViewById(R.id.id_nuevo_contra2);

    }
    public void EnvioDatosCuenta(View v) {

       String nom_user = usuario.getText().toString();
        String nom = nombre.getText().toString();
        String ap_pat1 =  ap_pat.getText().toString();
        String ap_mat1 = ap_mat.getText().toString();
        String edad1 = edad.getText().toString();
        String email = correo.getText().toString();
        String pass1 = contrasena.getText().toString();
        String pass2 = contrasena2.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


            if (pass1.equals(pass2)){
                try {
                    //Esta clase BaseDatos Puerto VersionSQL
                    SqLiteHelper sql = new SqLiteHelper(this, "almacen", null, 1);
                    SQLiteDatabase db = sql.getWritableDatabase(); // nos permite escribir dentro de la base de datos
                    String query = "INSERT INTO usuario_almacen ("
                            + "usuario,nombre,ap_pat,ap_mat,edad,correo,contrasena) VALUES('" + nom_user + "','" + nom + "','"
                            + ap_pat1 + "', '" + ap_mat1 + "','" + edad1 + "','" + email + "','" + pass1 + "')";

                    db.execSQL(query);
                    db.close();
                    Toast.makeText(getBaseContext(), "Bienvenido a: Mini Almacen", Toast.LENGTH_LONG).show();

                    startActivity(intent);

                } catch (Exception e) {

                    Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getBaseContext(), "Las contraseñas no son iguales", Toast.LENGTH_LONG).show();
            }

        finish();


    }

    public void CancelarReg(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(getBaseContext(),"Cancelado", Toast.LENGTH_LONG).show();
        finish();
    }
/*
    //Bloquea el boton "Atras" del telefono
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            //Esto es lo que hace mi botón al pulsar ir a atrás (UN mensaje)
            //Toast.makeText(getApplicationContext(), "Click en Salir", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/
}
